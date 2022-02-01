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
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.game.api.GameShareOption;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(19)
public class GameVideoEditorProxyUI
  extends MMBaseActivity
{
  private static final String tTM;
  private String cuO;
  private String mAppId;
  private Context mContext;
  private com.tencent.mm.ui.widget.a.e mDL;
  private int mFrom;
  private String tYL;
  private SparseArray<GameShareOption> tYZ;
  private GameShareOption tZa;
  private com.tencent.mm.plugin.sight.base.a tZb;
  private String tZc;
  private String tZd;
  private boolean tZe;
  private CaptureDataManager.b tZf;
  
  static
  {
    AppMethodBeat.i(41166);
    tTM = com.tencent.mm.plugin.game.commlib.util.b.c(com.tencent.mm.plugin.game.commlib.util.b.a.tTe) + "haowan/";
    AppMethodBeat.o(41166);
  }
  
  public GameVideoEditorProxyUI()
  {
    AppMethodBeat.i(41155);
    this.tZa = null;
    this.tZc = "";
    this.tZd = "";
    this.tZe = true;
    this.tZf = new CaptureDataManager.c()
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
        paramAnonymousBundle.putInt("key_raw_video_size", (int)com.tencent.mm.vfs.i.aYo(GameVideoEditorProxyUI.b(GameVideoEditorProxyUI.this)));
        paramAnonymousBundle.putInt("key_game_haowan_flag", 10);
        if ((GameVideoEditorProxyUI.a(GameVideoEditorProxyUI.this) == 2) && (GameVideoEditorProxyUI.d(GameVideoEditorProxyUI.this) != null))
        {
          if (GameVideoEditorProxyUI.d(GameVideoEditorProxyUI.this).size() > 1)
          {
            ad.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: more than 1 share options and need to show actionsheet");
            if (GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this) != null) {
              GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).bpT();
            }
            GameVideoEditorProxyUI.a(GameVideoEditorProxyUI.this, new com.tencent.mm.ui.widget.a.e(paramAnonymousContext, 1, false));
            GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).KJy = new n.d()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(41150);
                paramAnonymous2l.clear();
                int i = 0;
                while (i < GameVideoEditorProxyUI.d(GameVideoEditorProxyUI.this).size())
                {
                  GameShareOption localGameShareOption = (GameShareOption)GameVideoEditorProxyUI.d(GameVideoEditorProxyUI.this).valueAt(i);
                  paramAnonymous2l.c(localGameShareOption.id, localGameShareOption.title);
                  i += 1;
                }
                AppMethodBeat.o(41150);
              }
            };
            GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).KJz = new n.e()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(41151);
                ad.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: user selected: %d", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                paramAnonymous2MenuItem = (GameShareOption)GameVideoEditorProxyUI.d(GameVideoEditorProxyUI.this).get(paramAnonymous2MenuItem.getItemId());
                if (paramAnonymous2MenuItem != null)
                {
                  paramAnonymousBundle.putInt("key_selected_item", paramAnonymous2MenuItem.id);
                  paramAnonymousa.dFH();
                  AppMethodBeat.o(41151);
                  return;
                }
                ad.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: non option!!");
                AppMethodBeat.o(41151);
              }
            };
            GameVideoEditorProxyUI.e(GameVideoEditorProxyUI.this).cMW();
            AppMethodBeat.o(41153);
            return true;
          }
          if (GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this) == null) {
            break label271;
          }
          ad.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: only 1 option. use default, dafault id is %d", new Object[] { Integer.valueOf(GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this).id) });
          if (paramAnonymousBundle != null) {
            paramAnonymousBundle.putInt("key_selected_item", GameVideoEditorProxyUI.f(GameVideoEditorProxyUI.this).id);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(41153);
          return false;
          label271:
          ad.w("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: no default option!");
        }
      }
    };
    AppMethodBeat.o(41155);
  }
  
  private void cYk()
  {
    AppMethodBeat.i(41158);
    getWindow().getDecorView().setSystemUiVisibility(-3);
    long l = System.currentTimeMillis();
    this.tZc = (tTM + "vsg_output_" + l + ".mp4");
    this.tZd = (tTM + "vsg_thumb_" + l + ".jpg");
    RecordConfigProvider localRecordConfigProvider = RecordConfigProvider.as(this.cuO, this.tZc, this.tZd);
    localRecordConfigProvider.xyj = getVideoPara();
    localRecordConfigProvider.scene = 5;
    Object localObject1 = new UICustomParam.a();
    ((UICustomParam.a)localObject1).aby();
    ((UICustomParam.a)localObject1).abx();
    ((UICustomParam.a)localObject1).cP(true);
    if (cYl()) {
      ((UICustomParam.a)localObject1).abu().abv();
    }
    int i = com.tencent.mm.ui.aq.fromDPToPix(this, 32);
    if (this.mFrom != 2) {
      if (this.tZe)
      {
        localRecordConfigProvider.xyv = false;
        localRecordConfigProvider.xyq = Boolean.FALSE;
        localRecordConfigProvider.xyC = 604800000L;
        localRecordConfigProvider.xyt = (localRecordConfigProvider.xyj.duration * 1000);
        ((UICustomParam.a)localObject1).a(2131232586, 2131101179, getString(2131760002), i);
      }
    }
    label809:
    for (;;)
    {
      localRecordConfigProvider.xyk = ((UICustomParam.a)localObject1).gei;
      CaptureDataManager.xxY.xxX = this.tZf;
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.xyI;
      if (com.tencent.mm.plugin.recordvideo.jumper.a.a(this.mContext, localRecordConfigProvider)) {
        com.tencent.mm.game.report.b.a.a(this, 8763, 0, 1, com.tencent.mm.game.report.b.a.a(this.mFrom, null));
      }
      AppMethodBeat.o(41158);
      return;
      localRecordConfigProvider.xyv = true;
      localRecordConfigProvider.xyq = Boolean.TRUE;
      break;
      localRecordConfigProvider.xyv = true;
      localRecordConfigProvider.xyq = Boolean.TRUE;
      localRecordConfigProvider.xyt = 7200000;
      localRecordConfigProvider.remuxType = 2;
      Object localObject2 = getIntent().getBundleExtra("ext_data");
      Object localObject3;
      if (localObject2 != null)
      {
        localObject3 = ((Bundle)localObject2).getString("k_ext_wording");
        Object localObject4 = (VideoTransPara)((Bundle)localObject2).getParcelable("k_preferred_trans_param");
        if (localObject4 != null)
        {
          ad.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: has given trasn params: %s", new Object[] { ((VideoTransPara)localObject4).toString() });
          localRecordConfigProvider.xyj = ((VideoTransPara)localObject4);
        }
        if (!bt.isNullOrNil((String)localObject3)) {
          ((UICustomParam.a)localObject1).J((String)localObject3, getResources().getColor(2131101179));
        }
        localObject3 = ((Bundle)localObject2).getParcelableArrayList("k_ext_share_options");
        if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
        {
          this.tZa = ((GameShareOption)((ArrayList)localObject3).get(0));
          if (((ArrayList)localObject3).size() == 1) {
            ((UICustomParam.a)localObject1).a(0, 0, this.tZa.title, i);
          }
          for (;;)
          {
            this.tYZ = new SparseArray();
            localObject3 = ((ArrayList)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (GameShareOption)((Iterator)localObject3).next();
              this.tYZ.put(((GameShareOption)localObject4).id, localObject4);
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
  
  private boolean cYl()
  {
    AppMethodBeat.i(41159);
    boolean bool2 = false;
    int i = SightVideoJNI.getMp4RotateVFS(this.cuO);
    boolean bool1;
    if ((i == 0) || (i == 180))
    {
      bool1 = bool2;
      if (this.tZb.width >= this.tZb.height) {
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
        if (this.tZb.height >= this.tZb.width) {
          bool1 = true;
        }
      }
    }
  }
  
  private void gU(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(41162);
    com.tencent.mm.sdk.platformtools.aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41154);
        String str = GameVideoEditorProxyUI.a(GameVideoEditorProxyUI.this, paramString1, paramString2);
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", str);
        com.tencent.mm.bs.d.b(GameVideoEditorProxyUI.g(GameVideoEditorProxyUI.this), "webview", ".ui.tools.WebViewUI", localIntent, 131);
        AppMethodBeat.o(41154);
      }
    }, 0L);
    AppMethodBeat.o(41162);
  }
  
  private String gV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41163);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("https://game.weixin.qq.com/cgi-bin/h5/static/moment/publish.html");
    localStringBuffer.append("?video_info=");
    String str = "";
    if (paramString2 == null) {
      paramString2 = new com.tencent.mm.ac.i();
    }
    try
    {
      paramString2.h("videoUrl", paramString1);
      paramString2.h("thumbUrl", getIntent().getStringExtra("thumb_url"));
      label75:
      paramString1 = paramString2.toString();
      for (;;)
      {
        localStringBuffer.append(URLEncoder.encode(paramString1));
        localStringBuffer.append("&from=");
        localStringBuffer.append(this.mFrom);
        localStringBuffer.append("&appid=");
        localStringBuffer.append(this.mAppId);
        localStringBuffer.append("&game_info=");
        localStringBuffer.append(getIntent().getStringExtra("game_info"));
        ad.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "publish url:%s", new Object[] { localStringBuffer.toString() });
        paramString1 = localStringBuffer.toString();
        AppMethodBeat.o(41163);
        return paramString1;
        try
        {
          paramString1 = new JSONArray(paramString2).getJSONObject(0).toString();
        }
        catch (JSONException paramString1)
        {
          ad.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "json_err:%s", new Object[] { paramString1.getMessage() });
          paramString1 = str;
        }
      }
    }
    catch (com.tencent.mm.ac.g paramString1)
    {
      break label75;
    }
  }
  
  private VideoTransPara getVideoPara()
  {
    AppMethodBeat.i(41157);
    if ((this.mFrom == 3) || (this.mFrom == 5))
    {
      localVideoTransPara = com.tencent.mm.modelcontrol.d.aGQ().pd(1);
      AppMethodBeat.o(41157);
      return localVideoTransPara;
    }
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.d.aGQ().pd(0);
    AppMethodBeat.o(41157);
    return localVideoTransPara;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41161);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    int i = paramInt2;
    if (paramInt1 == 121) {
      if (paramInt2 == -1)
      {
        i = paramInt2;
        if (paramIntent != null)
        {
          i = paramInt2;
          if (this.mFrom == 3)
          {
            gU(null, paramIntent.getStringExtra("key_video_info"));
            AppMethodBeat.o(41161);
          }
        }
      }
      else
      {
        if ((paramInt2 != 0) && (paramInt2 != 3000) && (paramInt2 != 3001)) {
          break label171;
        }
        com.tencent.mm.game.report.b.a.a(this, 8763, 1, 2, com.tencent.mm.game.report.b.a.a(this.mFrom, null));
        i = paramInt2;
      }
    }
    label171:
    do
    {
      do
      {
        setResult(i, paramIntent);
        finish();
        if (this.mFrom == 3) {
          com.tencent.mm.pluginsdk.ui.tools.l.d(this.tYL, "", this.mAppId, 0, "");
        }
        AppMethodBeat.o(41161);
        return;
        if (paramInt2 != 888) {
          break;
        }
        ad.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "video edit in background");
        localObject = com.tencent.mm.plugin.game.media.background.a.gX(paramIntent.getStringExtra("key_thumb_path"), this.cuO);
        String str = paramIntent.getStringExtra("key_bg_mix_task_id");
        paramInt1 = bt.Dg(paramIntent.getIntExtra("key_video_duration", 0));
        localObject = ax.b("weixin://bgmixid/".concat(String.valueOf(str)), (String)localObject, paramInt1, this.tZb.height, this.tZb.width, 0);
        ad.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "videoInfo:%s", new Object[] { localObject });
        paramIntent.putExtra("key_video_info", (String)localObject);
        i = -1;
      } while (this.mFrom != 3);
      gU(null, paramIntent.getStringExtra("key_video_info"));
      AppMethodBeat.o(41161);
      return;
      ad.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "video check error: [%d]", new Object[] { Integer.valueOf(paramInt2) });
      Object localObject = new HashMap();
      ((Map)localObject).put("failid", Integer.valueOf(paramInt2));
      com.tencent.mm.game.report.b.a.a(this.mContext, 8763, 2, 56, com.tencent.mm.game.report.b.a.a(this.mFrom, (Map)localObject));
      t.makeText(this.mContext, 2131760008, 1).show();
      i = paramInt2;
    } while (this.mFrom != 3);
    setResult(paramInt2, paramIntent);
    finish();
    com.tencent.mm.pluginsdk.ui.tools.l.d(this.tYL, "Invalid video format", this.mAppId, -3, "Invalid video format");
    AppMethodBeat.o(41161);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41156);
    super.onCreate(paramBundle);
    this.mContext = this;
    this.mFrom = getIntent().getIntExtra("from", -1);
    this.tYL = getIntent().getStringExtra("business_type");
    this.mAppId = getIntent().getStringExtra("appid");
    this.cuO = getIntent().getStringExtra("video_path");
    boolean bool2 = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAk, "1").equals("1");
    boolean bool1;
    if (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qqs, 0) == 1)
    {
      bool1 = true;
      ad.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "video bg mix, debugOpen:%b, xLabOpen:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((!bool2) || (!bool1)) {
        break label241;
      }
      this.tZe = true;
      label158:
      ad.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "video_path:%s", new Object[] { this.cuO });
      this.tZb = com.tencent.mm.plugin.sight.base.e.axx(this.cuO);
      if (!getIntent().getBooleanExtra("need_edit", false)) {
        break label256;
      }
      if (this.tZb != null) {
        break label249;
      }
      ad.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "video is error");
      finish();
    }
    for (;;)
    {
      ad.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "onCreate");
      AppMethodBeat.o(41156);
      return;
      bool1 = false;
      break;
      label241:
      this.tZe = false;
      break label158;
      label249:
      cYk();
      continue;
      label256:
      if (!bt.isNullOrNil(this.cuO))
      {
        if (this.tZb == null)
        {
          ad.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "video is error");
          finish();
        }
        else
        {
          paramBundle = getVideoPara();
          if ((com.tencent.mm.vfs.i.aYo(this.cuO) > 104857600L) || ((paramBundle != null) && (paramBundle.duration < this.tZb.getVideoDuration())))
          {
            ad.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "videoLength(%d) > %d or videoDuration(%d) > paramDuration(%d), needEdit is invalid", new Object[] { Long.valueOf(com.tencent.mm.vfs.i.aYo(this.cuO)), Integer.valueOf(104857600), Integer.valueOf(this.tZb.getVideoDuration()), Integer.valueOf(paramBundle.duration) });
            cYk();
          }
          else
          {
            paramBundle = tTM + "vsg_output_" + System.currentTimeMillis() + ".mp4";
            String str = this.cuO;
            if (!str.equals(paramBundle))
            {
              com.tencent.mm.vfs.i.aYg(com.tencent.mm.vfs.i.aYr(paramBundle));
              com.tencent.mm.vfs.i.mz(str, paramBundle);
            }
            this.cuO = paramBundle;
            str = this.cuO;
            paramBundle = com.tencent.mm.plugin.game.media.background.a.alN(str);
            if (paramBundle == null) {}
            for (paramBundle = null;; paramBundle = ax.b(paramBundle.drH, str, paramBundle.duration, paramBundle.height, paramBundle.width, paramBundle.size))
            {
              if (paramBundle != null) {
                break label560;
              }
              finish();
              break;
              str = com.tencent.mm.plugin.game.media.background.a.gX(null, str);
              WebViewJSSDKFileItem localWebViewJSSDKFileItem = ao.eQs().aHu(str);
              if (localWebViewJSSDKFileItem != null) {
                paramBundle.kHB = localWebViewJSSDKFileItem.jUC;
              }
              paramBundle.ime.putInt("mark_edit_flag", 0);
            }
            label560:
            gU(null, paramBundle);
          }
        }
      }
      else {
        gU(getIntent().getStringExtra("video_url"), null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoEditorProxyUI
 * JD-Core Version:    0.7.0.1
 */