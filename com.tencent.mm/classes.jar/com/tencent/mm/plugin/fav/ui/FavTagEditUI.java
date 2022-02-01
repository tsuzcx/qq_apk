package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.a.d;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.protocal.protobuf.anl;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FavTagEditUI
  extends MMActivity
{
  private com.tencent.mm.plugin.fav.a.g tfP;
  private List<String> tfQ;
  private FavTagPanel tfR;
  private FavTagPanel tfS;
  private ListView tfT;
  private ListView tfU;
  private TextView tfV;
  private c tfW;
  private d tfX;
  private boolean tfY;
  
  private void XH()
  {
    AppMethodBeat.i(106929);
    h.c(getContext(), getString(2131759279), "", getString(2131755312), getString(2131755761), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(106912);
        FavTagEditUI.this.finish();
        AppMethodBeat.o(106912);
      }
    }, null);
    AppMethodBeat.o(106929);
  }
  
  public static void a(com.tencent.mm.plugin.fav.a.g paramg, Collection<String> paramCollection, int paramInt)
  {
    AppMethodBeat.i(106930);
    if (paramg == null)
    {
      AppMethodBeat.o(106930);
      return;
    }
    Log.d("MicroMsg.FavTagEditUI", "mod tags %s", new Object[] { paramCollection });
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(paramg.field_tagProto.Lyo);
    paramg.field_tagProto.Lyo.clear();
    if ((paramCollection == null) || (paramCollection.isEmpty())) {}
    for (;;)
    {
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      b.p(paramg);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().j(localHashSet);
      b.a(paramg, paramInt);
      AppMethodBeat.o(106930);
      return;
      paramg.field_tagProto.Lyo.addAll(paramCollection);
      localHashSet.removeAll(paramCollection);
    }
  }
  
  private void cWb()
  {
    AppMethodBeat.i(106926);
    if (this.tfY)
    {
      Log.w("MicroMsg.FavTagEditUI", "match max length, disable finish button");
      if (isOptionMenuEnable(0)) {
        enableOptionMenu(0, false);
      }
      AppMethodBeat.o(106926);
      return;
    }
    if (this.tfP == null)
    {
      if ((this.tfS.getTagCount() <= 0) && (this.tfS.getEditText().length() <= 0))
      {
        if (isOptionMenuEnable(0))
        {
          enableOptionMenu(0, false);
          AppMethodBeat.o(106926);
        }
      }
      else if (!isOptionMenuEnable(0))
      {
        enableOptionMenu(0, true);
        AppMethodBeat.o(106926);
      }
    }
    else if ((this.tfP.field_tagProto.Lyo.size() != this.tfS.getTagCount()) || (this.tfS.getEditText().length() > 0))
    {
      if (!isOptionMenuEnable(0))
      {
        enableOptionMenu(0, true);
        AppMethodBeat.o(106926);
      }
    }
    else
    {
      ArrayList localArrayList = this.tfS.getTagList();
      int i = 0;
      while (i < localArrayList.size())
      {
        if (!((String)localArrayList.get(i)).equals(this.tfP.field_tagProto.Lyo.get(i)))
        {
          if (!isOptionMenuEnable(0)) {
            enableOptionMenu(0, true);
          }
          AppMethodBeat.o(106926);
          return;
        }
        i += 1;
      }
      if (isOptionMenuEnable(0)) {
        enableOptionMenu(0, false);
      }
    }
    AppMethodBeat.o(106926);
  }
  
  public int getLayoutId()
  {
    return 2131494147;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106925);
    super.onCreate(paramBundle);
    final long l = getIntent().getLongExtra("key_fav_item_id", -1L);
    if (-1L != l) {
      this.tfP = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(l);
    }
    this.tfQ = getIntent().getStringArrayListExtra("key_fav_result_list");
    this.tfS = ((FavTagPanel)findViewById(2131300521));
    this.tfT = ((ListView)findViewById(2131308874));
    this.tfU = ((ListView)findViewById(2131307425));
    this.tfV = ((TextView)findViewById(2131304542));
    this.tfS.Bz(true);
    this.tfS.setTagEditTextBG(2131235168);
    this.tfS.setIsAllowEnterCharacter(true);
    this.tfS.setCallBack(new MMTagPanel.a()
    {
      public final void E(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(106917);
        FavTagEditUI.a(FavTagEditUI.this, paramAnonymousBoolean);
        TextView localTextView = FavTagEditUI.k(FavTagEditUI.this);
        if ((FavTagEditUI.b(FavTagEditUI.this)) && (paramAnonymousInt > 0)) {}
        for (int i = 0;; i = 8)
        {
          localTextView.setVisibility(i);
          FavTagEditUI.k(FavTagEditUI.this).setText(FavTagEditUI.this.getString(2131759347, new Object[] { Integer.valueOf(paramAnonymousInt) }));
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106917);
          return;
        }
      }
      
      public final void anb(String paramAnonymousString)
      {
        AppMethodBeat.i(106913);
        FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
        FavTagEditUI.f(FavTagEditUI.this).ast(paramAnonymousString);
        if (FavTagEditUI.g(FavTagEditUI.this) != null) {
          FavTagEditUI.g(FavTagEditUI.this).dn(paramAnonymousString, false);
        }
        FavTagEditUI.c(FavTagEditUI.this);
        AppMethodBeat.o(106913);
      }
      
      public final void anc(String paramAnonymousString) {}
      
      public final void and(String paramAnonymousString)
      {
        AppMethodBeat.i(106914);
        FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
        FavTagEditUI.f(FavTagEditUI.this).ast(paramAnonymousString);
        if (FavTagEditUI.g(FavTagEditUI.this) != null) {
          FavTagEditUI.g(FavTagEditUI.this).dn(paramAnonymousString, false);
        }
        FavTagEditUI.c(FavTagEditUI.this);
        AppMethodBeat.o(106914);
      }
      
      public final void ane(String paramAnonymousString)
      {
        AppMethodBeat.i(106915);
        if (!Util.isNullOrNil(paramAnonymousString))
        {
          d locald = FavTagEditUI.h(FavTagEditUI.this);
          locald.thC.clear();
          locald.thB.clear();
          locald.qLO = Util.nullAs(paramAnonymousString, "");
          Object localObject = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr();
          boolean bool = Util.isNullOrNil(paramAnonymousString);
          ArrayList localArrayList = new ArrayList(16);
          localObject = ((l)localObject).taG.xuO.iterator();
          while (((Iterator)localObject).hasNext())
          {
            Iterator localIterator = ((anm)((Iterator)localObject).next()).Lym.iterator();
            while (localIterator.hasNext())
            {
              anl localanl = (anl)localIterator.next();
              if ((bool) || (localanl.FeZ.contains(paramAnonymousString))) {
                localArrayList.add(localanl.FeZ);
              }
            }
          }
          locald.thB.addAll(localArrayList);
          locald.notifyDataSetChanged();
          FavTagEditUI.i(FavTagEditUI.this).setVisibility(0);
          FavTagEditUI.j(FavTagEditUI.this).setVisibility(8);
        }
        for (;;)
        {
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106915);
          return;
          FavTagEditUI.i(FavTagEditUI.this).setVisibility(8);
          FavTagEditUI.j(FavTagEditUI.this).setVisibility(0);
        }
      }
      
      public final void anf(String paramAnonymousString)
      {
        AppMethodBeat.i(106916);
        if (Util.isNullOrNil(paramAnonymousString))
        {
          Log.d("MicroMsg.FavTagEditUI", "on create tag, fail, tag is empty");
          AppMethodBeat.o(106916);
          return;
        }
        FavTagEditUI.d(FavTagEditUI.this).dm(paramAnonymousString, true);
        FavTagEditUI.c(FavTagEditUI.this);
        AppMethodBeat.o(106916);
      }
      
      public final void cIk() {}
    });
    this.tfS.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106918);
        FavTagEditUI.d(FavTagEditUI.this).gLd();
        FavTagEditUI.this.showVKB();
        AppMethodBeat.o(106918);
      }
    }, 100L);
    Object localObject;
    if (this.tfP != null)
    {
      this.tfS.a(this.tfP.field_tagProto.Lyo, this.tfP.field_tagProto.Lyo);
      this.tfW = new c(getContext())
      {
        public final void aso(String paramAnonymousString)
        {
          AppMethodBeat.i(106919);
          FavTagEditUI.d(FavTagEditUI.this).dm(paramAnonymousString, true);
          if (FavTagEditUI.g(FavTagEditUI.this) != null) {
            FavTagEditUI.g(FavTagEditUI.this).dn(paramAnonymousString, true);
          }
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106919);
        }
        
        public final void asp(String paramAnonymousString)
        {
          AppMethodBeat.i(106920);
          FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
          if (FavTagEditUI.g(FavTagEditUI.this) != null) {
            FavTagEditUI.g(FavTagEditUI.this).dn(paramAnonymousString, false);
          }
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106920);
        }
      };
      localObject = this.tfW;
      if (this.tfP != null) {
        break label633;
      }
    }
    label633:
    for (paramBundle = null;; paramBundle = this.tfP.field_tagProto.Lyo)
    {
      ((c)localObject).dK(paramBundle);
      if ((this.tfP != null) && (!this.tfP.field_tagProto.Lyn.isEmpty()))
      {
        paramBundle = View.inflate(getContext(), 2131494151, null);
        localObject = (TextView)paramBundle.findViewById(2131300491);
        ((TextView)localObject).setText(getString(2131759280));
        ((TextView)localObject).setVisibility(0);
        int i = getResources().getDimensionPixelSize(2131165377);
        this.tfR = ((FavTagPanel)paramBundle.findViewById(2131300523));
        this.tfR.setVisibility(0);
        this.tfR.a(this.tfP.field_tagProto.Lyo, this.tfP.field_tagProto.Lyn);
        this.tfR.setBackgroundResource(2131233338);
        this.tfR.setPadding(0, 0, 0, i);
        this.tfR.setCallBack(new MMTagPanel.a()
        {
          public final void E(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
          
          public final void anb(String paramAnonymousString)
          {
            AppMethodBeat.i(106921);
            FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
            FavTagEditUI.f(FavTagEditUI.this).ast(paramAnonymousString);
            FavTagEditUI.c(FavTagEditUI.this);
            AppMethodBeat.o(106921);
          }
          
          public final void anc(String paramAnonymousString)
          {
            AppMethodBeat.i(106922);
            FavTagEditUI.d(FavTagEditUI.this).dm(paramAnonymousString, true);
            FavTagEditUI.f(FavTagEditUI.this).ass(paramAnonymousString);
            FavTagEditUI.c(FavTagEditUI.this);
            AppMethodBeat.o(106922);
          }
          
          public final void and(String paramAnonymousString) {}
          
          public final void ane(String paramAnonymousString) {}
          
          public final void anf(String paramAnonymousString) {}
          
          public final void cIk() {}
        });
        this.tfT.addHeaderView(paramBundle);
      }
      if (((af)com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().cUF() > 0) {
        this.tfT.addHeaderView(View.inflate(getContext(), 2131494150, null));
      }
      this.tfT.setAdapter(this.tfW);
      this.tfT.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(106923);
          FavTagEditUI.d(FavTagEditUI.this).gLe();
          AppMethodBeat.o(106923);
          return false;
        }
      });
      this.tfX = new d(getContext())
      {
        public final void anW(String paramAnonymousString)
        {
          AppMethodBeat.i(106924);
          FavTagEditUI.d(FavTagEditUI.this).dm(paramAnonymousString, true);
          FavTagEditUI.f(FavTagEditUI.this).ass(paramAnonymousString);
          FavTagEditUI.d(FavTagEditUI.this).gLc();
          FavTagEditUI.d(FavTagEditUI.this).gLe();
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106924);
        }
      };
      this.tfU.setAdapter(this.tfX);
      this.tfU.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(106910);
          FavTagEditUI.d(FavTagEditUI.this).gLe();
          AppMethodBeat.o(106910);
          return false;
        }
      });
      setMMTitle(2131759199);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(106909);
          FavTagEditUI.a(FavTagEditUI.this);
          AppMethodBeat.o(106909);
          return true;
        }
      });
      addTextOptionMenu(0, getString(2131755858), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(106911);
          if (FavTagEditUI.b(FavTagEditUI.this))
          {
            FavTagEditUI.c(FavTagEditUI.this);
            AppMethodBeat.o(106911);
            return true;
          }
          paramAnonymousMenuItem = FavTagEditUI.d(FavTagEditUI.this).getTagList();
          Object localObject1 = FavTagEditUI.d(FavTagEditUI.this).getEditText().trim();
          if (!Util.isNullOrNil((String)localObject1))
          {
            paramAnonymousMenuItem.remove(localObject1);
            paramAnonymousMenuItem.add(localObject1);
          }
          FavTagEditUI.a(FavTagEditUI.this, ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(l));
          if (FavTagEditUI.e(FavTagEditUI.this) != null)
          {
            FavTagEditUI.a(FavTagEditUI.e(FavTagEditUI.this), paramAnonymousMenuItem, FavTagEditUI.this.getIntent().getIntExtra("key_fav_scene", 1));
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("key_fav_result_list", paramAnonymousMenuItem);
            FavTagEditUI.this.setResult(-1, (Intent)localObject1);
          }
          for (;;)
          {
            FavTagEditUI.this.finish();
            FavTagEditUI.this.hideVKB();
            AppMethodBeat.o(106911);
            return true;
            localObject1 = new String[paramAnonymousMenuItem.size()];
            Object localObject2 = paramAnonymousMenuItem.iterator();
            int i = 0;
            while (((Iterator)localObject2).hasNext())
            {
              localObject1[i] = ((String)((Iterator)localObject2).next());
              i += 1;
            }
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("key_fav_result_array", (String[])localObject1);
            ((Intent)localObject2).putExtra("key_fav_result_list", paramAnonymousMenuItem);
            FavTagEditUI.this.setResult(-1, (Intent)localObject2);
          }
        }
      }, null, t.b.OGU);
      cWb();
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().a(this.tfW);
      AppMethodBeat.o(106925);
      return;
      if (this.tfQ == null) {
        break;
      }
      this.tfS.a(this.tfQ, this.tfQ);
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106927);
    super.onDestroy();
    l locall = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr();
    c localc = this.tfW;
    if (localc == null)
    {
      AppMethodBeat.o(106927);
      return;
    }
    locall.bGH.remove(localc.toString());
    AppMethodBeat.o(106927);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106928);
    if (paramInt == 4)
    {
      XH();
      AppMethodBeat.o(106928);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(106928);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTagEditUI
 * JD-Core Version:    0.7.0.1
 */