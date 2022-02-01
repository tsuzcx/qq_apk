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
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.HeaderGridView;
import com.tencent.mm.ui.base.HeaderGridView.a;
import com.tencent.mm.ui.base.HeaderGridView.b;
import com.tencent.mm.ui.base.HeaderGridView.c;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.tools.b.b.a;
import com.tencent.mm.ui.widget.a.d;
import d.g.b.p;
import java.util.ArrayList;
import java.util.List;

public class EmojiCustomUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.al.f
{
  private static com.tencent.mm.aw.a.c.n ieg;
  private static com.tencent.mm.aw.a.c.e pIV;
  private ProgressDialog iYL;
  private ap mHandler;
  private b pIA;
  private HeaderGridView pIB;
  private View pIC;
  private Button pID;
  private Button pIE;
  private EmojiSyncManager.b pIF;
  private View pIG;
  private TextView pIH;
  private Button pII;
  private boolean pIJ;
  private boolean pIK;
  private boolean pIL;
  private a pIM;
  private ArrayList<String> pIN;
  private int pIO;
  private EmojiSyncManager pIP;
  private View.OnClickListener pIQ;
  private View.OnClickListener pIR;
  private View.OnClickListener pIS;
  private final k.a pIT;
  private final com.tencent.mm.emoji.sync.f pIU;
  private EmojiInfo pIW;
  private c pIz;
  
  static
  {
    AppMethodBeat.i(108926);
    pIV = new com.tencent.mm.aw.a.c.e()
    {
      public final byte[] j(Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(108875);
        if ((paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0))
        {
          paramAnonymousVarArgs = paramAnonymousVarArgs[0];
          if ((paramAnonymousVarArgs != null) && ((paramAnonymousVarArgs instanceof EmojiInfo)))
          {
            paramAnonymousVarArgs = com.tencent.mm.emoji.decode.a.aes().a((EmojiInfo)paramAnonymousVarArgs);
            AppMethodBeat.o(108875);
            return paramAnonymousVarArgs;
          }
        }
        AppMethodBeat.o(108875);
        return null;
      }
    };
    ieg = new com.tencent.mm.aw.a.c.n()
    {
      public final Bitmap FN(String paramAnonymousString)
      {
        AppMethodBeat.i(108877);
        paramAnonymousString = com.tencent.mm.plugin.gif.i.bp(com.tencent.mm.vfs.i.aY(paramAnonymousString, 0, -1));
        AppMethodBeat.o(108877);
        return paramAnonymousString;
      }
      
      public final Bitmap ab(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(108876);
        paramAnonymousArrayOfByte = com.tencent.mm.plugin.gif.i.bp(paramAnonymousArrayOfByte);
        AppMethodBeat.o(108876);
        return paramAnonymousArrayOfByte;
      }
    };
    AppMethodBeat.o(108926);
  }
  
  public EmojiCustomUI()
  {
    AppMethodBeat.i(108895);
    this.pIz = c.pJi;
    this.pIF = EmojiSyncManager.b.gpw;
    this.pIJ = false;
    this.pIK = false;
    this.pIL = false;
    this.pIM = a.pJf;
    this.pIN = new ArrayList();
    this.pIO = 0;
    this.pIQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108859);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiCustomUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        switch (EmojiCustomUI.11.pJa[EmojiCustomUI.a(EmojiCustomUI.this).ordinal()])
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(108859);
          return;
          EmojiCustomUI.b(EmojiCustomUI.this);
          continue;
          EmojiCustomUI.c(EmojiCustomUI.this).stop();
        }
      }
    };
    this.pIR = new EmojiCustomUI.12(this);
    this.pIS = new EmojiCustomUI.13(this);
    this.pIT = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(108872);
        if ((!bt.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.length() == 32) || (paramAnonymousString.equals("event_update_emoji"))) && (EmojiCustomUI.f(EmojiCustomUI.this) != null))
        {
          EmojiCustomUI.f(EmojiCustomUI.this).cic();
          EmojiCustomUI.f(EmojiCustomUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(108872);
      }
    };
    this.pIU = new com.tencent.mm.emoji.sync.f()
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
      
      public final void agl()
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
          if (EmojiCustomUI.c(EmojiCustomUI.this).gpm == EmojiSyncManager.b.gpx)
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
          EmojiCustomUI.f(EmojiCustomUI.this).cic();
          EmojiCustomUI.f(EmojiCustomUI.this).notifyDataSetChanged();
        }
        EmojiCustomUI.cia();
        AppMethodBeat.o(108878);
      }
    };
    AppMethodBeat.o(108895);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(108896);
    ad.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateButtonType,button type:%s]", new Object[] { parama.toString() });
    this.pIM = parama;
    switch (11.pJa[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(108896);
      return;
      this.pII.setVisibility(4);
      AppMethodBeat.o(108896);
      return;
      this.pII.setVisibility(0);
      this.pII.setText(2131758397);
      AppMethodBeat.o(108896);
      return;
      this.pII.setVisibility(0);
      this.pII.setText(2131758398);
    }
  }
  
  private void a(c paramc)
  {
    AppMethodBeat.i(108906);
    long l = System.currentTimeMillis();
    this.pIz = paramc;
    switch (11.pJc[paramc.ordinal()])
    {
    }
    for (;;)
    {
      if (this.pIA != null)
      {
        this.pIA.cic();
        this.pIA.notifyDataSetChanged();
      }
      ad.d("MicroMsg.emoji.EmojiCustomUI", "updateMode use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(108906);
      return;
      setBackBtn(new EmojiCustomUI.3(this));
      enableBackMenu(true);
      addTextOptionMenu(0, getString(2131758315), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(108863);
          EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.c.pJj);
          com.tencent.mm.plugin.report.service.g.yhR.f(11596, new Object[] { Integer.valueOf(1) });
          AppMethodBeat.o(108863);
          return true;
        }
      });
      this.pIC.setVisibility(8);
      chX();
      chT();
      for (;;)
      {
        chU();
        break;
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(108864);
            EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.c.pJi);
            AppMethodBeat.o(108864);
            return true;
          }
        });
        addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(108865);
            EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.c.pJi);
            AppMethodBeat.o(108865);
            return true;
          }
        });
        this.pIC.setVisibility(0);
        chW();
        chV();
      }
      chU();
    }
  }
  
  private boolean abZ(String paramString)
  {
    AppMethodBeat.i(108910);
    h.e(getContext(), paramString, "", "", getString(2131760315), null, null);
    AppMethodBeat.o(108910);
    return true;
  }
  
  private void aca(String paramString)
  {
    AppMethodBeat.i(108916);
    getString(2131755906);
    this.iYL = h.b(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(108916);
  }
  
  private void chI()
  {
    AppMethodBeat.i(108917);
    if ((this.iYL != null) && (this.iYL.isShowing())) {
      this.iYL.dismiss();
    }
    AppMethodBeat.o(108917);
  }
  
  private void chT()
  {
    AppMethodBeat.i(108907);
    if (this.pIN != null) {
      this.pIN.clear();
    }
    ad.i("MicroMsg.emoji.EmojiCustomUI", "clear md5 list. updateMode NORMAL");
    AppMethodBeat.o(108907);
  }
  
  private void chU()
  {
    AppMethodBeat.i(108908);
    View localView = this.pIC;
    if (this.pIz == c.pJj) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(108908);
      return;
    }
  }
  
  private void chV()
  {
    AppMethodBeat.i(108909);
    int i;
    if (this.pIz == c.pJj)
    {
      if (this.pIN != null) {
        break label94;
      }
      i = 0;
      if (i <= 0) {
        break label105;
      }
      this.pID.setText(getResources().getString(2131755707));
      this.pID.setEnabled(true);
      this.pIE.setEnabled(true);
    }
    for (;;)
    {
      setMMTitle(getResources().getString(2131758296, new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(108909);
      return;
      label94:
      i = this.pIN.size();
      break;
      label105:
      this.pID.setText(getResources().getString(2131755707));
      this.pID.setEnabled(false);
      this.pIE.setEnabled(false);
    }
  }
  
  private void chW()
  {
    AppMethodBeat.i(108911);
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessageDelayed(1003, 0L);
    }
    AppMethodBeat.o(108911);
  }
  
  private void chX()
  {
    AppMethodBeat.i(108912);
    if (!ay.isConnected(this))
    {
      chW();
      AppMethodBeat.o(108912);
      return;
    }
    if (chY())
    {
      AppMethodBeat.o(108912);
      return;
    }
    this.pIK = false;
    AppMethodBeat.o(108912);
  }
  
  private boolean chY()
  {
    AppMethodBeat.i(108913);
    if ((this.pIA != null) && (this.pIA.getRealCount() > com.tencent.mm.emoji.a.m.aeW()))
    {
      this.pIJ = true;
      this.pIG.setVisibility(0);
      chZ();
      this.pII.setVisibility(8);
      this.pIA.notifyDataSetChanged();
      enableOptionMenu(0, true);
      this.pIK = true;
      AppMethodBeat.o(108913);
      return true;
    }
    AppMethodBeat.o(108913);
    return false;
  }
  
  private void chZ()
  {
    AppMethodBeat.i(108914);
    this.pIH.setTextColor(getResources().getColor(2131100798));
    this.pIH.setText(getString(2131758393, new Object[] { Integer.valueOf(com.tencent.mm.emoji.a.m.aeW()) }));
    AppMethodBeat.o(108914);
  }
  
  private void kr(boolean paramBoolean)
  {
    AppMethodBeat.i(108897);
    int j = this.pIP.gpn.size();
    int k = this.pIP.cdl;
    if ((j == k) && (!paramBoolean))
    {
      this.pIH.setText(2131758400);
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
      this.pIH.setText(String.format(getString(i), new Object[] { Integer.valueOf(k - j), Integer.valueOf(k) }));
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
    this.pIG = getLayoutInflater().inflate(2131493768, null);
    this.pIH = ((TextView)this.pIG.findViewById(2131305593));
    this.pII = ((Button)this.pIG.findViewById(2131305592));
    this.pII.setOnClickListener(this.pIQ);
    this.pIB = ((HeaderGridView)findViewById(2131304643));
    Object localObject = this.pIB;
    View localView = this.pIG;
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
    locala.JiH = localb;
    locala.data = null;
    locala.isSelectable = false;
    ((HeaderGridView)localObject).JiG.add(locala);
    if (localListAdapter != null) {
      ((HeaderGridView.c)localListAdapter).mDataSetObservable.notifyChanged();
    }
    this.pIB.setAdapter$159aa965(this.pIA);
    this.pIB.setOnItemClickListener(this);
    this.pIB.setFocusableInTouchMode(false);
    this.pIC = findViewById(2131304642);
    this.pID = ((Button)findViewById(2131304644));
    this.pID.setOnClickListener(this.pIR);
    this.pIE = ((Button)findViewById(2131304645));
    this.pIE.setOnClickListener(this.pIS);
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
        if (this.pIA != null)
        {
          this.pIA.cic();
          this.pIA.notifyDataSetChanged();
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
        locala = com.tencent.mm.emoji.d.a.gqn;
        ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.emoji.d.a.agp());
        com.tencent.mm.plugin.emoji.b.iRG.a((Intent)localObject, 206, this, paramIntent);
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
        locala = com.tencent.mm.emoji.d.a.gqn;
        localObject = com.tencent.mm.emoji.d.a.agp() + paramIntent;
        this.pIW = k.getEmojiStorageMgr().ILn.aUK(paramIntent);
        localObject = com.tencent.mm.ui.tools.b.b.aXp((String)localObject);
        ((com.tencent.mm.ui.tools.b.b)localObject).mSize = com.tencent.mm.n.b.ace();
        ((com.tencent.mm.ui.tools.b.b)localObject).aeT(com.tencent.mm.n.b.acf()).a(new b.a()
        {
          public final void a(com.tencent.mm.ui.tools.b.b paramAnonymousb)
          {
            AppMethodBeat.i(108860);
            if (EmojiCustomUI.j(EmojiCustomUI.this) == null)
            {
              if (paramInt1 != 0) {
                break label119;
              }
              EmojiCustomUI.a(EmojiCustomUI.this, k.getEmojiStorageMgr().ILn.d(paramIntent, "", EmojiGroupInfo.OeN, EmojiInfo.OeU, paramAnonymousb.KMj, ""));
            }
            for (;;)
            {
              k.cgQ().a(EmojiCustomUI.this.getContext(), EmojiCustomUI.j(EmojiCustomUI.this), 1, u.aAm());
              if (EmojiCustomUI.f(EmojiCustomUI.this) != null)
              {
                EmojiCustomUI.f(EmojiCustomUI.this).cic();
                EmojiCustomUI.f(EmojiCustomUI.this).notifyDataSetChanged();
              }
              AppMethodBeat.o(108860);
              return;
              label119:
              EmojiCustomUI.a(EmojiCustomUI.this, k.getEmojiStorageMgr().ILn.d(paramIntent, "", EmojiGroupInfo.OeN, EmojiInfo.OeV, paramAnonymousb.KMj, ""));
            }
          }
          
          public final void chR()
          {
            AppMethodBeat.i(108861);
            h.a(EmojiCustomUI.this.getContext(), EmojiCustomUI.this.getContext().getString(2131758245), "", EmojiCustomUI.this.getContext().getString(2131760315), false, null);
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
    if (this.pIz == c.pJj)
    {
      a(c.pJi);
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
    this.pIO = getIntent().getIntExtra("key_emoji_panel_type", this.pIO);
    if (this.pIO == 1)
    {
      paramBundle = EmojiSyncManager.gpu;
      this.pIP = EmojiSyncManager.a.agk();
      this.pIA = new b(this.pIO);
      this.pIA.cic();
      initView();
      a(c.pJi);
      if (this.pIO != 1) {
        break label367;
      }
    }
    label367:
    for (boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iqw, Boolean.TRUE)).booleanValue();; bool = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iqv, Boolean.TRUE)).booleanValue())
    {
      ad.i("MicroMsg.emoji.EmojiCustomUI", "[cpan] touch batch emoji download from EmojiCustomUI needDownload:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        paramBundle = new com.tencent.mm.plugin.emoji.f.e(this.pIO);
        com.tencent.mm.kernel.g.ajB().gAO.a(paramBundle, 0);
      }
      k.getEmojiStorageMgr().ILn.add(this.pIT);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(406L, 9L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(406L, 11L, System.currentTimeMillis() - l, false);
      com.tencent.mm.plugin.report.service.g.yhR.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(28), Integer.valueOf(28) });
      paramBundle = this.pIP;
      com.tencent.mm.emoji.sync.f localf = this.pIU;
      p.h(localf, "callback");
      com.tencent.mm.ad.c.g((d.g.a.a)new EmojiSyncManager.e(paramBundle, localf));
      this.pIP.dt(true);
      paramBundle = j.gkf;
      j.aeQ();
      this.pIF = this.pIP.gpm;
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(1001);
      }
      AppMethodBeat.o(108898);
      return;
      paramBundle = EmojiSyncManager.gpu;
      this.pIP = EmojiSyncManager.a.agj();
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108901);
    super.onDestroy();
    k.getEmojiStorageMgr().ILn.remove(this.pIT);
    k.cgR().pGu.cEv = false;
    Object localObject = k.cgR().pGu;
    if (((BKGLoaderManager)localObject).pGF) {
      ((BKGLoaderManager)localObject).pGF = false;
    }
    localObject = this.pIP;
    com.tencent.mm.emoji.sync.f localf = this.pIU;
    p.h(localf, "callback");
    com.tencent.mm.ad.c.g((d.g.a.a)new EmojiSyncManager.h((EmojiSyncManager)localObject, localf));
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(108901);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(108903);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    if (this.pIA != null)
    {
      paramInt -= this.pIB.getHeaderViewCount() * 5;
      if ((this.pIz == c.pJi) && (paramInt == 0))
      {
        if (1 == this.pIO)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(108903);
          return;
        }
        if (!com.tencent.mm.kernel.g.ajC().isSDCardAvailable())
        {
          t.g(this, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(108903);
          return;
        }
        if (this.pIA.getRealCount() < com.tencent.mm.emoji.a.m.aeW()) {
          break label328;
        }
        h.d(this, getString(2131758413), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        com.tencent.mm.plugin.report.service.g.yhR.f(11596, new Object[] { Integer.valueOf(0) });
      }
      if ((this.pIz == c.pJj) && (paramInt < this.pIA.getRealCount()))
      {
        localObject = this.pIA.Cb(paramInt);
        paramAdapterView = null;
        if (paramView != null) {
          paramAdapterView = (d)paramView.getTag();
        }
        if (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.OeL) {
          break label336;
        }
        h.l(getContext(), 2131757146, 2131757146).show();
      }
    }
    for (;;)
    {
      chV();
      if (paramAdapterView == null) {
        this.pIA.notifyDataSetChanged();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(108903);
      return;
      label328:
      com.tencent.mm.pluginsdk.ui.tools.q.aS(this);
      break;
      label336:
      if (!this.pIN.contains(((EmojiInfo)localObject).Lb()))
      {
        paramView = ((EmojiInfo)localObject).Lb();
        if (this.pIN != null) {
          this.pIN.add(paramView);
        }
        if (paramAdapterView != null) {
          paramAdapterView.pJn.setChecked(true);
        }
        ad.i("MicroMsg.emoji.EmojiCustomUI", "selected md5:%s", new Object[] { ((EmojiInfo)localObject).Lb() });
      }
      else
      {
        paramView = ((EmojiInfo)localObject).Lb();
        if (this.pIN != null) {
          this.pIN.remove(paramView);
        }
        if (paramAdapterView != null)
        {
          paramAdapterView.pJn.setChecked(false);
          this.pIA.notifyDataSetChanged();
        }
        ad.i("MicroMsg.emoji.EmojiCustomUI", "unselected md5:%s", new Object[] { ((EmojiInfo)localObject).Lb() });
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(108900);
    super.onPause();
    com.tencent.mm.kernel.g.ajB().gAO.b(698, this);
    AppMethodBeat.o(108900);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(108899);
    super.onResume();
    chX();
    com.tencent.mm.kernel.g.ajB().gAO.a(698, this);
    AppMethodBeat.o(108899);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(108915);
    ad.i("MicroMsg.emoji.EmojiCustomUI", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramn instanceof com.tencent.mm.plugin.emoji.f.c))
    {
      switch (((com.tencent.mm.plugin.emoji.f.c)paramn).jed)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(108915);
        return;
        chI();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = new ArrayList(this.pIN);
          com.tencent.mm.kernel.g.ajF().ay(new EmojiCustomUI.9(this, paramString));
          if (this.pIO == 0)
          {
            com.tencent.mm.emoji.a.i.aeL().dm(true);
            com.tencent.mm.emoji.a.i.aeL().dl(true);
            paramString = j.gkf;
            j.dp(false);
          }
          for (;;)
          {
            k.getEmojiStorageMgr().ILn.B(this.pIN, this.pIO);
            chT();
            chV();
            this.mHandler.sendEmptyMessageDelayed(1004, 100L);
            AppMethodBeat.o(108915);
            return;
            com.tencent.mm.emoji.a.i.aeL().jdMethod_do(true);
            paramString = j.gkf;
            j.dq(false);
          }
        }
        ad.i("MicroMsg.emoji.EmojiCustomUI", "delete failed");
        abZ(getString(2131758409));
        AppMethodBeat.o(108915);
        return;
        chI();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.pIO == 0)
          {
            com.tencent.mm.emoji.a.i.aeL().dm(true);
            com.tencent.mm.emoji.a.i.aeL().dl(true);
          }
          for (;;)
          {
            k.getEmojiStorageMgr().ILn.q(this.pIO, this.pIN);
            chT();
            chV();
            this.mHandler.sendEmptyMessageDelayed(1004, 100L);
            AppMethodBeat.o(108915);
            return;
            com.tencent.mm.emoji.a.i.aeL().jdMethod_do(true);
          }
        }
        abZ(getString(2131758409));
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
      pJd = new a("START", 0);
      pJe = new a("PAUSE", 1);
      pJf = new a("EMPTY", 2);
      pJg = new a[] { pJd, pJe, pJf };
      AppMethodBeat.o(108881);
    }
    
    private a() {}
  }
  
  final class b
    extends BaseAdapter
  {
    private int gpq;
    private ArrayList<EmojiInfo> pFA;
    private Animation pJh;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(108882);
      this.gpq = paramInt;
      this.pJh = AnimationUtils.loadAnimation(EmojiCustomUI.this, 2130772121);
      this$1 = new LinearInterpolator();
      this.pJh.setInterpolator(EmojiCustomUI.this);
      AppMethodBeat.o(108882);
    }
    
    private static void a(ImageView paramImageView, EmojiInfo paramEmojiInfo)
    {
      AppMethodBeat.i(108889);
      com.tencent.mm.emoji.loader.e locale = com.tencent.mm.emoji.loader.e.giz;
      com.tencent.mm.emoji.loader.e.a(paramEmojiInfo, paramImageView);
      AppMethodBeat.o(108889);
    }
    
    private int cib()
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
    
    public final EmojiInfo Cb(int paramInt)
    {
      AppMethodBeat.i(108886);
      if (paramInt >= getRealCount())
      {
        AppMethodBeat.o(108886);
        return null;
      }
      if (this.pFA == null)
      {
        AppMethodBeat.o(108886);
        return null;
      }
      EmojiInfo localEmojiInfo = (EmojiInfo)this.pFA.get(paramInt);
      AppMethodBeat.o(108886);
      return localEmojiInfo;
    }
    
    public final boolean cic()
    {
      AppMethodBeat.i(108888);
      int i;
      if (com.tencent.mm.kernel.g.ajC().isSDCardAvailable()) {
        if (this.gpq == 0)
        {
          this.pFA = ((ArrayList)k.getEmojiStorageMgr().ILn.wQ(false));
          if (EmojiCustomUI.m(EmojiCustomUI.this) != EmojiCustomUI.c.pJj) {
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
        this.pFA = com.tencent.mm.emoji.a.i.aeL().dk(false);
        break;
        this.pFA = new ArrayList();
        break;
        label125:
        i = EmojiCustomUI.n(EmojiCustomUI.this).size();
        break label63;
        label139:
        if (this.gpq == 0) {
          EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(2131758247, new Object[] { Integer.valueOf(this.pFA.size()) }));
        } else {
          EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(2131758225, new Object[] { Integer.valueOf(this.pFA.size()) }));
        }
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(108883);
      int i = getRealCount();
      int j = cib();
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
      if (this.pFA == null)
      {
        AppMethodBeat.o(108885);
        return 0;
      }
      int i = this.pFA.size();
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
        if ((EmojiCustomUI.m(EmojiCustomUI.this) != EmojiCustomUI.c.pJl) && (EmojiCustomUI.m(EmojiCustomUI.this) != EmojiCustomUI.c.pJj)) {
          break label195;
        }
        i = cib();
        label84:
        if (paramInt >= getCount() - i) {
          break label235;
        }
        if (paramInt % 5 != 0) {
          break label223;
        }
        paramViewGroup.kBS.setBackgroundResource(2131232028);
      }
      for (;;)
      {
        paramViewGroup.image.clearAnimation();
        paramViewGroup.image.setScaleType(ImageView.ScaleType.FIT_CENTER);
        switch (EmojiCustomUI.11.pJc[EmojiCustomUI.m(EmojiCustomUI.this).ordinal()])
        {
        default: 
          AppMethodBeat.o(108887);
          return paramView;
          paramView.setVisibility(0);
          paramViewGroup = (EmojiCustomUI.d)paramView.getTag();
          break label52;
          label195:
          if (1 == this.gpq)
          {
            i = cib();
            break label84;
          }
          i = cib() - 1;
          break label84;
          label223:
          paramViewGroup.kBS.setBackgroundResource(2131232033);
          continue;
          label235:
          if (paramInt == getCount() - i) {
            paramViewGroup.kBS.setBackgroundResource(2131232032);
          } else {
            paramViewGroup.kBS.setBackgroundColor(0);
          }
          break;
        }
      }
      Object localObject;
      if (paramInt == getCount() - cib() + 1)
      {
        localObject = com.tencent.mm.emoji.loader.e.giz;
        com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
        paramViewGroup.image.setImageBitmap(null);
      }
      for (;;)
      {
        paramViewGroup.pJn.setVisibility(8);
        break;
        if (paramInt == 0)
        {
          if (this.gpq == 0)
          {
            localObject = com.tencent.mm.emoji.loader.e.giz;
            com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
            paramViewGroup.image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            paramViewGroup.image.setImageResource(2131690097);
          }
          else if (paramInt != getRealCount())
          {
            localObject = (EmojiInfo)this.pFA.get(paramInt);
            a(paramViewGroup.image, (EmojiInfo)localObject);
          }
        }
        else if (this.gpq == 0)
        {
          localObject = (EmojiInfo)this.pFA.get(paramInt - 1);
          a(paramViewGroup.image, (EmojiInfo)localObject);
        }
        else if (paramInt != getRealCount())
        {
          localObject = (EmojiInfo)this.pFA.get(paramInt);
          a(paramViewGroup.image, (EmojiInfo)localObject);
        }
        else
        {
          localObject = com.tencent.mm.emoji.loader.e.giz;
          com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
          paramViewGroup.image.setImageBitmap(null);
        }
      }
      if (paramInt == getCount() - cib() + 1)
      {
        localObject = com.tencent.mm.emoji.loader.e.giz;
        com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
        paramViewGroup.image.setImageBitmap(null);
      }
      for (;;)
      {
        paramViewGroup.pJn.setVisibility(8);
        break;
        if (paramInt == getRealCount())
        {
          localObject = com.tencent.mm.emoji.loader.e.giz;
          com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
          paramViewGroup.image.setImageResource(2131233679);
          paramViewGroup.image.startAnimation(this.pJh);
        }
        else
        {
          localObject = (EmojiInfo)this.pFA.get(paramInt);
          a(paramViewGroup.image, (EmojiInfo)localObject);
        }
      }
      if (paramInt == getCount() - cib() + 1)
      {
        localObject = com.tencent.mm.emoji.loader.e.giz;
        com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
        paramViewGroup.image.setImageBitmap(null);
      }
      for (;;)
      {
        paramViewGroup.pJn.setVisibility(8);
        break;
        if (paramInt == getRealCount())
        {
          localObject = com.tencent.mm.emoji.loader.e.giz;
          com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
          paramViewGroup.image.setImageBitmap(null);
        }
        else
        {
          localObject = (EmojiInfo)this.pFA.get(paramInt);
          a(paramViewGroup.image, (EmojiInfo)localObject);
          if (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.OeL)
          {
            paramViewGroup.pJn.setVisibility(0);
            paramViewGroup.pJn.setChecked(EmojiCustomUI.n(EmojiCustomUI.this).contains(((EmojiInfo)localObject).Lb()));
            break;
            if (paramInt == getCount() - cib() + 1)
            {
              localObject = com.tencent.mm.emoji.loader.e.giz;
              com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
              paramViewGroup.image.setImageBitmap(null);
            }
            else if (paramInt == getRealCount())
            {
              localObject = com.tencent.mm.emoji.loader.e.giz;
              com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
              paramViewGroup.image.setImageBitmap(null);
            }
            else
            {
              localObject = (EmojiInfo)this.pFA.get(paramInt);
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
      pJi = new c("NORMAL", 0);
      pJj = new c("EDIT", 1);
      pJk = new c("SYNCING", 2);
      pJl = new c("WITH_OUT_ADD", 3);
      pJm = new c[] { pJi, pJj, pJk, pJl };
      AppMethodBeat.o(108893);
    }
    
    private c() {}
  }
  
  static final class d
  {
    ImageView image;
    View kBS;
    CheckBox pJn;
    
    public d(View paramView)
    {
      AppMethodBeat.i(108894);
      this.kBS = paramView.findViewById(2131301137);
      this.image = ((ImageView)paramView.findViewById(2131300914));
      this.pJn = ((CheckBox)paramView.findViewById(2131298264));
      AppMethodBeat.o(108894);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI
 * JD-Core Version:    0.7.0.1
 */