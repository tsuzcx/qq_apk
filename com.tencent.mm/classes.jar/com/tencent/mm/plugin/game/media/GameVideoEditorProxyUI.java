package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.g;
import com.tencent.mm.ad.i;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.game.api.GameShareOption;
import com.tencent.mm.plugin.game.h.a;
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.d;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.protobuf.bj;
import com.tencent.mm.plugin.game.protobuf.cw;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bd;
import com.tencent.mm.vfs.y;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(19)
public class GameVideoEditorProxyUI
  extends MMBaseActivity
{
  private static final String Iuz;
  private SparseArray<GameShareOption> IAE;
  private GameShareOption IAF;
  private com.tencent.mm.plugin.sight.base.b IAG;
  private String IAH;
  private String IAI;
  private boolean IAJ;
  private CaptureDataManager.b IAK;
  private String IAw;
  private int IyH;
  private boolean Izi;
  private String eDC;
  private String mAppId;
  private Context mContext;
  private int mFrom;
  private com.tencent.mm.ui.widget.a.f ucS;
  
  static
  {
    AppMethodBeat.i(41166);
    Iuz = com.tencent.mm.plugin.game.commlib.e.c.c(com.tencent.mm.plugin.game.commlib.e.c.a.Itn) + "haowan/";
    AppMethodBeat.o(41166);
  }
  
  public GameVideoEditorProxyUI()
  {
    AppMethodBeat.i(41155);
    this.IAF = null;
    this.IAH = "";
    this.IAI = "";
    this.IAJ = true;
    this.Izi = false;
    this.IyH = 0;
    this.IAK = new CaptureDataManager.c()
    {
      public final void a(final Context paramAnonymousContext, final CaptureDataManager.CaptureVideoNormalModel paramAnonymousCaptureVideoNormalModel, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(41152);
        final Bundle localBundle = new Bundle();
        localBundle.putAll(paramAnonymousBundle);
        com.tencent.mm.ci.a.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41149);
            GameVideoEditorProxyUI.a(GameVideoEditorProxyUI.this, paramAnonymousContext, paramAnonymousCaptureVideoNormalModel, localBundle);
            AppMethodBeat.o(41149);
          }
        });
        AppMethodBeat.o(41152);
      }
      
      public final boolean a(Context paramAnonymousContext, final Bundle paramAnonymousBundle, final CaptureDataManager.a paramAnonymousa)
      {
        AppMethodBeat.i(41153);
        paramAnonymousBundle.putInt("key_video_from", GameVideoEditorProxyUI.a(GameVideoEditorProxyUI.this));
        paramAnonymousBundle.putString("key_raw_video_path", GameVideoEditorProxyUI.b(GameVideoEditorProxyUI.this));
        paramAnonymousBundle.putInt("key_raw_video_duration", GameVideoEditorProxyUI.c(GameVideoEditorProxyUI.this).getVideoDuration());
        paramAnonymousBundle.putInt("key_raw_video_size", (int)y.bEl(GameVideoEditorProxyUI.b(GameVideoEditorProxyUI.this)));
        paramAnonymousBundle.putInt("key_game_haowan_flag", 10);
        paramAnonymousBundle.putInt("game_haowan_source_scene_id", GameVideoEditorProxyUI.d(GameVideoEditorProxyUI.this));
        if ((GameVideoEditorProxyUI.a(GameVideoEditorProxyUI.this) == 2) && (GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this) != null))
        {
          if (GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).size() > 1)
          {
            Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: more than 1 share options and need to show actionsheet");
            if (GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this) != null) {
              GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this).cyW();
            }
            GameVideoEditorProxyUI.a(GameVideoEditorProxyUI.this, new com.tencent.mm.ui.widget.a.f(paramAnonymousContext, 1, false));
            GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this).Vtg = new u.g()
            {
              public final void onCreateMMMenu(s paramAnonymous2s)
              {
                AppMethodBeat.i(41150);
                paramAnonymous2s.clear();
                int i = 0;
                while (i < GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).size())
                {
                  GameShareOption localGameShareOption = (GameShareOption)GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).valueAt(i);
                  paramAnonymous2s.c(localGameShareOption.id, localGameShareOption.title);
                  i += 1;
                }
                AppMethodBeat.o(41150);
              }
            };
            GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this).GAC = new u.i()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(41151);
                Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: user selected: %d", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                paramAnonymous2MenuItem = (GameShareOption)GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).get(paramAnonymous2MenuItem.getItemId());
                if (paramAnonymous2MenuItem != null)
                {
                  paramAnonymousBundle.putInt("key_selected_item", paramAnonymous2MenuItem.id);
                  paramAnonymousa.onRequestFinish();
                  AppMethodBeat.o(41151);
                  return;
                }
                Log.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: non option!!");
                AppMethodBeat.o(41151);
              }
            };
            GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this).dDn();
            AppMethodBeat.o(41153);
            return true;
          }
          if (GameVideoEditorProxyUI.g(GameVideoEditorProxyUI.this) == null) {
            break label284;
          }
          Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: only 1 option. use default, dafault id is %d", new Object[] { Integer.valueOf(GameVideoEditorProxyUI.g(GameVideoEditorProxyUI.this).id) });
          if (paramAnonymousBundle != null) {
            paramAnonymousBundle.putInt("key_selected_item", GameVideoEditorProxyUI.g(GameVideoEditorProxyUI.this).id);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(41153);
          return false;
          label284:
          Log.w("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: no default option!");
        }
      }
    };
    AppMethodBeat.o(41155);
  }
  
  private boolean ejX()
  {
    AppMethodBeat.i(41159);
    boolean bool2 = false;
    int i = SightVideoJNI.getMp4RotateVFS(this.eDC);
    boolean bool1;
    if ((i == 0) || (i == 180))
    {
      bool1 = bool2;
      if (this.IAG.width >= this.IAG.height) {
        bool1 = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(41159);
      return bool1;
      if (i != 270)
      {
        bool1 = bool2;
        if (i != 90) {}
      }
      else
      {
        bool1 = bool2;
        if (this.IAG.height >= this.IAG.width) {
          bool1 = true;
        }
      }
    }
  }
  
  private void fFG()
  {
    AppMethodBeat.i(41158);
    getWindow().getDecorView().setSystemUiVisibility(-3);
    long l = System.currentTimeMillis();
    this.IAH = (Iuz + "vsg_output_" + l + ".mp4");
    this.IAI = (Iuz + "vsg_thumb_" + l + ".jpg");
    RecordConfigProvider localRecordConfigProvider = RecordConfigProvider.aM(this.eDC, this.IAH, this.IAI);
    localRecordConfigProvider.oXZ = getVideoPara();
    localRecordConfigProvider.scene = 5;
    Object localObject1 = new UICustomParam.a();
    ((UICustomParam.a)localObject1).aQw();
    ((UICustomParam.a)localObject1).aQv();
    ((UICustomParam.a)localObject1).eL(true);
    if (ejX()) {
      ((UICustomParam.a)localObject1).aQs().aQt();
    }
    int i = bd.fromDPToPix(this, 32);
    if (this.mFrom != 2) {
      if (this.IAJ)
      {
        localRecordConfigProvider.NIc = false;
        localRecordConfigProvider.NHX = Boolean.FALSE;
        localRecordConfigProvider.NIj = 604800000L;
        localRecordConfigProvider.NHZ = (localRecordConfigProvider.oXZ.duration * 1000);
        ((UICustomParam.a)localObject1).a(h.d.HTu, h.b.white, getString(h.i.Ich), i);
      }
    }
    label898:
    for (;;)
    {
      localRecordConfigProvider.NHR = ((UICustomParam.a)localObject1).lZB;
      CaptureDataManager.NHH.NHG = this.IAK;
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
      if (com.tencent.mm.plugin.recordvideo.jumper.a.a(this.mContext, h.a.sight_slide_bottom_in, localRecordConfigProvider)) {
        com.tencent.mm.game.report.b.a.a(this, 8763, 0, 1, this.IyH, com.tencent.mm.game.report.b.a.a(this.mFrom, null));
      }
      AppMethodBeat.o(41158);
      return;
      localRecordConfigProvider.NIc = true;
      localRecordConfigProvider.NHX = Boolean.TRUE;
      break;
      localRecordConfigProvider.NIc = true;
      localRecordConfigProvider.NHX = Boolean.TRUE;
      localRecordConfigProvider.NHZ = 7200000;
      localRecordConfigProvider.remuxType = 2;
      Object localObject2 = getIntent().getBundleExtra("ext_data");
      Object localObject3;
      if (localObject2 != null)
      {
        localObject3 = ((Bundle)localObject2).getString("k_ext_wording");
        Object localObject4 = (VideoTransPara)((Bundle)localObject2).getParcelable("k_preferred_trans_param");
        if (localObject4 != null)
        {
          Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: has given trasn params: %s", new Object[] { ((VideoTransPara)localObject4).toString() });
          localRecordConfigProvider.oXZ = ((VideoTransPara)localObject4);
        }
        if (!Util.isNullOrNil((String)localObject3)) {
          ((UICustomParam.a)localObject1).am((String)localObject3, getResources().getColor(h.b.white));
        }
        localObject3 = ((Bundle)localObject2).getParcelableArrayList("k_ext_share_options");
        if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
        {
          this.IAF = ((GameShareOption)((ArrayList)localObject3).get(0));
          if (((ArrayList)localObject3).size() == 1) {
            ((UICustomParam.a)localObject1).a(0, 0, this.IAF.title, i);
          }
          for (;;)
          {
            this.IAE = new SparseArray();
            localObject3 = ((ArrayList)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (GameShareOption)((Iterator)localObject3).next();
              this.IAE.put(((GameShareOption)localObject4).id, localObject4);
            }
            ((UICustomParam.a)localObject1).a(0, 0, getString(h.i.app_share), i);
          }
        }
        ((UICustomParam.a)localObject1).a(0, 0, getString(h.i.app_share), i);
        i = ((Bundle)localObject2).getInt("minDuration", -1);
        if (i > 0) {
          localRecordConfigProvider.NIa = (i * 1000);
        }
        i = ((Bundle)localObject2).getInt("maxDuration", -1);
        if (i > 0) {
          localRecordConfigProvider.NHZ = (i * 1000);
        }
        Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "zbq:minRecordTimeMs:%d,maxRecordTimeMs:%d", new Object[] { Integer.valueOf(localRecordConfigProvider.NIa), Integer.valueOf(localRecordConfigProvider.NHZ) });
        ((UICustomParam.a)localObject1).eK(true);
        if (((Bundle)localObject2).getInt("k_ext_editor_from", 0) == 1)
        {
          localObject2 = ((Bundle)localObject2).getStringArrayList("k_ext_tool_bars");
          if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
          {
            ((UICustomParam.a)localObject1).eH(true);
            ((UICustomParam.a)localObject1).eJ(true);
            ((UICustomParam.a)localObject1).eK(true);
            ((UICustomParam.a)localObject1).eI(true);
            localObject2 = ((ArrayList)localObject2).iterator();
          }
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label898;
          }
          localObject3 = (String)((Iterator)localObject2).next();
          if (((String)localObject3).equals("emoji"))
          {
            ((UICustomParam.a)localObject1).eH(false);
            continue;
            ((UICustomParam.a)localObject1).a(0, 0, getString(h.i.app_share), i);
            break;
          }
          if (((String)localObject3).equals("music")) {
            ((UICustomParam.a)localObject1).eJ(false);
          } else if (((String)localObject3).equals("text")) {
            ((UICustomParam.a)localObject1).eI(false);
          } else if (((String)localObject3).equals("crop")) {
            ((UICustomParam.a)localObject1).eK(false);
          }
        }
      }
    }
  }
  
  private VideoTransPara getVideoPara()
  {
    AppMethodBeat.i(41157);
    if ((this.mFrom == 3) || (this.mFrom == 5))
    {
      localVideoTransPara = e.bIg().vZ(1);
      AppMethodBeat.o(41157);
      return localVideoTransPara;
    }
    VideoTransPara localVideoTransPara = e.bIg().vZ(0);
    AppMethodBeat.o(41157);
    return localVideoTransPara;
  }
  
  private void iX(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(41162);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41154);
        String str = GameVideoEditorProxyUI.a(GameVideoEditorProxyUI.this, paramString1, paramString2);
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", str);
        com.tencent.mm.br.c.b(GameVideoEditorProxyUI.h(GameVideoEditorProxyUI.this), "webview", ".ui.tools.WebViewUI", localIntent, 131);
        AppMethodBeat.o(41154);
      }
    }, 0L);
    AppMethodBeat.o(41162);
  }
  
  private String iY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41163);
    Object localObject1 = com.tencent.mm.plugin.game.commlib.a.fDZ();
    Object localObject2;
    if ((localObject1 != null) && (!Util.isNullOrNil(((bj)localObject1).IIU)))
    {
      localObject1 = ((bj)localObject1).IIU.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (cw)((Iterator)localObject1).next();
      } while ((((cw)localObject2).IKW != 2) || (Util.isNullOrNil(((cw)localObject2).IGI)));
    }
    for (localObject1 = ((cw)localObject2).IGI;; localObject1 = "https://game.weixin.qq.com/cgi-bin/h5/static/appcenter/publish.html?ssid=5&scene=5")
    {
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append((String)localObject1);
      ((StringBuffer)localObject2).append("?video_info=");
      localObject1 = "";
      if (paramString2 == null) {
        paramString2 = new i();
      }
      try
      {
        paramString2.m("videoUrl", paramString1);
        paramString2.m("thumbUrl", getIntent().getStringExtra("thumb_url"));
        label145:
        paramString1 = paramString2.toString();
        for (;;)
        {
          ((StringBuffer)localObject2).append(URLEncoder.encode(paramString1));
          ((StringBuffer)localObject2).append("&from=");
          ((StringBuffer)localObject2).append(this.mFrom);
          ((StringBuffer)localObject2).append("&appid=");
          ((StringBuffer)localObject2).append(this.mAppId);
          ((StringBuffer)localObject2).append("&game_info=");
          ((StringBuffer)localObject2).append(getIntent().getStringExtra("game_info"));
          Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "publish url:%s", new Object[] { ((StringBuffer)localObject2).toString() });
          paramString1 = ((StringBuffer)localObject2).toString();
          AppMethodBeat.o(41163);
          return paramString1;
          try
          {
            paramString1 = new JSONArray(paramString2).getJSONObject(0).toString();
          }
          catch (JSONException paramString1)
          {
            Log.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "json_err:%s", new Object[] { paramString1.getMessage() });
            paramString1 = (String)localObject1;
          }
        }
      }
      catch (g paramString1)
      {
        break label145;
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41161);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    int i = paramInt2;
    if (paramInt1 == 121) {
      if (paramInt2 == -1)
      {
        i = paramInt2;
        if (paramIntent != null) {
          if (this.mFrom != 3)
          {
            i = paramInt2;
            if (!this.Izi) {}
          }
          else
          {
            iX(null, paramIntent.getStringExtra("key_video_info"));
            AppMethodBeat.o(41161);
          }
        }
      }
      else
      {
        if ((paramInt2 != 0) && (paramInt2 != 3000) && (paramInt2 != 3001)) {
          break label182;
        }
        com.tencent.mm.game.report.b.a.a(this, 8763, 1, 2, this.IyH, com.tencent.mm.game.report.b.a.a(this.mFrom, null));
        i = paramInt2;
      }
    }
    label182:
    do
    {
      do
      {
        setResult(i, paramIntent);
        finish();
        if (this.mFrom == 3) {
          n.d(this.IAw, "", this.mAppId, 0, "");
        }
        AppMethodBeat.o(41161);
        return;
        if (paramInt2 != 888) {
          break;
        }
        Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "video edit in background");
        localObject = com.tencent.mm.plugin.game.media.background.a.ja(paramIntent.getStringExtra("key_thumb_path"), this.eDC);
        String str = paramIntent.getStringExtra("key_bg_mix_task_id");
        paramInt1 = Util.videoMsToSec(paramIntent.getIntExtra("key_video_duration", 0));
        localObject = az.c("weixin://bgmixid/".concat(String.valueOf(str)), (String)localObject, paramInt1, this.IAG.height, this.IAG.width, 0);
        Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "videoInfo:%s", new Object[] { localObject });
        paramIntent.putExtra("key_video_info", (String)localObject);
        i = -1;
      } while ((this.mFrom != 3) && (!this.Izi));
      iX(null, paramIntent.getStringExtra("key_video_info"));
      AppMethodBeat.o(41161);
      return;
      Log.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "video check error: [%d]", new Object[] { Integer.valueOf(paramInt2) });
      Object localObject = new HashMap();
      ((Map)localObject).put("failid", Integer.valueOf(paramInt2));
      com.tencent.mm.game.report.b.a.a(this.mContext, 8763, 2, 56, this.IyH, com.tencent.mm.game.report.b.a.a(this.mFrom, (Map)localObject));
      aa.makeText(this.mContext, h.i.Icn, 1).show();
      i = paramInt2;
    } while (this.mFrom != 3);
    setResult(paramInt2, paramIntent);
    finish();
    n.d(this.IAw, "Invalid video format", this.mAppId, -3, "Invalid video format");
    AppMethodBeat.o(41161);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41156);
    super.onCreate(paramBundle);
    this.mContext = this;
    this.mFrom = getIntent().getIntExtra("from", -1);
    this.IAw = getIntent().getStringExtra("business_type");
    this.mAppId = getIntent().getStringExtra("appid");
    this.eDC = getIntent().getStringExtra("video_path");
    paramBundle = getIntent().getBundleExtra("ext_data");
    if (paramBundle != null) {
      this.Izi = paramBundle.getBoolean("game_straight_to_publish", false);
    }
    this.IyH = getIntent().getIntExtra("game_haowan_source_scene_id", 0);
    boolean bool2 = h.baE().ban().get(at.a.acSG, "1").equals("1");
    boolean bool1;
    if (((com.tencent.mm.game.report.a.b)h.ax(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.c.a.yHJ, 1) == 1)
    {
      bool1 = true;
      Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "video bg mix, debugOpen:%b, xLabOpen:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((!bool2) || (!bool1)) {
        break label282;
      }
      this.IAJ = true;
      label199:
      Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "video_path:%s", new Object[] { this.eDC });
      this.IAG = com.tencent.mm.plugin.sight.base.f.aVX(this.eDC);
      if (!getIntent().getBooleanExtra("need_edit", false)) {
        break label297;
      }
      if (this.IAG != null) {
        break label290;
      }
      Log.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "video is error");
      finish();
    }
    for (;;)
    {
      Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "onCreate");
      AppMethodBeat.o(41156);
      return;
      bool1 = false;
      break;
      label282:
      this.IAJ = false;
      break label199;
      label290:
      fFG();
      continue;
      label297:
      if (!Util.isNullOrNil(this.eDC))
      {
        if (this.IAG == null)
        {
          Log.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "video is error");
          finish();
        }
        else
        {
          paramBundle = getVideoPara();
          if ((y.bEl(this.eDC) > 104857600L) || ((paramBundle != null) && (paramBundle.duration < this.IAG.getVideoDuration())))
          {
            Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "videoLength(%d) > %d or videoDuration(%d) > paramDuration(%d), needEdit is invalid", new Object[] { Long.valueOf(y.bEl(this.eDC)), Integer.valueOf(104857600), Integer.valueOf(this.IAG.getVideoDuration()), Integer.valueOf(paramBundle.duration) });
            fFG();
          }
          else
          {
            paramBundle = Iuz + "vsg_output_" + System.currentTimeMillis() + ".mp4";
            String str = this.eDC;
            if (!str.equals(paramBundle))
            {
              y.bDX(y.bEo(paramBundle));
              y.O(str, paramBundle, false);
            }
            this.eDC = paramBundle;
            str = this.eDC;
            paramBundle = com.tencent.mm.plugin.game.media.background.a.aGC(str);
            if (paramBundle == null) {}
            for (paramBundle = null;; paramBundle = az.c(paramBundle.hHB, str, paramBundle.duration, paramBundle.height, paramBundle.width, paramBundle.size))
            {
              if (paramBundle != null) {
                break label602;
              }
              finish();
              break;
              str = com.tencent.mm.plugin.game.media.background.a.ja(null, str);
              WebViewJSSDKFileItem localWebViewJSSDKFileItem = ao.ivu().bks(str);
              if (localWebViewJSSDKFileItem != null) {
                paramBundle.rPM = localWebViewJSSDKFileItem.qUK;
              }
              paramBundle.oSS.putInt("mark_edit_flag", 0);
            }
            label602:
            iX(null, paramBundle);
          }
        }
      }
      else {
        iX(getIntent().getStringExtra("video_url"), null);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41160);
    super.onDestroy();
    AppMethodBeat.o(41160);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoEditorProxyUI
 * JD-Core Version:    0.7.0.1
 */