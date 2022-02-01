package com.tencent.mm.plugin.flash.b;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.b.v;
import com.tencent.mm.plugin.facedetect.b.w;
import com.tencent.mm.plugin.facedetect.model.k;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectForWXJNIInterface;
import com.tencent.mm.protocal.protobuf.ng;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends a
{
  public String Hjk;
  public com.tencent.mm.plugin.facedetect.d.a zUt;
  
  public c()
  {
    AppMethodBeat.i(264777);
    this.zUt = new com.tencent.mm.plugin.facedetect.d.a();
    this.Hjk = "";
    AppMethodBeat.o(264777);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(264852);
    Log.i("MicroMsg.FaceFlashManagerNumber", "startRecord");
    this.zUt.aC(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264756);
        parama.j(c.a(c.this));
        AppMethodBeat.o(264756);
      }
    });
    AppMethodBeat.o(264852);
  }
  
  protected final String aDw(String paramString)
  {
    AppMethodBeat.i(264823);
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = new ng();
      localObject = f.l((JSONObject)localObject, String.valueOf(this.zSK));
      paramString.YOZ = com.tencent.mm.bx.b.cX((byte[])localObject);
      paramString.YOY = com.tencent.mm.bx.b.cX(f.v(String.valueOf(this.zSK), (byte[])localObject));
      localObject = k.dPd();
      k.e(paramString.toByteArray(), (String)localObject);
      Log.i("MicroMsg.FaceFlashManagerNumber", "save verify result to bioId:%s file:%s  fileSize:%s", new Object[] { String.valueOf(this.zSK), localObject, Long.valueOf(y.bEl((String)localObject)) });
      AppMethodBeat.o(264823);
      return localObject;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", paramString, "number get yt result data error", new Object[0]);
      AppMethodBeat.o(264823);
    }
    return "";
  }
  
  public final int fuB()
  {
    return 0;
  }
  
  public final int fuH()
  {
    return 0;
  }
  
  public final int fux()
  {
    return 1;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(264846);
    if (((paramp instanceof v)) || ((paramp instanceof w)))
    {
      Log.i("MicroMsg.FaceFlashManagerNumber", "[cgi-ret]NetSceneGetBioConfig errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.Hjg = System.currentTimeMillis();
      com.tencent.mm.plugin.flash.c.b.F("rspCfg", Integer.valueOf(paramInt2));
      com.tencent.mm.plugin.flash.c.b.fuO().ivC = System.currentTimeMillis();
      com.tencent.mm.plugin.flash.c.b.fuO().ivq = paramInt2;
      paramString = new HashMap();
      JSONObject localJSONObject = new JSONObject();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramp = (com.tencent.mm.plugin.facedetect.b.c)paramp;
        this.zSK = paramp.dOz();
        paramp = YTAGFaceReflectForWXJNIInterface.decrypt(this.zSK, paramp.dOA(), paramp.dOA().length);
        Log.i("MicroMsg.FaceFlashManagerNumber", "mBioId:%s decryptConfig:%s", new Object[] { Long.valueOf(this.zSK), paramp });
        try
        {
          localJSONObject.put("errorcode", 0);
          localJSONObject.put("errormsg", "OK");
          localJSONObject.put("type", 1);
          paramp = new JSONObject(paramp).optJSONArray("face_action_seq");
          if (paramp != null)
          {
            paramInt1 = 0;
            while (paramInt1 < paramp.length())
            {
              Object localObject = paramp.optJSONObject(paramInt1);
              if ((localObject != null) && (((JSONObject)localObject).optInt("action_id", 0) == 4))
              {
                this.Hjk = ((JSONObject)localObject).optString("action_data");
                localObject = this.Hjk.replaceAll("(.)", "$1,");
                localJSONObject.put("action_data", ((String)localObject).substring(0, ((String)localObject).length() - 1));
              }
              paramInt1 += 1;
            }
          }
          paramString.put("response", localJSONObject.toString());
        }
        catch (JSONException paramp)
        {
          Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", paramp, "reflect get config error", new Object[0]);
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.FaceFlashManagerNumber", "set ytsdk number config:%s", new Object[] { paramString });
        this.HiY.onNetworkResponseEvent(paramString, null);
        AppMethodBeat.o(264846);
        return;
        Log.e("MicroMsg.FaceFlashManagerError", "get mBioId failed");
        com.tencent.mm.plugin.flash.c.b.fuO().ivK = 3;
        try
        {
          localJSONObject.put("errorcode", 90036);
          localJSONObject.put("errormsg", "WeChat face get config error!");
          localJSONObject.put("err_feedback", this.Hjb);
          localJSONObject.put("err_msg", com.tencent.mm.cd.a.bt(this.activity, a.i.net_fetch_failed));
        }
        catch (JSONException paramp)
        {
          Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", paramp, "reflect get config error2", new Object[0]);
        }
      }
    }
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    AppMethodBeat.o(264846);
  }
  
  public final void release()
  {
    AppMethodBeat.i(264867);
    Log.i("MicroMsg.FaceFlashManagerNumber", "release");
    super.release();
    this.zUt.recycle();
    this.zUt.clearDiskCache();
    AppMethodBeat.o(264867);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(264862);
    Log.i("MicroMsg.FaceFlashManagerNumber", "reset");
    super.reset();
    stopRecord();
    this.zUt.recycle();
    this.zUt.clearDiskCache();
    this.zUt = new com.tencent.mm.plugin.facedetect.d.a();
    AppMethodBeat.o(264862);
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(264856);
    Log.i("MicroMsg.FaceFlashManagerNumber", "stopRecord");
    this.zUt.stopRecord();
    this.zUt.recycle();
    this.zUt.b(com.tencent.mm.plugin.facedetect.e.a.dPv().dPw());
    AppMethodBeat.o(264856);
  }
  
  public final void y(TextView paramTextView)
  {
    AppMethodBeat.i(264873);
    com.tencent.mm.plugin.flash.d.a.d(paramTextView, com.tencent.mm.cd.a.bt(paramTextView.getContext(), a.i.face_number_msg_single));
    AppMethodBeat.o(264873);
  }
  
  public static abstract interface a
  {
    public abstract void j(com.tencent.mm.plugin.facedetect.d.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.b.c
 * JD-Core Version:    0.7.0.1
 */