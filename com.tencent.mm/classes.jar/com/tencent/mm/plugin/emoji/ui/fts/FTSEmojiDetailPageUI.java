package com.tencent.mm.plugin.emoji.ui.fts;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.eb;
import com.tencent.mm.b.g;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.loader.b.k;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.g;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.model.i.a;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

public class FTSEmojiDetailPageUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private EmojiInfo Dhj;
  private String designerName;
  private String hAw;
  private String hIo;
  private String hTM;
  private EmojiInfo mgK;
  private int nUT;
  private String productId;
  private l sLE;
  private int scene;
  private int sourceType;
  private int type;
  private ProgressBar uZY;
  private i.a xNb;
  private String xNp;
  private MMAnimateView xUW;
  private Button xUX;
  private Button xUY;
  private TextView xUZ;
  private ImageView xVa;
  private View xVb;
  private boolean xVc;
  private boolean xVd;
  private String xVe;
  private int xVf;
  private String xVg;
  private String xVh;
  private String xVi;
  private String xVj;
  private String xVk;
  private int xVl;
  private String xVm;
  private IListener xVn;
  private k xVo;
  private u.i xVp;
  
  public FTSEmojiDetailPageUI()
  {
    AppMethodBeat.i(109114);
    this.xVn = new IListener(com.tencent.mm.app.f.hfK) {};
    this.xNb = new i.a()
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
    this.xVo = new k()
    {
      public final void onImageLoadComplete(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(109112);
        Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
        if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_encrypturl)))
        {
          paramAnonymousString = new u(paramAnonymousVarArgs[0].toString());
          if (paramAnonymousString.jKS())
          {
            FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_md5 = y.bub(ah.v(paramAnonymousString.mUri));
            FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this, EmojiLogic.W(com.tencent.mm.plugin.emoji.g.d.bzQ(), "", FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_md5));
            y.O(ah.v(paramAnonymousString.jKT()), FTSEmojiDetailPageUI.f(FTSEmojiDetailPageUI.this), false);
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
    this.xVp = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(109101);
        FTSEmojiDetailPageUI.k(FTSEmojiDetailPageUI.this);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(109101);
          return;
          FTSEmojiDetailPageUI.l(FTSEmojiDetailPageUI.this);
          AppMethodBeat.o(109101);
          return;
          FTSEmojiDetailPageUI.m(FTSEmojiDetailPageUI.this);
        }
      }
    };
    AppMethodBeat.o(109114);
  }
  
  private void dCb()
  {
    AppMethodBeat.i(109119);
    this.xUY.setEnabled(true);
    AppMethodBeat.o(109119);
  }
  
  private void dCc()
  {
    AppMethodBeat.i(109120);
    EmojiInfo localEmojiInfo2 = s.getEmojiStorageMgr().adju.bza(this.mgK.getMd5());
    EmojiInfo localEmojiInfo1 = localEmojiInfo2;
    if (localEmojiInfo2 == null) {
      localEmojiInfo1 = this.mgK;
    }
    if (localEmojiInfo1.field_catalog == EmojiGroupInfo.aklF)
    {
      this.xUX.setEnabled(false);
      this.xUX.setText(h.h.app_added);
      AppMethodBeat.o(109120);
      return;
    }
    this.xUX.setText(h.h.emoji_store_add_emoji);
    if (y.ZC(this.hTM))
    {
      this.xUX.setEnabled(true);
      AppMethodBeat.o(109120);
      return;
    }
    this.xUX.setEnabled(false);
    AppMethodBeat.o(109120);
  }
  
  private boolean dCd()
  {
    AppMethodBeat.i(109121);
    if ((!Util.isNullOrNil(this.xVm)) && (this.sourceType == 1))
    {
      AppMethodBeat.o(109121);
      return true;
    }
    AppMethodBeat.o(109121);
    return false;
  }
  
  private boolean dCe()
  {
    AppMethodBeat.i(270440);
    if ((!Util.isNullOrNil(this.hAw)) && (this.sourceType == 2))
    {
      AppMethodBeat.o(270440);
      return true;
    }
    AppMethodBeat.o(270440);
    return false;
  }
  
  private void kD(boolean paramBoolean)
  {
    AppMethodBeat.i(109118);
    if (paramBoolean) {
      setMMTitle(this.mgK.getName());
    }
    Object localObject1;
    switch (this.type)
    {
    default: 
      if (y.ZC(this.hTM))
      {
        this.uZY.setVisibility(8);
        this.xUW.setVisibility(0);
        localObject1 = s.getEmojiStorageMgr().adju.bza(this.mgK.getMd5());
        if ((localObject1 != null) && ((((EmojiInfo)localObject1).field_reserved4 & EmojiInfo.akmb) == EmojiInfo.akmb))
        {
          Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: decrypt");
          this.xUW.h(((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().a((EmojiInfo)localObject1), "");
          label151:
          dCc();
          dCb();
        }
      }
      break;
    }
    for (;;)
    {
      if (this.xVc) {
        this.xUX.setVisibility(8);
      }
      AppMethodBeat.o(109118);
      return;
      r.bKe().loadImage(this.xVg, this.xVa);
      this.xUZ.setText(this.xVh);
      if (this.xVl == 1)
      {
        this.hTM = this.Dhj.kMn();
        break;
      }
      this.hTM = this.mgK.kMn();
      break;
      r.bKe().loadImage(this.xVk, this.xVa);
      this.xUZ.setText(this.designerName);
      if (this.xVl == 1)
      {
        this.hTM = this.Dhj.kMn();
        break;
      }
      this.hTM = this.mgK.kMn();
      break;
      this.xVa.setVisibility(8);
      if (!Util.isNullOrNil(this.xVj))
      {
        this.xUZ.setText(this.xVj);
        break;
      }
      this.xUZ.setText(h.h.search_emoji_network_source);
      break;
      Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: no decrypt");
      if ((localObject1 != null) && (this.xVl == 1))
      {
        this.xUW.h(((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().a((EmojiInfo)localObject1), "");
        break label151;
      }
      this.xUW.setImageFilePath(this.hTM);
      break label151;
      if (paramBoolean) {
        if (this.type == 4)
        {
          localObject1 = new u(getCacheDir(), g.getMessageDigest(this.mgK.field_encrypturl.getBytes()));
          Object localObject2;
          if (((u)localObject1).jKS())
          {
            this.mgK.field_md5 = y.bub(ah.v(((u)localObject1).mUri));
            localObject2 = EmojiLogic.W(com.tencent.mm.plugin.emoji.g.d.bzQ(), "", this.mgK.field_md5);
            if (!y.ZC((String)localObject2)) {
              y.O(ah.v(((u)localObject1).jKT()), (String)localObject2, false);
            }
            this.hTM = ((String)localObject2);
            kD(false);
          }
          else
          {
            localObject2 = new c.a();
            ((c.a)localObject2).oKp = true;
            ((c.a)localObject2).fullPath = ah.v(((u)localObject1).jKT());
            ((c.a)localObject2).oKP = new Object[] { ah.v(((u)localObject1).jKT()) };
            localObject1 = ((c.a)localObject2).bKx();
            s.dAi().a(this.mgK.field_encrypturl, null, (c)localObject1, this.xVo);
          }
        }
        else
        {
          this.xUW.setVisibility(8);
          this.uZY.setVisibility(0);
          this.xUX.setText(h.h.emoji_store_add_emoji);
          this.xUY.setText(h.h.retransmits);
          this.xUX.setEnabled(false);
          this.xUY.setEnabled(false);
          if (this.xVl == 1) {
            s.dAj().u(this.Dhj);
          } else {
            s.dAj().u(this.mgK);
          }
        }
      }
    }
  }
  
  public int getLayoutId()
  {
    return h.f.fts_emoji_detail_page_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109117);
    if ((paramInt1 == 1001) && (paramInt2 == -1)) {
      com.tencent.mm.ui.widget.snackbar.b.u(this, getContext().getString(h.h.app_sent));
    }
    AppMethodBeat.o(109117);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109115);
    super.onCreate(paramBundle);
    this.xUX = ((Button)findViewById(h.e.emoji_add_btn));
    this.xUY = ((Button)findViewById(h.e.emoji_send_btn));
    this.xUW = ((MMAnimateView)findViewById(h.e.emoji_image_iv));
    this.uZY = ((ProgressBar)findViewById(h.e.loading_pb));
    this.xUZ = ((TextView)findViewById(h.e.emoji_source_title_tv));
    this.xVa = ((ImageView)findViewById(h.e.emoji_source_iv));
    this.xVb = findViewById(h.e.bottom_bar);
    setBackBtn(new FTSEmojiDetailPageUI.1(this));
    this.xUX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109103);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).getMd5(), FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_designerID, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_thumbUrl, FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this).field_activityid);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109103);
      }
    });
    this.xUY.setOnClickListener(new FTSEmojiDetailPageUI.7(this));
    this.xVb.setOnClickListener(new FTSEmojiDetailPageUI.8(this));
    addIconOptionMenu(0, h.g.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
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
    this.xVl = getIntent().getIntExtra("extra_gen_sticker", 0);
    this.mgK = new EmojiInfo();
    this.mgK.field_designerID = getIntent().getStringExtra("id");
    this.mgK.field_name = getIntent().getStringExtra("extra_emoji_name");
    this.mgK.field_aeskey = getIntent().getStringExtra("extra_aeskey");
    this.mgK.field_encrypturl = getIntent().getStringExtra("extra_encrypt_url");
    this.mgK.field_thumbUrl = getIntent().getStringExtra("extra_thumb_url");
    this.mgK.field_md5 = getIntent().getStringExtra("extra_md5");
    this.mgK.field_groupId = getIntent().getStringExtra("extra_product_id");
    if (Util.isNullOrNil(this.mgK.field_aeskey)) {
      this.mgK.field_cdnUrl = this.mgK.field_encrypturl;
    }
    this.productId = this.mgK.field_groupId;
    this.xVh = getIntent().getStringExtra("extra_product_name");
    this.xVg = getIntent().getStringExtra("productUrl");
    this.xVi = getIntent().getStringExtra("extra_article_url");
    this.xVj = getIntent().getStringExtra("extra_article_name");
    this.hIo = this.mgK.field_designerID;
    this.designerName = getIntent().getStringExtra("name");
    this.xVk = getIntent().getStringExtra("headurl");
    this.hAw = getIntent().getStringExtra("biz_user_name");
    this.xVm = getIntent().getStringExtra("weapp_user_name");
    this.nUT = getIntent().getIntExtra("weapp_version", 0);
    this.sourceType = getIntent().getIntExtra("source_type", 0);
    this.xVe = getIntent().getStringExtra("searchID");
    this.xNp = getIntent().getStringExtra("docID");
    this.xVf = getIntent().getIntExtra("search_type", 0);
    this.xVc = getIntent().getBooleanExtra("disableAddSticker", false);
    this.xVd = getIntent().getBooleanExtra("needSavePhotosAlbum", false);
    paramBundle = getIntent().getStringExtra("activityId");
    if (!Util.isNullOrNil(paramBundle)) {
      this.mgK.field_activityid = paramBundle;
    }
    this.xVn.alive();
    if (this.xVl == 1)
    {
      this.Dhj = new EmojiInfo();
      this.Dhj.convertFrom(this.mgK.convertTo(), false);
      this.Dhj.field_designerID = "";
      this.Dhj.field_groupId = "";
    }
    s.dAj().xMB = this.xNb;
    as.g(this.scene, this.xVe, this.xNp, this.xVf);
    kD(true);
    Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "localPath=%s", new Object[] { this.hTM });
    as.g(this.scene, this.xVe, this.xNp, this.xVf);
    AppMethodBeat.o(109115);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109122);
    this.xVn.dead();
    s.dAj().xMB = null;
    super.onDestroy();
    AppMethodBeat.o(109122);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109116);
    super.onResume();
    kD(false);
    AppMethodBeat.o(109116);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp) {}
  
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