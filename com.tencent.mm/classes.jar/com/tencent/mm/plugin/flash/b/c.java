package com.tencent.mm.plugin.flash.b;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.facedetect.b.u;
import com.tencent.mm.plugin.facedetect.b.v;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectForWXJNIInterface;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends a
{
  public com.tencent.mm.plugin.facedetect.d.a sSq;
  public String wIt;
  
  public c()
  {
    AppMethodBeat.i(186633);
    this.sSq = new com.tencent.mm.plugin.facedetect.d.a();
    this.wIt = "";
    AppMethodBeat.o(186633);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(186636);
    Log.i("MicroMsg.FaceFlashManagerNumber", "startRecord");
    this.sSq.ap(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186632);
        parama.j(c.this.sSq);
        AppMethodBeat.o(186632);
      }
    });
    AppMethodBeat.o(186636);
  }
  
  protected final String axi(String paramString)
  {
    AppMethodBeat.i(186634);
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = new mn();
      localObject = f.j((JSONObject)localObject, String.valueOf(this.sQI));
      paramString.KQJ = com.tencent.mm.bw.b.cD((byte[])localObject);
      paramString.KQI = com.tencent.mm.bw.b.cD(f.p(String.valueOf(this.sQI), (byte[])localObject));
      localObject = p.cTn();
      p.e(paramString.toByteArray(), (String)localObject);
      Log.i("MicroMsg.FaceFlashManagerNumber", "save verify result to file:%s  fileSize:%s", new Object[] { localObject, Long.valueOf(s.boW((String)localObject)) });
      AppMethodBeat.o(186634);
      return localObject;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", paramString, "number get yt result data error", new Object[0]);
      AppMethodBeat.o(186634);
    }
    return "";
  }
  
  public final int dKV()
  {
    return 1;
  }
  
  public final int dLb()
  {
    return 0;
  }
  
  public final int dLc()
  {
    return 0;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(186635);
    if (((paramq instanceof u)) || ((paramq instanceof v)))
    {
      Log.i("MicroMsg.FaceFlashManagerNumber", "[cgi-ret]NetSceneGetBioConfig errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.wIr = System.currentTimeMillis();
      com.tencent.mm.plugin.flash.c.b.s("rspCfg", Integer.valueOf(paramInt2));
      com.tencent.mm.plugin.flash.c.b.dLi().erf = System.currentTimeMillis();
      com.tencent.mm.plugin.flash.c.b.dLi().eqT = paramInt2;
      paramString = new HashMap();
      JSONObject localJSONObject = new JSONObject();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = (com.tencent.mm.plugin.facedetect.b.b)paramq;
        this.sQI = paramq.cSK();
        paramq = YTAGFaceReflectForWXJNIInterface.decrypt(this.sQI, paramq.cSL(), paramq.cSL().length);
        Log.i("MicroMsg.FaceFlashManagerNumber", "mBioId:%s decryptConfig:%s", new Object[] { Long.valueOf(this.sQI), paramq });
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
                this.wIt = ((JSONObject)localObject).optString("action_data");
                localObject = this.wIt.replaceAll("(.)", "$1,");
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
        this.wIj.onNetworkResponseEvent(paramString, null);
        AppMethodBeat.o(186635);
        return;
        Log.e("MicroMsg.FaceFlashManagerError", "get mBioId failed");
        try
        {
          localJSONObject.put("errorcode", -1);
          localJSONObject.put("errormsg", "WeChat face get config error!");
          localJSONObject.put("err_feedback", this.wIm);
          localJSONObject.put("err_msg", com.tencent.mm.cb.a.aI(this.activity, 2131763495));
        }
        catch (JSONException paramq)
        {
          Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", paramq, "reflect get config error2", new Object[0]);
        }
      }
    }
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    AppMethodBeat.o(186635);
  }
  
  public final void r(TextView paramTextView)
  {
    AppMethodBeat.i(186640);
    paramTextView.setText(com.tencent.mm.cb.a.aI(paramTextView.getContext(), 2131759066));
    AppMethodBeat.o(186640);
  }
  
  public final void release()
  {
    AppMethodBeat.i(186639);
    Log.i("MicroMsg.FaceFlashManagerNumber", "release");
    super.release();
    this.sSq.recycle();
    this.sSq.clearDiskCache();
    AppMethodBeat.o(186639);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(186638);
    Log.i("MicroMsg.FaceFlashManagerNumber", "reset");
    stopRecord();
    this.sSq.recycle();
    this.sSq.clearDiskCache();
    this.sSq = new com.tencent.mm.plugin.facedetect.d.a();
    AppMethodBeat.o(186638);
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(186637);
    Log.i("MicroMsg.FaceFlashManagerNumber", "stopRecord");
    this.sSq.stopRecord();
    this.sSq.recycle();
    this.sSq.c(com.tencent.mm.plugin.facedetect.e.a.cTF().cTG());
    AppMethodBeat.o(186637);
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