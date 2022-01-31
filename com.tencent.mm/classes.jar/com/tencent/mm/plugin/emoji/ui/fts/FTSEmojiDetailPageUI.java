package com.tencent.mm.plugin.emoji.ui.fts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;

public class FTSEmojiDetailPageUI
  extends MMActivity
  implements f
{
  private String cBD;
  private int cpG;
  private String cqx;
  private String cuE;
  private String designerName;
  private EmojiInfo evH;
  private int fjQ;
  private l igW;
  private ProgressBar jCA;
  private String lhA;
  private com.tencent.mm.plugin.emoji.model.c.a lhs;
  private String loA;
  private String loB;
  private String loC;
  private String loD;
  private com.tencent.mm.sdk.b.c loE;
  private com.tencent.mm.at.a.c.i loF;
  private n.d loG;
  private MMAnimateView loo;
  private Button lop;
  private Button loq;
  private TextView lor;
  private ImageView los;
  private View lot;
  private boolean lou;
  private boolean lov;
  private String low;
  private int lox;
  private String loy;
  private String loz;
  private int scene;
  private int type;
  
  public FTSEmojiDetailPageUI()
  {
    AppMethodBeat.i(53551);
    this.loE = new FTSEmojiDetailPageUI.9(this);
    this.lhs = new FTSEmojiDetailPageUI.10(this);
    this.loF = new FTSEmojiDetailPageUI.11(this);
    this.loG = new FTSEmojiDetailPageUI.3(this);
    AppMethodBeat.o(53551);
  }
  
  private void bmZ()
  {
    AppMethodBeat.i(53556);
    this.loq.setEnabled(true);
    AppMethodBeat.o(53556);
  }
  
  private void bna()
  {
    AppMethodBeat.i(53557);
    EmojiInfo localEmojiInfo2 = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNn.asP(this.evH.Al());
    EmojiInfo localEmojiInfo1 = localEmojiInfo2;
    if (localEmojiInfo2 == null) {
      localEmojiInfo1 = this.evH;
    }
    if (localEmojiInfo1.field_catalog == EmojiGroupInfo.yPf)
    {
      this.lop.setEnabled(false);
      this.lop.setText(2131296540);
      AppMethodBeat.o(53557);
      return;
    }
    this.lop.setText(2131299182);
    if (e.cN(this.cBD))
    {
      this.lop.setEnabled(true);
      AppMethodBeat.o(53557);
      return;
    }
    this.lop.setEnabled(false);
    AppMethodBeat.o(53557);
  }
  
  private boolean bnb()
  {
    AppMethodBeat.i(53558);
    if ((!bo.isNullOrNil(this.loD)) && (this.cpG == 1))
    {
      AppMethodBeat.o(53558);
      return true;
    }
    AppMethodBeat.o(53558);
    return false;
  }
  
  private void gJ(boolean paramBoolean)
  {
    AppMethodBeat.i(53555);
    if (paramBoolean) {
      setMMTitle(this.evH.getName());
    }
    Object localObject1;
    switch (this.type)
    {
    default: 
      if (e.cN(this.cBD))
      {
        this.jCA.setVisibility(8);
        this.loo.setVisibility(0);
        localObject1 = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNn.asP(this.evH.Al());
        if ((localObject1 != null) && ((((EmojiInfo)localObject1).field_reserved4 & EmojiInfo.APx) == EmojiInfo.APx))
        {
          ab.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: decrypt");
          this.loo.f(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().l((EmojiInfo)localObject1), "");
          label151:
          bna();
          bmZ();
        }
      }
      break;
    }
    for (;;)
    {
      if (this.lou) {
        this.lop.setVisibility(8);
      }
      AppMethodBeat.o(53555);
      return;
      o.ahG().a(this.loy, this.los);
      this.lor.setText(this.loz);
      this.cBD = this.evH.dQB();
      break;
      o.ahG().a(this.loC, this.los);
      this.lor.setText(this.designerName);
      this.cBD = this.evH.dQB();
      break;
      this.los.setVisibility(8);
      if (!bo.isNullOrNil(this.loB))
      {
        this.lor.setText(this.loB);
        break;
      }
      this.lor.setText(2131303004);
      break;
      ab.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: no decrypt");
      this.loo.setImageFilePath(this.cBD);
      break label151;
      if (paramBoolean) {
        if (this.type == 4)
        {
          localObject1 = new com.tencent.mm.vfs.b(getCacheDir(), com.tencent.mm.a.g.w(this.evH.field_encrypturl.getBytes()));
          Object localObject2;
          if (((com.tencent.mm.vfs.b)localObject1).exists())
          {
            this.evH.field_md5 = e.avP(j.p(((com.tencent.mm.vfs.b)localObject1).mUri));
            localObject2 = EmojiLogic.M(com.tencent.mm.plugin.emoji.h.b.YP(), "", this.evH.field_md5);
            if (!e.cN((String)localObject2)) {
              e.C(j.p(((com.tencent.mm.vfs.b)localObject1).dQJ()), (String)localObject2);
            }
            this.cBD = ((String)localObject2);
            gJ(false);
          }
          else
          {
            localObject2 = new com.tencent.mm.at.a.a.c.a();
            ((com.tencent.mm.at.a.a.c.a)localObject2).eNM = true;
            ((com.tencent.mm.at.a.a.c.a)localObject2).eNO = j.p(((com.tencent.mm.vfs.b)localObject1).dQJ());
            ((com.tencent.mm.at.a.a.c.a)localObject2).eOi = new Object[] { j.p(((com.tencent.mm.vfs.b)localObject1).dQJ()) };
            localObject1 = ((com.tencent.mm.at.a.a.c.a)localObject2).ahY();
            com.tencent.mm.plugin.emoji.model.i.bld().a(this.evH.field_encrypturl, null, (com.tencent.mm.at.a.a.c)localObject1, this.loF);
          }
        }
        else
        {
          this.loo.setVisibility(8);
          this.jCA.setVisibility(0);
          this.lop.setText(2131299182);
          this.loq.setText(2131302657);
          this.lop.setEnabled(false);
          this.loq.setEnabled(false);
          com.tencent.mm.plugin.emoji.model.i.blo().t(this.evH);
        }
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2130969657;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(53554);
    if ((paramInt1 == 1001) && (paramInt2 == -1)) {
      com.tencent.mm.ui.widget.snackbar.b.l(this, getContext().getString(2131297070));
    }
    AppMethodBeat.o(53554);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(53552);
    super.onCreate(paramBundle);
    this.lop = ((Button)findViewById(2131824351));
    this.loq = ((Button)findViewById(2131824350));
    this.loo = ((MMAnimateView)findViewById(2131824349));
    this.jCA = ((ProgressBar)findViewById(2131821643));
    this.lor = ((TextView)findViewById(2131824352));
    this.los = ((ImageView)findViewById(2131824353));
    this.lot = findViewById(2131823738);
    setBackBtn(new FTSEmojiDetailPageUI.1(this));
    this.lop.setOnClickListener(new FTSEmojiDetailPageUI.5(this));
    this.loq.setOnClickListener(new FTSEmojiDetailPageUI.6(this));
    this.lot.setOnClickListener(new FTSEmojiDetailPageUI.7(this));
    addIconOptionMenu(0, 2130839668, new FTSEmojiDetailPageUI.8(this));
    this.type = getIntent().getIntExtra("extra_type", 0);
    this.scene = getIntent().getIntExtra("extra_scence", 0);
    this.evH = new EmojiInfo();
    this.evH.field_designerID = getIntent().getStringExtra("id");
    this.evH.field_name = getIntent().getStringExtra("extra_emoji_name");
    this.evH.field_aeskey = getIntent().getStringExtra("extra_aeskey");
    this.evH.field_encrypturl = getIntent().getStringExtra("extra_encrypt_url");
    this.evH.field_thumbUrl = getIntent().getStringExtra("extra_thumb_url");
    this.evH.field_md5 = getIntent().getStringExtra("extra_md5");
    this.evH.field_groupId = getIntent().getStringExtra("extra_product_id");
    this.cqx = this.evH.field_groupId;
    this.loz = getIntent().getStringExtra("extra_product_name");
    this.loy = getIntent().getStringExtra("productUrl");
    this.loA = getIntent().getStringExtra("extra_article_url");
    this.loB = getIntent().getStringExtra("extra_article_name");
    this.cuE = this.evH.field_designerID;
    this.designerName = getIntent().getStringExtra("name");
    this.loC = getIntent().getStringExtra("headurl");
    this.loD = getIntent().getStringExtra("weapp_user_name");
    this.fjQ = getIntent().getIntExtra("weapp_version", 0);
    this.cpG = getIntent().getIntExtra("source_type", 0);
    this.low = getIntent().getStringExtra("searchID");
    this.lhA = getIntent().getStringExtra("docID");
    this.lox = getIntent().getIntExtra("search_type", 0);
    this.lou = getIntent().getBooleanExtra("disableAddSticker", false);
    this.lov = getIntent().getBooleanExtra("needSavePhotosAlbum", false);
    paramBundle = getIntent().getStringExtra("activityId");
    if (!bo.isNullOrNil(paramBundle)) {
      this.evH.field_activityid = paramBundle;
    }
    com.tencent.mm.sdk.b.a.ymk.c(this.loE);
    com.tencent.mm.plugin.emoji.model.i.blo().lhf = this.lhs;
    an.e(this.scene, this.low, this.lhA, this.lox);
    gJ(true);
    ab.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "localPath=%s", new Object[] { this.cBD });
    an.e(this.scene, this.low, this.lhA, this.lox);
    AppMethodBeat.o(53552);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(53559);
    com.tencent.mm.sdk.b.a.ymk.d(this.loE);
    com.tencent.mm.plugin.emoji.model.i.blo().lhf = null;
    super.onDestroy();
    AppMethodBeat.o(53559);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(53553);
    super.onResume();
    gJ(false);
    AppMethodBeat.o(53553);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI
 * JD-Core Version:    0.7.0.1
 */