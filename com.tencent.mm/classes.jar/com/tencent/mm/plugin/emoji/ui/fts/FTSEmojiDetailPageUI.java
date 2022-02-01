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
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.de;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.snackbar.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;

public class FTSEmojiDetailPageUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private String designerName;
  private String dft;
  private String djB;
  private String drZ;
  private EmojiInfo fLP;
  private int gKK;
  private l kxh;
  private ProgressBar mtV;
  private MMAnimateView oEC;
  private Button oED;
  private Button oEE;
  private TextView oEF;
  private ImageView oEG;
  private View oEH;
  private boolean oEI;
  private boolean oEJ;
  private String oEK;
  private int oEL;
  private String oEM;
  private String oEN;
  private String oEO;
  private String oEP;
  private String oEQ;
  private String oER;
  private com.tencent.mm.sdk.b.c oES;
  private com.tencent.mm.aw.a.c.k oET;
  private n.d oEU;
  private String oxC;
  private com.tencent.mm.plugin.emoji.model.c.a oxg;
  private int scene;
  private int sourceType;
  private int type;
  
  public FTSEmojiDetailPageUI()
  {
    AppMethodBeat.i(109114);
    this.oES = new com.tencent.mm.sdk.b.c() {};
    this.oxg = new com.tencent.mm.plugin.emoji.model.c.a()
    {
      public final void a(boolean paramAnonymousBoolean, EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(109110);
        if ((paramAnonymousEmojiInfo != null) && (paramAnonymousBoolean) && (FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this) != null) && (FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).JS().equals(paramAnonymousEmojiInfo.JS())))
        {
          ad.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiServiceCallback onDownload %s", new Object[] { FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).JS() });
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
    this.oET = new com.tencent.mm.aw.a.c.k()
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
            FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_md5 = i.aEN(com.tencent.mm.vfs.q.B(paramAnonymousString.mUri));
            paramAnonymousView = FTSEmojiDetailPageUI.this;
            paramAnonymousBitmap = com.tencent.mm.emoji.d.a.fSR;
            FTSEmojiDetailPageUI.a(paramAnonymousView, EmojiLogic.P(com.tencent.mm.emoji.d.a.acD(), "", FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_md5));
            i.lC(com.tencent.mm.vfs.q.B(paramAnonymousString.fhU()), FTSEmojiDetailPageUI.f(FTSEmojiDetailPageUI.this));
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
    this.oEU = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(109101);
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
  
  private void bWJ()
  {
    AppMethodBeat.i(109119);
    this.oEE.setEnabled(true);
    AppMethodBeat.o(109119);
  }
  
  private void bWK()
  {
    AppMethodBeat.i(109120);
    EmojiInfo localEmojiInfo2 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.aJx(this.fLP.JS());
    EmojiInfo localEmojiInfo1 = localEmojiInfo2;
    if (localEmojiInfo2 == null) {
      localEmojiInfo1 = this.fLP;
    }
    if (localEmojiInfo1.field_catalog == EmojiGroupInfo.LBP)
    {
      this.oED.setEnabled(false);
      this.oED.setText(2131755275);
      AppMethodBeat.o(109120);
      return;
    }
    this.oED.setText(2131758308);
    if (i.eK(this.drZ))
    {
      this.oED.setEnabled(true);
      AppMethodBeat.o(109120);
      return;
    }
    this.oED.setEnabled(false);
    AppMethodBeat.o(109120);
  }
  
  private boolean bWL()
  {
    AppMethodBeat.i(109121);
    if ((!bt.isNullOrNil(this.oER)) && (this.sourceType == 1))
    {
      AppMethodBeat.o(109121);
      return true;
    }
    AppMethodBeat.o(109121);
    return false;
  }
  
  private void gP(boolean paramBoolean)
  {
    AppMethodBeat.i(109118);
    if (paramBoolean) {
      setMMTitle(this.fLP.getName());
    }
    Object localObject1;
    switch (this.type)
    {
    default: 
      if (i.eK(this.drZ))
      {
        this.mtV.setVisibility(8);
        this.oEC.setVisibility(0);
        localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.aJx(this.fLP.JS());
        if ((localObject1 != null) && ((((EmojiInfo)localObject1).field_reserved4 & EmojiInfo.LCl) == EmojiInfo.LCl))
        {
          ad.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: decrypt");
          this.oEC.g(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((EmojiInfo)localObject1), "");
          label151:
          bWK();
          bWJ();
        }
      }
      break;
    }
    for (;;)
    {
      if (this.oEI) {
        this.oED.setVisibility(8);
      }
      AppMethodBeat.o(109118);
      return;
      o.ayJ().loadImage(this.oEM, this.oEG);
      this.oEF.setText(this.oEN);
      this.drZ = this.fLP.gaa();
      break;
      o.ayJ().loadImage(this.oEQ, this.oEG);
      this.oEF.setText(this.designerName);
      this.drZ = this.fLP.gaa();
      break;
      this.oEG.setVisibility(8);
      if (!bt.isNullOrNil(this.oEP))
      {
        this.oEF.setText(this.oEP);
        break;
      }
      this.oEF.setText(2131762944);
      break;
      ad.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: no decrypt");
      this.oEC.setImageFilePath(this.drZ);
      break label151;
      if (paramBoolean) {
        if (this.type == 4)
        {
          localObject1 = new e(getCacheDir(), com.tencent.mm.b.g.getMessageDigest(this.fLP.field_encrypturl.getBytes()));
          Object localObject2;
          if (((e)localObject1).exists())
          {
            this.fLP.field_md5 = i.aEN(com.tencent.mm.vfs.q.B(((e)localObject1).mUri));
            localObject2 = com.tencent.mm.emoji.d.a.fSR;
            localObject2 = EmojiLogic.P(com.tencent.mm.emoji.d.a.acD(), "", this.fLP.field_md5);
            if (!i.eK((String)localObject2)) {
              i.lC(com.tencent.mm.vfs.q.B(((e)localObject1).fhU()), (String)localObject2);
            }
            this.drZ = ((String)localObject2);
            gP(false);
          }
          else
          {
            localObject2 = new com.tencent.mm.aw.a.a.c.a();
            ((com.tencent.mm.aw.a.a.c.a)localObject2).hjU = true;
            ((com.tencent.mm.aw.a.a.c.a)localObject2).gjt = com.tencent.mm.vfs.q.B(((e)localObject1).fhU());
            ((com.tencent.mm.aw.a.a.c.a)localObject2).hkt = new Object[] { com.tencent.mm.vfs.q.B(((e)localObject1).fhU()) };
            localObject1 = ((com.tencent.mm.aw.a.a.c.a)localObject2).azc();
            com.tencent.mm.plugin.emoji.model.k.bUX().a(this.fLP.field_encrypturl, null, (com.tencent.mm.aw.a.a.c)localObject1, this.oET);
          }
        }
        else
        {
          this.oEC.setVisibility(8);
          this.mtV.setVisibility(0);
          this.oED.setText(2131758308);
          this.oEE.setText(2131762566);
          this.oED.setEnabled(false);
          this.oEE.setEnabled(false);
          com.tencent.mm.plugin.emoji.model.k.bUY().u(this.fLP);
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
    this.oED = ((Button)findViewById(2131299331));
    this.oEE = ((Button)findViewById(2131299432));
    this.oEC = ((MMAnimateView)findViewById(2131299379));
    this.mtV = ((ProgressBar)findViewById(2131301506));
    this.oEF = ((TextView)findViewById(2131299435));
    this.oEG = ((ImageView)findViewById(2131299434));
    this.oEH = findViewById(2131297432);
    setBackBtn(new FTSEmojiDetailPageUI.1(this));
    this.oED.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109103);
        FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).JS(), FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_designerID, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_thumbUrl, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_activityid);
        AppMethodBeat.o(109103);
      }
    });
    this.oEE.setOnClickListener(new FTSEmojiDetailPageUI.6(this));
    this.oEH.setOnClickListener(new FTSEmojiDetailPageUI.7(this));
    addIconOptionMenu(0, 2131690603, new FTSEmojiDetailPageUI.8(this));
    this.type = getIntent().getIntExtra("extra_type", 0);
    this.scene = getIntent().getIntExtra("extra_scence", 0);
    this.fLP = new EmojiInfo();
    this.fLP.field_designerID = getIntent().getStringExtra("id");
    this.fLP.field_name = getIntent().getStringExtra("extra_emoji_name");
    this.fLP.field_aeskey = getIntent().getStringExtra("extra_aeskey");
    this.fLP.field_encrypturl = getIntent().getStringExtra("extra_encrypt_url");
    this.fLP.field_thumbUrl = getIntent().getStringExtra("extra_thumb_url");
    this.fLP.field_md5 = getIntent().getStringExtra("extra_md5");
    this.fLP.field_groupId = getIntent().getStringExtra("extra_product_id");
    this.dft = this.fLP.field_groupId;
    this.oEN = getIntent().getStringExtra("extra_product_name");
    this.oEM = getIntent().getStringExtra("productUrl");
    this.oEO = getIntent().getStringExtra("extra_article_url");
    this.oEP = getIntent().getStringExtra("extra_article_name");
    this.djB = this.fLP.field_designerID;
    this.designerName = getIntent().getStringExtra("name");
    this.oEQ = getIntent().getStringExtra("headurl");
    this.oER = getIntent().getStringExtra("weapp_user_name");
    this.gKK = getIntent().getIntExtra("weapp_version", 0);
    this.sourceType = getIntent().getIntExtra("source_type", 0);
    this.oEK = getIntent().getStringExtra("searchID");
    this.oxC = getIntent().getStringExtra("docID");
    this.oEL = getIntent().getIntExtra("search_type", 0);
    this.oEI = getIntent().getBooleanExtra("disableAddSticker", false);
    this.oEJ = getIntent().getBooleanExtra("needSavePhotosAlbum", false);
    paramBundle = getIntent().getStringExtra("activityId");
    if (!bt.isNullOrNil(paramBundle)) {
      this.fLP.field_activityid = paramBundle;
    }
    com.tencent.mm.sdk.b.a.ESL.c(this.oES);
    com.tencent.mm.plugin.emoji.model.k.bUY().owM = this.oxg;
    ak.g(this.scene, this.oEK, this.oxC, this.oEL);
    gP(true);
    ad.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "localPath=%s", new Object[] { this.drZ });
    ak.g(this.scene, this.oEK, this.oxC, this.oEL);
    AppMethodBeat.o(109115);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109122);
    com.tencent.mm.sdk.b.a.ESL.d(this.oES);
    com.tencent.mm.plugin.emoji.model.k.bUY().owM = null;
    super.onDestroy();
    AppMethodBeat.o(109122);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109116);
    super.onResume();
    gP(false);
    AppMethodBeat.o(109116);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI
 * JD-Core Version:    0.7.0.1
 */