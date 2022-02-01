package com.tencent.mm.plugin.emoji.ui.fts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.a.c.k;
import com.tencent.mm.b.g;
import com.tencent.mm.f.a.dr;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.i.g;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i.a;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.ui.widget.a.e.b;

public class FTSEmojiDetailPageUI
  extends MMActivity
  implements com.tencent.mm.an.i
{
  private String designerName;
  private String fDy;
  private String fNU;
  private EmojiInfo jHh;
  private int lpR;
  private m pGE;
  private String productId;
  private ProgressBar rOK;
  private int scene;
  private int sourceType;
  private int type;
  private i.a uEE;
  private String uEN;
  private boolean uMA;
  private boolean uMB;
  private String uMC;
  private int uMD;
  private String uME;
  private String uMF;
  private String uMG;
  private String uMH;
  private String uMI;
  private String uMJ;
  private IListener uMK;
  private k uML;
  private q.g uMM;
  private MMAnimateView uMu;
  private Button uMv;
  private Button uMw;
  private TextView uMx;
  private ImageView uMy;
  private View uMz;
  
  public FTSEmojiDetailPageUI()
  {
    AppMethodBeat.i(109114);
    this.uMK = new IListener() {};
    this.uEE = new i.a()
    {
      public final void a(boolean paramAnonymousBoolean, EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(109110);
        if ((paramAnonymousEmojiInfo != null) && (paramAnonymousBoolean) && (FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this) != null) && (FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).getMd5().equals(paramAnonymousEmojiInfo.getMd5())))
        {
          Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiServiceCallback onDownload %s", new Object[] { FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).getMd5() });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(109109);
              FTSEmojiDetailPageUI.e(FTSEmojiDetailPageUI.this);
              AppMethodBeat.o(109109);
            }
          });
          AppMethodBeat.o(109110);
          return;
        }
        Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "somethings error.");
        AppMethodBeat.o(109110);
      }
    };
    this.uML = new k()
    {
      public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(109112);
        Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
        if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_encrypturl)))
        {
          paramAnonymousString = new com.tencent.mm.vfs.q(paramAnonymousVarArgs[0].toString());
          if (paramAnonymousString.ifE())
          {
            FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_md5 = com.tencent.mm.vfs.u.buc(paramAnonymousString.getPath());
            FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this, EmojiLogic.T(com.tencent.mm.plugin.emoji.i.b.bcb(), "", FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_md5));
            com.tencent.mm.vfs.u.on(paramAnonymousString.bOF(), FTSEmojiDetailPageUI.f(FTSEmojiDetailPageUI.this));
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(109111);
                FTSEmojiDetailPageUI.e(FTSEmojiDetailPageUI.this);
                AppMethodBeat.o(109111);
              }
            });
          }
        }
        AppMethodBeat.o(109112);
      }
    };
    this.uMM = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(109101);
        FTSEmojiDetailPageUI.g(FTSEmojiDetailPageUI.this);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(109101);
          return;
          FTSEmojiDetailPageUI.h(FTSEmojiDetailPageUI.this);
          AppMethodBeat.o(109101);
          return;
          FTSEmojiDetailPageUI.i(FTSEmojiDetailPageUI.this);
        }
      }
    };
    AppMethodBeat.o(109114);
  }
  
  private void cWx()
  {
    AppMethodBeat.i(109119);
    this.uMw.setEnabled(true);
    AppMethodBeat.o(109119);
  }
  
  private void cWy()
  {
    AppMethodBeat.i(109120);
    EmojiInfo localEmojiInfo2 = p.getEmojiStorageMgr().VFH.bxK(this.jHh.getMd5());
    EmojiInfo localEmojiInfo1 = localEmojiInfo2;
    if (localEmojiInfo2 == null) {
      localEmojiInfo1 = this.jHh;
    }
    if (localEmojiInfo1.field_catalog == EmojiGroupInfo.YCw)
    {
      this.uMv.setEnabled(false);
      this.uMv.setText(i.h.app_added);
      AppMethodBeat.o(109120);
      return;
    }
    this.uMv.setText(i.h.emoji_store_add_emoji);
    if (com.tencent.mm.vfs.u.agG(this.fNU))
    {
      this.uMv.setEnabled(true);
      AppMethodBeat.o(109120);
      return;
    }
    this.uMv.setEnabled(false);
    AppMethodBeat.o(109120);
  }
  
  private boolean cWz()
  {
    AppMethodBeat.i(109121);
    if ((!Util.isNullOrNil(this.uMJ)) && (this.sourceType == 1))
    {
      AppMethodBeat.o(109121);
      return true;
    }
    AppMethodBeat.o(109121);
    return false;
  }
  
  private void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(109118);
    if (paramBoolean) {
      setMMTitle(this.jHh.getName());
    }
    Object localObject1;
    switch (this.type)
    {
    default: 
      if (com.tencent.mm.vfs.u.agG(this.fNU))
      {
        this.rOK.setVisibility(8);
        this.uMu.setVisibility(0);
        localObject1 = p.getEmojiStorageMgr().VFH.bxK(this.jHh.getMd5());
        if ((localObject1 != null) && ((((EmojiInfo)localObject1).field_reserved4 & EmojiInfo.ZuM) == EmojiInfo.ZuM))
        {
          Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: decrypt");
          this.uMu.h(((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((EmojiInfo)localObject1), "");
          label151:
          cWy();
          cWx();
        }
      }
      break;
    }
    for (;;)
    {
      if (this.uMA) {
        this.uMv.setVisibility(8);
      }
      AppMethodBeat.o(109118);
      return;
      com.tencent.mm.ay.q.bml().loadImage(this.uME, this.uMy);
      this.uMx.setText(this.uMF);
      this.fNU = this.jHh.ifh();
      break;
      com.tencent.mm.ay.q.bml().loadImage(this.uMI, this.uMy);
      this.uMx.setText(this.designerName);
      this.fNU = this.jHh.ifh();
      break;
      this.uMy.setVisibility(8);
      if (!Util.isNullOrNil(this.uMH))
      {
        this.uMx.setText(this.uMH);
        break;
      }
      this.uMx.setText(i.h.search_emoji_network_source);
      break;
      Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: no decrypt");
      this.uMu.setImageFilePath(this.fNU);
      break label151;
      if (paramBoolean) {
        if (this.type == 4)
        {
          localObject1 = new com.tencent.mm.vfs.q(getCacheDir(), g.getMessageDigest(this.jHh.field_encrypturl.getBytes()));
          Object localObject2;
          if (((com.tencent.mm.vfs.q)localObject1).ifE())
          {
            this.jHh.field_md5 = com.tencent.mm.vfs.u.buc(((com.tencent.mm.vfs.q)localObject1).getPath());
            localObject2 = EmojiLogic.T(com.tencent.mm.plugin.emoji.i.b.bcb(), "", this.jHh.field_md5);
            if (!com.tencent.mm.vfs.u.agG((String)localObject2)) {
              com.tencent.mm.vfs.u.on(((com.tencent.mm.vfs.q)localObject1).bOF(), (String)localObject2);
            }
            this.fNU = ((String)localObject2);
            jq(false);
          }
          else
          {
            localObject2 = new c.a();
            ((c.a)localObject2).lRD = true;
            ((c.a)localObject2).fullPath = ((com.tencent.mm.vfs.q)localObject1).bOF();
            ((c.a)localObject2).lSd = new Object[] { ((com.tencent.mm.vfs.q)localObject1).bOF() };
            localObject1 = ((c.a)localObject2).bmL();
            p.cUL().a(this.jHh.field_encrypturl, null, (c)localObject1, this.uML);
          }
        }
        else
        {
          this.uMu.setVisibility(8);
          this.rOK.setVisibility(0);
          this.uMv.setText(i.h.emoji_store_add_emoji);
          this.uMw.setText(i.h.retransmits);
          this.uMv.setEnabled(false);
          this.uMw.setEnabled(false);
          p.cUM().u(this.jHh);
        }
      }
    }
  }
  
  public int getLayoutId()
  {
    return i.f.fts_emoji_detail_page_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109117);
    if ((paramInt1 == 1001) && (paramInt2 == -1)) {
      com.tencent.mm.ui.widget.snackbar.b.r(this, getContext().getString(i.h.app_sent));
    }
    AppMethodBeat.o(109117);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109115);
    super.onCreate(paramBundle);
    this.uMv = ((Button)findViewById(i.e.emoji_add_btn));
    this.uMw = ((Button)findViewById(i.e.emoji_send_btn));
    this.uMu = ((MMAnimateView)findViewById(i.e.emoji_image_iv));
    this.rOK = ((ProgressBar)findViewById(i.e.loading_pb));
    this.uMx = ((TextView)findViewById(i.e.emoji_source_title_tv));
    this.uMy = ((ImageView)findViewById(i.e.emoji_source_iv));
    this.uMz = findViewById(i.e.bottom_bar);
    setBackBtn(new FTSEmojiDetailPageUI.1(this));
    this.uMv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109103);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).getMd5(), FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_designerID, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_thumbUrl, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_activityid);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109103);
      }
    });
    this.uMw.setOnClickListener(new FTSEmojiDetailPageUI.6(this));
    this.uMz.setOnClickListener(new FTSEmojiDetailPageUI.7(this));
    addIconOptionMenu(0, i.g.icons_outlined_more, new FTSEmojiDetailPageUI.8(this));
    this.type = getIntent().getIntExtra("extra_type", 0);
    this.scene = getIntent().getIntExtra("extra_scence", 0);
    this.jHh = new EmojiInfo();
    this.jHh.field_designerID = getIntent().getStringExtra("id");
    this.jHh.field_name = getIntent().getStringExtra("extra_emoji_name");
    this.jHh.field_aeskey = getIntent().getStringExtra("extra_aeskey");
    this.jHh.field_encrypturl = getIntent().getStringExtra("extra_encrypt_url");
    this.jHh.field_thumbUrl = getIntent().getStringExtra("extra_thumb_url");
    this.jHh.field_md5 = getIntent().getStringExtra("extra_md5");
    this.jHh.field_groupId = getIntent().getStringExtra("extra_product_id");
    this.productId = this.jHh.field_groupId;
    this.uMF = getIntent().getStringExtra("extra_product_name");
    this.uME = getIntent().getStringExtra("productUrl");
    this.uMG = getIntent().getStringExtra("extra_article_url");
    this.uMH = getIntent().getStringExtra("extra_article_name");
    this.fDy = this.jHh.field_designerID;
    this.designerName = getIntent().getStringExtra("name");
    this.uMI = getIntent().getStringExtra("headurl");
    this.uMJ = getIntent().getStringExtra("weapp_user_name");
    this.lpR = getIntent().getIntExtra("weapp_version", 0);
    this.sourceType = getIntent().getIntExtra("source_type", 0);
    this.uMC = getIntent().getStringExtra("searchID");
    this.uEN = getIntent().getStringExtra("docID");
    this.uMD = getIntent().getIntExtra("search_type", 0);
    this.uMA = getIntent().getBooleanExtra("disableAddSticker", false);
    this.uMB = getIntent().getBooleanExtra("needSavePhotosAlbum", false);
    paramBundle = getIntent().getStringExtra("activityId");
    if (!Util.isNullOrNil(paramBundle)) {
      this.jHh.field_activityid = paramBundle;
    }
    EventCenter.instance.addListener(this.uMK);
    p.cUM().uEk = this.uEE;
    ar.h(this.scene, this.uMC, this.uEN, this.uMD);
    jq(true);
    Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "localPath=%s", new Object[] { this.fNU });
    ar.h(this.scene, this.uMC, this.uEN, this.uMD);
    AppMethodBeat.o(109115);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109122);
    EventCenter.instance.removeListener(this.uMK);
    p.cUM().uEk = null;
    super.onDestroy();
    AppMethodBeat.o(109122);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109116);
    super.onResume();
    jq(false);
    AppMethodBeat.o(109116);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI
 * JD-Core Version:    0.7.0.1
 */