package com.tencent.mm.plugin.flash.b;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.b.v;
import com.tencent.mm.plugin.facedetect.b.w;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectForWXJNIInterface;
import com.tencent.mm.protocal.protobuf.md;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends a
{
  public String BBD;
  public com.tencent.mm.plugin.facedetect.d.a wym;
  
  public c()
  {
    AppMethodBeat.i(197596);
    this.wym = new com.tencent.mm.plugin.facedetect.d.a();
    this.BBD = "";
    AppMethodBeat.o(197596);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(197626);
    Log.i("MicroMsg.FaceFlashManagerNumber", "startRecord");
    this.wym.au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193754);
        parama.j(c.a(c.this));
        AppMethodBeat.o(193754);
      }
    });
    AppMethodBeat.o(197626);
  }
  
  protected final String aHd(String paramString)
  {
    AppMethodBeat.i(197601);
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = new md();
      localObject = f.k((JSONObject)localObject, String.valueOf(this.wwE));
      paramString.RRH = com.tencent.mm.cd.b.cU((byte[])localObject);
      paramString.RRG = com.tencent.mm.cd.b.cU(f.s(String.valueOf(this.wwE), (byte[])localObject));
      localObject = p.dis();
      p.e(paramString.toByteArray(), (String)localObject);
      Log.i("MicroMsg.FaceFlashManagerNumber", "save verify result to bioId:%s file:%s  fileSize:%s", new Object[] { String.valueOf(this.wwE), localObject, Long.valueOf(u.bBQ((String)localObject)) });
      AppMethodBeat.o(197601);
      return localObject;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", paramString, "number get yt result data error", new Object[0]);
      AppMethodBeat.o(197601);
    }
    return "";
  }
  
  public final int epF()
  {
    return 0;
  }
  
  public final int epv()
  {
    return 1;
  }
  
  public final int epz()
  {
    return 0;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(197623);
    if (((paramq instanceof v)) || ((paramq instanceof w)))
    {
      Log.i("MicroMsg.FaceFlashManagerNumber", "[cgi-ret]NetSceneGetBioConfig errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.BBA = System.currentTimeMillis();
      com.tencent.mm.plugin.flash.c.b.s("rspCfg", Integer.valueOf(paramInt2));
      com.tencent.mm.plugin.flash.c.b.epM().gmy = System.currentTimeMillis();
      com.tencent.mm.plugin.flash.c.b.epM().gmm = paramInt2;
      paramString = new HashMap();
      JSONObject localJSONObject = new JSONObject();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = (com.tencent.mm.plugin.facedetect.b.c)paramq;
        this.wwE = paramq.dhO();
        paramq = YTAGFaceReflectForWXJNIInterface.decrypt(this.wwE, paramq.dhP(), paramq.dhP().length);
        Log.i("MicroMsg.FaceFlashManagerNumber", "mBioId:%s decryptConfig:%s", new Object[] { Long.valueOf(this.wwE), paramq });
        try
        {
          localJSONObject.put("errorcode", 0);
          localJSONObject.put("errormsg", "OK");
          localJSONObject.put("type", 1);
          paramq = new JSONObject(paramq).optJSONArray("face_action_seq");
          if (paramq != null)
          {
            paramInt1 = 0;
            while (paramInt1 < paramq.length())
            {
              Object localObject = paramq.optJSONObject(paramInt1);
              if ((localObject != null) && (((JSONObject)localObject).optInt("action_id", 0) == 4))
              {
                this.BBD = ((JSONObject)localObject).optString("action_data");
                localObject = this.BBD.replaceAll("(.)", "$1,");
                localJSONObject.put("action_data", ((String)localObject).substring(0, ((String)localObject).length() - 1));
              }
              paramInt1 += 1;
            }
          }
          paramString.put("response", localJSONObject.toString());
        }
        catch (JSONException paramq)
        {
          Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", paramq, "reflect get config error", new Object[0]);
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.FaceFlashManagerNumber", "set ytsdk number config:%s", new Object[] { paramString });
        this.BBs.onNetworkResponseEvent(paramString, null);
        AppMethodBeat.o(197623);
        return;
        Log.e("MicroMsg.FaceFlashManagerError", "get mBioId failed");
        com.tencent.mm.plugin.flash.c.b.epM().gmH = 3;
        try
        {
          localJSONObject.put("errorcode", 90036);
          localJSONObject.put("errormsg", "WeChat face get config error!");
          localJSONObject.put("err_feedback", this.BBv);
          localJSONObject.put("err_msg", com.tencent.mm.ci.a.ba(this.activity, a.i.net_fetch_failed));
        }
        catch (JSONException paramq)
        {
          Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", paramq, "reflect get config error2", new Object[0]);
        }
      }
    }
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    AppMethodBeat.o(197623);
  }
  
  public final void release()
  {
    AppMethodBeat.i(197636);
    Log.i("MicroMsg.FaceFlashManagerNumber", "release");
    super.release();
    this.wym.recycle();
    this.wym.clearDiskCache();
    AppMethodBeat.o(197636);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(197633);
    Log.i("MicroMsg.FaceFlashManagerNumber", "reset");
    super.reset();
    stopRecord();
    this.wym.recycle();
    this.wym.clearDiskCache();
    this.wym = new com.tencent.mm.plugin.facedetect.d.a();
    AppMethodBeat.o(197633);
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(197630);
    Log.i("MicroMsg.FaceFlashManagerNumber", "stopRecord");
    this.wym.stopRecord();
    this.wym.recycle();
    this.wym.c(com.tencent.mm.plugin.facedetect.e.a.diK().diL());
    AppMethodBeat.o(197630);
  }
  
  public final void x(TextView paramTextView)
  {
    AppMethodBeat.i(197638);
    com.tencent.mm.plugin.flash.d.a.d(paramTextView, com.tencent.mm.ci.a.ba(paramTextView.getContext(), a.i.face_number_msg_single));
    AppMethodBeat.o(197638);
  }
  
  public static abstract interface a
  {
    public abstract void j(com.tencent.mm.plugin.facedetect.d.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.b.c
 * JD-Core Version:    0.7.0.1
 */