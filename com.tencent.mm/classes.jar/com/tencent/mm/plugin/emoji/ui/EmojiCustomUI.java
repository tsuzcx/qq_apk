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
import com.tencent.mm.emoji.a.j;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.emoji.sync.EmojiSyncManager.a;
import com.tencent.mm.emoji.sync.EmojiSyncManager.b;
import com.tencent.mm.emoji.sync.EmojiSyncManager.e;
import com.tencent.mm.emoji.sync.EmojiSyncManager.h;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.az;
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
  implements AdapterView.OnItemClickListener, com.tencent.mm.ak.g
{
  private static com.tencent.mm.av.a.c.n hLl;
  private static com.tencent.mm.av.a.c.e pft;
  private ProgressDialog iFC;
  private ao mHandler;
  private c peX;
  private b peY;
  private HeaderGridView peZ;
  private View pfa;
  private Button pfb;
  private Button pfc;
  private EmojiSyncManager.b pfd;
  private View pfe;
  private TextView pff;
  private Button pfg;
  private boolean pfh;
  private boolean pfi;
  private boolean pfj;
  private a pfk;
  private ArrayList<String> pfl;
  private int pfm;
  private EmojiSyncManager pfn;
  private View.OnClickListener pfo;
  private View.OnClickListener pfp;
  private View.OnClickListener pfq;
  private final k.a pfr;
  private final com.tencent.mm.emoji.sync.f pfs;
  private EmojiInfo pfu;
  
  static
  {
    AppMethodBeat.i(108926);
    pft = new com.tencent.mm.av.a.c.e()
    {
      public final byte[] j(Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(108875);
        if ((paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0))
        {
          paramAnonymousVarArgs = paramAnonymousVarArgs[0];
          if ((paramAnonymousVarArgs != null) && ((paramAnonymousVarArgs instanceof EmojiInfo)))
          {
            paramAnonymousVarArgs = com.tencent.mm.emoji.decode.a.abO().a((EmojiInfo)paramAnonymousVarArgs);
            AppMethodBeat.o(108875);
            return paramAnonymousVarArgs;
          }
        }
        AppMethodBeat.o(108875);
        return null;
      }
    };
    hLl = new com.tencent.mm.av.a.c.n()
    {
      public final Bitmap CJ(String paramAnonymousString)
      {
        AppMethodBeat.i(108877);
        paramAnonymousString = com.tencent.mm.plugin.gif.i.bm(com.tencent.mm.vfs.i.aU(paramAnonymousString, 0, -1));
        AppMethodBeat.o(108877);
        return paramAnonymousString;
      }
      
      public final Bitmap ab(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(108876);
        paramAnonymousArrayOfByte = com.tencent.mm.plugin.gif.i.bm(paramAnonymousArrayOfByte);
        AppMethodBeat.o(108876);
        return paramAnonymousArrayOfByte;
      }
    };
    AppMethodBeat.o(108926);
  }
  
  public EmojiCustomUI()
  {
    AppMethodBeat.i(108895);
    this.peX = c.pfG;
    this.pfd = EmojiSyncManager.b.fVT;
    this.pfh = false;
    this.pfi = false;
    this.pfj = false;
    this.pfk = a.pfD;
    this.pfl = new ArrayList();
    this.pfm = 0;
    this.pfo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108859);
        switch (EmojiCustomUI.11.pfy[EmojiCustomUI.a(EmojiCustomUI.this).ordinal()])
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
    this.pfp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108870);
        EmojiCustomUI.d(EmojiCustomUI.this);
        AppMethodBeat.o(108870);
      }
    };
    this.pfq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108871);
        EmojiCustomUI.e(EmojiCustomUI.this);
        AppMethodBeat.o(108871);
      }
    };
    this.pfr = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(108872);
        if ((!bs.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.length() == 32) || (paramAnonymousString.equals("event_update_emoji"))) && (EmojiCustomUI.f(EmojiCustomUI.this) != null))
        {
          EmojiCustomUI.f(EmojiCustomUI.this).cdz();
          EmojiCustomUI.f(EmojiCustomUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(108872);
      }
    };
    this.pfs = new com.tencent.mm.emoji.sync.f()
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
      
      public final void adF()
      {
        AppMethodBeat.i(108873);
        if (EmojiCustomUI.g(EmojiCustomUI.this) != null) {
          EmojiCustomUI.g(EmojiCustomUI.this).sendEmptyMessage(1002);
        }
        AppMethodBeat.o(108873);
      }
    };
    this.mHandler = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(108878);
        switch (paramAnonymousMessage.what)
        {
        default: 
          ac.e("MicroMsg.emoji.EmojiCustomUI", "unknow Msg");
        case 1001: 
        case 1002: 
          do
          {
            AppMethodBeat.o(108878);
            return;
            EmojiCustomUI.h(EmojiCustomUI.this);
            AppMethodBeat.o(108878);
            return;
          } while (ax.isWifi(EmojiCustomUI.this));
          if (EmojiCustomUI.c(EmojiCustomUI.this).fVJ == EmojiSyncManager.b.fVU)
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
          EmojiCustomUI.f(EmojiCustomUI.this).cdz();
          EmojiCustomUI.f(EmojiCustomUI.this).notifyDataSetChanged();
        }
        EmojiCustomUI.cdx();
        AppMethodBeat.o(108878);
      }
    };
    AppMethodBeat.o(108895);
  }
  
  private boolean Yt(String paramString)
  {
    AppMethodBeat.i(108910);
    com.tencent.mm.ui.base.h.d(getContext(), paramString, "", "", getString(2131760315), null, null);
    AppMethodBeat.o(108910);
    return true;
  }
  
  private void Yu(String paramString)
  {
    AppMethodBeat.i(108916);
    getString(2131755906);
    this.iFC = com.tencent.mm.ui.base.h.b(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(108916);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(108896);
    ac.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateButtonType,button type:%s]", new Object[] { parama.toString() });
    this.pfk = parama;
    switch (11.pfy[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(108896);
      return;
      this.pfg.setVisibility(4);
      AppMethodBeat.o(108896);
      return;
      this.pfg.setVisibility(0);
      this.pfg.setText(2131758397);
      AppMethodBeat.o(108896);
      return;
      this.pfg.setVisibility(0);
      this.pfg.setText(2131758398);
    }
  }
  
  private void a(c paramc)
  {
    AppMethodBeat.i(108906);
    long l = System.currentTimeMillis();
    this.peX = paramc;
    switch (11.pfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      if (this.peY != null)
      {
        this.peY.cdz();
        this.peY.notifyDataSetChanged();
      }
      ac.d("MicroMsg.emoji.EmojiCustomUI", "updateMode use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
          EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.c.pfH);
          com.tencent.mm.plugin.report.service.h.wUl.f(11596, new Object[] { Integer.valueOf(1) });
          AppMethodBeat.o(108863);
          return true;
        }
      });
      this.pfa.setVisibility(8);
      cdu();
      cdq();
      for (;;)
      {
        cdr();
        break;
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(108864);
            EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.c.pfG);
            AppMethodBeat.o(108864);
            return true;
          }
        });
        addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(108865);
            EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.c.pfG);
            AppMethodBeat.o(108865);
            return true;
          }
        });
        this.pfa.setVisibility(0);
        cdt();
        cds();
      }
      cdr();
    }
  }
  
  private void cdf()
  {
    AppMethodBeat.i(108917);
    if ((this.iFC != null) && (this.iFC.isShowing())) {
      this.iFC.dismiss();
    }
    AppMethodBeat.o(108917);
  }
  
  private void cdq()
  {
    AppMethodBeat.i(108907);
    if (this.pfl != null) {
      this.pfl.clear();
    }
    ac.i("MicroMsg.emoji.EmojiCustomUI", "clear md5 list. updateMode NORMAL");
    AppMethodBeat.o(108907);
  }
  
  private void cdr()
  {
    AppMethodBeat.i(108908);
    View localView = this.pfa;
    if (this.peX == c.pfH) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(108908);
      return;
    }
  }
  
  private void cds()
  {
    AppMethodBeat.i(108909);
    int i;
    if (this.peX == c.pfH)
    {
      if (this.pfl != null) {
        break label94;
      }
      i = 0;
      if (i <= 0) {
        break label105;
      }
      this.pfb.setText(getResources().getString(2131755707));
      this.pfb.setEnabled(true);
      this.pfc.setEnabled(true);
    }
    for (;;)
    {
      setMMTitle(getResources().getString(2131758296, new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(108909);
      return;
      label94:
      i = this.pfl.size();
      break;
      label105:
      this.pfb.setText(getResources().getString(2131755707));
      this.pfb.setEnabled(false);
      this.pfc.setEnabled(false);
    }
  }
  
  private void cdt()
  {
    AppMethodBeat.i(108911);
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessageDelayed(1003, 0L);
    }
    AppMethodBeat.o(108911);
  }
  
  private void cdu()
  {
    AppMethodBeat.i(108912);
    if (!ax.isConnected(this))
    {
      cdt();
      AppMethodBeat.o(108912);
      return;
    }
    if (cdv())
    {
      AppMethodBeat.o(108912);
      return;
    }
    this.pfi = false;
    AppMethodBeat.o(108912);
  }
  
  private boolean cdv()
  {
    AppMethodBeat.i(108913);
    if ((this.peY != null) && (this.peY.getRealCount() > com.tencent.mm.emoji.a.m.acs()))
    {
      this.pfh = true;
      this.pfe.setVisibility(0);
      cdw();
      this.pfg.setVisibility(8);
      this.peY.notifyDataSetChanged();
      enableOptionMenu(0, true);
      this.pfi = true;
      AppMethodBeat.o(108913);
      return true;
    }
    AppMethodBeat.o(108913);
    return false;
  }
  
  private void cdw()
  {
    AppMethodBeat.i(108914);
    this.pff.setTextColor(getResources().getColor(2131100798));
    this.pff.setText(getString(2131758393, new Object[] { Integer.valueOf(com.tencent.mm.emoji.a.m.acs()) }));
    AppMethodBeat.o(108914);
  }
  
  private void kg(boolean paramBoolean)
  {
    AppMethodBeat.i(108897);
    int j = this.pfn.fVK.size();
    int k = this.pfn.bSY;
    if ((j == k) && (!paramBoolean))
    {
      this.pff.setText(2131758400);
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
      this.pff.setText(String.format(getString(i), new Object[] { Integer.valueOf(k - j), Integer.valueOf(k) }));
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
    this.pfe = getLayoutInflater().inflate(2131493768, null);
    this.pff = ((TextView)this.pfe.findViewById(2131305593));
    this.pfg = ((Button)this.pfe.findViewById(2131305592));
    this.pfg.setOnClickListener(this.pfo);
    this.peZ = ((HeaderGridView)findViewById(2131304643));
    Object localObject = this.peZ;
    View localView = this.pfe;
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
    locala.HuR = localb;
    locala.data = null;
    locala.isSelectable = false;
    ((HeaderGridView)localObject).HuQ.add(locala);
    if (localListAdapter != null) {
      ((HeaderGridView.c)localListAdapter).mDataSetObservable.notifyChanged();
    }
    this.peZ.setAdapter$159aa965(this.peY);
    this.peZ.setOnItemClickListener(this);
    this.peZ.setFocusableInTouchMode(false);
    this.pfa = findViewById(2131304642);
    this.pfb = ((Button)findViewById(2131304644));
    this.pfb.setOnClickListener(this.pfp);
    this.pfc = ((Button)findViewById(2131304645));
    this.pfc.setOnClickListener(this.pfq);
    AppMethodBeat.o(108902);
  }
  
  public void onActivityResult(final int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(108904);
    ac.d("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: requestCode[%d],resultCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      Object localObject;
      com.tencent.mm.emoji.d.a locala;
      switch (paramInt1)
      {
      default: 
        ac.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: not found this requestCode");
        AppMethodBeat.o(108904);
        return;
      case 214: 
        if (this.peY != null)
        {
          this.peY.cdz();
          this.peY.notifyDataSetChanged();
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
        locala = com.tencent.mm.emoji.d.a.fWM;
        ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.emoji.d.a.adJ());
        com.tencent.mm.plugin.emoji.b.iyx.a((Intent)localObject, 206, this, paramIntent);
        AppMethodBeat.o(108904);
        return;
      case 206: 
        if (paramIntent == null)
        {
          ac.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult MAT_IMAGE_IN_CROP_ACTIVITY return null.");
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
        locala = com.tencent.mm.emoji.d.a.fWM;
        localObject = com.tencent.mm.emoji.d.a.adJ() + paramIntent;
        this.pfu = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.aOT(paramIntent);
        localObject = com.tencent.mm.ui.tools.b.b.aRr((String)localObject);
        ((com.tencent.mm.ui.tools.b.b)localObject).mSize = com.tencent.mm.m.b.ZE();
        ((com.tencent.mm.ui.tools.b.b)localObject).acv(com.tencent.mm.m.b.ZF()).a(new b.a()
        {
          public final void a(com.tencent.mm.ui.tools.b.b paramAnonymousb)
          {
            AppMethodBeat.i(108860);
            if (EmojiCustomUI.j(EmojiCustomUI.this) == null)
            {
              if (paramInt1 != 0) {
                break label119;
              }
              EmojiCustomUI.a(EmojiCustomUI.this, com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.d(paramIntent, "", EmojiGroupInfo.Jss, EmojiInfo.KfY, paramAnonymousb.IVf, ""));
            }
            for (;;)
            {
              com.tencent.mm.plugin.emoji.model.k.ccm().a(EmojiCustomUI.this.getContext(), EmojiCustomUI.j(EmojiCustomUI.this), 1, u.axw());
              if (EmojiCustomUI.f(EmojiCustomUI.this) != null)
              {
                EmojiCustomUI.f(EmojiCustomUI.this).cdz();
                EmojiCustomUI.f(EmojiCustomUI.this).notifyDataSetChanged();
              }
              AppMethodBeat.o(108860);
              return;
              label119:
              EmojiCustomUI.a(EmojiCustomUI.this, com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.d(paramIntent, "", EmojiGroupInfo.Jss, EmojiInfo.KfZ, paramAnonymousb.IVf, ""));
            }
          }
          
          public final void cdo()
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
    if (this.peX == c.pfH)
    {
      a(c.pfG);
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
    this.pfm = getIntent().getIntExtra("key_emoji_panel_type", this.pfm);
    if (this.pfm == 1)
    {
      paramBundle = EmojiSyncManager.fVR;
      this.pfn = EmojiSyncManager.a.adE();
      this.peY = new b(this.pfm);
      this.peY.cdz();
      initView();
      a(c.pfG);
      if (this.pfm != 1) {
        break label364;
      }
    }
    label364:
    for (boolean bool = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GEd, Boolean.TRUE)).booleanValue();; bool = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GEc, Boolean.TRUE)).booleanValue())
    {
      ac.i("MicroMsg.emoji.EmojiCustomUI", "[cpan] touch batch emoji download from EmojiCustomUI needDownload:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        paramBundle = new com.tencent.mm.plugin.emoji.f.e(this.pfm);
        com.tencent.mm.kernel.g.agQ().ghe.a(paramBundle, 0);
      }
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.add(this.pfr);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(406L, 9L, 1L, false);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(406L, 11L, System.currentTimeMillis() - l, false);
      com.tencent.mm.plugin.report.service.h.wUl.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(28), Integer.valueOf(28) });
      paramBundle = this.pfn;
      com.tencent.mm.emoji.sync.f localf = this.pfs;
      d.g.b.k.h(localf, "callback");
      com.tencent.mm.ac.c.g((d.g.a.a)new EmojiSyncManager.e(paramBundle, localf));
      this.pfn.dr(true);
      paramBundle = j.fQF;
      j.acm();
      this.pfd = this.pfn.fVJ;
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(1001);
      }
      AppMethodBeat.o(108898);
      return;
      paramBundle = EmojiSyncManager.fVR;
      this.pfn = EmojiSyncManager.a.adD();
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108901);
    super.onDestroy();
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.remove(this.pfr);
    com.tencent.mm.plugin.emoji.model.k.ccn().pcK.ctA = false;
    Object localObject = com.tencent.mm.plugin.emoji.model.k.ccn().pcK;
    if (((BKGLoaderManager)localObject).pcV) {
      ((BKGLoaderManager)localObject).pcV = false;
    }
    localObject = this.pfn;
    com.tencent.mm.emoji.sync.f localf = this.pfs;
    d.g.b.k.h(localf, "callback");
    com.tencent.mm.ac.c.g((d.g.a.a)new EmojiSyncManager.h((EmojiSyncManager)localObject, localf));
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(108901);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = null;
    AppMethodBeat.i(108903);
    EmojiInfo localEmojiInfo;
    if (this.peY != null)
    {
      paramInt -= this.peZ.getHeaderViewCount() * 5;
      if ((this.peX == c.pfG) && (paramInt == 0))
      {
        if (1 == this.pfm)
        {
          AppMethodBeat.o(108903);
          return;
        }
        if (!com.tencent.mm.kernel.g.agR().isSDCardAvailable())
        {
          t.g(this, null);
          AppMethodBeat.o(108903);
          return;
        }
        if (this.peY.getRealCount() < com.tencent.mm.emoji.a.m.acs()) {
          break label224;
        }
        com.tencent.mm.ui.base.h.d(this, getString(2131758413), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        com.tencent.mm.plugin.report.service.h.wUl.f(11596, new Object[] { Integer.valueOf(0) });
      }
      if ((this.peX == c.pfH) && (paramInt < this.peY.getRealCount()))
      {
        localEmojiInfo = this.peY.Bt(paramInt);
        if (paramView != null) {
          paramAdapterView = (d)paramView.getTag();
        }
        if (localEmojiInfo.field_catalog != EmojiGroupInfo.Jsq) {
          break label232;
        }
        com.tencent.mm.ui.base.h.l(getContext(), 2131757146, 2131757146).show();
      }
    }
    for (;;)
    {
      cds();
      if (paramAdapterView == null) {
        this.peY.notifyDataSetChanged();
      }
      AppMethodBeat.o(108903);
      return;
      label224:
      com.tencent.mm.pluginsdk.ui.tools.q.aS(this);
      break;
      label232:
      if (!this.pfl.contains(localEmojiInfo.JC()))
      {
        paramView = localEmojiInfo.JC();
        if (this.pfl != null) {
          this.pfl.add(paramView);
        }
        if (paramAdapterView != null) {
          paramAdapterView.pfL.setChecked(true);
        }
        ac.i("MicroMsg.emoji.EmojiCustomUI", "selected md5:%s", new Object[] { localEmojiInfo.JC() });
      }
      else
      {
        paramView = localEmojiInfo.JC();
        if (this.pfl != null) {
          this.pfl.remove(paramView);
        }
        if (paramAdapterView != null)
        {
          paramAdapterView.pfL.setChecked(false);
          this.peY.notifyDataSetChanged();
        }
        ac.i("MicroMsg.emoji.EmojiCustomUI", "unselected md5:%s", new Object[] { localEmojiInfo.JC() });
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(108900);
    super.onPause();
    com.tencent.mm.kernel.g.agQ().ghe.b(698, this);
    AppMethodBeat.o(108900);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(108899);
    super.onResume();
    cdu();
    com.tencent.mm.kernel.g.agQ().ghe.a(698, this);
    AppMethodBeat.o(108899);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(108915);
    ac.i("MicroMsg.emoji.EmojiCustomUI", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramn instanceof com.tencent.mm.plugin.emoji.f.c))
    {
      switch (((com.tencent.mm.plugin.emoji.f.c)paramn).iKU)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(108915);
        return;
        cdf();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = new ArrayList(this.pfl);
          com.tencent.mm.kernel.g.agU().az(new EmojiCustomUI.9(this, paramString));
          if (this.pfm == 0)
          {
            com.tencent.mm.emoji.a.i.ach().dk(true);
            com.tencent.mm.emoji.a.i.ach().dj(true);
            paramString = j.fQF;
            j.dn(false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.z(this.pfl, this.pfm);
            cdq();
            cds();
            this.mHandler.sendEmptyMessageDelayed(1004, 100L);
            AppMethodBeat.o(108915);
            return;
            com.tencent.mm.emoji.a.i.ach().dm(true);
            paramString = j.fQF;
            j.jdMethod_do(false);
          }
        }
        ac.i("MicroMsg.emoji.EmojiCustomUI", "delete failed");
        Yt(getString(2131758409));
        AppMethodBeat.o(108915);
        return;
        cdf();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.pfm == 0)
          {
            com.tencent.mm.emoji.a.i.ach().dk(true);
            com.tencent.mm.emoji.a.i.ach().dj(true);
          }
          for (;;)
          {
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.p(this.pfm, this.pfl);
            cdq();
            cds();
            this.mHandler.sendEmptyMessageDelayed(1004, 100L);
            AppMethodBeat.o(108915);
            return;
            com.tencent.mm.emoji.a.i.ach().dm(true);
          }
        }
        Yt(getString(2131758409));
      }
    }
    ac.w("MicroMsg.emoji.EmojiCustomUI", "no emoji operate");
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
      pfB = new a("START", 0);
      pfC = new a("PAUSE", 1);
      pfD = new a("EMPTY", 2);
      pfE = new a[] { pfB, pfC, pfD };
      AppMethodBeat.o(108881);
    }
    
    private a() {}
  }
  
  final class b
    extends BaseAdapter
  {
    private int fVN;
    private ArrayList<EmojiInfo> pbQ;
    private Animation pfF;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(108882);
      this.fVN = paramInt;
      this.pfF = AnimationUtils.loadAnimation(EmojiCustomUI.this, 2130772121);
      this$1 = new LinearInterpolator();
      this.pfF.setInterpolator(EmojiCustomUI.this);
      AppMethodBeat.o(108882);
    }
    
    private static void a(ImageView paramImageView, EmojiInfo paramEmojiInfo)
    {
      AppMethodBeat.i(108889);
      com.tencent.mm.emoji.loader.e locale = com.tencent.mm.emoji.loader.e.fOZ;
      com.tencent.mm.emoji.loader.e.a(paramEmojiInfo, paramImageView);
      AppMethodBeat.o(108889);
    }
    
    private int cdy()
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
    
    public final EmojiInfo Bt(int paramInt)
    {
      AppMethodBeat.i(108886);
      if (paramInt >= getRealCount())
      {
        AppMethodBeat.o(108886);
        return null;
      }
      if (this.pbQ == null)
      {
        AppMethodBeat.o(108886);
        return null;
      }
      EmojiInfo localEmojiInfo = (EmojiInfo)this.pbQ.get(paramInt);
      AppMethodBeat.o(108886);
      return localEmojiInfo;
    }
    
    public final boolean cdz()
    {
      AppMethodBeat.i(108888);
      int i;
      if (com.tencent.mm.kernel.g.agR().isSDCardAvailable()) {
        if (this.fVN == 0)
        {
          this.pbQ = ((ArrayList)com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.we(false));
          if (EmojiCustomUI.m(EmojiCustomUI.this) != EmojiCustomUI.c.pfH) {
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
        this.pbQ = com.tencent.mm.emoji.a.i.ach().di(false);
        break;
        this.pbQ = new ArrayList();
        break;
        label125:
        i = EmojiCustomUI.n(EmojiCustomUI.this).size();
        break label63;
        label139:
        if (this.fVN == 0) {
          EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(2131758247, new Object[] { Integer.valueOf(this.pbQ.size()) }));
        } else {
          EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(2131758225, new Object[] { Integer.valueOf(this.pbQ.size()) }));
        }
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(108883);
      int i = getRealCount();
      int j = cdy();
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
      if (this.pbQ == null)
      {
        AppMethodBeat.o(108885);
        return 0;
      }
      int i = this.pbQ.size();
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
        if ((EmojiCustomUI.m(EmojiCustomUI.this) != EmojiCustomUI.c.pfJ) && (EmojiCustomUI.m(EmojiCustomUI.this) != EmojiCustomUI.c.pfH)) {
          break label195;
        }
        i = cdy();
        label84:
        if (paramInt >= getCount() - i) {
          break label235;
        }
        if (paramInt % 5 != 0) {
          break label223;
        }
        paramViewGroup.khe.setBackgroundResource(2131232028);
      }
      for (;;)
      {
        paramViewGroup.image.clearAnimation();
        paramViewGroup.image.setScaleType(ImageView.ScaleType.FIT_CENTER);
        switch (EmojiCustomUI.11.pfA[EmojiCustomUI.m(EmojiCustomUI.this).ordinal()])
        {
        default: 
          AppMethodBeat.o(108887);
          return paramView;
          paramView.setVisibility(0);
          paramViewGroup = (EmojiCustomUI.d)paramView.getTag();
          break label52;
          label195:
          if (1 == this.fVN)
          {
            i = cdy();
            break label84;
          }
          i = cdy() - 1;
          break label84;
          label223:
          paramViewGroup.khe.setBackgroundResource(2131232033);
          continue;
          label235:
          if (paramInt == getCount() - i) {
            paramViewGroup.khe.setBackgroundResource(2131232032);
          } else {
            paramViewGroup.khe.setBackgroundColor(0);
          }
          break;
        }
      }
      Object localObject;
      if (paramInt == getCount() - cdy() + 1)
      {
        localObject = com.tencent.mm.emoji.loader.e.fOZ;
        com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
        paramViewGroup.image.setImageBitmap(null);
      }
      for (;;)
      {
        paramViewGroup.pfL.setVisibility(8);
        break;
        if (paramInt == 0)
        {
          if (this.fVN == 0)
          {
            localObject = com.tencent.mm.emoji.loader.e.fOZ;
            com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
            paramViewGroup.image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            paramViewGroup.image.setImageResource(2131690097);
          }
          else if (paramInt != getRealCount())
          {
            localObject = (EmojiInfo)this.pbQ.get(paramInt);
            a(paramViewGroup.image, (EmojiInfo)localObject);
          }
        }
        else if (this.fVN == 0)
        {
          localObject = (EmojiInfo)this.pbQ.get(paramInt - 1);
          a(paramViewGroup.image, (EmojiInfo)localObject);
        }
        else if (paramInt != getRealCount())
        {
          localObject = (EmojiInfo)this.pbQ.get(paramInt);
          a(paramViewGroup.image, (EmojiInfo)localObject);
        }
        else
        {
          localObject = com.tencent.mm.emoji.loader.e.fOZ;
          com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
          paramViewGroup.image.setImageBitmap(null);
        }
      }
      if (paramInt == getCount() - cdy() + 1)
      {
        localObject = com.tencent.mm.emoji.loader.e.fOZ;
        com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
        paramViewGroup.image.setImageBitmap(null);
      }
      for (;;)
      {
        paramViewGroup.pfL.setVisibility(8);
        break;
        if (paramInt == getRealCount())
        {
          localObject = com.tencent.mm.emoji.loader.e.fOZ;
          com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
          paramViewGroup.image.setImageResource(2131233679);
          paramViewGroup.image.startAnimation(this.pfF);
        }
        else
        {
          localObject = (EmojiInfo)this.pbQ.get(paramInt);
          a(paramViewGroup.image, (EmojiInfo)localObject);
        }
      }
      if (paramInt == getCount() - cdy() + 1)
      {
        localObject = com.tencent.mm.emoji.loader.e.fOZ;
        com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
        paramViewGroup.image.setImageBitmap(null);
      }
      for (;;)
      {
        paramViewGroup.pfL.setVisibility(8);
        break;
        if (paramInt == getRealCount())
        {
          localObject = com.tencent.mm.emoji.loader.e.fOZ;
          com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
          paramViewGroup.image.setImageBitmap(null);
        }
        else
        {
          localObject = (EmojiInfo)this.pbQ.get(paramInt);
          a(paramViewGroup.image, (EmojiInfo)localObject);
          if (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.Jsq)
          {
            paramViewGroup.pfL.setVisibility(0);
            paramViewGroup.pfL.setChecked(EmojiCustomUI.n(EmojiCustomUI.this).contains(((EmojiInfo)localObject).JC()));
            break;
            if (paramInt == getCount() - cdy() + 1)
            {
              localObject = com.tencent.mm.emoji.loader.e.fOZ;
              com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
              paramViewGroup.image.setImageBitmap(null);
            }
            else if (paramInt == getRealCount())
            {
              localObject = com.tencent.mm.emoji.loader.e.fOZ;
              com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
              paramViewGroup.image.setImageBitmap(null);
            }
            else
            {
              localObject = (EmojiInfo)this.pbQ.get(paramInt);
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
      pfG = new c("NORMAL", 0);
      pfH = new c("EDIT", 1);
      pfI = new c("SYNCING", 2);
      pfJ = new c("WITH_OUT_ADD", 3);
      pfK = new c[] { pfG, pfH, pfI, pfJ };
      AppMethodBeat.o(108893);
    }
    
    private c() {}
  }
  
  static final class d
  {
    ImageView image;
    View khe;
    CheckBox pfL;
    
    public d(View paramView)
    {
      AppMethodBeat.i(108894);
      this.khe = paramView.findViewById(2131301137);
      this.image = ((ImageView)paramView.findViewById(2131300914));
      this.pfL = ((CheckBox)paramView.findViewById(2131298264));
      AppMethodBeat.o(108894);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI
 * JD-Core Version:    0.7.0.1
 */