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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.a.d;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.protocal.protobuf.akx;
import com.tencent.mm.protocal.protobuf.aky;
import com.tencent.mm.protocal.protobuf.akz;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s.b;
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
  private com.tencent.mm.plugin.fav.a.g rGj;
  private List<String> rGk;
  private FavTagPanel rGl;
  private FavTagPanel rGm;
  private ListView rGn;
  private ListView rGo;
  private TextView rGp;
  private c rGq;
  private d rGr;
  private boolean rGs;
  
  private void Nv()
  {
    AppMethodBeat.i(106929);
    h.e(getContext(), getString(2131758955), "", getString(2131755277), getString(2131755691), new DialogInterface.OnClickListener()
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
    ae.d("MicroMsg.FavTagEditUI", "mod tags %s", new Object[] { paramCollection });
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(paramg.field_tagProto.GCs);
    paramg.field_tagProto.GCs.clear();
    if ((paramCollection == null) || (paramCollection.isEmpty())) {}
    for (;;)
    {
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      com.tencent.mm.plugin.fav.a.b.p(paramg);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().j(localHashSet);
      com.tencent.mm.plugin.fav.a.b.a(paramg, paramInt);
      AppMethodBeat.o(106930);
      return;
      paramg.field_tagProto.GCs.addAll(paramCollection);
      localHashSet.removeAll(paramCollection);
    }
  }
  
  private void cxX()
  {
    AppMethodBeat.i(106926);
    if (this.rGs)
    {
      ae.w("MicroMsg.FavTagEditUI", "match max length, disable finish button");
      if (isOptionMenuEnable(0)) {
        enableOptionMenu(0, false);
      }
      AppMethodBeat.o(106926);
      return;
    }
    if (this.rGj == null)
    {
      if ((this.rGm.getTagCount() <= 0) && (this.rGm.getEditText().length() <= 0))
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
    else if ((this.rGj.field_tagProto.GCs.size() != this.rGm.getTagCount()) || (this.rGm.getEditText().length() > 0))
    {
      if (!isOptionMenuEnable(0))
      {
        enableOptionMenu(0, true);
        AppMethodBeat.o(106926);
      }
    }
    else
    {
      ArrayList localArrayList = this.rGm.getTagList();
      int i = 0;
      while (i < localArrayList.size())
      {
        if (!((String)localArrayList.get(i)).equals(this.rGj.field_tagProto.GCs.get(i)))
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
    return 2131493977;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106925);
    super.onCreate(paramBundle);
    final long l = getIntent().getLongExtra("key_fav_item_id", -1L);
    if (-1L != l) {
      this.rGj = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(l);
    }
    this.rGk = getIntent().getStringArrayListExtra("key_fav_result_list");
    this.rGm = ((FavTagPanel)findViewById(2131299843));
    this.rGn = ((ListView)findViewById(2131305632));
    this.rGo = ((ListView)findViewById(2131304449));
    this.rGp = ((TextView)findViewById(2131302197));
    this.rGm.xK(true);
    this.rGm.setTagEditTextBG(2131234289);
    this.rGm.setIsAllowEnterCharacter(true);
    this.rGm.setCallBack(new MMTagPanel.a()
    {
      public final void D(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(106917);
        FavTagEditUI.a(FavTagEditUI.this, paramAnonymousBoolean);
        TextView localTextView = FavTagEditUI.k(FavTagEditUI.this);
        if ((FavTagEditUI.b(FavTagEditUI.this)) && (paramAnonymousInt > 0)) {}
        for (int i = 0;; i = 8)
        {
          localTextView.setVisibility(i);
          FavTagEditUI.k(FavTagEditUI.this).setText(FavTagEditUI.this.getString(2131759021, new Object[] { Integer.valueOf(paramAnonymousInt) }));
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106917);
          return;
        }
      }
      
      public final void acT(String paramAnonymousString)
      {
        AppMethodBeat.i(106913);
        FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
        FavTagEditUI.f(FavTagEditUI.this).ahL(paramAnonymousString);
        if (FavTagEditUI.g(FavTagEditUI.this) != null) {
          FavTagEditUI.g(FavTagEditUI.this).cS(paramAnonymousString, false);
        }
        FavTagEditUI.c(FavTagEditUI.this);
        AppMethodBeat.o(106913);
      }
      
      public final void acU(String paramAnonymousString) {}
      
      public final void acV(String paramAnonymousString)
      {
        AppMethodBeat.i(106914);
        FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
        FavTagEditUI.f(FavTagEditUI.this).ahL(paramAnonymousString);
        if (FavTagEditUI.g(FavTagEditUI.this) != null) {
          FavTagEditUI.g(FavTagEditUI.this).cS(paramAnonymousString, false);
        }
        FavTagEditUI.c(FavTagEditUI.this);
        AppMethodBeat.o(106914);
      }
      
      public final void acW(String paramAnonymousString)
      {
        AppMethodBeat.i(106915);
        if (!bu.isNullOrNil(paramAnonymousString))
        {
          d locald = FavTagEditUI.h(FavTagEditUI.this);
          locald.rHV.clear();
          locald.rHU.clear();
          locald.pwx = bu.bI(paramAnonymousString, "");
          Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr();
          boolean bool = bu.isNullOrNil(paramAnonymousString);
          ArrayList localArrayList = new ArrayList(16);
          localObject = ((l)localObject).rBb.uda.iterator();
          while (((Iterator)localObject).hasNext())
          {
            Iterator localIterator = ((aky)((Iterator)localObject).next()).GCq.iterator();
            while (localIterator.hasNext())
            {
              akx localakx = (akx)localIterator.next();
              if ((bool) || (localakx.AUt.contains(paramAnonymousString))) {
                localArrayList.add(localakx.AUt);
              }
            }
          }
          locald.rHU.addAll(localArrayList);
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
      
      public final void acX(String paramAnonymousString)
      {
        AppMethodBeat.i(106916);
        if (bu.isNullOrNil(paramAnonymousString))
        {
          ae.d("MicroMsg.FavTagEditUI", "on create tag, fail, tag is empty");
          AppMethodBeat.o(106916);
          return;
        }
        FavTagEditUI.d(FavTagEditUI.this).cR(paramAnonymousString, true);
        FavTagEditUI.c(FavTagEditUI.this);
        AppMethodBeat.o(106916);
      }
      
      public final void cki() {}
    });
    this.rGm.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106918);
        FavTagEditUI.d(FavTagEditUI.this).fDc();
        FavTagEditUI.this.showVKB();
        AppMethodBeat.o(106918);
      }
    }, 100L);
    Object localObject;
    if (this.rGj != null)
    {
      this.rGm.a(this.rGj.field_tagProto.GCs, this.rGj.field_tagProto.GCs);
      this.rGq = new c(getContext())
      {
        public final void ahG(String paramAnonymousString)
        {
          AppMethodBeat.i(106919);
          FavTagEditUI.d(FavTagEditUI.this).cR(paramAnonymousString, true);
          if (FavTagEditUI.g(FavTagEditUI.this) != null) {
            FavTagEditUI.g(FavTagEditUI.this).cS(paramAnonymousString, true);
          }
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106919);
        }
        
        public final void ahH(String paramAnonymousString)
        {
          AppMethodBeat.i(106920);
          FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
          if (FavTagEditUI.g(FavTagEditUI.this) != null) {
            FavTagEditUI.g(FavTagEditUI.this).cS(paramAnonymousString, false);
          }
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106920);
        }
      };
      localObject = this.rGq;
      if (this.rGj != null) {
        break label633;
      }
    }
    label633:
    for (paramBundle = null;; paramBundle = this.rGj.field_tagProto.GCs)
    {
      ((c)localObject).dw(paramBundle);
      if ((this.rGj != null) && (!this.rGj.field_tagProto.GCr.isEmpty()))
      {
        paramBundle = View.inflate(getContext(), 2131493981, null);
        localObject = (TextView)paramBundle.findViewById(2131299815);
        ((TextView)localObject).setText(getString(2131758956));
        ((TextView)localObject).setVisibility(0);
        int i = getResources().getDimensionPixelSize(2131165366);
        this.rGl = ((FavTagPanel)paramBundle.findViewById(2131299845));
        this.rGl.setVisibility(0);
        this.rGl.a(this.rGj.field_tagProto.GCs, this.rGj.field_tagProto.GCr);
        this.rGl.setBackgroundResource(2131232878);
        this.rGl.setPadding(0, 0, 0, i);
        this.rGl.setCallBack(new MMTagPanel.a()
        {
          public final void D(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
          
          public final void acT(String paramAnonymousString)
          {
            AppMethodBeat.i(106921);
            FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
            FavTagEditUI.f(FavTagEditUI.this).ahL(paramAnonymousString);
            FavTagEditUI.c(FavTagEditUI.this);
            AppMethodBeat.o(106921);
          }
          
          public final void acU(String paramAnonymousString)
          {
            AppMethodBeat.i(106922);
            FavTagEditUI.d(FavTagEditUI.this).cR(paramAnonymousString, true);
            FavTagEditUI.f(FavTagEditUI.this).ahK(paramAnonymousString);
            FavTagEditUI.c(FavTagEditUI.this);
            AppMethodBeat.o(106922);
          }
          
          public final void acV(String paramAnonymousString) {}
          
          public final void acW(String paramAnonymousString) {}
          
          public final void acX(String paramAnonymousString) {}
          
          public final void cki() {}
        });
        this.rGn.addHeaderView(paramBundle);
      }
      if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().cwB() > 0) {
        this.rGn.addHeaderView(View.inflate(getContext(), 2131493980, null));
      }
      this.rGn.setAdapter(this.rGq);
      this.rGn.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(106923);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          a.b("com/tencent/mm/plugin/fav/ui/FavTagEditUI$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          FavTagEditUI.d(FavTagEditUI.this).fDd();
          a.a(false, this, "com/tencent/mm/plugin/fav/ui/FavTagEditUI$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(106923);
          return false;
        }
      });
      this.rGr = new d(getContext())
      {
        public final void adN(String paramAnonymousString)
        {
          AppMethodBeat.i(106924);
          FavTagEditUI.d(FavTagEditUI.this).cR(paramAnonymousString, true);
          FavTagEditUI.f(FavTagEditUI.this).ahK(paramAnonymousString);
          FavTagEditUI.d(FavTagEditUI.this).fDb();
          FavTagEditUI.d(FavTagEditUI.this).fDd();
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106924);
        }
      };
      this.rGo.setAdapter(this.rGr);
      this.rGo.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(106910);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          a.b("com/tencent/mm/plugin/fav/ui/FavTagEditUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          FavTagEditUI.d(FavTagEditUI.this).fDd();
          a.a(false, this, "com/tencent/mm/plugin/fav/ui/FavTagEditUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(106910);
          return false;
        }
      });
      setMMTitle(2131758875);
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
      addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
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
          if (!bu.isNullOrNil((String)localObject1))
          {
            paramAnonymousMenuItem.remove(localObject1);
            paramAnonymousMenuItem.add(localObject1);
          }
          FavTagEditUI.a(FavTagEditUI.this, ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(l));
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
      }, null, s.b.JwA);
      cxX();
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().a(this.rGq);
      AppMethodBeat.o(106925);
      return;
      if (this.rGk == null) {
        break;
      }
      this.rGm.a(this.rGk, this.rGk);
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106927);
    super.onDestroy();
    l locall = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr();
    c localc = this.rGq;
    if (localc == null)
    {
      AppMethodBeat.o(106927);
      return;
    }
    locall.bGq.remove(localc.toString());
    AppMethodBeat.o(106927);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106928);
    if (paramInt == 4)
    {
      Nv();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTagEditUI
 * JD-Core Version:    0.7.0.1
 */