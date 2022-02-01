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
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.d.a;
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
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public class FTSEmojiDetailPageUI
  extends MMActivity
  implements i
{
  private String dKJ;
  private String dUs;
  private String designerName;
  private EmojiInfo gWm;
  private l mHj;
  private ProgressBar oMO;
  private String productId;
  private d.a rbA;
  private String rbI;
  private MMAnimateView rji;
  private Button rjj;
  private Button rjk;
  private TextView rjl;
  private ImageView rjm;
  private View rjn;
  private boolean rjo;
  private boolean rjp;
  private String rjq;
  private int rjr;
  private String rjs;
  private String rjt;
  private String rju;
  private String rjv;
  private String rjw;
  private IListener rjx;
  private com.tencent.mm.av.a.c.k rjy;
  private o.g rjz;
  private int scene;
  private int sourceType;
  private int type;
  private String weappUserName;
  private int weappVersion;
  
  public FTSEmojiDetailPageUI()
  {
    AppMethodBeat.i(109114);
    this.rjx = new IListener() {};
    this.rbA = new d.a()
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
    this.rjy = new com.tencent.mm.av.a.c.k()
    {
      public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(109112);
        Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
        if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_encrypturl)))
        {
          paramAnonymousString = new o(paramAnonymousVarArgs[0].toString());
          if (paramAnonymousString.exists())
          {
            FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_md5 = com.tencent.mm.vfs.s.bhK(aa.z(paramAnonymousString.mUri));
            paramAnonymousView = FTSEmojiDetailPageUI.this;
            paramAnonymousBitmap = com.tencent.mm.emoji.e.a.hdT;
            FTSEmojiDetailPageUI.a(paramAnonymousView, EmojiLogic.W(com.tencent.mm.emoji.e.a.awt(), "", FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_md5));
            com.tencent.mm.vfs.s.nw(aa.z(paramAnonymousString.her()), FTSEmojiDetailPageUI.f(FTSEmojiDetailPageUI.this));
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
    this.rjz = new o.g()
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
  
  private void cHQ()
  {
    AppMethodBeat.i(109119);
    this.rjk.setEnabled(true);
    AppMethodBeat.o(109119);
  }
  
  private void cHR()
  {
    AppMethodBeat.i(109120);
    EmojiInfo localEmojiInfo2 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk(this.gWm.getMd5());
    EmojiInfo localEmojiInfo1 = localEmojiInfo2;
    if (localEmojiInfo2 == null) {
      localEmojiInfo1 = this.gWm;
    }
    if (localEmojiInfo1.field_catalog == EmojiGroupInfo.Uuo)
    {
      this.rjj.setEnabled(false);
      this.rjj.setText(2131755310);
      AppMethodBeat.o(109120);
      return;
    }
    this.rjj.setText(2131758602);
    if (com.tencent.mm.vfs.s.YS(this.dUs))
    {
      this.rjj.setEnabled(true);
      AppMethodBeat.o(109120);
      return;
    }
    this.rjj.setEnabled(false);
    AppMethodBeat.o(109120);
  }
  
  private boolean cHS()
  {
    AppMethodBeat.i(109121);
    if ((!Util.isNullOrNil(this.weappUserName)) && (this.sourceType == 1))
    {
      AppMethodBeat.o(109121);
      return true;
    }
    AppMethodBeat.o(109121);
    return false;
  }
  
  private void is(boolean paramBoolean)
  {
    AppMethodBeat.i(109118);
    if (paramBoolean) {
      setMMTitle(this.gWm.getName());
    }
    Object localObject1;
    switch (this.type)
    {
    default: 
      if (com.tencent.mm.vfs.s.YS(this.dUs))
      {
        this.oMO.setVisibility(8);
        this.rji.setVisibility(0);
        localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk(this.gWm.getMd5());
        if ((localObject1 != null) && ((((EmojiInfo)localObject1).field_reserved4 & EmojiInfo.UuK) == EmojiInfo.UuK))
        {
          Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: decrypt");
          this.rji.g(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((EmojiInfo)localObject1), "");
          label151:
          cHR();
          cHQ();
        }
      }
      break;
    }
    for (;;)
    {
      if (this.rjo) {
        this.rjj.setVisibility(8);
      }
      AppMethodBeat.o(109118);
      return;
      com.tencent.mm.av.q.bcV().loadImage(this.rjs, this.rjm);
      this.rjl.setText(this.rjt);
      this.dUs = this.gWm.hRM();
      break;
      com.tencent.mm.av.q.bcV().loadImage(this.rjw, this.rjm);
      this.rjl.setText(this.designerName);
      this.dUs = this.gWm.hRM();
      break;
      this.rjm.setVisibility(8);
      if (!Util.isNullOrNil(this.rjv))
      {
        this.rjl.setText(this.rjv);
        break;
      }
      this.rjl.setText(2131765080);
      break;
      Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: no decrypt");
      this.rji.setImageFilePath(this.dUs);
      break label151;
      if (paramBoolean) {
        if (this.type == 4)
        {
          localObject1 = new o(getCacheDir(), com.tencent.mm.b.g.getMessageDigest(this.gWm.field_encrypturl.getBytes()));
          Object localObject2;
          if (((o)localObject1).exists())
          {
            this.gWm.field_md5 = com.tencent.mm.vfs.s.bhK(aa.z(((o)localObject1).mUri));
            localObject2 = com.tencent.mm.emoji.e.a.hdT;
            localObject2 = EmojiLogic.W(com.tencent.mm.emoji.e.a.awt(), "", this.gWm.field_md5);
            if (!com.tencent.mm.vfs.s.YS((String)localObject2)) {
              com.tencent.mm.vfs.s.nw(aa.z(((o)localObject1).her()), (String)localObject2);
            }
            this.dUs = ((String)localObject2);
            is(false);
          }
          else
          {
            localObject2 = new c.a();
            ((c.a)localObject2).jbf = true;
            ((c.a)localObject2).fullPath = aa.z(((o)localObject1).her());
            ((c.a)localObject2).jbE = new Object[] { aa.z(((o)localObject1).her()) };
            localObject1 = ((c.a)localObject2).bdv();
            com.tencent.mm.plugin.emoji.model.k.cGc().a(this.gWm.field_encrypturl, null, (c)localObject1, this.rjy);
          }
        }
        else
        {
          this.rji.setVisibility(8);
          this.oMO.setVisibility(0);
          this.rjj.setText(2131758602);
          this.rjk.setText(2131764635);
          this.rjj.setEnabled(false);
          this.rjk.setEnabled(false);
          com.tencent.mm.plugin.emoji.model.k.cGd().u(this.gWm);
        }
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131494752;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109117);
    if ((paramInt1 == 1001) && (paramInt2 == -1)) {
      com.tencent.mm.ui.widget.snackbar.b.r(this, getContext().getString(2131755979));
    }
    AppMethodBeat.o(109117);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109115);
    super.onCreate(paramBundle);
    this.rjj = ((Button)findViewById(2131299943));
    this.rjk = ((Button)findViewById(2131300046));
    this.rji = ((MMAnimateView)findViewById(2131299992));
    this.oMO = ((ProgressBar)findViewById(2131303709));
    this.rjl = ((TextView)findViewById(2131300049));
    this.rjm = ((ImageView)findViewById(2131300048));
    this.rjn = findViewById(2131297662);
    setBackBtn(new FTSEmojiDetailPageUI.1(this));
    this.rjj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109103);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).getMd5(), FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_designerID, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_thumbUrl, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_activityid);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109103);
      }
    });
    this.rjk.setOnClickListener(new FTSEmojiDetailPageUI.6(this));
    this.rjn.setOnClickListener(new FTSEmojiDetailPageUI.7(this));
    addIconOptionMenu(0, 2131690843, new FTSEmojiDetailPageUI.8(this));
    this.type = getIntent().getIntExtra("extra_type", 0);
    this.scene = getIntent().getIntExtra("extra_scence", 0);
    this.gWm = new EmojiInfo();
    this.gWm.field_designerID = getIntent().getStringExtra("id");
    this.gWm.field_name = getIntent().getStringExtra("extra_emoji_name");
    this.gWm.field_aeskey = getIntent().getStringExtra("extra_aeskey");
    this.gWm.field_encrypturl = getIntent().getStringExtra("extra_encrypt_url");
    this.gWm.field_thumbUrl = getIntent().getStringExtra("extra_thumb_url");
    this.gWm.field_md5 = getIntent().getStringExtra("extra_md5");
    this.gWm.field_groupId = getIntent().getStringExtra("extra_product_id");
    this.productId = this.gWm.field_groupId;
    this.rjt = getIntent().getStringExtra("extra_product_name");
    this.rjs = getIntent().getStringExtra("productUrl");
    this.rju = getIntent().getStringExtra("extra_article_url");
    this.rjv = getIntent().getStringExtra("extra_article_name");
    this.dKJ = this.gWm.field_designerID;
    this.designerName = getIntent().getStringExtra("name");
    this.rjw = getIntent().getStringExtra("headurl");
    this.weappUserName = getIntent().getStringExtra("weapp_user_name");
    this.weappVersion = getIntent().getIntExtra("weapp_version", 0);
    this.sourceType = getIntent().getIntExtra("source_type", 0);
    this.rjq = getIntent().getStringExtra("searchID");
    this.rbI = getIntent().getStringExtra("docID");
    this.rjr = getIntent().getIntExtra("search_type", 0);
    this.rjo = getIntent().getBooleanExtra("disableAddSticker", false);
    this.rjp = getIntent().getBooleanExtra("needSavePhotosAlbum", false);
    paramBundle = getIntent().getStringExtra("activityId");
    if (!Util.isNullOrNil(paramBundle)) {
      this.gWm.field_activityid = paramBundle;
    }
    EventCenter.instance.addListener(this.rjx);
    com.tencent.mm.plugin.emoji.model.k.cGd().rbg = this.rbA;
    ar.h(this.scene, this.rjq, this.rbI, this.rjr);
    is(true);
    Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "localPath=%s", new Object[] { this.dUs });
    ar.h(this.scene, this.rjq, this.rbI, this.rjr);
    AppMethodBeat.o(109115);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109122);
    EventCenter.instance.removeListener(this.rjx);
    com.tencent.mm.plugin.emoji.model.k.cGd().rbg = null;
    super.onDestroy();
    AppMethodBeat.o(109122);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109116);
    super.onResume();
    is(false);
    AppMethodBeat.o(109116);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI
 * JD-Core Version:    0.7.0.1
 */