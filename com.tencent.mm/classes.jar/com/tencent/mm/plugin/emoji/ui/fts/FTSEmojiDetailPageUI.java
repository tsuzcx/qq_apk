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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;

public class FTSEmojiDetailPageUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private String dCC;
  private String designerName;
  private String dpp;
  private String dtA;
  private EmojiInfo glt;
  private int hGl;
  private l lzV;
  private ProgressBar nBP;
  private com.tencent.mm.plugin.emoji.model.c.a pKU;
  private String pLq;
  private n.e pSA;
  private MMAnimateView pSi;
  private Button pSj;
  private Button pSk;
  private TextView pSl;
  private ImageView pSm;
  private View pSn;
  private boolean pSo;
  private boolean pSp;
  private String pSq;
  private int pSr;
  private String pSs;
  private String pSt;
  private String pSu;
  private String pSv;
  private String pSw;
  private String pSx;
  private com.tencent.mm.sdk.b.c pSy;
  private com.tencent.mm.av.a.c.k pSz;
  private int scene;
  private int sourceType;
  private int type;
  
  public FTSEmojiDetailPageUI()
  {
    AppMethodBeat.i(109114);
    this.pSy = new com.tencent.mm.sdk.b.c() {};
    this.pKU = new com.tencent.mm.plugin.emoji.model.c.a()
    {
      public final void a(boolean paramAnonymousBoolean, EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(109110);
        if ((paramAnonymousEmojiInfo != null) && (paramAnonymousBoolean) && (FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this) != null) && (FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).Lj().equals(paramAnonymousEmojiInfo.Lj())))
        {
          ae.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiServiceCallback onDownload %s", new Object[] { FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).Lj() });
          ar.f(new Runnable()
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
        ae.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "somethings error.");
        AppMethodBeat.o(109110);
      }
    };
    this.pSz = new com.tencent.mm.av.a.c.k()
    {
      public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(109112);
        ae.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
        if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_encrypturl)))
        {
          paramAnonymousString = new com.tencent.mm.vfs.k(paramAnonymousVarArgs[0].toString());
          if (paramAnonymousString.exists())
          {
            FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_md5 = o.aRh(w.B(paramAnonymousString.mUri));
            paramAnonymousView = FTSEmojiDetailPageUI.this;
            paramAnonymousBitmap = com.tencent.mm.emoji.d.a.gsI;
            FTSEmojiDetailPageUI.a(paramAnonymousView, EmojiLogic.R(com.tencent.mm.emoji.d.a.agD(), "", FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_md5));
            o.mF(w.B(paramAnonymousString.fTh()), FTSEmojiDetailPageUI.f(FTSEmojiDetailPageUI.this));
            ar.f(new Runnable()
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
    this.pSA = new n.e()
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
  
  private void cjP()
  {
    AppMethodBeat.i(109119);
    this.pSk.setEnabled(true);
    AppMethodBeat.o(109119);
  }
  
  private void cjQ()
  {
    AppMethodBeat.i(109120);
    EmojiInfo localEmojiInfo2 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfU.aWl(this.glt.Lj());
    EmojiInfo localEmojiInfo1 = localEmojiInfo2;
    if (localEmojiInfo2 == null) {
      localEmojiInfo1 = this.glt;
    }
    if (localEmojiInfo1.field_catalog == EmojiGroupInfo.OzT)
    {
      this.pSj.setEnabled(false);
      this.pSj.setText(2131755275);
      AppMethodBeat.o(109120);
      return;
    }
    this.pSj.setText(2131758308);
    if (o.fB(this.dCC))
    {
      this.pSj.setEnabled(true);
      AppMethodBeat.o(109120);
      return;
    }
    this.pSj.setEnabled(false);
    AppMethodBeat.o(109120);
  }
  
  private boolean cjR()
  {
    AppMethodBeat.i(109121);
    if ((!bu.isNullOrNil(this.pSx)) && (this.sourceType == 1))
    {
      AppMethodBeat.o(109121);
      return true;
    }
    AppMethodBeat.o(109121);
    return false;
  }
  
  private void hr(boolean paramBoolean)
  {
    AppMethodBeat.i(109118);
    if (paramBoolean) {
      setMMTitle(this.glt.getName());
    }
    Object localObject1;
    switch (this.type)
    {
    default: 
      if (o.fB(this.dCC))
      {
        this.nBP.setVisibility(8);
        this.pSi.setVisibility(0);
        localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfU.aWl(this.glt.Lj());
        if ((localObject1 != null) && ((((EmojiInfo)localObject1).field_reserved4 & EmojiInfo.OAp) == EmojiInfo.OAp))
        {
          ae.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: decrypt");
          this.pSi.g(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((EmojiInfo)localObject1), "");
          label151:
          cjQ();
          cjP();
        }
      }
      break;
    }
    for (;;)
    {
      if (this.pSo) {
        this.pSj.setVisibility(8);
      }
      AppMethodBeat.o(109118);
      return;
      com.tencent.mm.av.q.aJb().loadImage(this.pSs, this.pSm);
      this.pSl.setText(this.pSt);
      this.dCC = this.glt.fSQ();
      break;
      com.tencent.mm.av.q.aJb().loadImage(this.pSw, this.pSm);
      this.pSl.setText(this.designerName);
      this.dCC = this.glt.fSQ();
      break;
      this.pSm.setVisibility(8);
      if (!bu.isNullOrNil(this.pSv))
      {
        this.pSl.setText(this.pSv);
        break;
      }
      this.pSl.setText(2131762944);
      break;
      ae.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: no decrypt");
      this.pSi.setImageFilePath(this.dCC);
      break label151;
      if (paramBoolean) {
        if (this.type == 4)
        {
          localObject1 = new com.tencent.mm.vfs.k(getCacheDir(), com.tencent.mm.b.g.getMessageDigest(this.glt.field_encrypturl.getBytes()));
          Object localObject2;
          if (((com.tencent.mm.vfs.k)localObject1).exists())
          {
            this.glt.field_md5 = o.aRh(w.B(((com.tencent.mm.vfs.k)localObject1).mUri));
            localObject2 = com.tencent.mm.emoji.d.a.gsI;
            localObject2 = EmojiLogic.R(com.tencent.mm.emoji.d.a.agD(), "", this.glt.field_md5);
            if (!o.fB((String)localObject2)) {
              o.mF(w.B(((com.tencent.mm.vfs.k)localObject1).fTh()), (String)localObject2);
            }
            this.dCC = ((String)localObject2);
            hr(false);
          }
          else
          {
            localObject2 = new com.tencent.mm.av.a.a.c.a();
            ((com.tencent.mm.av.a.a.c.a)localObject2).igk = true;
            ((com.tencent.mm.av.a.a.c.a)localObject2).hgD = w.B(((com.tencent.mm.vfs.k)localObject1).fTh());
            ((com.tencent.mm.av.a.a.c.a)localObject2).igJ = new Object[] { w.B(((com.tencent.mm.vfs.k)localObject1).fTh()) };
            localObject1 = ((com.tencent.mm.av.a.a.c.a)localObject2).aJu();
            com.tencent.mm.plugin.emoji.model.k.cie().a(this.glt.field_encrypturl, null, (com.tencent.mm.av.a.a.c)localObject1, this.pSz);
          }
        }
        else
        {
          this.pSi.setVisibility(8);
          this.nBP.setVisibility(0);
          this.pSj.setText(2131758308);
          this.pSk.setText(2131762566);
          this.pSj.setEnabled(false);
          this.pSk.setEnabled(false);
          com.tencent.mm.plugin.emoji.model.k.cif().u(this.glt);
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
    this.pSj = ((Button)findViewById(2131299331));
    this.pSk = ((Button)findViewById(2131299432));
    this.pSi = ((MMAnimateView)findViewById(2131299379));
    this.nBP = ((ProgressBar)findViewById(2131301506));
    this.pSl = ((TextView)findViewById(2131299435));
    this.pSm = ((ImageView)findViewById(2131299434));
    this.pSn = findViewById(2131297432);
    setBackBtn(new FTSEmojiDetailPageUI.1(this));
    this.pSj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109103);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).Lj(), FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_designerID, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_thumbUrl, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_activityid);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109103);
      }
    });
    this.pSk.setOnClickListener(new FTSEmojiDetailPageUI.6(this));
    this.pSn.setOnClickListener(new FTSEmojiDetailPageUI.7(this));
    addIconOptionMenu(0, 2131690603, new FTSEmojiDetailPageUI.8(this));
    this.type = getIntent().getIntExtra("extra_type", 0);
    this.scene = getIntent().getIntExtra("extra_scence", 0);
    this.glt = new EmojiInfo();
    this.glt.field_designerID = getIntent().getStringExtra("id");
    this.glt.field_name = getIntent().getStringExtra("extra_emoji_name");
    this.glt.field_aeskey = getIntent().getStringExtra("extra_aeskey");
    this.glt.field_encrypturl = getIntent().getStringExtra("extra_encrypt_url");
    this.glt.field_thumbUrl = getIntent().getStringExtra("extra_thumb_url");
    this.glt.field_md5 = getIntent().getStringExtra("extra_md5");
    this.glt.field_groupId = getIntent().getStringExtra("extra_product_id");
    this.dpp = this.glt.field_groupId;
    this.pSt = getIntent().getStringExtra("extra_product_name");
    this.pSs = getIntent().getStringExtra("productUrl");
    this.pSu = getIntent().getStringExtra("extra_article_url");
    this.pSv = getIntent().getStringExtra("extra_article_name");
    this.dtA = this.glt.field_designerID;
    this.designerName = getIntent().getStringExtra("name");
    this.pSw = getIntent().getStringExtra("headurl");
    this.pSx = getIntent().getStringExtra("weapp_user_name");
    this.hGl = getIntent().getIntExtra("weapp_version", 0);
    this.sourceType = getIntent().getIntExtra("source_type", 0);
    this.pSq = getIntent().getStringExtra("searchID");
    this.pLq = getIntent().getStringExtra("docID");
    this.pSr = getIntent().getIntExtra("search_type", 0);
    this.pSo = getIntent().getBooleanExtra("disableAddSticker", false);
    this.pSp = getIntent().getBooleanExtra("needSavePhotosAlbum", false);
    paramBundle = getIntent().getStringExtra("activityId");
    if (!bu.isNullOrNil(paramBundle)) {
      this.glt.field_activityid = paramBundle;
    }
    com.tencent.mm.sdk.b.a.IvT.c(this.pSy);
    com.tencent.mm.plugin.emoji.model.k.cif().pKA = this.pKU;
    am.h(this.scene, this.pSq, this.pLq, this.pSr);
    hr(true);
    ae.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "localPath=%s", new Object[] { this.dCC });
    am.h(this.scene, this.pSq, this.pLq, this.pSr);
    AppMethodBeat.o(109115);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109122);
    com.tencent.mm.sdk.b.a.IvT.d(this.pSy);
    com.tencent.mm.plugin.emoji.model.k.cif().pKA = null;
    super.onDestroy();
    AppMethodBeat.o(109122);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109116);
    super.onResume();
    hr(false);
    AppMethodBeat.o(109116);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn) {}
  
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