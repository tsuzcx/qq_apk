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
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.game.api.GameShareOption;
import com.tencent.mm.plugin.game.d.bg;
import com.tencent.mm.plugin.game.d.ct;
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
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.o;
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
  private static final String ueE;
  private String cvr;
  private String mAppId;
  private Context mContext;
  private int mFrom;
  private com.tencent.mm.ui.widget.a.e mIQ;
  private boolean uiK;
  private String ujN;
  private SparseArray<GameShareOption> ukb;
  private GameShareOption ukc;
  private com.tencent.mm.plugin.sight.base.a ukd;
  private String uke;
  private String ukf;
  private boolean ukg;
  private CaptureDataManager.b ukh;
  
  static
  {
    AppMethodBeat.i(41166);
    ueE = com.tencent.mm.plugin.game.commlib.util.b.c(com.tencent.mm.plugin.game.commlib.util.b.a.udV) + "haowan/";
    AppMethodBeat.o(41166);
  }
  
  public GameVideoEditorProxyUI()
  {
    AppMethodBeat.i(41155);
    this.ukc = null;
    this.uke = "";
    this.ukf = "";
    this.ukg = true;
    this.uiK = false;
    this.ukh = new CaptureDataManager.c()
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
        paramAnonymousBundle.putInt("key_raw_video_size", (int)o.aZR(GameVideoEditorProxyUI.b(GameVideoEditorProxyUI.this)));
        paramAnonymousBundle.putInt("key_game_haowan_flag", 10);
        if ((GameVideoEditorProxyUI.a(GameVideoEditorProxyUI.this) == 2) && (GameVideoEditorProxyUI.d(GameVideoEditorProxyUI.this) != null))
        {
          if (GameVideoEditorProxyUI.d(GameVideoEditorProxyUI.this).size() > 1)
          {
            ae.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: more than 1 share options and need to show actionsheet");
            if (GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this) != null) {
              GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).bqD();
            }
            GameVideoEditorProxyUI.a(GameVideoEditorProxyUI.this, new com.tencent.mm.ui.widget.a.e(paramAnonymousContext, 1, false));
            GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).LfS = new n.d()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(41150);
                paramAnonymous2l.clear();
                int i = 0;
                while (i < GameVideoEditorProxyUI.d(GameVideoEditorProxyUI.this).size())
                {
                  GameShareOption localGameShareOption = (GameShareOption)GameVideoEditorProxyUI.d(GameVideoEditorProxyUI.this).valueAt(i);
                  paramAnonymous2l.d(localGameShareOption.id, localGameShareOption.title);
                  i += 1;
                }
                AppMethodBeat.o(41150);
              }
            };
            GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).LfT = new n.e()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(41151);
                ae.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: user selected: %d", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                paramAnonymous2MenuItem = (GameShareOption)GameVideoEditorProxyUI.d(GameVideoEditorProxyUI.this).get(paramAnonymous2MenuItem.getItemId());
                if (paramAnonymous2MenuItem != null)
                {
                  paramAnonymousBundle.putInt("key_selected_item", paramAnonymous2MenuItem.id);
                  paramAnonymousa.dIY();
                  AppMethodBeat.o(41151);
                  return;
                }
                ae.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: non option!!");
                AppMethodBeat.o(41151);
              }
            };
            GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).cPF();
            AppMethodBeat.o(41153);
            return true;
          }
          if (GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this) == null) {
            break label271;
          }
          ae.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: only 1 option. use default, dafault id is %d", new Object[] { Integer.valueOf(GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this).id) });
          if (paramAnonymousBundle != null) {
            paramAnonymousBundle.putInt("key_selected_item", GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this).id);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(41153);
          return false;
          label271:
          ae.w("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: no default option!");
        }
      }
    };
    AppMethodBeat.o(41155);
  }
  
  private void daU()
  {
    AppMethodBeat.i(41158);
    getWindow().getDecorView().setSystemUiVisibility(-3);
    long l = System.currentTimeMillis();
    this.uke = (ueE + "vsg_output_" + l + ".mp4");
    this.ukf = (ueE + "vsg_thumb_" + l + ".jpg");
    RecordConfigProvider localRecordConfigProvider = RecordConfigProvider.as(this.cvr, this.uke, this.ukf);
    localRecordConfigProvider.xOg = getVideoPara();
    localRecordConfigProvider.scene = 5;
    Object localObject1 = new UICustomParam.a();
    ((UICustomParam.a)localObject1).abH();
    ((UICustomParam.a)localObject1).abG();
    ((UICustomParam.a)localObject1).cP(true);
    if (daV()) {
      ((UICustomParam.a)localObject1).abD().abE();
    }
    int i = aq.fromDPToPix(this, 32);
    if (this.mFrom != 2) {
      if (this.ukg)
      {
        localRecordConfigProvider.xOr = false;
        localRecordConfigProvider.xOn = Boolean.FALSE;
        localRecordConfigProvider.xOy = 604800000L;
        localRecordConfigProvider.xOp = (localRecordConfigProvider.xOg.duration * 1000);
        ((UICustomParam.a)localObject1).a(2131232586, 2131101179, getString(2131760002), i);
      }
    }
    label809:
    for (;;)
    {
      localRecordConfigProvider.xOh = ((UICustomParam.a)localObject1).ggq;
      CaptureDataManager.xNV.xNU = this.ukh;
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.xOE;
      if (com.tencent.mm.plugin.recordvideo.jumper.a.a(this.mContext, localRecordConfigProvider)) {
        com.tencent.mm.game.report.b.a.a(this, 8763, 0, 1, com.tencent.mm.game.report.b.a.b(this.mFrom, null));
      }
      AppMethodBeat.o(41158);
      return;
      localRecordConfigProvider.xOr = true;
      localRecordConfigProvider.xOn = Boolean.TRUE;
      break;
      localRecordConfigProvider.xOr = true;
      localRecordConfigProvider.xOn = Boolean.TRUE;
      localRecordConfigProvider.xOp = 7200000;
      localRecordConfigProvider.remuxType = 2;
      Object localObject2 = getIntent().getBundleExtra("ext_data");
      Object localObject3;
      if (localObject2 != null)
      {
        localObject3 = ((Bundle)localObject2).getString("k_ext_wording");
        Object localObject4 = (VideoTransPara)((Bundle)localObject2).getParcelable("k_preferred_trans_param");
        if (localObject4 != null)
        {
          ae.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: has given trasn params: %s", new Object[] { ((VideoTransPara)localObject4).toString() });
          localRecordConfigProvider.xOg = ((VideoTransPara)localObject4);
        }
        if (!bu.isNullOrNil((String)localObject3)) {
          ((UICustomParam.a)localObject1).K((String)localObject3, getResources().getColor(2131101179));
        }
        localObject3 = ((Bundle)localObject2).getParcelableArrayList("k_ext_share_options");
        if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
        {
          this.ukc = ((GameShareOption)((ArrayList)localObject3).get(0));
          if (((ArrayList)localObject3).size() == 1) {
            ((UICustomParam.a)localObject1).a(0, 0, this.ukc.title, i);
          }
          for (;;)
          {
            this.ukb = new SparseArray();
            localObject3 = ((ArrayList)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (GameShareOption)((Iterator)localObject3).next();
              this.ukb.put(((GameShareOption)localObject4).id, localObject4);
            }
            ((UICustomParam.a)localObject1).a(0, 0, getString(2131755891), i);
          }
        }
        ((UICustomParam.a)localObject1).a(0, 0, getString(2131755891), i);
        ((UICustomParam.a)localObject1).cO(true);
        if (((Bundle)localObject2).getInt("k_ext_editor_from", 0) == 1)
        {
          localObject2 = ((Bundle)localObject2).getStringArrayList("k_ext_tool_bars");
          if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
          {
            ((UICustomParam.a)localObject1).cL(true);
            ((UICustomParam.a)localObject1).cN(true);
            ((UICustomParam.a)localObject1).cO(true);
            ((UICustomParam.a)localObject1).cM(true);
            localObject2 = ((ArrayList)localObject2).iterator();
          }
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label809;
          }
          localObject3 = (String)((Iterator)localObject2).next();
          if (((String)localObject3).equals("emoji"))
          {
            ((UICustomParam.a)localObject1).cL(false);
            continue;
            ((UICustomParam.a)localObject1).a(0, 0, getString(2131755891), i);
            break;
          }
          if (((String)localObject3).equals("music")) {
            ((UICustomParam.a)localObject1).cN(false);
          } else if (((String)localObject3).equals("text")) {
            ((UICustomParam.a)localObject1).cM(false);
          } else if (((String)localObject3).equals("crop")) {
            ((UICustomParam.a)localObject1).cO(false);
          }
        }
      }
    }
  }
  
  private boolean daV()
  {
    AppMethodBeat.i(41159);
    boolean bool2 = false;
    int i = SightVideoJNI.getMp4RotateVFS(this.cvr);
    boolean bool1;
    if ((i == 0) || (i == 180))
    {
      bool1 = bool2;
      if (this.ukd.width >= this.ukd.height) {
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
        if (this.ukd.height >= this.ukd.width) {
          bool1 = true;
        }
      }
    }
  }
  
  private void gZ(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(41162);
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41154);
        String str = GameVideoEditorProxyUI.a(GameVideoEditorProxyUI.this, paramString1, paramString2);
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", str);
        com.tencent.mm.br.d.b(GameVideoEditorProxyUI.g(GameVideoEditorProxyUI.this), "webview", ".ui.tools.WebViewUI", localIntent, 131);
        AppMethodBeat.o(41154);
      }
    }, 0L);
    AppMethodBeat.o(41162);
  }
  
  private VideoTransPara getVideoPara()
  {
    AppMethodBeat.i(41157);
    if ((this.mFrom == 3) || (this.mFrom == 5))
    {
      localVideoTransPara = com.tencent.mm.modelcontrol.d.aHh().pg(1);
      AppMethodBeat.o(41157);
      return localVideoTransPara;
    }
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.d.aHh().pg(0);
    AppMethodBeat.o(41157);
    return localVideoTransPara;
  }
  
  private String ha(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41163);
    Object localObject1 = com.tencent.mm.plugin.game.commlib.a.cZA();
    Object localObject2;
    if ((localObject1 != null) && (!bu.ht(((bg)localObject1).usl)))
    {
      localObject1 = ((bg)localObject1).usl.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ct)((Iterator)localObject1).next();
      } while ((((ct)localObject2).uuz != 2) || (bu.isNullOrNil(((ct)localObject2).uqf)));
    }
    for (localObject1 = ((ct)localObject2).uqf;; localObject1 = "https://game.weixin.qq.com/cgi-bin/h5/static/appcenter/publish.html?ssid=5&scene=5")
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
          ae.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "publish url:%s", new Object[] { ((StringBuffer)localObject2).toString() });
          paramString1 = ((StringBuffer)localObject2).toString();
          AppMethodBeat.o(41163);
          return paramString1;
          try
          {
            paramString1 = new JSONArray(paramString2).getJSONObject(0).toString();
          }
          catch (JSONException paramString1)
          {
            ae.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "json_err:%s", new Object[] { paramString1.getMessage() });
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
    ae.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    int i = paramInt2;
    if (paramInt1 == 121) {
      if (paramInt2 == -1)
      {
        i = paramInt2;
        if (paramIntent != null) {
          if (this.mFrom != 3)
          {
            i = paramInt2;
            if (!this.uiK) {}
          }
          else
          {
            gZ(null, paramIntent.getStringExtra("key_video_info"));
            AppMethodBeat.o(41161);
          }
        }
      }
      else
      {
        if ((paramInt2 != 0) && (paramInt2 != 3000) && (paramInt2 != 3001)) {
          break label178;
        }
        com.tencent.mm.game.report.b.a.a(this, 8763, 1, 2, com.tencent.mm.game.report.b.a.b(this.mFrom, null));
        i = paramInt2;
      }
    }
    label178:
    do
    {
      do
      {
        setResult(i, paramIntent);
        finish();
        if (this.mFrom == 3) {
          com.tencent.mm.pluginsdk.ui.tools.l.d(this.ujN, "", this.mAppId, 0, "");
        }
        AppMethodBeat.o(41161);
        return;
        if (paramInt2 != 888) {
          break;
        }
        ae.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "video edit in background");
        localObject = com.tencent.mm.plugin.game.media.background.a.hc(paramIntent.getStringExtra("key_thumb_path"), this.cvr);
        String str = paramIntent.getStringExtra("key_bg_mix_task_id");
        paramInt1 = bu.DE(paramIntent.getIntExtra("key_video_duration", 0));
        localObject = ax.b("weixin://bgmixid/".concat(String.valueOf(str)), (String)localObject, paramInt1, this.ukd.height, this.ukd.width, 0);
        ae.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "videoInfo:%s", new Object[] { localObject });
        paramIntent.putExtra("key_video_info", (String)localObject);
        i = -1;
      } while ((this.mFrom != 3) && (!this.uiK));
      gZ(null, paramIntent.getStringExtra("key_video_info"));
      AppMethodBeat.o(41161);
      return;
      ae.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "video check error: [%d]", new Object[] { Integer.valueOf(paramInt2) });
      Object localObject = new HashMap();
      ((Map)localObject).put("failid", Integer.valueOf(paramInt2));
      com.tencent.mm.game.report.b.a.a(this.mContext, 8763, 2, 56, com.tencent.mm.game.report.b.a.b(this.mFrom, (Map)localObject));
      t.makeText(this.mContext, 2131760008, 1).show();
      i = paramInt2;
    } while (this.mFrom != 3);
    setResult(paramInt2, paramIntent);
    finish();
    com.tencent.mm.pluginsdk.ui.tools.l.d(this.ujN, "Invalid video format", this.mAppId, -3, "Invalid video format");
    AppMethodBeat.o(41161);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41156);
    super.onCreate(paramBundle);
    this.mContext = this;
    this.mFrom = getIntent().getIntExtra("from", -1);
    this.ujN = getIntent().getStringExtra("business_type");
    this.mAppId = getIntent().getStringExtra("appid");
    this.cvr = getIntent().getStringExtra("video_path");
    paramBundle = getIntent().getBundleExtra("ext_data");
    if (paramBundle != null) {
      this.uiK = paramBundle.getBoolean("game_straight_to_publish", false);
    }
    boolean bool2 = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUJ, "1").equals("1");
    boolean bool1;
    if (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qxa, 0) == 1)
    {
      bool1 = true;
      ae.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "video bg mix, debugOpen:%b, xLabOpen:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((!bool2) || (!bool1)) {
        break label268;
      }
      this.ukg = true;
      label185:
      ae.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "video_path:%s", new Object[] { this.cvr });
      this.ukd = com.tencent.mm.plugin.sight.base.e.ayN(this.cvr);
      if (!getIntent().getBooleanExtra("need_edit", false)) {
        break label283;
      }
      if (this.ukd != null) {
        break label276;
      }
      ae.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "video is error");
      finish();
    }
    for (;;)
    {
      ae.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "onCreate");
      AppMethodBeat.o(41156);
      return;
      bool1 = false;
      break;
      label268:
      this.ukg = false;
      break label185;
      label276:
      daU();
      continue;
      label283:
      if (!bu.isNullOrNil(this.cvr))
      {
        if (this.ukd == null)
        {
          ae.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "video is error");
          finish();
        }
        else
        {
          paramBundle = getVideoPara();
          if ((o.aZR(this.cvr) > 104857600L) || ((paramBundle != null) && (paramBundle.duration < this.ukd.getVideoDuration())))
          {
            ae.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "videoLength(%d) > %d or videoDuration(%d) > paramDuration(%d), needEdit is invalid", new Object[] { Long.valueOf(o.aZR(this.cvr)), Integer.valueOf(104857600), Integer.valueOf(this.ukd.getVideoDuration()), Integer.valueOf(paramBundle.duration) });
            daU();
          }
          else
          {
            paramBundle = ueE + "vsg_output_" + System.currentTimeMillis() + ".mp4";
            String str = this.cvr;
            if (!str.equals(paramBundle))
            {
              o.aZI(o.aZU(paramBundle));
              o.mF(str, paramBundle);
            }
            this.cvr = paramBundle;
            str = this.cvr;
            paramBundle = com.tencent.mm.plugin.game.media.background.a.amN(str);
            if (paramBundle == null) {}
            for (paramBundle = null;; paramBundle = ax.b(paramBundle.dsN, str, paramBundle.duration, paramBundle.height, paramBundle.width, paramBundle.size))
            {
              if (paramBundle != null) {
                break label587;
              }
              finish();
              break;
              str = com.tencent.mm.plugin.game.media.background.a.hc(null, str);
              WebViewJSSDKFileItem localWebViewJSSDKFileItem = ao.eUe().aIN(str);
              if (localWebViewJSSDKFileItem != null) {
                paramBundle.kKQ = localWebViewJSSDKFileItem.jXT;
              }
              paramBundle.ioY.putInt("mark_edit_flag", 0);
            }
            label587:
            gZ(null, paramBundle);
          }
        }
      }
      else {
        gZ(getIntent().getStringExtra("video_url"), null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoEditorProxyUI
 * JD-Core Version:    0.7.0.1
 */