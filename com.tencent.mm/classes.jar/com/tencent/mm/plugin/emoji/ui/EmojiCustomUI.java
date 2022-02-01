package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.DataSetObservable;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.emoji.sync.EmojiSyncManager.a;
import com.tencent.mm.emoji.sync.EmojiSyncManager.b;
import com.tencent.mm.emoji.sync.EmojiSyncManager.e;
import com.tencent.mm.emoji.sync.EmojiSyncManager.h;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.HeaderGridView;
import com.tencent.mm.ui.base.HeaderGridView.a;
import com.tencent.mm.ui.base.HeaderGridView.b;
import com.tencent.mm.ui.base.HeaderGridView.c;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.tools.b.b.a;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.List;

public class EmojiCustomUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.al.g
{
  private static com.tencent.mm.aw.a.c.n hkI;
  private static com.tencent.mm.aw.a.c.e oBT;
  private ProgressDialog ift;
  private ap mHandler;
  private View oBA;
  private Button oBB;
  private Button oBC;
  private EmojiSyncManager.b oBD;
  private View oBE;
  private TextView oBF;
  private Button oBG;
  private boolean oBH;
  private boolean oBI;
  private boolean oBJ;
  private a oBK;
  private ArrayList<String> oBL;
  private int oBM;
  private EmojiSyncManager oBN;
  private View.OnClickListener oBO;
  private View.OnClickListener oBP;
  private View.OnClickListener oBQ;
  private final k.a oBR;
  private final com.tencent.mm.emoji.sync.f oBS;
  private EmojiInfo oBU;
  private c oBx;
  private b oBy;
  private HeaderGridView oBz;
  
  static
  {
    AppMethodBeat.i(108926);
    oBT = new com.tencent.mm.aw.a.c.e()
    {
      public final byte[] i(Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(108875);
        if ((paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0))
        {
          paramAnonymousVarArgs = paramAnonymousVarArgs[0];
          if ((paramAnonymousVarArgs != null) && ((paramAnonymousVarArgs instanceof EmojiInfo)))
          {
            paramAnonymousVarArgs = com.tencent.mm.emoji.decode.a.aaP().a((EmojiInfo)paramAnonymousVarArgs);
            AppMethodBeat.o(108875);
            return paramAnonymousVarArgs;
          }
        }
        AppMethodBeat.o(108875);
        return null;
      }
    };
    hkI = new com.tencent.mm.aw.a.c.n()
    {
      public final Bitmap ac(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(108876);
        paramAnonymousArrayOfByte = com.tencent.mm.plugin.gif.i.bn(paramAnonymousArrayOfByte);
        AppMethodBeat.o(108876);
        return paramAnonymousArrayOfByte;
      }
      
      public final Bitmap yE(String paramAnonymousString)
      {
        AppMethodBeat.i(108877);
        paramAnonymousString = com.tencent.mm.plugin.gif.i.bn(com.tencent.mm.vfs.i.aR(paramAnonymousString, 0, -1));
        AppMethodBeat.o(108877);
        return paramAnonymousString;
      }
    };
    AppMethodBeat.o(108926);
  }
  
  public EmojiCustomUI()
  {
    AppMethodBeat.i(108895);
    this.oBx = c.oCg;
    this.oBD = EmojiSyncManager.b.fRY;
    this.oBH = false;
    this.oBI = false;
    this.oBJ = false;
    this.oBK = a.oCd;
    this.oBL = new ArrayList();
    this.oBM = 0;
    this.oBO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108859);
        switch (EmojiCustomUI.11.oBY[EmojiCustomUI.a(EmojiCustomUI.this).ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(108859);
          return;
          EmojiCustomUI.b(EmojiCustomUI.this);
          AppMethodBeat.o(108859);
          return;
          EmojiCustomUI.c(EmojiCustomUI.this).stop();
        }
      }
    };
    this.oBP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108870);
        EmojiCustomUI.d(EmojiCustomUI.this);
        AppMethodBeat.o(108870);
      }
    };
    this.oBQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108871);
        EmojiCustomUI.e(EmojiCustomUI.this);
        AppMethodBeat.o(108871);
      }
    };
    this.oBR = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(108872);
        if ((!bt.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.length() == 32) || (paramAnonymousString.equals("event_update_emoji"))) && (EmojiCustomUI.f(EmojiCustomUI.this) != null))
        {
          EmojiCustomUI.f(EmojiCustomUI.this).bWm();
          EmojiCustomUI.f(EmojiCustomUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(108872);
      }
    };
    this.oBS = new com.tencent.mm.emoji.sync.f()
    {
      public final void a(EmojiSyncManager.b paramAnonymousb)
      {
        AppMethodBeat.i(108874);
        EmojiCustomUI.a(EmojiCustomUI.this, paramAnonymousb);
        if (EmojiCustomUI.g(EmojiCustomUI.this) != null) {
          EmojiCustomUI.g(EmojiCustomUI.this).sendEmptyMessage(1001);
        }
        AppMethodBeat.o(108874);
      }
      
      public final void acz()
      {
        AppMethodBeat.i(108873);
        if (EmojiCustomUI.g(EmojiCustomUI.this) != null) {
          EmojiCustomUI.g(EmojiCustomUI.this).sendEmptyMessage(1002);
        }
        AppMethodBeat.o(108873);
      }
    };
    this.mHandler = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(108878);
        switch (paramAnonymousMessage.what)
        {
        default: 
          ad.e("MicroMsg.emoji.EmojiCustomUI", "unknow Msg");
        case 1001: 
        case 1002: 
          do
          {
            AppMethodBeat.o(108878);
            return;
            EmojiCustomUI.h(EmojiCustomUI.this);
            AppMethodBeat.o(108878);
            return;
          } while (ay.isWifi(EmojiCustomUI.this));
          if (EmojiCustomUI.c(EmojiCustomUI.this).fRO == EmojiSyncManager.b.fRZ)
          {
            EmojiCustomUI.a(EmojiCustomUI.this, true);
            AppMethodBeat.o(108878);
            return;
          }
          EmojiCustomUI.a(EmojiCustomUI.this, false);
          AppMethodBeat.o(108878);
          return;
        case 1003: 
          EmojiCustomUI.i(EmojiCustomUI.this).setVisibility(8);
          EmojiCustomUI.f(EmojiCustomUI.this).notifyDataSetChanged();
          AppMethodBeat.o(108878);
          return;
        }
        if (EmojiCustomUI.f(EmojiCustomUI.this) != null)
        {
          EmojiCustomUI.f(EmojiCustomUI.this).bWm();
          EmojiCustomUI.f(EmojiCustomUI.this).notifyDataSetChanged();
        }
        EmojiCustomUI.bWk();
        AppMethodBeat.o(108878);
      }
    };
    AppMethodBeat.o(108895);
  }
  
  private boolean Uh(String paramString)
  {
    AppMethodBeat.i(108910);
    com.tencent.mm.ui.base.h.d(getContext(), paramString, "", "", getString(2131760315), null, null);
    AppMethodBeat.o(108910);
    return true;
  }
  
  private void Ui(String paramString)
  {
    AppMethodBeat.i(108916);
    getString(2131755906);
    this.ift = com.tencent.mm.ui.base.h.b(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(108916);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(108896);
    ad.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateButtonType,button type:%s]", new Object[] { parama.toString() });
    this.oBK = parama;
    switch (11.oBY[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(108896);
      return;
      this.oBG.setVisibility(4);
      AppMethodBeat.o(108896);
      return;
      this.oBG.setVisibility(0);
      this.oBG.setText(2131758397);
      AppMethodBeat.o(108896);
      return;
      this.oBG.setVisibility(0);
      this.oBG.setText(2131758398);
    }
  }
  
  private void a(c paramc)
  {
    AppMethodBeat.i(108906);
    long l = System.currentTimeMillis();
    this.oBx = paramc;
    switch (11.oCa[paramc.ordinal()])
    {
    }
    for (;;)
    {
      if (this.oBy != null)
      {
        this.oBy.bWm();
        this.oBy.notifyDataSetChanged();
      }
      ad.d("MicroMsg.emoji.EmojiCustomUI", "updateMode use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(108906);
      return;
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(108862);
          EmojiCustomUI.this.finish();
          AppMethodBeat.o(108862);
          return true;
        }
      });
      enableBackMenu(true);
      addTextOptionMenu(0, getString(2131758315), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(108863);
          EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.c.oCh);
          com.tencent.mm.plugin.report.service.h.vKh.f(11596, new Object[] { Integer.valueOf(1) });
          AppMethodBeat.o(108863);
          return true;
        }
      });
      this.oBA.setVisibility(8);
      bWh();
      bWd();
      for (;;)
      {
        bWe();
        break;
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(108864);
            EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.c.oCg);
            AppMethodBeat.o(108864);
            return true;
          }
        });
        addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(108865);
            EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.c.oCg);
            AppMethodBeat.o(108865);
            return true;
          }
        });
        this.oBA.setVisibility(0);
        bWg();
        bWf();
      }
      bWe();
    }
  }
  
  private void bVS()
  {
    AppMethodBeat.i(108917);
    if ((this.ift != null) && (this.ift.isShowing())) {
      this.ift.dismiss();
    }
    AppMethodBeat.o(108917);
  }
  
  private void bWd()
  {
    AppMethodBeat.i(108907);
    if (this.oBL != null) {
      this.oBL.clear();
    }
    ad.i("MicroMsg.emoji.EmojiCustomUI", "clear md5 list. updateMode NORMAL");
    AppMethodBeat.o(108907);
  }
  
  private void bWe()
  {
    AppMethodBeat.i(108908);
    View localView = this.oBA;
    if (this.oBx == c.oCh) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(108908);
      return;
    }
  }
  
  private void bWf()
  {
    AppMethodBeat.i(108909);
    int i;
    if (this.oBx == c.oCh)
    {
      if (this.oBL != null) {
        break label94;
      }
      i = 0;
      if (i <= 0) {
        break label105;
      }
      this.oBB.setText(getResources().getString(2131755707));
      this.oBB.setEnabled(true);
      this.oBC.setEnabled(true);
    }
    for (;;)
    {
      setMMTitle(getResources().getString(2131758296, new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(108909);
      return;
      label94:
      i = this.oBL.size();
      break;
      label105:
      this.oBB.setText(getResources().getString(2131755707));
      this.oBB.setEnabled(false);
      this.oBC.setEnabled(false);
    }
  }
  
  private void bWg()
  {
    AppMethodBeat.i(108911);
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessageDelayed(1003, 0L);
    }
    AppMethodBeat.o(108911);
  }
  
  private void bWh()
  {
    AppMethodBeat.i(108912);
    if (!ay.isConnected(this))
    {
      bWg();
      AppMethodBeat.o(108912);
      return;
    }
    if (bWi())
    {
      AppMethodBeat.o(108912);
      return;
    }
    this.oBI = false;
    AppMethodBeat.o(108912);
  }
  
  private boolean bWi()
  {
    AppMethodBeat.i(108913);
    if ((this.oBy != null) && (this.oBy.getRealCount() > com.tencent.mm.emoji.a.l.abt()))
    {
      this.oBH = true;
      this.oBE.setVisibility(0);
      bWj();
      this.oBG.setVisibility(8);
      this.oBy.notifyDataSetChanged();
      enableOptionMenu(0, true);
      this.oBI = true;
      AppMethodBeat.o(108913);
      return true;
    }
    AppMethodBeat.o(108913);
    return false;
  }
  
  private void bWj()
  {
    AppMethodBeat.i(108914);
    this.oBF.setTextColor(getResources().getColor(2131100798));
    this.oBF.setText(getString(2131758393, new Object[] { Integer.valueOf(com.tencent.mm.emoji.a.l.abt()) }));
    AppMethodBeat.o(108914);
  }
  
  private void jD(boolean paramBoolean)
  {
    AppMethodBeat.i(108897);
    int j = this.oBN.fRP.size();
    int k = this.oBN.bVq;
    if ((j == k) && (!paramBoolean))
    {
      this.oBF.setText(2131758400);
      AppMethodBeat.o(108897);
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
    for (int i = 2131758402;; i = 2131758395)
    {
      this.oBF.setText(String.format(getString(i), new Object[] { Integer.valueOf(k - j), Integer.valueOf(k) }));
      AppMethodBeat.o(108897);
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
    return 2131493766;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108902);
    this.oBE = getLayoutInflater().inflate(2131493768, null);
    this.oBF = ((TextView)this.oBE.findViewById(2131305593));
    this.oBG = ((Button)this.oBE.findViewById(2131305592));
    this.oBG.setOnClickListener(this.oBO);
    this.oBz = ((HeaderGridView)findViewById(2131304643));
    Object localObject = this.oBz;
    View localView = this.oBE;
    ListAdapter localListAdapter = ((HeaderGridView)localObject).getAdapter();
    if ((localListAdapter != null) && (!(localListAdapter instanceof HeaderGridView.c)))
    {
      localObject = new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
      AppMethodBeat.o(108902);
      throw ((Throwable)localObject);
    }
    HeaderGridView.a locala = new HeaderGridView.a((byte)0);
    HeaderGridView.b localb = new HeaderGridView.b((HeaderGridView)localObject, ((HeaderGridView)localObject).getContext());
    localb.addView(localView);
    locala.view = localView;
    locala.FVd = localb;
    locala.data = null;
    locala.isSelectable = false;
    ((HeaderGridView)localObject).FVc.add(locala);
    if (localListAdapter != null) {
      ((HeaderGridView.c)localListAdapter).mDataSetObservable.notifyChanged();
    }
    this.oBz.setAdapter$159aa965(this.oBy);
    this.oBz.setOnItemClickListener(this);
    this.oBz.setFocusableInTouchMode(false);
    this.oBA = findViewById(2131304642);
    this.oBB = ((Button)findViewById(2131304644));
    this.oBB.setOnClickListener(this.oBP);
    this.oBC = ((Button)findViewById(2131304645));
    this.oBC.setOnClickListener(this.oBQ);
    AppMethodBeat.o(108902);
  }
  
  public void onActivityResult(final int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(108904);
    ad.d("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: requestCode[%d],resultCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      Object localObject;
      com.tencent.mm.emoji.d.a locala;
      switch (paramInt1)
      {
      default: 
        ad.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: not found this requestCode");
        AppMethodBeat.o(108904);
        return;
      case 214: 
        if (this.oBy != null)
        {
          this.oBy.bWm();
          this.oBy.notifyDataSetChanged();
          AppMethodBeat.o(108904);
          return;
        }
        break;
      case 205: 
        if (paramIntent == null)
        {
          AppMethodBeat.o(108904);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CropImageMode", 3);
        locala = com.tencent.mm.emoji.d.a.fSR;
        ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.emoji.d.a.acD());
        com.tencent.mm.plugin.emoji.b.hYt.a((Intent)localObject, 206, this, paramIntent);
        AppMethodBeat.o(108904);
        return;
      case 206: 
        if (paramIntent == null)
        {
          ad.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult MAT_IMAGE_IN_CROP_ACTIVITY return null.");
          AppMethodBeat.o(108904);
          return;
        }
        localObject = paramIntent.getStringExtra("CropImage_OutputPath");
        paramInt1 = paramIntent.getIntExtra("emoji_type", 0);
        if ((localObject == null) || (((String)localObject).length() <= 0))
        {
          AppMethodBeat.o(108904);
          return;
        }
        paramIntent = ((String)localObject).substring(((String)localObject).lastIndexOf('/') + 1);
        localObject = new StringBuilder();
        locala = com.tencent.mm.emoji.d.a.fSR;
        localObject = com.tencent.mm.emoji.d.a.acD() + paramIntent;
        this.oBU = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.aJx(paramIntent);
        localObject = com.tencent.mm.ui.tools.b.b.aLP((String)localObject);
        ((com.tencent.mm.ui.tools.b.b)localObject).mSize = com.tencent.mm.m.b.YH();
        ((com.tencent.mm.ui.tools.b.b)localObject).aai(com.tencent.mm.m.b.YI()).a(new b.a()
        {
          public final void a(com.tencent.mm.ui.tools.b.b paramAnonymousb)
          {
            AppMethodBeat.i(108860);
            if (EmojiCustomUI.j(EmojiCustomUI.this) == null)
            {
              if (paramInt1 != 0) {
                break label119;
              }
              EmojiCustomUI.a(EmojiCustomUI.this, com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.d(paramIntent, "", EmojiGroupInfo.LBQ, EmojiInfo.LBX, paramAnonymousb.HuI, ""));
            }
            for (;;)
            {
              com.tencent.mm.plugin.emoji.model.k.bUZ().a(EmojiCustomUI.this.getContext(), EmojiCustomUI.j(EmojiCustomUI.this), 1, u.aqG());
              if (EmojiCustomUI.f(EmojiCustomUI.this) != null)
              {
                EmojiCustomUI.f(EmojiCustomUI.this).bWm();
                EmojiCustomUI.f(EmojiCustomUI.this).notifyDataSetChanged();
              }
              AppMethodBeat.o(108860);
              return;
              label119:
              EmojiCustomUI.a(EmojiCustomUI.this, com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.d(paramIntent, "", EmojiGroupInfo.LBQ, EmojiInfo.LBY, paramAnonymousb.HuI, ""));
            }
          }
          
          public final void bWb()
          {
            AppMethodBeat.i(108861);
            com.tencent.mm.ui.base.h.a(EmojiCustomUI.this.getContext(), EmojiCustomUI.this.getContext().getString(2131758245), "", EmojiCustomUI.this.getContext().getString(2131760315), false, null);
            AppMethodBeat.o(108861);
          }
        });
        AppMethodBeat.o(108904);
        return;
      }
    }
    AppMethodBeat.o(108904);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(108905);
    if (this.oBx == c.oCh)
    {
      a(c.oCg);
      AppMethodBeat.o(108905);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(108905);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108898);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    this.oBM = getIntent().getIntExtra("key_emoji_panel_type", this.oBM);
    if (this.oBM == 1)
    {
      paramBundle = EmojiSyncManager.fRW;
      this.oBN = EmojiSyncManager.a.acy();
      this.oBy = new b(this.oBM);
      this.oBy.bWm();
      initView();
      a(c.oCg);
      if (this.oBM != 1) {
        break label364;
      }
    }
    label364:
    for (boolean bool = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fgp, Boolean.TRUE)).booleanValue();; bool = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fgo, Boolean.TRUE)).booleanValue())
    {
      ad.i("MicroMsg.emoji.EmojiCustomUI", "[cpan] touch batch emoji download from EmojiCustomUI needDownload:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        paramBundle = new com.tencent.mm.plugin.emoji.f.e(this.oBM);
        com.tencent.mm.kernel.g.afA().gcy.a(paramBundle, 0);
      }
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.add(this.oBR);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(406L, 9L, 1L, false);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(406L, 11L, System.currentTimeMillis() - l, false);
      com.tencent.mm.plugin.report.service.h.vKh.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(28), Integer.valueOf(28) });
      paramBundle = this.oBN;
      com.tencent.mm.emoji.sync.f localf = this.oBS;
      d.g.b.k.h(localf, "callback");
      com.tencent.mm.ad.c.g((d.g.a.a)new EmojiSyncManager.e(paramBundle, localf));
      this.oBN.dr(true);
      paramBundle = com.tencent.mm.emoji.a.i.fMT;
      com.tencent.mm.emoji.a.i.abn();
      this.oBD = this.oBN.fRO;
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(1001);
      }
      AppMethodBeat.o(108898);
      return;
      paramBundle = EmojiSyncManager.fRW;
      this.oBN = EmojiSyncManager.a.acx();
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108901);
    super.onDestroy();
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.remove(this.oBR);
    com.tencent.mm.plugin.emoji.model.k.bVa().ozk.cwr = false;
    Object localObject = com.tencent.mm.plugin.emoji.model.k.bVa().ozk;
    if (((BKGLoaderManager)localObject).ozv) {
      ((BKGLoaderManager)localObject).ozv = false;
    }
    localObject = this.oBN;
    com.tencent.mm.emoji.sync.f localf = this.oBS;
    d.g.b.k.h(localf, "callback");
    com.tencent.mm.ad.c.g((d.g.a.a)new EmojiSyncManager.h((EmojiSyncManager)localObject, localf));
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(108901);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = null;
    AppMethodBeat.i(108903);
    EmojiInfo localEmojiInfo;
    if (this.oBy != null)
    {
      paramInt -= this.oBz.getHeaderViewCount() * 5;
      if ((this.oBx == c.oCg) && (paramInt == 0))
      {
        if (1 == this.oBM)
        {
          AppMethodBeat.o(108903);
          return;
        }
        if (!com.tencent.mm.kernel.g.afB().isSDCardAvailable())
        {
          t.g(this, null);
          AppMethodBeat.o(108903);
          return;
        }
        if (this.oBy.getRealCount() < com.tencent.mm.emoji.a.l.abt()) {
          break label224;
        }
        com.tencent.mm.ui.base.h.d(this, getString(2131758413), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        com.tencent.mm.plugin.report.service.h.vKh.f(11596, new Object[] { Integer.valueOf(0) });
      }
      if ((this.oBx == c.oCh) && (paramInt < this.oBy.getRealCount()))
      {
        localEmojiInfo = this.oBy.AB(paramInt);
        if (paramView != null) {
          paramAdapterView = (EmojiCustomUI.d)paramView.getTag();
        }
        if (localEmojiInfo.field_catalog != EmojiGroupInfo.LBO) {
          break label232;
        }
        com.tencent.mm.ui.base.h.j(getContext(), 2131757146, 2131757146).show();
      }
    }
    for (;;)
    {
      bWf();
      if (paramAdapterView == null) {
        this.oBy.notifyDataSetChanged();
      }
      AppMethodBeat.o(108903);
      return;
      label224:
      com.tencent.mm.pluginsdk.ui.tools.q.aO(this);
      break;
      label232:
      if (!this.oBL.contains(localEmojiInfo.JS()))
      {
        paramView = localEmojiInfo.JS();
        if (this.oBL != null) {
          this.oBL.add(paramView);
        }
        if (paramAdapterView != null) {
          paramAdapterView.oCl.setChecked(true);
        }
        ad.i("MicroMsg.emoji.EmojiCustomUI", "selected md5:%s", new Object[] { localEmojiInfo.JS() });
      }
      else
      {
        paramView = localEmojiInfo.JS();
        if (this.oBL != null) {
          this.oBL.remove(paramView);
        }
        if (paramAdapterView != null)
        {
          paramAdapterView.oCl.setChecked(false);
          this.oBy.notifyDataSetChanged();
        }
        ad.i("MicroMsg.emoji.EmojiCustomUI", "unselected md5:%s", new Object[] { localEmojiInfo.JS() });
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(108900);
    super.onPause();
    com.tencent.mm.kernel.g.afA().gcy.b(698, this);
    AppMethodBeat.o(108900);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(108899);
    super.onResume();
    bWh();
    com.tencent.mm.kernel.g.afA().gcy.a(698, this);
    AppMethodBeat.o(108899);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(108915);
    ad.i("MicroMsg.emoji.EmojiCustomUI", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramn instanceof com.tencent.mm.plugin.emoji.f.c))
    {
      switch (((com.tencent.mm.plugin.emoji.f.c)paramn).ikN)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(108915);
        return;
        bVS();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = new ArrayList(this.oBL);
          com.tencent.mm.kernel.g.afE().ax(new EmojiCustomUI.9(this, paramString));
          if (this.oBM == 0)
          {
            com.tencent.mm.emoji.a.h.abj().dl(true);
            com.tencent.mm.emoji.a.h.abj().dk(true);
            paramString = com.tencent.mm.emoji.a.i.fMT;
            com.tencent.mm.emoji.a.i.jdMethod_do(false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.z(this.oBL, this.oBM);
            bWd();
            bWf();
            this.mHandler.sendEmptyMessageDelayed(1004, 100L);
            AppMethodBeat.o(108915);
            return;
            com.tencent.mm.emoji.a.h.abj().dn(true);
            paramString = com.tencent.mm.emoji.a.i.fMT;
            com.tencent.mm.emoji.a.i.dp(false);
          }
        }
        ad.i("MicroMsg.emoji.EmojiCustomUI", "delete failed");
        Uh(getString(2131758409));
        AppMethodBeat.o(108915);
        return;
        bVS();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.oBM == 0)
          {
            com.tencent.mm.emoji.a.h.abj().dl(true);
            com.tencent.mm.emoji.a.h.abj().dk(true);
          }
          for (;;)
          {
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.m(this.oBM, this.oBL);
            bWd();
            bWf();
            this.mHandler.sendEmptyMessageDelayed(1004, 100L);
            AppMethodBeat.o(108915);
            return;
            com.tencent.mm.emoji.a.h.abj().dn(true);
          }
        }
        Uh(getString(2131758409));
      }
    }
    ad.w("MicroMsg.emoji.EmojiCustomUI", "no emoji operate");
    AppMethodBeat.o(108915);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(108881);
      oCb = new a("START", 0);
      oCc = new a("PAUSE", 1);
      oCd = new a("EMPTY", 2);
      oCe = new a[] { oCb, oCc, oCd };
      AppMethodBeat.o(108881);
    }
    
    private a() {}
  }
  
  final class b
    extends BaseAdapter
  {
    private int fRS;
    private Animation oCf;
    private ArrayList<EmojiInfo> oyq;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(108882);
      this.fRS = paramInt;
      this.oCf = AnimationUtils.loadAnimation(EmojiCustomUI.this, 2130772121);
      this$1 = new LinearInterpolator();
      this.oCf.setInterpolator(EmojiCustomUI.this);
      AppMethodBeat.o(108882);
    }
    
    private static void a(ImageView paramImageView, EmojiInfo paramEmojiInfo)
    {
      AppMethodBeat.i(108889);
      com.tencent.mm.emoji.loader.e locale = com.tencent.mm.emoji.loader.e.fLn;
      com.tencent.mm.emoji.loader.e.a(paramEmojiInfo, paramImageView);
      AppMethodBeat.o(108889);
    }
    
    private int bWl()
    {
      AppMethodBeat.i(108884);
      if ((getRealCount() > 0) && ((getRealCount() + 1) % 5 == 0))
      {
        AppMethodBeat.o(108884);
        return 1;
      }
      AppMethodBeat.o(108884);
      return 2;
    }
    
    public final EmojiInfo AB(int paramInt)
    {
      AppMethodBeat.i(108886);
      if (paramInt >= getRealCount())
      {
        AppMethodBeat.o(108886);
        return null;
      }
      if (this.oyq == null)
      {
        AppMethodBeat.o(108886);
        return null;
      }
      EmojiInfo localEmojiInfo = (EmojiInfo)this.oyq.get(paramInt);
      AppMethodBeat.o(108886);
      return localEmojiInfo;
    }
    
    public final boolean bWm()
    {
      AppMethodBeat.i(108888);
      int i;
      if (com.tencent.mm.kernel.g.afB().isSDCardAvailable()) {
        if (this.fRS == 0)
        {
          this.oyq = ((ArrayList)com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.vc(false));
          if (EmojiCustomUI.m(EmojiCustomUI.this) != EmojiCustomUI.c.oCh) {
            break label139;
          }
          if (EmojiCustomUI.n(EmojiCustomUI.this) != null) {
            break label125;
          }
          i = 0;
          label63:
          EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(2131758296, new Object[] { Integer.valueOf(i) }));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(108888);
        return true;
        this.oyq = com.tencent.mm.emoji.a.h.abj().dj(false);
        break;
        this.oyq = new ArrayList();
        break;
        label125:
        i = EmojiCustomUI.n(EmojiCustomUI.this).size();
        break label63;
        label139:
        if (this.fRS == 0) {
          EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(2131758247, new Object[] { Integer.valueOf(this.oyq.size()) }));
        } else {
          EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(2131758225, new Object[] { Integer.valueOf(this.oyq.size()) }));
        }
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(108883);
      int i = getRealCount();
      int j = bWl();
      AppMethodBeat.o(108883);
      return i + j;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getRealCount()
    {
      AppMethodBeat.i(108885);
      if (this.oyq == null)
      {
        AppMethodBeat.o(108885);
        return 0;
      }
      int i = this.oyq.size();
      AppMethodBeat.o(108885);
      return i;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(108887);
      label52:
      int i;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(EmojiCustomUI.this.getContext()).inflate(2131493767, null);
        paramView.setVisibility(0);
        paramViewGroup = new EmojiCustomUI.d(paramView);
        paramView.setTag(paramViewGroup);
        if ((EmojiCustomUI.m(EmojiCustomUI.this) != EmojiCustomUI.c.oCj) && (EmojiCustomUI.m(EmojiCustomUI.this) != EmojiCustomUI.c.oCh)) {
          break label195;
        }
        i = bWl();
        label84:
        if (paramInt >= getCount() - i) {
          break label235;
        }
        if (paramInt % 5 != 0) {
          break label223;
        }
        paramViewGroup.jGG.setBackgroundResource(2131232028);
      }
      for (;;)
      {
        paramViewGroup.image.clearAnimation();
        paramViewGroup.image.setScaleType(ImageView.ScaleType.FIT_CENTER);
        switch (EmojiCustomUI.11.oCa[EmojiCustomUI.m(EmojiCustomUI.this).ordinal()])
        {
        default: 
          AppMethodBeat.o(108887);
          return paramView;
          paramView.setVisibility(0);
          paramViewGroup = (EmojiCustomUI.d)paramView.getTag();
          break label52;
          label195:
          if (1 == this.fRS)
          {
            i = bWl();
            break label84;
          }
          i = bWl() - 1;
          break label84;
          label223:
          paramViewGroup.jGG.setBackgroundResource(2131232033);
          continue;
          label235:
          if (paramInt == getCount() - i) {
            paramViewGroup.jGG.setBackgroundResource(2131232032);
          } else {
            paramViewGroup.jGG.setBackgroundColor(0);
          }
          break;
        }
      }
      Object localObject;
      if (paramInt == getCount() - bWl() + 1)
      {
        localObject = com.tencent.mm.emoji.loader.e.fLn;
        com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
        paramViewGroup.image.setImageBitmap(null);
      }
      for (;;)
      {
        paramViewGroup.oCl.setVisibility(8);
        break;
        if (paramInt == 0)
        {
          if (this.fRS == 0)
          {
            localObject = com.tencent.mm.emoji.loader.e.fLn;
            com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
            paramViewGroup.image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            paramViewGroup.image.setImageResource(2131690097);
          }
          else if (paramInt != getRealCount())
          {
            localObject = (EmojiInfo)this.oyq.get(paramInt);
            a(paramViewGroup.image, (EmojiInfo)localObject);
          }
        }
        else if (this.fRS == 0)
        {
          localObject = (EmojiInfo)this.oyq.get(paramInt - 1);
          a(paramViewGroup.image, (EmojiInfo)localObject);
        }
        else if (paramInt != getRealCount())
        {
          localObject = (EmojiInfo)this.oyq.get(paramInt);
          a(paramViewGroup.image, (EmojiInfo)localObject);
        }
        else
        {
          localObject = com.tencent.mm.emoji.loader.e.fLn;
          com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
          paramViewGroup.image.setImageBitmap(null);
        }
      }
      if (paramInt == getCount() - bWl() + 1)
      {
        localObject = com.tencent.mm.emoji.loader.e.fLn;
        com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
        paramViewGroup.image.setImageBitmap(null);
      }
      for (;;)
      {
        paramViewGroup.oCl.setVisibility(8);
        break;
        if (paramInt == getRealCount())
        {
          localObject = com.tencent.mm.emoji.loader.e.fLn;
          com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
          paramViewGroup.image.setImageResource(2131233679);
          paramViewGroup.image.startAnimation(this.oCf);
        }
        else
        {
          localObject = (EmojiInfo)this.oyq.get(paramInt);
          a(paramViewGroup.image, (EmojiInfo)localObject);
        }
      }
      if (paramInt == getCount() - bWl() + 1)
      {
        localObject = com.tencent.mm.emoji.loader.e.fLn;
        com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
        paramViewGroup.image.setImageBitmap(null);
      }
      for (;;)
      {
        paramViewGroup.oCl.setVisibility(8);
        break;
        if (paramInt == getRealCount())
        {
          localObject = com.tencent.mm.emoji.loader.e.fLn;
          com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
          paramViewGroup.image.setImageBitmap(null);
        }
        else
        {
          localObject = (EmojiInfo)this.oyq.get(paramInt);
          a(paramViewGroup.image, (EmojiInfo)localObject);
          if (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.LBO)
          {
            paramViewGroup.oCl.setVisibility(0);
            paramViewGroup.oCl.setChecked(EmojiCustomUI.n(EmojiCustomUI.this).contains(((EmojiInfo)localObject).JS()));
            break;
            if (paramInt == getCount() - bWl() + 1)
            {
              localObject = com.tencent.mm.emoji.loader.e.fLn;
              com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
              paramViewGroup.image.setImageBitmap(null);
            }
            else if (paramInt == getRealCount())
            {
              localObject = com.tencent.mm.emoji.loader.e.fLn;
              com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
              paramViewGroup.image.setImageBitmap(null);
            }
            else
            {
              localObject = (EmojiInfo)this.oyq.get(paramInt);
              a(paramViewGroup.image, (EmojiInfo)localObject);
            }
          }
        }
      }
    }
  }
  
  static enum c
  {
    static
    {
      AppMethodBeat.i(108893);
      oCg = new c("NORMAL", 0);
      oCh = new c("EDIT", 1);
      oCi = new c("SYNCING", 2);
      oCj = new c("WITH_OUT_ADD", 3);
      oCk = new c[] { oCg, oCh, oCi, oCj };
      AppMethodBeat.o(108893);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI
 * JD-Core Version:    0.7.0.1
 */