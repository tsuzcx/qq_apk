package com.tencent.mm.plugin.emoji.ui.fts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.df;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.snackbar.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.util.List;

public class FTSEmojiDetailPageUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private String dcO;
  private String designerName;
  private String dgW;
  private String dpK;
  private EmojiInfo fPB;
  private int hlk;
  private com.tencent.mm.ui.tools.l kYv;
  private ProgressBar mVX;
  private com.tencent.mm.plugin.emoji.model.c.a paG;
  private String pbc;
  private MMAnimateView pib;
  private Button pic;
  private Button pie;
  private TextView pif;
  private ImageView pig;
  private View pih;
  private boolean pii;
  private boolean pij;
  private String pik;
  private int pil;
  private String pim;
  private String pio;
  private String pip;
  private String piq;
  private String pir;
  private String pis;
  private com.tencent.mm.sdk.b.c pit;
  private com.tencent.mm.av.a.c.k piu;
  private n.d piv;
  private int scene;
  private int sourceType;
  private int type;
  
  public FTSEmojiDetailPageUI()
  {
    AppMethodBeat.i(109114);
    this.pit = new com.tencent.mm.sdk.b.c() {};
    this.paG = new com.tencent.mm.plugin.emoji.model.c.a()
    {
      public final void a(boolean paramAnonymousBoolean, EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(109110);
        if ((paramAnonymousEmojiInfo != null) && (paramAnonymousBoolean) && (FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this) != null) && (FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).JC().equals(paramAnonymousEmojiInfo.JC())))
        {
          ac.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiServiceCallback onDownload %s", new Object[] { FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).JC() });
          ap.f(new Runnable()
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
        ac.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "somethings error.");
        AppMethodBeat.o(109110);
      }
    };
    this.piu = new com.tencent.mm.av.a.c.k()
    {
      public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(109112);
        ac.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
        if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_encrypturl)))
        {
          paramAnonymousString = new e(paramAnonymousVarArgs[0].toString());
          if (paramAnonymousString.exists())
          {
            FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_md5 = i.aKe(com.tencent.mm.vfs.q.B(paramAnonymousString.mUri));
            paramAnonymousView = FTSEmojiDetailPageUI.this;
            paramAnonymousBitmap = com.tencent.mm.emoji.d.a.fWM;
            FTSEmojiDetailPageUI.a(paramAnonymousView, EmojiLogic.P(com.tencent.mm.emoji.d.a.adJ(), "", FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_md5));
            i.lZ(com.tencent.mm.vfs.q.B(paramAnonymousString.fxV()), FTSEmojiDetailPageUI.f(FTSEmojiDetailPageUI.this));
            ap.f(new Runnable()
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
    this.piv = new n.d()
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
  
  private void cdW()
  {
    AppMethodBeat.i(109119);
    this.pie.setEnabled(true);
    AppMethodBeat.o(109119);
  }
  
  private void cdX()
  {
    AppMethodBeat.i(109120);
    EmojiInfo localEmojiInfo2 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.aOT(this.fPB.JC());
    EmojiInfo localEmojiInfo1 = localEmojiInfo2;
    if (localEmojiInfo2 == null) {
      localEmojiInfo1 = this.fPB;
    }
    if (localEmojiInfo1.field_catalog == EmojiGroupInfo.Jsr)
    {
      this.pic.setEnabled(false);
      this.pic.setText(2131755275);
      AppMethodBeat.o(109120);
      return;
    }
    this.pic.setText(2131758308);
    if (i.eA(this.dpK))
    {
      this.pic.setEnabled(true);
      AppMethodBeat.o(109120);
      return;
    }
    this.pic.setEnabled(false);
    AppMethodBeat.o(109120);
  }
  
  private boolean cdY()
  {
    AppMethodBeat.i(109121);
    if ((!bs.isNullOrNil(this.pis)) && (this.sourceType == 1))
    {
      AppMethodBeat.o(109121);
      return true;
    }
    AppMethodBeat.o(109121);
    return false;
  }
  
  private void hj(boolean paramBoolean)
  {
    AppMethodBeat.i(109118);
    if (paramBoolean) {
      setMMTitle(this.fPB.getName());
    }
    Object localObject1;
    switch (this.type)
    {
    default: 
      if (i.eA(this.dpK))
      {
        this.mVX.setVisibility(8);
        this.pib.setVisibility(0);
        localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.aOT(this.fPB.JC());
        if ((localObject1 != null) && ((((EmojiInfo)localObject1).field_reserved4 & EmojiInfo.Kgm) == EmojiInfo.Kgm))
        {
          ac.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: decrypt");
          this.pib.g(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((EmojiInfo)localObject1), "");
          label151:
          cdX();
          cdW();
        }
      }
      break;
    }
    for (;;)
    {
      if (this.pii) {
        this.pic.setVisibility(8);
      }
      AppMethodBeat.o(109118);
      return;
      o.aFB().loadImage(this.pim, this.pig);
      this.pif.setText(this.pio);
      this.dpK = this.fPB.ghd();
      break;
      o.aFB().loadImage(this.pir, this.pig);
      this.pif.setText(this.designerName);
      this.dpK = this.fPB.ghd();
      break;
      this.pig.setVisibility(8);
      if (!bs.isNullOrNil(this.piq))
      {
        this.pif.setText(this.piq);
        break;
      }
      this.pif.setText(2131762944);
      break;
      ac.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: no decrypt");
      this.pib.setImageFilePath(this.dpK);
      break label151;
      if (paramBoolean) {
        if (this.type == 4)
        {
          localObject1 = new e(getCacheDir(), com.tencent.mm.b.g.getMessageDigest(this.fPB.field_encrypturl.getBytes()));
          Object localObject2;
          if (((e)localObject1).exists())
          {
            this.fPB.field_md5 = i.aKe(com.tencent.mm.vfs.q.B(((e)localObject1).mUri));
            localObject2 = com.tencent.mm.emoji.d.a.fWM;
            localObject2 = EmojiLogic.P(com.tencent.mm.emoji.d.a.adJ(), "", this.fPB.field_md5);
            if (!i.eA((String)localObject2)) {
              i.lZ(com.tencent.mm.vfs.q.B(((e)localObject1).fxV()), (String)localObject2);
            }
            this.dpK = ((String)localObject2);
            hj(false);
          }
          else
          {
            localObject2 = new com.tencent.mm.av.a.a.c.a();
            ((com.tencent.mm.av.a.a.c.a)localObject2).hKx = true;
            ((com.tencent.mm.av.a.a.c.a)localObject2).gKe = com.tencent.mm.vfs.q.B(((e)localObject1).fxV());
            ((com.tencent.mm.av.a.a.c.a)localObject2).hKW = new Object[] { com.tencent.mm.vfs.q.B(((e)localObject1).fxV()) };
            localObject1 = ((com.tencent.mm.av.a.a.c.a)localObject2).aFT();
            com.tencent.mm.plugin.emoji.model.k.cck().a(this.fPB.field_encrypturl, null, (com.tencent.mm.av.a.a.c)localObject1, this.piu);
          }
        }
        else
        {
          this.pib.setVisibility(8);
          this.mVX.setVisibility(0);
          this.pic.setText(2131758308);
          this.pie.setText(2131762566);
          this.pic.setEnabled(false);
          this.pie.setEnabled(false);
          com.tencent.mm.plugin.emoji.model.k.ccl().u(this.fPB);
        }
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131494199;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109117);
    if ((paramInt1 == 1001) && (paramInt2 == -1)) {
      b.n(this, getContext().getString(2131755887));
    }
    AppMethodBeat.o(109117);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109115);
    super.onCreate(paramBundle);
    this.pic = ((Button)findViewById(2131299331));
    this.pie = ((Button)findViewById(2131299432));
    this.pib = ((MMAnimateView)findViewById(2131299379));
    this.mVX = ((ProgressBar)findViewById(2131301506));
    this.pif = ((TextView)findViewById(2131299435));
    this.pig = ((ImageView)findViewById(2131299434));
    this.pih = findViewById(2131297432);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109099);
        FTSEmojiDetailPageUI.this.finish();
        AppMethodBeat.o(109099);
        return false;
      }
    });
    this.pic.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109103);
        FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).JC(), FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_designerID, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_thumbUrl, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_activityid);
        AppMethodBeat.o(109103);
      }
    });
    this.pie.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109104);
        FTSEmojiDetailPageUI.b(FTSEmojiDetailPageUI.this);
        AppMethodBeat.o(109104);
      }
    });
    this.pih.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109105);
        FTSEmojiDetailPageUI.c(FTSEmojiDetailPageUI.this);
        AppMethodBeat.o(109105);
      }
    });
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109106);
        FTSEmojiDetailPageUI.d(FTSEmojiDetailPageUI.this);
        AppMethodBeat.o(109106);
        return true;
      }
    });
    this.type = getIntent().getIntExtra("extra_type", 0);
    this.scene = getIntent().getIntExtra("extra_scence", 0);
    this.fPB = new EmojiInfo();
    this.fPB.field_designerID = getIntent().getStringExtra("id");
    this.fPB.field_name = getIntent().getStringExtra("extra_emoji_name");
    this.fPB.field_aeskey = getIntent().getStringExtra("extra_aeskey");
    this.fPB.field_encrypturl = getIntent().getStringExtra("extra_encrypt_url");
    this.fPB.field_thumbUrl = getIntent().getStringExtra("extra_thumb_url");
    this.fPB.field_md5 = getIntent().getStringExtra("extra_md5");
    this.fPB.field_groupId = getIntent().getStringExtra("extra_product_id");
    this.dcO = this.fPB.field_groupId;
    this.pio = getIntent().getStringExtra("extra_product_name");
    this.pim = getIntent().getStringExtra("productUrl");
    this.pip = getIntent().getStringExtra("extra_article_url");
    this.piq = getIntent().getStringExtra("extra_article_name");
    this.dgW = this.fPB.field_designerID;
    this.designerName = getIntent().getStringExtra("name");
    this.pir = getIntent().getStringExtra("headurl");
    this.pis = getIntent().getStringExtra("weapp_user_name");
    this.hlk = getIntent().getIntExtra("weapp_version", 0);
    this.sourceType = getIntent().getIntExtra("source_type", 0);
    this.pik = getIntent().getStringExtra("searchID");
    this.pbc = getIntent().getStringExtra("docID");
    this.pil = getIntent().getIntExtra("search_type", 0);
    this.pii = getIntent().getBooleanExtra("disableAddSticker", false);
    this.pij = getIntent().getBooleanExtra("needSavePhotosAlbum", false);
    paramBundle = getIntent().getStringExtra("activityId");
    if (!bs.isNullOrNil(paramBundle)) {
      this.fPB.field_activityid = paramBundle;
    }
    com.tencent.mm.sdk.b.a.GpY.c(this.pit);
    com.tencent.mm.plugin.emoji.model.k.ccl().pam = this.paG;
    ai.h(this.scene, this.pik, this.pbc, this.pil);
    hj(true);
    ac.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "localPath=%s", new Object[] { this.dpK });
    ai.h(this.scene, this.pik, this.pbc, this.pil);
    AppMethodBeat.o(109115);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109122);
    com.tencent.mm.sdk.b.a.GpY.d(this.pit);
    com.tencent.mm.plugin.emoji.model.k.ccl().pam = null;
    super.onDestroy();
    AppMethodBeat.o(109122);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109116);
    super.onResume();
    hj(false);
    AppMethodBeat.o(109116);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI
 * JD-Core Version:    0.7.0.1
 */