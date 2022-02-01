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
import com.tencent.mm.ab.i;
import com.tencent.mm.br.c;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.game.api.GameShareOption;
import com.tencent.mm.plugin.game.protobuf.bh;
import com.tencent.mm.plugin.game.protobuf.ct;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.s;
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
  private static final String xwF;
  private String cJp;
  private String mAppId;
  private Context mContext;
  private int mFrom;
  private com.tencent.mm.ui.widget.a.e nVN;
  private int xAD;
  private boolean xBd;
  private CaptureDataManager.b xCA;
  private String xCg;
  private SparseArray<GameShareOption> xCu;
  private GameShareOption xCv;
  private com.tencent.mm.plugin.sight.base.a xCw;
  private String xCx;
  private String xCy;
  private boolean xCz;
  
  static
  {
    AppMethodBeat.i(41166);
    xwF = com.tencent.mm.plugin.game.commlib.util.b.c(com.tencent.mm.plugin.game.commlib.util.b.a.xvH) + "haowan/";
    AppMethodBeat.o(41166);
  }
  
  public GameVideoEditorProxyUI()
  {
    AppMethodBeat.i(41155);
    this.xCv = null;
    this.xCx = "";
    this.xCy = "";
    this.xCz = true;
    this.xBd = false;
    this.xAD = 0;
    this.xCA = new CaptureDataManager.c()
    {
      public final void a(final Context paramAnonymousContext, final CaptureDataManager.CaptureVideoNormalModel paramAnonymousCaptureVideoNormalModel, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(41152);
        final Bundle localBundle = new Bundle();
        localBundle.putAll(paramAnonymousBundle);
        com.tencent.mm.ch.a.post(new Runnable()
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
        paramAnonymousBundle.putInt("key_raw_video_size", (int)s.boW(GameVideoEditorProxyUI.b(GameVideoEditorProxyUI.this)));
        paramAnonymousBundle.putInt("key_game_haowan_flag", 10);
        paramAnonymousBundle.putInt("game_haowan_source_scene_id", GameVideoEditorProxyUI.d(GameVideoEditorProxyUI.this));
        if ((GameVideoEditorProxyUI.a(GameVideoEditorProxyUI.this) == 2) && (GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this) != null))
        {
          if (GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).size() > 1)
          {
            Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: more than 1 share options and need to show actionsheet");
            if (GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this) != null) {
              GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this).bMo();
            }
            GameVideoEditorProxyUI.a(GameVideoEditorProxyUI.this, new com.tencent.mm.ui.widget.a.e(paramAnonymousContext, 1, false));
            GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this).HLX = new o.f()
            {
              public final void onCreateMMMenu(m paramAnonymous2m)
              {
                AppMethodBeat.i(41150);
                paramAnonymous2m.clear();
                int i = 0;
                while (i < GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).size())
                {
                  GameShareOption localGameShareOption = (GameShareOption)GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).valueAt(i);
                  paramAnonymous2m.d(localGameShareOption.id, localGameShareOption.title);
                  i += 1;
                }
                AppMethodBeat.o(41150);
              }
            };
            GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this).HLY = new o.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(41151);
                Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: user selected: %d", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                paramAnonymous2MenuItem = (GameShareOption)GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).get(paramAnonymous2MenuItem.getItemId());
                if (paramAnonymous2MenuItem != null)
                {
                  paramAnonymousBundle.putInt("key_selected_item", paramAnonymous2MenuItem.id);
                  paramAnonymousa.eJL();
                  AppMethodBeat.o(41151);
                  return;
                }
                Log.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: non option!!");
                AppMethodBeat.o(41151);
              }
            };
            GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this).dGm();
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
  
  private void dUC()
  {
    AppMethodBeat.i(41158);
    getWindow().getDecorView().setSystemUiVisibility(-3);
    long l = System.currentTimeMillis();
    this.xCx = (xwF + "vsg_output_" + l + ".mp4");
    this.xCy = (xwF + "vsg_thumb_" + l + ".jpg");
    RecordConfigProvider localRecordConfigProvider = RecordConfigProvider.aD(this.cJp, this.xCx, this.xCy);
    localRecordConfigProvider.BOm = getVideoPara();
    localRecordConfigProvider.scene = 5;
    Object localObject1 = new UICustomParam.a();
    ((UICustomParam.a)localObject1).apE();
    ((UICustomParam.a)localObject1).apD();
    ((UICustomParam.a)localObject1).dz(true);
    if (djo()) {
      ((UICustomParam.a)localObject1).apA().apB();
    }
    int i = at.fromDPToPix(this, 32);
    if (this.mFrom != 2) {
      if (this.xCz)
      {
        localRecordConfigProvider.BOy = false;
        localRecordConfigProvider.BOt = Boolean.FALSE;
        localRecordConfigProvider.BOF = 604800000L;
        localRecordConfigProvider.BOv = (localRecordConfigProvider.BOm.duration * 1000);
        ((UICustomParam.a)localObject1).a(2131232975, 2131101424, getString(2131761366), i);
      }
    }
    label813:
    for (;;)
    {
      localRecordConfigProvider.BOn = ((UICustomParam.a)localObject1).gLU;
      CaptureDataManager.BOb.BOa = this.xCA;
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
      if (com.tencent.mm.plugin.recordvideo.jumper.a.a(this.mContext, localRecordConfigProvider)) {
        com.tencent.mm.game.report.b.a.a(this, 8763, 0, 1, this.xAD, com.tencent.mm.game.report.b.a.c(this.mFrom, null));
      }
      AppMethodBeat.o(41158);
      return;
      localRecordConfigProvider.BOy = true;
      localRecordConfigProvider.BOt = Boolean.TRUE;
      break;
      localRecordConfigProvider.BOy = true;
      localRecordConfigProvider.BOt = Boolean.TRUE;
      localRecordConfigProvider.BOv = 7200000;
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
          localRecordConfigProvider.BOm = ((VideoTransPara)localObject4);
        }
        if (!Util.isNullOrNil((String)localObject3)) {
          ((UICustomParam.a)localObject1).L((String)localObject3, getResources().getColor(2131101424));
        }
        localObject3 = ((Bundle)localObject2).getParcelableArrayList("k_ext_share_options");
        if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
        {
          this.xCv = ((GameShareOption)((ArrayList)localObject3).get(0));
          if (((ArrayList)localObject3).size() == 1) {
            ((UICustomParam.a)localObject1).a(0, 0, this.xCv.title, i);
          }
          for (;;)
          {
            this.xCu = new SparseArray();
            localObject3 = ((ArrayList)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (GameShareOption)((Iterator)localObject3).next();
              this.xCu.put(((GameShareOption)localObject4).id, localObject4);
            }
            ((UICustomParam.a)localObject1).a(0, 0, getString(2131755983), i);
          }
        }
        ((UICustomParam.a)localObject1).a(0, 0, getString(2131755983), i);
        ((UICustomParam.a)localObject1).dy(true);
        if (((Bundle)localObject2).getInt("k_ext_editor_from", 0) == 1)
        {
          localObject2 = ((Bundle)localObject2).getStringArrayList("k_ext_tool_bars");
          if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
          {
            ((UICustomParam.a)localObject1).dv(true);
            ((UICustomParam.a)localObject1).dx(true);
            ((UICustomParam.a)localObject1).dy(true);
            ((UICustomParam.a)localObject1).dw(true);
            localObject2 = ((ArrayList)localObject2).iterator();
          }
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label813;
          }
          localObject3 = (String)((Iterator)localObject2).next();
          if (((String)localObject3).equals("emoji"))
          {
            ((UICustomParam.a)localObject1).dv(false);
            continue;
            ((UICustomParam.a)localObject1).a(0, 0, getString(2131755983), i);
            break;
          }
          if (((String)localObject3).equals("music")) {
            ((UICustomParam.a)localObject1).dx(false);
          } else if (((String)localObject3).equals("text")) {
            ((UICustomParam.a)localObject1).dw(false);
          } else if (((String)localObject3).equals("crop")) {
            ((UICustomParam.a)localObject1).dy(false);
          }
        }
      }
    }
  }
  
  private boolean djo()
  {
    AppMethodBeat.i(41159);
    boolean bool2 = false;
    int i = SightVideoJNI.getMp4RotateVFS(this.cJp);
    boolean bool1;
    if ((i == 0) || (i == 180))
    {
      bool1 = bool2;
      if (this.xCw.width >= this.xCw.height) {
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
        if (this.xCw.height >= this.xCw.width) {
          bool1 = true;
        }
      }
    }
  }
  
  private VideoTransPara getVideoPara()
  {
    AppMethodBeat.i(41157);
    if ((this.mFrom == 3) || (this.mFrom == 5))
    {
      localVideoTransPara = com.tencent.mm.modelcontrol.e.baZ().sV(1);
      AppMethodBeat.o(41157);
      return localVideoTransPara;
    }
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.e.baZ().sV(0);
    AppMethodBeat.o(41157);
    return localVideoTransPara;
  }
  
  private void hG(final String paramString1, final String paramString2)
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
        c.b(GameVideoEditorProxyUI.h(GameVideoEditorProxyUI.this), "webview", ".ui.tools.WebViewUI", localIntent, 131);
        AppMethodBeat.o(41154);
      }
    }, 0L);
    AppMethodBeat.o(41162);
  }
  
  private String hH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41163);
    Object localObject1 = com.tencent.mm.plugin.game.commlib.a.dTb();
    Object localObject2;
    if ((localObject1 != null) && (!Util.isNullOrNil(((bh)localObject1).xKD)))
    {
      localObject1 = ((bh)localObject1).xKD.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ct)((Iterator)localObject1).next();
      } while ((((ct)localObject2).xMB != 2) || (Util.isNullOrNil(((ct)localObject2).xIy)));
    }
    for (localObject1 = ((ct)localObject2).xIy;; localObject1 = "https://game.weixin.qq.com/cgi-bin/h5/static/appcenter/publish.html?ssid=5&scene=5")
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
        paramString2.h("videoUrl", paramString1);
        paramString2.h("thumbUrl", getIntent().getStringExtra("thumb_url"));
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
      catch (com.tencent.mm.ab.g paramString1)
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
            if (!this.xBd) {}
          }
          else
          {
            hG(null, paramIntent.getStringExtra("key_video_info"));
            AppMethodBeat.o(41161);
          }
        }
      }
      else
      {
        if ((paramInt2 != 0) && (paramInt2 != 3000) && (paramInt2 != 3001)) {
          break label182;
        }
        com.tencent.mm.game.report.b.a.a(this, 8763, 1, 2, this.xAD, com.tencent.mm.game.report.b.a.c(this.mFrom, null));
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
          n.d(this.xCg, "", this.mAppId, 0, "");
        }
        AppMethodBeat.o(41161);
        return;
        if (paramInt2 != 888) {
          break;
        }
        Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "video edit in background");
        localObject = com.tencent.mm.plugin.game.media.background.a.hJ(paramIntent.getStringExtra("key_thumb_path"), this.cJp);
        String str = paramIntent.getStringExtra("key_bg_mix_task_id");
        paramInt1 = Util.videoMsToSec(paramIntent.getIntExtra("key_video_duration", 0));
        localObject = ay.c("weixin://bgmixid/".concat(String.valueOf(str)), (String)localObject, paramInt1, this.xCw.height, this.xCw.width, 0);
        Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "videoInfo:%s", new Object[] { localObject });
        paramIntent.putExtra("key_video_info", (String)localObject);
        i = -1;
      } while ((this.mFrom != 3) && (!this.xBd));
      hG(null, paramIntent.getStringExtra("key_video_info"));
      AppMethodBeat.o(41161);
      return;
      Log.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "video check error: [%d]", new Object[] { Integer.valueOf(paramInt2) });
      Object localObject = new HashMap();
      ((Map)localObject).put("failid", Integer.valueOf(paramInt2));
      com.tencent.mm.game.report.b.a.a(this.mContext, 8763, 2, 56, this.xAD, com.tencent.mm.game.report.b.a.c(this.mFrom, (Map)localObject));
      u.makeText(this.mContext, 2131761372, 1).show();
      i = paramInt2;
    } while (this.mFrom != 3);
    setResult(paramInt2, paramIntent);
    finish();
    n.d(this.xCg, "Invalid video format", this.mAppId, -3, "Invalid video format");
    AppMethodBeat.o(41161);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41156);
    super.onCreate(paramBundle);
    this.mContext = this;
    this.mFrom = getIntent().getIntExtra("from", -1);
    this.xCg = getIntent().getStringExtra("business_type");
    this.mAppId = getIntent().getStringExtra("appid");
    this.cJp = getIntent().getStringExtra("video_path");
    paramBundle = getIntent().getBundleExtra("ext_data");
    if (paramBundle != null) {
      this.xBd = paramBundle.getBoolean("game_straight_to_publish", false);
    }
    this.xAD = getIntent().getIntExtra("game_haowan_source_scene_id", 0);
    boolean bool2 = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OcX, "1").equals("1");
    boolean bool1;
    if (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rON, 0) == 1)
    {
      bool1 = true;
      Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "video bg mix, debugOpen:%b, xLabOpen:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((!bool2) || (!bool1)) {
        break label282;
      }
      this.xCz = true;
      label199:
      Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "video_path:%s", new Object[] { this.cJp });
      this.xCw = com.tencent.mm.plugin.sight.base.e.aNx(this.cJp);
      if (!getIntent().getBooleanExtra("need_edit", false)) {
        break label297;
      }
      if (this.xCw != null) {
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
      this.xCz = false;
      break label199;
      label290:
      dUC();
      continue;
      label297:
      if (!Util.isNullOrNil(this.cJp))
      {
        if (this.xCw == null)
        {
          Log.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "video is error");
          finish();
        }
        else
        {
          paramBundle = getVideoPara();
          if ((s.boW(this.cJp) > 104857600L) || ((paramBundle != null) && (paramBundle.duration < this.xCw.getVideoDuration())))
          {
            Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "videoLength(%d) > %d or videoDuration(%d) > paramDuration(%d), needEdit is invalid", new Object[] { Long.valueOf(s.boW(this.cJp)), Integer.valueOf(104857600), Integer.valueOf(this.xCw.getVideoDuration()), Integer.valueOf(paramBundle.duration) });
            dUC();
          }
          else
          {
            paramBundle = xwF + "vsg_output_" + System.currentTimeMillis() + ".mp4";
            String str = this.cJp;
            if (!str.equals(paramBundle))
            {
              s.boN(s.boZ(paramBundle));
              s.nw(str, paramBundle);
            }
            this.cJp = paramBundle;
            str = this.cJp;
            paramBundle = com.tencent.mm.plugin.game.media.background.a.aAc(str);
            if (paramBundle == null) {}
            for (paramBundle = null;; paramBundle = ay.c(paramBundle.dJX, str, paramBundle.duration, paramBundle.height, paramBundle.width, paramBundle.size))
            {
              if (paramBundle != null) {
                break label601;
              }
              finish();
              break;
              str = com.tencent.mm.plugin.game.media.background.a.hJ(null, str);
              WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.model.ao.gcQ().aYO(str);
              if (localWebViewJSSDKFileItem != null) {
                paramBundle.lPx = localWebViewJSSDKFileItem.laR;
              }
              paramBundle.jkf.putInt("mark_edit_flag", 0);
            }
            label601:
            hG(null, paramBundle);
          }
        }
      }
      else {
        hG(getIntent().getStringExtra("video_url"), null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoEditorProxyUI
 * JD-Core Version:    0.7.0.1
 */