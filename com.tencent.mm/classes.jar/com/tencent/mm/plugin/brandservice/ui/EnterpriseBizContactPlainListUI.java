package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.s;

public class EnterpriseBizContactPlainListUI
  extends MMActivity
{
  private String iNV;
  private ListView krb;
  private a ppu;
  private long ppv;
  private AdapterView.OnItemClickListener ppw;
  private int scene;
  
  public int getLayoutId()
  {
    return 2131493996;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5736);
    this.krb = ((ListView)findViewById(2131300142));
    if (this.ppu == null)
    {
      this.ppu = new a(this);
      this.ppw = new EnterpriseBizContactPlainListUI.1(this);
    }
    Log.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "count = %s", new Object[] { Integer.valueOf(this.ppu.getCount()) });
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.iNV);
    if (this.scene == 2)
    {
      setMMTitle(2131758735);
      if ((localObject != null) && (com.tencent.mm.contact.c.oR(((ax)localObject).field_type)) && (this.ppu.getCount() > 0)) {
        break label218;
      }
      this.krb.setVisibility(8);
      localObject = (TextView)findViewById(2131300143);
      ((TextView)localObject).setText(2131758742);
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      setBackBtn(new EnterpriseBizContactPlainListUI.2(this));
      setToTop(new EnterpriseBizContactPlainListUI.3(this));
      AppMethodBeat.o(5736);
      return;
      if (localObject == null) {
        break;
      }
      setMMTitle(((as)localObject).arI());
      break;
      label218:
      this.krb.setVisibility(0);
      this.krb.setAdapter(this.ppu);
      this.krb.setOnItemClickListener(this.ppw);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(5740);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.scene == 4) {
      finish();
    }
    AppMethodBeat.o(5740);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5735);
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("enterprise_scene", 2);
    this.iNV = getIntent().getStringExtra("enterprise_biz_name");
    this.ppv = getIntent().getLongExtra("biz_chat_chat_id", -1L);
    Log.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizName = %s", new Object[] { this.iNV });
    initView();
    ag.bah().add(this.ppu);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().add(this.ppu);
    AppMethodBeat.o(5735);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5739);
    ag.bah().remove(this.ppu);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().remove(this.ppu);
    this.ppu.ebf();
    a locala = this.ppu;
    if (locala.kex != null)
    {
      locala.kex.detach();
      locala.kex = null;
    }
    super.onDestroy();
    AppMethodBeat.o(5739);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5738);
    super.onPause();
    AppMethodBeat.o(5738);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(5737);
    super.onResume();
    if (!ab.IS(this.iNV))
    {
      Log.e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "%s !isContact", new Object[] { this.iNV });
      finish();
      AppMethodBeat.o(5737);
      return;
    }
    AppMethodBeat.o(5737);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends s<qw>
    implements MStorageEx.IOnStorageChange
  {
    b kex;
    private b.b kez;
    
    public a(Context paramContext)
    {
      super(new qw());
      AppMethodBeat.i(5729);
      this.kez = null;
      this.kex = new b(new b.a()
      {
        public final Bitmap Ta(String paramAnonymousString)
        {
          AppMethodBeat.i(5724);
          paramAnonymousString = com.tencent.mm.aj.c.a(paramAnonymousString, false, -1, null);
          AppMethodBeat.o(5724);
          return paramAnonymousString;
        }
      });
      anp();
      AppMethodBeat.o(5729);
    }
    
    public final void anp()
    {
      AppMethodBeat.i(5733);
      if (!com.tencent.mm.kernel.g.aAc())
      {
        Log.e("MicroMsg.EnterpriseBizListAdapter", "accHasReady");
        AppMethodBeat.o(5733);
        return;
      }
      ebf();
      Object localObject2 = null;
      Object localObject1;
      switch (EnterpriseBizContactPlainListUI.b(EnterpriseBizContactPlainListUI.this))
      {
      default: 
        ag.bah();
        localObject1 = f.O(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this), true);
      }
      for (;;)
      {
        setCursor((Cursor)localObject1);
        AppMethodBeat.o(5733);
        return;
        ag.bah();
        localObject1 = f.aq(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this), 25);
        continue;
        ag.bah();
        localObject1 = f.MV(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this));
        continue;
        ag.bah();
        localObject1 = f.aq(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this), 128);
        continue;
        com.tencent.mm.api.c localc = com.tencent.mm.al.g.fJ(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this));
        localObject1 = localObject2;
        if (localc != null)
        {
          localObject1 = localObject2;
          if (localc.field_enterpriseFather != null) {
            localObject1 = ag.bah().MU(localc.field_enterpriseFather);
          }
        }
      }
    }
    
    public final void anq()
    {
      AppMethodBeat.i(258317);
      anp();
      AppMethodBeat.o(258317);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(5731);
      if (this.kez == null) {
        this.kez = new b.b()
        {
          public final int bnW()
          {
            AppMethodBeat.i(5727);
            int i = EnterpriseBizContactPlainListUI.a.this.getCount();
            AppMethodBeat.o(5727);
            return i;
          }
          
          public final String vg(int paramAnonymousInt)
          {
            AppMethodBeat.i(5726);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= EnterpriseBizContactPlainListUI.a.this.getCount()))
            {
              Log.e("MicroMsg.EnterpriseBizListAdapter", "pos is invalid");
              AppMethodBeat.o(5726);
              return null;
            }
            Object localObject = (qw)EnterpriseBizContactPlainListUI.a.this.getItem(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(5726);
              return null;
            }
            localObject = ((qw)localObject).userName;
            AppMethodBeat.o(5726);
            return localObject;
          }
        };
      }
      if (this.kex != null) {
        this.kex.a(paramInt, this.kez);
      }
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, 2131493994, null);
        paramViewGroup.keC = ((ImageView)paramView.findViewById(2131305241));
        paramViewGroup.kcS = ((TextView)paramView.findViewById(2131305247));
        paramView.setTag(paramViewGroup);
      }
      qw localqw;
      for (;;)
      {
        localqw = (qw)getItem(paramInt);
        if (localqw != null) {
          break;
        }
        paramViewGroup.clear();
        AppMethodBeat.o(5731);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.clear();
      paramInt = paramView.getPaddingBottom();
      int i = paramView.getPaddingTop();
      int j = paramView.getPaddingRight();
      int k = paramView.getPaddingLeft();
      paramView.setBackgroundDrawable(a.l(this.context, 2131231898));
      paramView.setPadding(k, i, j, paramInt);
      String str = Util.nullAsNil(localqw.contact.arI());
      paramViewGroup.kcS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, str, paramViewGroup.kcS.getTextSize()));
      paramViewGroup.kcS.setVisibility(0);
      paramViewGroup.keC.setVisibility(0);
      if (!Util.isNullOrNil(localqw.contact.field_username)) {
        a.b.c(paramViewGroup.keC, localqw.contact.field_username);
      }
      for (;;)
      {
        AppMethodBeat.o(5731);
        return paramView;
        paramViewGroup.keC.setImageDrawable(null);
      }
    }
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(5730);
      Log.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange");
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5725);
          EnterpriseBizContactPlainListUI.a.this.anq();
          TextView localTextView = (TextView)EnterpriseBizContactPlainListUI.this.findViewById(2131300143);
          if ((EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this) != null) && (localTextView != null))
          {
            as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this));
            if ((localas != null) && (com.tencent.mm.contact.c.oR(localas.field_type))) {
              break label123;
            }
            EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this).setVisibility(8);
            localTextView.setVisibility(0);
          }
          for (;;)
          {
            EnterpriseBizContactPlainListUI.a.this.notifyDataSetChanged();
            AppMethodBeat.o(5725);
            return;
            label123:
            if (EnterpriseBizContactPlainListUI.d(EnterpriseBizContactPlainListUI.this).getCount() <= 0)
            {
              EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this).setVisibility(8);
              localTextView.setVisibility(0);
            }
            else
            {
              EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this).setVisibility(0);
              localTextView.setVisibility(8);
              EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this).setAdapter(EnterpriseBizContactPlainListUI.d(EnterpriseBizContactPlainListUI.this));
              EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this).setOnItemClickListener(EnterpriseBizContactPlainListUI.e(EnterpriseBizContactPlainListUI.this));
            }
          }
        }
      });
      AppMethodBeat.o(5730);
    }
    
    final class a
    {
      TextView kcS;
      ImageView keC;
      
      a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(5728);
        if (this.keC != null)
        {
          this.keC.setImageDrawable(null);
          this.keC.setVisibility(8);
        }
        if (this.kcS != null)
        {
          this.kcS.setText("");
          this.kcS.setVisibility(8);
        }
        AppMethodBeat.o(5728);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI
 * JD-Core Version:    0.7.0.1
 */