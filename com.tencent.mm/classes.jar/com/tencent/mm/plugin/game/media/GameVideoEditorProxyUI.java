package com.tencent.mm.plugin.game.media;

import android.app.Activity;
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
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.api.GameShareOption;
import com.tencent.mm.plugin.game.commlib.e.c.a;
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.protobuf.bi;
import com.tencent.mm.plugin.game.protobuf.cu;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.u;
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
  private static final String CAN;
  private int CEE;
  private boolean CFe;
  private CaptureDataManager.b CGA;
  private String CGg;
  private SparseArray<GameShareOption> CGu;
  private GameShareOption CGv;
  private com.tencent.mm.plugin.sight.base.b CGw;
  private String CGx;
  private String CGy;
  private boolean CGz;
  private String cJT;
  private String mAppId;
  private Context mContext;
  private int mFrom;
  private com.tencent.mm.ui.widget.a.e qXn;
  
  static
  {
    AppMethodBeat.i(41166);
    CAN = com.tencent.mm.plugin.game.commlib.e.c.c(c.a.Czx) + "haowan/";
    AppMethodBeat.o(41166);
  }
  
  public GameVideoEditorProxyUI()
  {
    AppMethodBeat.i(41155);
    this.CGv = null;
    this.CGx = "";
    this.CGy = "";
    this.CGz = true;
    this.CFe = false;
    this.CEE = 0;
    this.CGA = new CaptureDataManager.c()
    {
      public final void a(final Context paramAnonymousContext, final CaptureDataManager.CaptureVideoNormalModel paramAnonymousCaptureVideoNormalModel, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(41152);
        final Bundle localBundle = new Bundle();
        localBundle.putAll(paramAnonymousBundle);
        com.tencent.mm.co.a.post(new Runnable()
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
        paramAnonymousBundle.putInt("key_raw_video_size", (int)u.bBQ(GameVideoEditorProxyUI.b(GameVideoEditorProxyUI.this)));
        paramAnonymousBundle.putInt("key_game_haowan_flag", 10);
        paramAnonymousBundle.putInt("game_haowan_source_scene_id", GameVideoEditorProxyUI.d(GameVideoEditorProxyUI.this));
        if ((GameVideoEditorProxyUI.a(GameVideoEditorProxyUI.this) == 2) && (GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this) != null))
        {
          if (GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).size() > 1)
          {
            Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: more than 1 share options and need to show actionsheet");
            if (GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this) != null) {
              GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this).bYF();
            }
            GameVideoEditorProxyUI.a(GameVideoEditorProxyUI.this, new com.tencent.mm.ui.widget.a.e(paramAnonymousContext, 1, false));
            GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this).ODT = new q.f()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
              {
                AppMethodBeat.i(41150);
                paramAnonymous2o.clear();
                int i = 0;
                while (i < GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).size())
                {
                  GameShareOption localGameShareOption = (GameShareOption)GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).valueAt(i);
                  paramAnonymous2o.d(localGameShareOption.id, localGameShareOption.title);
                  i += 1;
                }
                AppMethodBeat.o(41150);
              }
            };
            GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this).ODU = new q.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(41151);
                Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: user selected: %d", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                paramAnonymous2MenuItem = (GameShareOption)GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).get(paramAnonymous2MenuItem.getItemId());
                if (paramAnonymous2MenuItem != null)
                {
                  paramAnonymousBundle.putInt("key_selected_item", paramAnonymous2MenuItem.id);
                  paramAnonymousa.fvW();
                  AppMethodBeat.o(41151);
                  return;
                }
                Log.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: non option!!");
                AppMethodBeat.o(41151);
              }
            };
            GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this).eik();
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
  
  private boolean dGR()
  {
    AppMethodBeat.i(41159);
    boolean bool2 = false;
    int i = SightVideoJNI.getMp4RotateVFS(this.cJT);
    boolean bool1;
    if ((i == 0) || (i == 180))
    {
      bool1 = bool2;
      if (this.CGw.width >= this.CGw.height) {
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
        if (this.CGw.height >= this.CGw.width) {
          bool1 = true;
        }
      }
    }
  }
  
  private void exJ()
  {
    AppMethodBeat.i(41158);
    getWindow().getDecorView().setSystemUiVisibility(-3);
    long l = System.currentTimeMillis();
    this.CGx = (CAN + "vsg_output_" + l + ".mp4");
    this.CGy = (CAN + "vsg_thumb_" + l + ".jpg");
    RecordConfigProvider localRecordConfigProvider = RecordConfigProvider.ay(this.cJT, this.CGx, this.CGy);
    localRecordConfigProvider.mfk = getVideoPara();
    localRecordConfigProvider.scene = 5;
    Object localObject1 = new UICustomParam.a();
    ((UICustomParam.a)localObject1).avX();
    ((UICustomParam.a)localObject1).avW();
    ((UICustomParam.a)localObject1).dZ(true);
    if (dGR()) {
      ((UICustomParam.a)localObject1).avT().avU();
    }
    int i = aw.fromDPToPix(this, 32);
    if (this.mFrom != 2) {
      if (this.CGz)
      {
        localRecordConfigProvider.HLe = false;
        localRecordConfigProvider.HKZ = Boolean.FALSE;
        localRecordConfigProvider.HLl = 604800000L;
        localRecordConfigProvider.HLb = (localRecordConfigProvider.mfk.duration * 1000);
        ((UICustomParam.a)localObject1).a(g.d.Chl, g.b.white, getString(g.i.CpY), i);
      }
    }
    label898:
    for (;;)
    {
      localRecordConfigProvider.HKT = ((UICustomParam.a)localObject1).jwj;
      CaptureDataManager.HKJ.HKI = this.CGA;
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
      if (com.tencent.mm.plugin.recordvideo.jumper.a.a(this.mContext, g.a.sight_slide_bottom_in, localRecordConfigProvider)) {
        com.tencent.mm.game.report.b.a.a(this, 8763, 0, 1, this.CEE, com.tencent.mm.game.report.b.a.b(this.mFrom, null));
      }
      AppMethodBeat.o(41158);
      return;
      localRecordConfigProvider.HLe = true;
      localRecordConfigProvider.HKZ = Boolean.TRUE;
      break;
      localRecordConfigProvider.HLe = true;
      localRecordConfigProvider.HKZ = Boolean.TRUE;
      localRecordConfigProvider.HLb = 7200000;
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
          localRecordConfigProvider.mfk = ((VideoTransPara)localObject4);
        }
        if (!Util.isNullOrNil((String)localObject3)) {
          ((UICustomParam.a)localObject1).ad((String)localObject3, getResources().getColor(g.b.white));
        }
        localObject3 = ((Bundle)localObject2).getParcelableArrayList("k_ext_share_options");
        if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
        {
          this.CGv = ((GameShareOption)((ArrayList)localObject3).get(0));
          if (((ArrayList)localObject3).size() == 1) {
            ((UICustomParam.a)localObject1).a(0, 0, this.CGv.title, i);
          }
          for (;;)
          {
            this.CGu = new SparseArray();
            localObject3 = ((ArrayList)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (GameShareOption)((Iterator)localObject3).next();
              this.CGu.put(((GameShareOption)localObject4).id, localObject4);
            }
            ((UICustomParam.a)localObject1).a(0, 0, getString(g.i.app_share), i);
          }
        }
        ((UICustomParam.a)localObject1).a(0, 0, getString(g.i.app_share), i);
        i = ((Bundle)localObject2).getInt("minDuration", -1);
        if (i > 0) {
          localRecordConfigProvider.HLc = (i * 1000);
        }
        i = ((Bundle)localObject2).getInt("maxDuration", -1);
        if (i > 0) {
          localRecordConfigProvider.HLb = (i * 1000);
        }
        Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "zbq:minRecordTimeMs:%d,maxRecordTimeMs:%d", new Object[] { Integer.valueOf(localRecordConfigProvider.HLc), Integer.valueOf(localRecordConfigProvider.HLb) });
        ((UICustomParam.a)localObject1).dY(true);
        if (((Bundle)localObject2).getInt("k_ext_editor_from", 0) == 1)
        {
          localObject2 = ((Bundle)localObject2).getStringArrayList("k_ext_tool_bars");
          if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
          {
            ((UICustomParam.a)localObject1).dV(true);
            ((UICustomParam.a)localObject1).dX(true);
            ((UICustomParam.a)localObject1).dY(true);
            ((UICustomParam.a)localObject1).dW(true);
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
            ((UICustomParam.a)localObject1).dV(false);
            continue;
            ((UICustomParam.a)localObject1).a(0, 0, getString(g.i.app_share), i);
            break;
          }
          if (((String)localObject3).equals("music")) {
            ((UICustomParam.a)localObject1).dX(false);
          } else if (((String)localObject3).equals("text")) {
            ((UICustomParam.a)localObject1).dW(false);
          } else if (((String)localObject3).equals("crop")) {
            ((UICustomParam.a)localObject1).dY(false);
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
      localVideoTransPara = com.tencent.mm.modelcontrol.e.bkp().vU(1);
      AppMethodBeat.o(41157);
      return localVideoTransPara;
    }
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.e.bkp().vU(0);
    AppMethodBeat.o(41157);
    return localVideoTransPara;
  }
  
  private void hP(final String paramString1, final String paramString2)
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
        com.tencent.mm.by.c.b(GameVideoEditorProxyUI.h(GameVideoEditorProxyUI.this), "webview", ".ui.tools.WebViewUI", localIntent, 131);
        AppMethodBeat.o(41154);
      }
    }, 0L);
    AppMethodBeat.o(41162);
  }
  
  private String hQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41163);
    Object localObject1 = com.tencent.mm.plugin.game.commlib.a.ewk();
    Object localObject2;
    if ((localObject1 != null) && (!Util.isNullOrNil(((bi)localObject1).COK)))
    {
      localObject1 = ((bi)localObject1).COK.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (cu)((Iterator)localObject1).next();
      } while ((((cu)localObject2).CQK != 2) || (Util.isNullOrNil(((cu)localObject2).CMD)));
    }
    for (localObject1 = ((cu)localObject2).CMD;; localObject1 = "https://game.weixin.qq.com/cgi-bin/h5/static/appcenter/publish.html?ssid=5&scene=5")
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
        paramString2.g("videoUrl", paramString1);
        paramString2.g("thumbUrl", getIntent().getStringExtra("thumb_url"));
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
            if (!this.CFe) {}
          }
          else
          {
            hP(null, paramIntent.getStringExtra("key_video_info"));
            AppMethodBeat.o(41161);
          }
        }
      }
      else
      {
        if ((paramInt2 != 0) && (paramInt2 != 3000) && (paramInt2 != 3001)) {
          break label182;
        }
        com.tencent.mm.game.report.b.a.a(this, 8763, 1, 2, this.CEE, com.tencent.mm.game.report.b.a.b(this.mFrom, null));
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
          com.tencent.mm.pluginsdk.ui.tools.o.d(this.CGg, "", this.mAppId, 0, "");
        }
        AppMethodBeat.o(41161);
        return;
        if (paramInt2 != 888) {
          break;
        }
        Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "video edit in background");
        localObject = com.tencent.mm.plugin.game.media.background.a.hS(paramIntent.getStringExtra("key_thumb_path"), this.cJT);
        String str = paramIntent.getStringExtra("key_bg_mix_task_id");
        paramInt1 = Util.videoMsToSec(paramIntent.getIntExtra("key_video_duration", 0));
        localObject = az.c("weixin://bgmixid/".concat(String.valueOf(str)), (String)localObject, paramInt1, this.CGw.height, this.CGw.width, 0);
        Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "videoInfo:%s", new Object[] { localObject });
        paramIntent.putExtra("key_video_info", (String)localObject);
        i = -1;
      } while ((this.mFrom != 3) && (!this.CFe));
      hP(null, paramIntent.getStringExtra("key_video_info"));
      AppMethodBeat.o(41161);
      return;
      Log.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "video check error: [%d]", new Object[] { Integer.valueOf(paramInt2) });
      Object localObject = new HashMap();
      ((Map)localObject).put("failid", Integer.valueOf(paramInt2));
      com.tencent.mm.game.report.b.a.a(this.mContext, 8763, 2, 56, this.CEE, com.tencent.mm.game.report.b.a.b(this.mFrom, (Map)localObject));
      w.makeText(this.mContext, g.i.Cqe, 1).show();
      i = paramInt2;
    } while (this.mFrom != 3);
    setResult(paramInt2, paramIntent);
    finish();
    com.tencent.mm.pluginsdk.ui.tools.o.d(this.CGg, "Invalid video format", this.mAppId, -3, "Invalid video format");
    AppMethodBeat.o(41161);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41156);
    super.onCreate(paramBundle);
    this.mContext = this;
    this.mFrom = getIntent().getIntExtra("from", -1);
    this.CGg = getIntent().getStringExtra("business_type");
    this.mAppId = getIntent().getStringExtra("appid");
    this.cJT = getIntent().getStringExtra("video_path");
    paramBundle = getIntent().getBundleExtra("ext_data");
    if (paramBundle != null) {
      this.CFe = paramBundle.getBoolean("game_straight_to_publish", false);
    }
    this.CEE = getIntent().getIntExtra("game_haowan_source_scene_id", 0);
    boolean bool2 = h.aHG().aHp().get(ar.a.Vre, "1").equals("1");
    boolean bool1;
    if (((com.tencent.mm.game.report.a.b)h.ae(com.tencent.mm.game.report.a.b.class)).a(b.a.vuP, 0) == 1)
    {
      bool1 = true;
      Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "video bg mix, debugOpen:%b, xLabOpen:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((!bool2) || (!bool1)) {
        break label282;
      }
      this.CGz = true;
      label199:
      Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "video_path:%s", new Object[] { this.cJT });
      this.CGw = com.tencent.mm.plugin.sight.base.f.aYg(this.cJT);
      if (!getIntent().getBooleanExtra("need_edit", false)) {
        break label297;
      }
      if (this.CGw != null) {
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
      this.CGz = false;
      break label199;
      label290:
      exJ();
      continue;
      label297:
      if (!Util.isNullOrNil(this.cJT))
      {
        if (this.CGw == null)
        {
          Log.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "video is error");
          finish();
        }
        else
        {
          paramBundle = getVideoPara();
          if ((u.bBQ(this.cJT) > 104857600L) || ((paramBundle != null) && (paramBundle.duration < this.CGw.getVideoDuration())))
          {
            Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "videoLength(%d) > %d or videoDuration(%d) > paramDuration(%d), needEdit is invalid", new Object[] { Long.valueOf(u.bBQ(this.cJT)), Integer.valueOf(104857600), Integer.valueOf(this.CGw.getVideoDuration()), Integer.valueOf(paramBundle.duration) });
            exJ();
          }
          else
          {
            paramBundle = CAN + "vsg_output_" + System.currentTimeMillis() + ".mp4";
            String str = this.cJT;
            if (!str.equals(paramBundle))
            {
              u.bBD(u.bBT(paramBundle));
              u.on(str, paramBundle);
            }
            this.cJT = paramBundle;
            str = this.cJT;
            paramBundle = com.tencent.mm.plugin.game.media.background.a.aJN(str);
            if (paramBundle == null) {}
            for (paramBundle = null;; paramBundle = az.c(paramBundle.fCM, str, paramBundle.duration, paramBundle.height, paramBundle.width, paramBundle.size))
            {
              if (paramBundle != null) {
                break label601;
              }
              finish();
              break;
              str = com.tencent.mm.plugin.game.media.background.a.hS(null, str);
              WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.model.ao.gVN().bkI(str);
              if (localWebViewJSSDKFileItem != null) {
                paramBundle.oLR = localWebViewJSSDKFileItem.nVa;
              }
              paramBundle.mab.putInt("mark_edit_flag", 0);
            }
            label601:
            hP(null, paramBundle);
          }
        }
      }
      else {
        hP(getIntent().getStringExtra("video_url"), null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoEditorProxyUI
 * JD-Core Version:    0.7.0.1
 */