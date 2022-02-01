package com.tencent.mm.plugin.emoji.ui.fts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.di;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;

public class FTSEmojiDetailPageUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private String dBx;
  private String designerName;
  private String dok;
  private String dsu;
  private EmojiInfo gjb;
  private int hDt;
  private l lvx;
  private ProgressBar nwu;
  private String pEM;
  private com.tencent.mm.plugin.emoji.model.c.a pEq;
  private MMAnimateView pLD;
  private Button pLE;
  private Button pLF;
  private TextView pLG;
  private ImageView pLH;
  private View pLI;
  private boolean pLJ;
  private boolean pLK;
  private String pLL;
  private int pLM;
  private String pLN;
  private String pLO;
  private String pLP;
  private String pLQ;
  private String pLR;
  private String pLS;
  private com.tencent.mm.sdk.b.c pLT;
  private com.tencent.mm.aw.a.c.k pLU;
  private n.e pLV;
  private int scene;
  private int sourceType;
  private int type;
  
  public FTSEmojiDetailPageUI()
  {
    AppMethodBeat.i(109114);
    this.pLT = new com.tencent.mm.sdk.b.c() {};
    this.pEq = new com.tencent.mm.plugin.emoji.model.c.a()
    {
      public final void a(boolean paramAnonymousBoolean, EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(109110);
        if ((paramAnonymousEmojiInfo != null) && (paramAnonymousBoolean) && (FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this) != null) && (FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).Lb().equals(paramAnonymousEmojiInfo.Lb())))
        {
          ad.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiServiceCallback onDownload %s", new Object[] { FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).Lb() });
          aq.f(new Runnable()
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
        ad.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "somethings error.");
        AppMethodBeat.o(109110);
      }
    };
    this.pLU = new com.tencent.mm.aw.a.c.k()
    {
      public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(109112);
        ad.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
        if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_encrypturl)))
        {
          paramAnonymousString = new e(paramAnonymousVarArgs[0].toString());
          if (paramAnonymousString.exists())
          {
            FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_md5 = i.aPK(com.tencent.mm.vfs.q.B(paramAnonymousString.mUri));
            paramAnonymousView = FTSEmojiDetailPageUI.this;
            paramAnonymousBitmap = com.tencent.mm.emoji.d.a.gqn;
            FTSEmojiDetailPageUI.a(paramAnonymousView, EmojiLogic.Q(com.tencent.mm.emoji.d.a.agp(), "", FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_md5));
            i.mz(com.tencent.mm.vfs.q.B(paramAnonymousString.fOK()), FTSEmojiDetailPageUI.f(FTSEmojiDetailPageUI.this));
            aq.f(new Runnable()
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
    this.pLV = new n.e()
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
  
  private void ciA()
  {
    AppMethodBeat.i(109120);
    EmojiInfo localEmojiInfo2 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILn.aUK(this.gjb.Lb());
    EmojiInfo localEmojiInfo1 = localEmojiInfo2;
    if (localEmojiInfo2 == null) {
      localEmojiInfo1 = this.gjb;
    }
    if (localEmojiInfo1.field_catalog == EmojiGroupInfo.OeM)
    {
      this.pLE.setEnabled(false);
      this.pLE.setText(2131755275);
      AppMethodBeat.o(109120);
      return;
    }
    this.pLE.setText(2131758308);
    if (i.fv(this.dBx))
    {
      this.pLE.setEnabled(true);
      AppMethodBeat.o(109120);
      return;
    }
    this.pLE.setEnabled(false);
    AppMethodBeat.o(109120);
  }
  
  private boolean ciB()
  {
    AppMethodBeat.i(109121);
    if ((!bt.isNullOrNil(this.pLS)) && (this.sourceType == 1))
    {
      AppMethodBeat.o(109121);
      return true;
    }
    AppMethodBeat.o(109121);
    return false;
  }
  
  private void ciz()
  {
    AppMethodBeat.i(109119);
    this.pLF.setEnabled(true);
    AppMethodBeat.o(109119);
  }
  
  private void hq(boolean paramBoolean)
  {
    AppMethodBeat.i(109118);
    if (paramBoolean) {
      setMMTitle(this.gjb.getName());
    }
    Object localObject1;
    switch (this.type)
    {
    default: 
      if (i.fv(this.dBx))
      {
        this.nwu.setVisibility(8);
        this.pLD.setVisibility(0);
        localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILn.aUK(this.gjb.Lb());
        if ((localObject1 != null) && ((((EmojiInfo)localObject1).field_reserved4 & EmojiInfo.Ofi) == EmojiInfo.Ofi))
        {
          ad.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: decrypt");
          this.pLD.g(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((EmojiInfo)localObject1), "");
          label151:
          ciA();
          ciz();
        }
      }
      break;
    }
    for (;;)
    {
      if (this.pLJ) {
        this.pLE.setVisibility(8);
      }
      AppMethodBeat.o(109118);
      return;
      com.tencent.mm.aw.q.aIJ().loadImage(this.pLN, this.pLH);
      this.pLG.setText(this.pLO);
      this.dBx = this.gjb.gzQ();
      break;
      com.tencent.mm.aw.q.aIJ().loadImage(this.pLR, this.pLH);
      this.pLG.setText(this.designerName);
      this.dBx = this.gjb.gzQ();
      break;
      this.pLH.setVisibility(8);
      if (!bt.isNullOrNil(this.pLQ))
      {
        this.pLG.setText(this.pLQ);
        break;
      }
      this.pLG.setText(2131762944);
      break;
      ad.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: no decrypt");
      this.pLD.setImageFilePath(this.dBx);
      break label151;
      if (paramBoolean) {
        if (this.type == 4)
        {
          localObject1 = new e(getCacheDir(), com.tencent.mm.b.g.getMessageDigest(this.gjb.field_encrypturl.getBytes()));
          Object localObject2;
          if (((e)localObject1).exists())
          {
            this.gjb.field_md5 = i.aPK(com.tencent.mm.vfs.q.B(((e)localObject1).mUri));
            localObject2 = com.tencent.mm.emoji.d.a.gqn;
            localObject2 = EmojiLogic.Q(com.tencent.mm.emoji.d.a.agp(), "", this.gjb.field_md5);
            if (!i.fv((String)localObject2)) {
              i.mz(com.tencent.mm.vfs.q.B(((e)localObject1).fOK()), (String)localObject2);
            }
            this.dBx = ((String)localObject2);
            hq(false);
          }
          else
          {
            localObject2 = new com.tencent.mm.aw.a.a.c.a();
            ((com.tencent.mm.aw.a.a.c.a)localObject2).idr = true;
            ((com.tencent.mm.aw.a.a.c.a)localObject2).hdP = com.tencent.mm.vfs.q.B(((e)localObject1).fOK());
            ((com.tencent.mm.aw.a.a.c.a)localObject2).idR = new Object[] { com.tencent.mm.vfs.q.B(((e)localObject1).fOK()) };
            localObject1 = ((com.tencent.mm.aw.a.a.c.a)localObject2).aJc();
            com.tencent.mm.plugin.emoji.model.k.cgO().a(this.gjb.field_encrypturl, null, (com.tencent.mm.aw.a.a.c)localObject1, this.pLU);
          }
        }
        else
        {
          this.pLD.setVisibility(8);
          this.nwu.setVisibility(0);
          this.pLE.setText(2131758308);
          this.pLF.setText(2131762566);
          this.pLE.setEnabled(false);
          this.pLF.setEnabled(false);
          com.tencent.mm.plugin.emoji.model.k.cgP().u(this.gjb);
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
      com.tencent.mm.ui.widget.snackbar.b.n(this, getContext().getString(2131755887));
    }
    AppMethodBeat.o(109117);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109115);
    super.onCreate(paramBundle);
    this.pLE = ((Button)findViewById(2131299331));
    this.pLF = ((Button)findViewById(2131299432));
    this.pLD = ((MMAnimateView)findViewById(2131299379));
    this.nwu = ((ProgressBar)findViewById(2131301506));
    this.pLG = ((TextView)findViewById(2131299435));
    this.pLH = ((ImageView)findViewById(2131299434));
    this.pLI = findViewById(2131297432);
    setBackBtn(new FTSEmojiDetailPageUI.1(this));
    this.pLE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109103);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).Lb(), FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_designerID, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_thumbUrl, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_activityid);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109103);
      }
    });
    this.pLF.setOnClickListener(new FTSEmojiDetailPageUI.6(this));
    this.pLI.setOnClickListener(new FTSEmojiDetailPageUI.7(this));
    addIconOptionMenu(0, 2131690603, new FTSEmojiDetailPageUI.8(this));
    this.type = getIntent().getIntExtra("extra_type", 0);
    this.scene = getIntent().getIntExtra("extra_scence", 0);
    this.gjb = new EmojiInfo();
    this.gjb.field_designerID = getIntent().getStringExtra("id");
    this.gjb.field_name = getIntent().getStringExtra("extra_emoji_name");
    this.gjb.field_aeskey = getIntent().getStringExtra("extra_aeskey");
    this.gjb.field_encrypturl = getIntent().getStringExtra("extra_encrypt_url");
    this.gjb.field_thumbUrl = getIntent().getStringExtra("extra_thumb_url");
    this.gjb.field_md5 = getIntent().getStringExtra("extra_md5");
    this.gjb.field_groupId = getIntent().getStringExtra("extra_product_id");
    this.dok = this.gjb.field_groupId;
    this.pLO = getIntent().getStringExtra("extra_product_name");
    this.pLN = getIntent().getStringExtra("productUrl");
    this.pLP = getIntent().getStringExtra("extra_article_url");
    this.pLQ = getIntent().getStringExtra("extra_article_name");
    this.dsu = this.gjb.field_designerID;
    this.designerName = getIntent().getStringExtra("name");
    this.pLR = getIntent().getStringExtra("headurl");
    this.pLS = getIntent().getStringExtra("weapp_user_name");
    this.hDt = getIntent().getIntExtra("weapp_version", 0);
    this.sourceType = getIntent().getIntExtra("source_type", 0);
    this.pLL = getIntent().getStringExtra("searchID");
    this.pEM = getIntent().getStringExtra("docID");
    this.pLM = getIntent().getIntExtra("search_type", 0);
    this.pLJ = getIntent().getBooleanExtra("disableAddSticker", false);
    this.pLK = getIntent().getBooleanExtra("needSavePhotosAlbum", false);
    paramBundle = getIntent().getStringExtra("activityId");
    if (!bt.isNullOrNil(paramBundle)) {
      this.gjb.field_activityid = paramBundle;
    }
    com.tencent.mm.sdk.b.a.IbL.c(this.pLT);
    com.tencent.mm.plugin.emoji.model.k.cgP().pDW = this.pEq;
    am.h(this.scene, this.pLL, this.pEM, this.pLM);
    hq(true);
    ad.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "localPath=%s", new Object[] { this.dBx });
    am.h(this.scene, this.pLL, this.pEM, this.pLM);
    AppMethodBeat.o(109115);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109122);
    com.tencent.mm.sdk.b.a.IbL.d(this.pLT);
    com.tencent.mm.plugin.emoji.model.k.cgP().pDW = null;
    super.onDestroy();
    AppMethodBeat.o(109122);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109116);
    super.onResume();
    hq(false);
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