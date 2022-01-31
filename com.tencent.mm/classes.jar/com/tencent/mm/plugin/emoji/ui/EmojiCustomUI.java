package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.database.DataSetObservable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.emoji.f.b;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.a;
import com.tencent.mm.plugin.emoji.sync.a.a;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.HeaderGridView;
import com.tencent.mm.ui.base.HeaderGridView.a;
import com.tencent.mm.ui.base.HeaderGridView.b;
import com.tencent.mm.ui.base.HeaderGridView.c;
import com.tencent.mm.ui.tools.a.b.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EmojiCustomUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.ah.f
{
  private static com.tencent.mm.as.a.c.l erY = new EmojiCustomUI.17();
  private static com.tencent.mm.as.a.c.d jcQ = new EmojiCustomUI.16();
  private ProgressDialog faz;
  private Button jcA;
  private a.a jcB = a.a.jao;
  private View jcC;
  private TextView jcD;
  private Button jcE;
  private boolean jcF = false;
  private boolean jcG = false;
  private boolean jcH = false;
  private EmojiCustomUI.a jcI = EmojiCustomUI.a.jda;
  private ArrayList<String> jcJ = new ArrayList();
  private long jcK;
  private View.OnClickListener jcL = new EmojiCustomUI.1(this);
  private View.OnClickListener jcM = new EmojiCustomUI.12(this);
  private View.OnClickListener jcN = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      EmojiCustomUI.d(EmojiCustomUI.this);
    }
  };
  private final j.a jcO = new EmojiCustomUI.14(this);
  private final com.tencent.mm.plugin.emoji.sync.c jcP = new EmojiCustomUI.15(this);
  private EmojiInfo jcR;
  private EmojiCustomUI.c jcv = EmojiCustomUI.c.jde;
  private EmojiCustomUI.b jcw;
  private HeaderGridView jcx;
  private View jcy;
  private Button jcz;
  private ah mHandler = new EmojiCustomUI.18(this);
  
  private boolean AZ(String paramString)
  {
    com.tencent.mm.ui.base.h.a(this.mController.uMN, paramString, "", "", getString(f.h.i_know_it), null, null);
    return true;
  }
  
  private void Ba(String paramString)
  {
    getString(f.h.app_tip);
    this.faz = com.tencent.mm.ui.base.h.b(this, paramString, true, new EmojiCustomUI.10(this));
  }
  
  private void a(EmojiCustomUI.a parama)
  {
    y.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateButtonType,button type:%s]", new Object[] { parama.toString() });
    this.jcI = parama;
    switch (EmojiCustomUI.11.jcV[parama.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.jcE.setVisibility(4);
      return;
    case 2: 
      this.jcE.setVisibility(0);
      this.jcE.setText(f.h.emoji_sync_start_sync);
      return;
    }
    this.jcE.setVisibility(0);
    this.jcE.setText(f.h.emoji_sync_stop_sync);
  }
  
  private void a(EmojiCustomUI.c paramc)
  {
    long l = System.currentTimeMillis();
    this.jcv = paramc;
    switch (EmojiCustomUI.11.jcX[paramc.ordinal()])
    {
    }
    for (;;)
    {
      if (this.jcw != null)
      {
        this.jcw.aJc();
        this.jcw.notifyDataSetChanged();
      }
      y.d("MicroMsg.emoji.EmojiCustomUI", "updateMode use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
      setBackBtn(new EmojiCustomUI.3(this));
      enableBackMenu(true);
      addTextOptionMenu(0, getString(f.h.emoji_store_custom_mgr), new EmojiCustomUI.4(this));
      this.jcy.setVisibility(8);
      aIZ();
      aIV();
      for (;;)
      {
        aIW();
        break;
        setBackBtn(new EmojiCustomUI.5(this));
        addTextOptionMenu(0, getString(f.h.app_finish), new EmojiCustomUI.6(this));
        this.jcy.setVisibility(0);
        aIY();
        aIX();
      }
      aIW();
    }
  }
  
  private void aIJ()
  {
    if ((this.faz != null) && (this.faz.isShowing())) {
      this.faz.dismiss();
    }
  }
  
  private void aIV()
  {
    if (this.jcJ != null) {
      this.jcJ.clear();
    }
    y.i("MicroMsg.emoji.EmojiCustomUI", "clear md5 list. updateMode NORMAL");
  }
  
  private void aIW()
  {
    View localView = this.jcy;
    if (this.jcv == EmojiCustomUI.c.jdf) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private void aIX()
  {
    int i;
    if (this.jcv == EmojiCustomUI.c.jdf)
    {
      if (this.jcJ != null) {
        break label82;
      }
      i = 0;
      if (i <= 0) {
        break label93;
      }
      this.jcz.setText(getResources().getString(f.h.app_delete));
      this.jcz.setEnabled(true);
      this.jcA.setEnabled(true);
    }
    for (;;)
    {
      setMMTitle(getResources().getString(f.h.emoji_select_count, new Object[] { Integer.valueOf(i) }));
      return;
      label82:
      i = this.jcJ.size();
      break;
      label93:
      this.jcz.setText(getResources().getString(f.h.app_delete));
      this.jcz.setEnabled(false);
      this.jcA.setEnabled(false);
    }
  }
  
  private void aIY()
  {
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessageDelayed(1003, 0L);
    }
  }
  
  private void aIZ()
  {
    int i = 1;
    i.aHQ();
    if (!aq.isConnected(ae.getContext())) {
      aIY();
    }
    for (;;)
    {
      return;
      if ((this.jcw != null) && (this.jcw.getRealCount() > com.tencent.mm.plugin.emoji.e.l.aHC()))
      {
        this.jcF = true;
        this.jcC.setVisibility(0);
        int j = f.h.emoji_sync_delete_emoji;
        int k = f.b.red;
        this.jcD.setTextColor(getResources().getColor(k));
        this.jcD.setText(getString(j, new Object[] { Integer.valueOf(com.tencent.mm.plugin.emoji.e.l.aHC()) }));
        this.jcE.setVisibility(8);
        this.jcw.notifyDataSetChanged();
        enableOptionMenu(0, true);
        this.jcG = true;
      }
      while (i == 0)
      {
        this.jcG = false;
        return;
        i = 0;
      }
    }
  }
  
  private void fe(boolean paramBoolean)
  {
    int j = i.getEmojiStorageMgr().uBb.cwQ();
    int k = i.aHQ().jan.jay;
    if ((j == k) && (!paramBoolean))
    {
      this.jcD.setText(f.h.emoji_sync_sync_start_not_in_wifi);
      return;
    }
    if (k == 0)
    {
      i = j;
      k += i;
      if (!paramBoolean) {
        break label106;
      }
    }
    label106:
    for (int i = f.h.emoji_sync_syncing_not_in_wifi;; i = f.h.emoji_sync_pause_not_in_wifi)
    {
      this.jcD.setText(String.format(getString(i), new Object[] { Integer.valueOf(k - j), Integer.valueOf(k) }));
      return;
      i = 0;
      break;
    }
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return f.f.emoji_custom;
  }
  
  protected final void initView()
  {
    this.jcC = getLayoutInflater().inflate(f.f.emoji_custom_header, null);
    this.jcD = ((TextView)this.jcC.findViewById(f.e.sync_status));
    this.jcE = ((Button)this.jcC.findViewById(f.e.sync_action_btn));
    this.jcE.setOnClickListener(this.jcL);
    this.jcx = ((HeaderGridView)findViewById(f.e.settings_emoticons_custom_grid));
    HeaderGridView localHeaderGridView = this.jcx;
    View localView = this.jcC;
    ListAdapter localListAdapter = localHeaderGridView.getAdapter();
    if ((localListAdapter != null) && (!(localListAdapter instanceof HeaderGridView.c))) {
      throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
    }
    HeaderGridView.a locala = new HeaderGridView.a((byte)0);
    HeaderGridView.b localb = new HeaderGridView.b(localHeaderGridView, localHeaderGridView.getContext());
    localb.addView(localView);
    locala.view = localView;
    locala.uSZ = localb;
    locala.data = null;
    locala.isSelectable = false;
    localHeaderGridView.uSY.add(locala);
    if (localListAdapter != null) {
      ((HeaderGridView.c)localListAdapter).mDataSetObservable.notifyChanged();
    }
    this.jcx.setAdapter$159aa965(this.jcw);
    this.jcx.setOnItemClickListener(this);
    this.jcx.setFocusableInTouchMode(false);
    this.jcy = findViewById(f.e.settings_emoticons_custom_footer);
    this.jcz = ((Button)findViewById(f.e.settings_emoticons_delete));
    this.jcz.setOnClickListener(this.jcM);
    this.jcA = ((Button)findViewById(f.e.settings_emoticons_top));
    this.jcA.setOnClickListener(this.jcN);
  }
  
  protected void onActivityResult(final int paramInt1, int paramInt2, final Intent paramIntent)
  {
    y.d("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: requestCode[%d],resultCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      default: 
        y.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: not found this requestCode");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jcw == null);
        this.jcw.aJc();
        this.jcw.notifyDataSetChanged();
        return;
      } while (paramIntent == null);
      localObject = new Intent();
      ((Intent)localObject).putExtra("CropImageMode", 3);
      ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.plugin.emoji.h.b.FL());
      com.tencent.mm.plugin.emoji.b.eUR.a((Intent)localObject, 206, this, paramIntent);
      return;
      if (paramIntent == null)
      {
        y.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult MAT_IMAGE_IN_CROP_ACTIVITY return null.");
        return;
      }
      localObject = paramIntent.getStringExtra("CropImage_OutputPath");
      paramInt1 = paramIntent.getIntExtra("emoji_type", 0);
    } while ((localObject == null) || (((String)localObject).length() <= 0));
    paramIntent = ((String)localObject).substring(((String)localObject).lastIndexOf('/') + 1);
    Object localObject = com.tencent.mm.plugin.emoji.h.b.FL() + paramIntent;
    this.jcR = i.getEmojiStorageMgr().uBb.acC(paramIntent);
    localObject = com.tencent.mm.ui.tools.a.b.aen((String)localObject);
    ((com.tencent.mm.ui.tools.a.b)localObject).mSize = com.tencent.mm.m.b.Af();
    ((com.tencent.mm.ui.tools.a.b)localObject).If(com.tencent.mm.m.b.Ag()).a(new b.a()
    {
      public final void a(com.tencent.mm.ui.tools.a.b paramAnonymousb)
      {
        if (EmojiCustomUI.i(EmojiCustomUI.this) == null)
        {
          if (paramInt1 != 0) {
            break label112;
          }
          EmojiCustomUI.a(EmojiCustomUI.this, i.getEmojiStorageMgr().uBb.d(paramIntent, "", EmojiGroupInfo.uCT, EmojiInfo.uDa, paramAnonymousb.wfI, ""));
        }
        for (;;)
        {
          i.aHP().a(EmojiCustomUI.this.mController.uMN, EmojiCustomUI.i(EmojiCustomUI.this), 1, q.Gj());
          if (EmojiCustomUI.e(EmojiCustomUI.this) != null)
          {
            EmojiCustomUI.e(EmojiCustomUI.this).aJc();
            EmojiCustomUI.e(EmojiCustomUI.this).notifyDataSetChanged();
          }
          return;
          label112:
          EmojiCustomUI.a(EmojiCustomUI.this, i.getEmojiStorageMgr().uBb.d(paramIntent, "", EmojiGroupInfo.uCT, EmojiInfo.uDb, paramAnonymousb.wfI, ""));
        }
      }
      
      public final void aIT()
      {
        com.tencent.mm.ui.base.h.a(EmojiCustomUI.this.mController.uMN, EmojiCustomUI.this.mController.uMN.getString(f.h.emoji_custom_gif_max_size_limit), "", EmojiCustomUI.this.mController.uMN.getString(f.h.i_know_it), false, null);
      }
    });
  }
  
  public void onBackPressed()
  {
    if (this.jcv == EmojiCustomUI.c.jdf)
    {
      a(EmojiCustomUI.c.jde);
      return;
    }
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    this.jcw = new EmojiCustomUI.b(this);
    this.jcw.aJc();
    initView();
    i.aHQ().fd(true);
    a(EmojiCustomUI.c.jde);
    boolean bool = ((Boolean)g.DP().Dz().get(ac.a.uod, Boolean.valueOf(true))).booleanValue();
    y.i("MicroMsg.emoji.EmojiCustomUI", "[cpan] touch batch emoji download from EmojiCustomUI needDownload:%b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      paramBundle = new com.tencent.mm.plugin.emoji.f.f();
      g.DO().dJT.a(paramBundle, 0);
    }
    i.getEmojiStorageMgr().uBb.c(this.jcO);
    com.tencent.mm.plugin.report.service.h.nFQ.a(406L, 9L, 1L, false);
    com.tencent.mm.plugin.report.service.h.nFQ.a(406L, 11L, System.currentTimeMillis() - l, false);
    com.tencent.mm.plugin.report.service.h.nFQ.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(28), Integer.valueOf(28) });
    this.jcK = getIntent().getLongExtra("key_capture_enter_time", 0L);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    i.getEmojiStorageMgr().uBb.d(this.jcO);
    i.aHQ().fd(false);
    BKGLoaderManager localBKGLoaderManager = i.aHQ().jan;
    if (localBKGLoaderManager.jaE) {
      localBKGLoaderManager.jaE = false;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jcw != null)
    {
      paramInt -= this.jcx.getHeaderViewCount() * 5;
      if ((this.jcv != EmojiCustomUI.c.jde) || (paramInt != this.jcw.getRealCount())) {
        break label109;
      }
      if (g.DP().isSDCardAvailable()) {
        break label54;
      }
      com.tencent.mm.ui.base.s.gM(this);
    }
    label54:
    label89:
    label109:
    while ((this.jcv != EmojiCustomUI.c.jdf) || (paramInt >= this.jcw.getRealCount()))
    {
      return;
      if (this.jcw.getRealCount() < com.tencent.mm.plugin.emoji.e.l.aHC()) {
        break;
      }
      com.tencent.mm.ui.base.h.a(this, getString(f.h.emoji_upper_limit_warning), "", new EmojiCustomUI.19(this));
      com.tencent.mm.plugin.report.service.h.nFQ.f(11596, new Object[] { Integer.valueOf(0) });
    }
    EmojiInfo localEmojiInfo = this.jcw.pW(paramInt);
    paramAdapterView = null;
    if (paramView != null) {
      paramAdapterView = (EmojiCustomUI.d)paramView.getTag();
    }
    if (localEmojiInfo.field_catalog == EmojiGroupInfo.uCR) {
      com.tencent.mm.ui.base.h.h(this.mController.uMN, f.h.chatting_can_not_del_sys_smiley, f.h.chatting_can_not_del_sys_smiley).show();
    }
    for (;;)
    {
      aIX();
      if (paramAdapterView != null) {
        break;
      }
      this.jcw.notifyDataSetChanged();
      return;
      com.tencent.mm.pluginsdk.ui.tools.l.j(this, 205);
      break label89;
      if (!this.jcJ.contains(localEmojiInfo.Wv()))
      {
        paramView = localEmojiInfo.Wv();
        if (this.jcJ != null) {
          this.jcJ.add(paramView);
        }
        if (paramAdapterView != null) {
          paramAdapterView.jdl.setChecked(true);
        }
        y.i("MicroMsg.emoji.EmojiCustomUI", "selected md5:%s", new Object[] { localEmojiInfo.Wv() });
      }
      else
      {
        paramView = localEmojiInfo.Wv();
        if (this.jcJ != null) {
          this.jcJ.remove(paramView);
        }
        if (paramAdapterView != null)
        {
          paramAdapterView.jdl.setChecked(false);
          this.jcw.notifyDataSetChanged();
        }
        y.i("MicroMsg.emoji.EmojiCustomUI", "unselected md5:%s", new Object[] { localEmojiInfo.Wv() });
      }
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    Object localObject = i.aHQ();
    com.tencent.mm.plugin.emoji.sync.c localc = this.jcP;
    localObject = ((a)localObject).jan;
    if (((BKGLoaderManager)localObject).jaM == null) {
      ((BKGLoaderManager)localObject).jaM = new HashSet();
    }
    if (((BKGLoaderManager)localObject).jaM.contains(localc)) {
      ((BKGLoaderManager)localObject).jaM.remove(localc);
    }
    g.DO().dJT.b(698, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    Object localObject = i.aHQ();
    com.tencent.mm.plugin.emoji.sync.c localc = this.jcP;
    localObject = ((a)localObject).jan;
    if (((BKGLoaderManager)localObject).jaM == null) {
      ((BKGLoaderManager)localObject).jaM = new HashSet();
    }
    if (!((BKGLoaderManager)localObject).jaM.contains(localc)) {
      ((BKGLoaderManager)localObject).jaM.add(localc);
    }
    aIZ();
    g.DO().dJT.a(698, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.emoji.EmojiCustomUI", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramm instanceof com.tencent.mm.plugin.emoji.f.d))
    {
      switch (((com.tencent.mm.plugin.emoji.f.d)paramm).fgi)
      {
      default: 
        return;
      case 2: 
        aIJ();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = new ArrayList(this.jcJ);
          g.DS().O(new EmojiCustomUI.9(this, paramString));
          i.aHQ().w(this.jcJ);
          i.getEmojiStorageMgr().uBb.dI(this.jcJ);
          aIV();
          aIX();
          this.mHandler.sendEmptyMessageDelayed(1004, 100L);
          return;
        }
        y.i("MicroMsg.emoji.EmojiCustomUI", "delete failed");
        AZ(getString(f.h.emoji_top_failed));
        return;
      }
      aIJ();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        i.getEmojiStorageMgr().uBb.dJ(this.jcJ);
        aIV();
        aIX();
        this.mHandler.sendEmptyMessageDelayed(1004, 100L);
        return;
      }
      AZ(getString(f.h.emoji_top_failed));
      return;
    }
    y.w("MicroMsg.emoji.EmojiCustomUI", "no emoji operate");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI
 * JD-Core Version:    0.7.0.1
 */