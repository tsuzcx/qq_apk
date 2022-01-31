package com.tencent.mm.plugin.emoji.ui;

import a.f.b.j;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.database.DataSetObservable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.a.c.l;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.emoji.sync.EmojiSyncManager.a;
import com.tencent.mm.emoji.sync.EmojiSyncManager.b;
import com.tencent.mm.emoji.sync.EmojiSyncManager.e;
import com.tencent.mm.emoji.sync.EmojiSyncManager.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.HeaderGridView;
import com.tencent.mm.ui.base.HeaderGridView.a;
import com.tencent.mm.ui.base.HeaderGridView.b;
import com.tencent.mm.ui.base.HeaderGridView.c;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.List;

public class EmojiCustomUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, f
{
  private static l fHN;
  private static com.tencent.mm.at.a.c.d llD;
  private ProgressDialog gsr;
  private View.OnClickListener llA;
  private final k.a llB;
  private final com.tencent.mm.emoji.sync.c llC;
  private EmojiInfo llE;
  private EmojiCustomUI.c llh;
  private EmojiCustomUI.b lli;
  private HeaderGridView llj;
  private View llk;
  private Button lll;
  private Button llm;
  private EmojiSyncManager.b lln;
  private View llo;
  private TextView llp;
  private Button llq;
  private boolean llr;
  private boolean lls;
  private boolean llt;
  private EmojiCustomUI.a llu;
  private ArrayList<String> llv;
  private int llw;
  private EmojiSyncManager llx;
  private View.OnClickListener lly;
  private View.OnClickListener llz;
  private ak mHandler;
  
  static
  {
    AppMethodBeat.i(53366);
    llD = new EmojiCustomUI.16();
    fHN = new EmojiCustomUI.17();
    AppMethodBeat.o(53366);
  }
  
  public EmojiCustomUI()
  {
    AppMethodBeat.i(53335);
    this.llh = EmojiCustomUI.c.llQ;
    this.lln = EmojiSyncManager.b.exI;
    this.llr = false;
    this.lls = false;
    this.llt = false;
    this.llu = EmojiCustomUI.a.llN;
    this.llv = new ArrayList();
    this.llw = 0;
    this.lly = new EmojiCustomUI.1(this);
    this.llz = new EmojiCustomUI.12(this);
    this.llA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(53311);
        EmojiCustomUI.e(EmojiCustomUI.this);
        AppMethodBeat.o(53311);
      }
    };
    this.llB = new EmojiCustomUI.14(this);
    this.llC = new EmojiCustomUI.15(this);
    this.mHandler = new EmojiCustomUI.18(this);
    AppMethodBeat.o(53335);
  }
  
  private boolean Lb(String paramString)
  {
    AppMethodBeat.i(53350);
    com.tencent.mm.ui.base.h.d(getContext(), paramString, "", "", getString(2131300718), null, null);
    AppMethodBeat.o(53350);
    return true;
  }
  
  private void Lc(String paramString)
  {
    AppMethodBeat.i(53356);
    getString(2131297087);
    this.gsr = com.tencent.mm.ui.base.h.b(this, paramString, true, new EmojiCustomUI.10(this));
    AppMethodBeat.o(53356);
  }
  
  private void a(EmojiCustomUI.a parama)
  {
    AppMethodBeat.i(53336);
    ab.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateButtonType,button type:%s]", new Object[] { parama.toString() });
    this.llu = parama;
    switch (EmojiCustomUI.11.llI[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(53336);
      return;
      this.llq.setVisibility(4);
      AppMethodBeat.o(53336);
      return;
      this.llq.setVisibility(0);
      this.llq.setText(2131299271);
      AppMethodBeat.o(53336);
      return;
      this.llq.setVisibility(0);
      this.llq.setText(2131299272);
    }
  }
  
  private void a(EmojiCustomUI.c paramc)
  {
    AppMethodBeat.i(53346);
    long l = System.currentTimeMillis();
    this.llh = paramc;
    switch (EmojiCustomUI.11.llK[paramc.ordinal()])
    {
    }
    for (;;)
    {
      if (this.lli != null)
      {
        this.lli.bmC();
        this.lli.notifyDataSetChanged();
      }
      ab.d("MicroMsg.emoji.EmojiCustomUI", "updateMode use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(53346);
      return;
      setBackBtn(new EmojiCustomUI.3(this));
      enableBackMenu(true);
      addTextOptionMenu(0, getString(2131299189), new EmojiCustomUI.4(this));
      this.llk.setVisibility(8);
      bmx();
      bmt();
      for (;;)
      {
        bmu();
        break;
        setBackBtn(new EmojiCustomUI.5(this));
        addTextOptionMenu(0, getString(2131296964), new EmojiCustomUI.6(this));
        this.llk.setVisibility(0);
        bmw();
        bmv();
      }
      bmu();
    }
  }
  
  private void bmh()
  {
    AppMethodBeat.i(53357);
    if ((this.gsr != null) && (this.gsr.isShowing())) {
      this.gsr.dismiss();
    }
    AppMethodBeat.o(53357);
  }
  
  private void bmt()
  {
    AppMethodBeat.i(53347);
    if (this.llv != null) {
      this.llv.clear();
    }
    ab.i("MicroMsg.emoji.EmojiCustomUI", "clear md5 list. updateMode NORMAL");
    AppMethodBeat.o(53347);
  }
  
  private void bmu()
  {
    AppMethodBeat.i(53348);
    View localView = this.llk;
    if (this.llh == EmojiCustomUI.c.llR) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(53348);
      return;
    }
  }
  
  private void bmv()
  {
    AppMethodBeat.i(53349);
    int i;
    if (this.llh == EmojiCustomUI.c.llR)
    {
      if (this.llv != null) {
        break label94;
      }
      i = 0;
      if (i <= 0) {
        break label105;
      }
      this.lll.setText(getResources().getString(2131296901));
      this.lll.setEnabled(true);
      this.llm.setEnabled(true);
    }
    for (;;)
    {
      setMMTitle(getResources().getString(2131299170, new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(53349);
      return;
      label94:
      i = this.llv.size();
      break;
      label105:
      this.lll.setText(getResources().getString(2131296901));
      this.lll.setEnabled(false);
      this.llm.setEnabled(false);
    }
  }
  
  private void bmw()
  {
    AppMethodBeat.i(53351);
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessageDelayed(1003, 0L);
    }
    AppMethodBeat.o(53351);
  }
  
  private void bmx()
  {
    AppMethodBeat.i(53352);
    if (!com.tencent.mm.sdk.platformtools.at.isConnected(this))
    {
      bmw();
      AppMethodBeat.o(53352);
      return;
    }
    if (bmy())
    {
      AppMethodBeat.o(53352);
      return;
    }
    this.lls = false;
    AppMethodBeat.o(53352);
  }
  
  private boolean bmy()
  {
    AppMethodBeat.i(53353);
    if ((this.lli != null) && (this.lli.getRealCount() > com.tencent.mm.emoji.a.h.OK()))
    {
      this.llr = true;
      this.llo.setVisibility(0);
      bmz();
      this.llq.setVisibility(8);
      this.lli.notifyDataSetChanged();
      enableOptionMenu(0, true);
      this.lls = true;
      AppMethodBeat.o(53353);
      return true;
    }
    AppMethodBeat.o(53353);
    return false;
  }
  
  private void bmz()
  {
    AppMethodBeat.i(53354);
    this.llp.setTextColor(getResources().getColor(2131690391));
    this.llp.setText(getString(2131299267, new Object[] { Integer.valueOf(com.tencent.mm.emoji.a.h.OK()) }));
    AppMethodBeat.o(53354);
  }
  
  private void gF(boolean paramBoolean)
  {
    AppMethodBeat.i(53337);
    int j = this.llx.exA.size();
    int k = this.llx.exB;
    if ((j == k) && (!paramBoolean))
    {
      this.llp.setText(2131299274);
      AppMethodBeat.o(53337);
      return;
    }
    if (k == 0)
    {
      i = j;
      k += i;
      if (!paramBoolean) {
        break label125;
      }
    }
    label125:
    for (int i = 2131299276;; i = 2131299269)
    {
      this.llp.setText(String.format(getString(i), new Object[] { Integer.valueOf(k - j), Integer.valueOf(k) }));
      AppMethodBeat.o(53337);
      return;
      i = 0;
      break;
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969365;
  }
  
  public void initView()
  {
    AppMethodBeat.i(53342);
    this.llo = getLayoutInflater().inflate(2130969367, null);
    this.llp = ((TextView)this.llo.findViewById(2131823567));
    this.llq = ((Button)this.llo.findViewById(2131823568));
    this.llq.setOnClickListener(this.lly);
    this.llj = ((HeaderGridView)findViewById(2131823561));
    Object localObject = this.llj;
    View localView = this.llo;
    ListAdapter localListAdapter = ((HeaderGridView)localObject).getAdapter();
    if ((localListAdapter != null) && (!(localListAdapter instanceof HeaderGridView.c)))
    {
      localObject = new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
      AppMethodBeat.o(53342);
      throw ((Throwable)localObject);
    }
    HeaderGridView.a locala = new HeaderGridView.a((byte)0);
    HeaderGridView.b localb = new HeaderGridView.b((HeaderGridView)localObject, ((HeaderGridView)localObject).getContext());
    localb.addView(localView);
    locala.view = localView;
    locala.zhz = localb;
    locala.data = null;
    locala.isSelectable = false;
    ((HeaderGridView)localObject).zhy.add(locala);
    if (localListAdapter != null) {
      ((HeaderGridView.c)localListAdapter).mDataSetObservable.notifyChanged();
    }
    this.llj.setAdapter$159aa965(this.lli);
    this.llj.setOnItemClickListener(this);
    this.llj.setFocusableInTouchMode(false);
    this.llk = findViewById(2131823562);
    this.lll = ((Button)findViewById(2131823564));
    this.lll.setOnClickListener(this.llz);
    this.llm = ((Button)findViewById(2131823563));
    this.llm.setOnClickListener(this.llA);
    AppMethodBeat.o(53342);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(53344);
    ab.d("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: requestCode[%d],resultCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      Object localObject;
      switch (paramInt1)
      {
      default: 
        ab.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: not found this requestCode");
        AppMethodBeat.o(53344);
        return;
      case 214: 
        if (this.lli != null)
        {
          this.lli.bmC();
          this.lli.notifyDataSetChanged();
          AppMethodBeat.o(53344);
          return;
        }
        break;
      case 205: 
        if (paramIntent == null)
        {
          AppMethodBeat.o(53344);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CropImageMode", 3);
        ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.plugin.emoji.h.b.YP());
        com.tencent.mm.plugin.emoji.b.gmO.a((Intent)localObject, 206, this, paramIntent);
        AppMethodBeat.o(53344);
        return;
      case 206: 
        if (paramIntent == null)
        {
          ab.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult MAT_IMAGE_IN_CROP_ACTIVITY return null.");
          AppMethodBeat.o(53344);
          return;
        }
        localObject = paramIntent.getStringExtra("CropImage_OutputPath");
        paramInt1 = paramIntent.getIntExtra("emoji_type", 0);
        if ((localObject == null) || (((String)localObject).length() <= 0))
        {
          AppMethodBeat.o(53344);
          return;
        }
        paramIntent = ((String)localObject).substring(((String)localObject).lastIndexOf('/') + 1);
        localObject = com.tencent.mm.plugin.emoji.h.b.YP() + paramIntent;
        this.llE = i.getEmojiStorageMgr().yNn.asP(paramIntent);
        localObject = com.tencent.mm.ui.tools.b.b.auW((String)localObject);
        ((com.tencent.mm.ui.tools.b.b)localObject).mSize = com.tencent.mm.m.b.MU();
        ((com.tencent.mm.ui.tools.b.b)localObject).QR(com.tencent.mm.m.b.MV()).a(new EmojiCustomUI.2(this, paramInt1, paramIntent));
        AppMethodBeat.o(53344);
        return;
      }
    }
    AppMethodBeat.o(53344);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(53345);
    if (this.llh == EmojiCustomUI.c.llR)
    {
      a(EmojiCustomUI.c.llQ);
      AppMethodBeat.o(53345);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(53345);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(53338);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    this.llw = getIntent().getIntExtra("key_emoji_panel_type", this.llw);
    if (this.llw == 1)
    {
      paramBundle = EmojiSyncManager.exH;
      this.llx = EmojiSyncManager.a.Ph();
      this.lli = new EmojiCustomUI.b(this, this.llw);
      this.lli.bmC();
      initView();
      a(EmojiCustomUI.c.llQ);
      if (this.llw != 1) {
        break label335;
      }
    }
    label335:
    for (boolean bool = ((Boolean)g.RL().Ru().get(ac.a.yxV, Boolean.TRUE)).booleanValue();; bool = ((Boolean)g.RL().Ru().get(ac.a.yxU, Boolean.TRUE)).booleanValue())
    {
      ab.i("MicroMsg.emoji.EmojiCustomUI", "[cpan] touch batch emoji download from EmojiCustomUI needDownload:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        paramBundle = new com.tencent.mm.plugin.emoji.f.e(this.llw);
        g.RK().eHt.a(paramBundle, 0);
      }
      i.getEmojiStorageMgr().yNn.add(this.llB);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(406L, 9L, 1L, false);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(406L, 11L, System.currentTimeMillis() - l, false);
      com.tencent.mm.plugin.report.service.h.qsU.e(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(28), Integer.valueOf(28) });
      paramBundle = this.llx;
      com.tencent.mm.emoji.sync.c localc = this.llC;
      j.q(localc, "callback");
      com.tencent.mm.ab.b.b((a.f.a.a)new EmojiSyncManager.e(paramBundle, localc));
      this.llx.cp(true);
      paramBundle = com.tencent.mm.emoji.a.e.ewz;
      com.tencent.mm.emoji.a.e.OE();
      AppMethodBeat.o(53338);
      return;
      paramBundle = EmojiSyncManager.exH;
      this.llx = EmojiSyncManager.a.Pg();
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(53341);
    super.onDestroy();
    i.getEmojiStorageMgr().yNn.remove(this.llB);
    i.blq().lje.bNX = false;
    Object localObject = i.blq().lje;
    if (((BKGLoaderManager)localObject).ljn) {
      ((BKGLoaderManager)localObject).ljn = false;
    }
    localObject = this.llx;
    com.tencent.mm.emoji.sync.c localc = this.llC;
    j.q(localc, "callback");
    com.tencent.mm.ab.b.b((a.f.a.a)new EmojiSyncManager.h((EmojiSyncManager)localObject, localc));
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(53341);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(53343);
    EmojiInfo localEmojiInfo;
    if (this.lli != null)
    {
      paramInt -= this.llj.getHeaderViewCount() * 5;
      if ((this.llh == EmojiCustomUI.c.llQ) && (paramInt == 0))
      {
        if (1 == this.llw)
        {
          AppMethodBeat.o(53343);
          return;
        }
        if (!g.RL().isSDCardAvailable())
        {
          t.ii(this);
          AppMethodBeat.o(53343);
          return;
        }
        if (this.lli.getRealCount() < com.tencent.mm.emoji.a.h.OK()) {
          break label223;
        }
        com.tencent.mm.ui.base.h.a(this, getString(2131299287), "", new EmojiCustomUI.19(this));
        com.tencent.mm.plugin.report.service.h.qsU.e(11596, new Object[] { Integer.valueOf(0) });
      }
      if ((this.llh == EmojiCustomUI.c.llR) && (paramInt < this.lli.getRealCount()))
      {
        localEmojiInfo = this.lli.ur(paramInt);
        paramAdapterView = null;
        if (paramView != null) {
          paramAdapterView = (EmojiCustomUI.d)paramView.getTag();
        }
        if (localEmojiInfo.field_catalog != EmojiGroupInfo.yPe) {
          break label231;
        }
        com.tencent.mm.ui.base.h.h(getContext(), 2131298157, 2131298157).show();
      }
    }
    for (;;)
    {
      bmv();
      if (paramAdapterView == null) {
        this.lli.notifyDataSetChanged();
      }
      AppMethodBeat.o(53343);
      return;
      label223:
      com.tencent.mm.pluginsdk.ui.tools.n.as(this);
      break;
      label231:
      if (!this.llv.contains(localEmojiInfo.Al()))
      {
        paramView = localEmojiInfo.Al();
        if (this.llv != null) {
          this.llv.add(paramView);
        }
        if (paramAdapterView != null) {
          paramAdapterView.llV.setChecked(true);
        }
        ab.i("MicroMsg.emoji.EmojiCustomUI", "selected md5:%s", new Object[] { localEmojiInfo.Al() });
      }
      else
      {
        paramView = localEmojiInfo.Al();
        if (this.llv != null) {
          this.llv.remove(paramView);
        }
        if (paramAdapterView != null)
        {
          paramAdapterView.llV.setChecked(false);
          this.lli.notifyDataSetChanged();
        }
        ab.i("MicroMsg.emoji.EmojiCustomUI", "unselected md5:%s", new Object[] { localEmojiInfo.Al() });
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(53340);
    super.onPause();
    g.RK().eHt.b(698, this);
    AppMethodBeat.o(53340);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(53339);
    super.onResume();
    bmx();
    g.RK().eHt.a(698, this);
    AppMethodBeat.o(53339);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(53355);
    ab.i("MicroMsg.emoji.EmojiCustomUI", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramm instanceof com.tencent.mm.plugin.emoji.f.c))
    {
      switch (((com.tencent.mm.plugin.emoji.f.c)paramm).gxQ)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(53355);
        return;
        bmh();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = new ArrayList(this.llv);
          g.RO().ac(new EmojiCustomUI.9(this, paramString));
          i.getEmojiStorageMgr().yNn.t(this.llv, this.llw);
          bmt();
          bmv();
          if (this.llw == 0)
          {
            com.tencent.mm.emoji.a.d.Oz().ck(true);
            paramString = com.tencent.mm.emoji.a.e.ewz;
            com.tencent.mm.emoji.a.e.cn(false);
          }
          for (;;)
          {
            this.mHandler.sendEmptyMessageDelayed(1004, 100L);
            AppMethodBeat.o(53355);
            return;
            com.tencent.mm.emoji.a.d.Oz().cm(true);
            paramString = com.tencent.mm.emoji.a.e.ewz;
            com.tencent.mm.emoji.a.e.co(false);
          }
        }
        ab.i("MicroMsg.emoji.EmojiCustomUI", "delete failed");
        Lb(getString(2131299283));
        AppMethodBeat.o(53355);
        return;
        bmh();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          i.getEmojiStorageMgr().yNn.l(this.llw, this.llv);
          bmt();
          bmv();
          if (this.llw == 0) {
            com.tencent.mm.emoji.a.d.Oz().ck(true);
          }
          for (;;)
          {
            this.mHandler.sendEmptyMessageDelayed(1004, 100L);
            AppMethodBeat.o(53355);
            return;
            com.tencent.mm.emoji.a.d.Oz().cm(true);
          }
        }
        Lb(getString(2131299283));
      }
    }
    ab.w("MicroMsg.emoji.EmojiCustomUI", "no emoji operate");
    AppMethodBeat.o(53355);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI
 * JD-Core Version:    0.7.0.1
 */