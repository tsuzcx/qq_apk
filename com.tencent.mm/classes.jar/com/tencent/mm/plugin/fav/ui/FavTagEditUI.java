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
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.r.b;
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
  private FavTagPanel qfA;
  private ListView qfB;
  private ListView qfC;
  private TextView qfD;
  private c qfE;
  private d qfF;
  private boolean qfG;
  private com.tencent.mm.plugin.fav.a.g qfx;
  private List<String> qfy;
  private FavTagPanel qfz;
  
  private void LS()
  {
    AppMethodBeat.i(106929);
    h.d(getContext(), getString(2131758955), "", getString(2131755277), getString(2131755691), new DialogInterface.OnClickListener()
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
    ad.d("MicroMsg.FavTagEditUI", "mod tags %s", new Object[] { paramCollection });
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(paramg.field_tagProto.DiR);
    paramg.field_tagProto.DiR.clear();
    if ((paramCollection == null) || (paramCollection.isEmpty())) {}
    for (;;)
    {
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      b.p(paramg);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().e(localHashSet);
      b.a(paramg, paramInt);
      AppMethodBeat.o(106930);
      return;
      paramg.field_tagProto.DiR.addAll(paramCollection);
      localHashSet.removeAll(paramCollection);
    }
  }
  
  private void cjf()
  {
    AppMethodBeat.i(106926);
    if (this.qfG)
    {
      ad.w("MicroMsg.FavTagEditUI", "match max length, disable finish button");
      if (isOptionMenuEnable(0)) {
        enableOptionMenu(0, false);
      }
      AppMethodBeat.o(106926);
      return;
    }
    if (this.qfx == null)
    {
      if ((this.qfA.getTagCount() <= 0) && (this.qfA.getEditText().length() <= 0))
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
    else if ((this.qfx.field_tagProto.DiR.size() != this.qfA.getTagCount()) || (this.qfA.getEditText().length() > 0))
    {
      if (!isOptionMenuEnable(0))
      {
        enableOptionMenu(0, true);
        AppMethodBeat.o(106926);
      }
    }
    else
    {
      ArrayList localArrayList = this.qfA.getTagList();
      int i = 0;
      while (i < localArrayList.size())
      {
        if (!((String)localArrayList.get(i)).equals(this.qfx.field_tagProto.DiR.get(i)))
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
      this.qfx = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(l);
    }
    this.qfy = getIntent().getStringArrayListExtra("key_fav_result_list");
    this.qfA = ((FavTagPanel)findViewById(2131299843));
    this.qfB = ((ListView)findViewById(2131305632));
    this.qfC = ((ListView)findViewById(2131304449));
    this.qfD = ((TextView)findViewById(2131302197));
    this.qfA.vN(true);
    this.qfA.setTagEditTextBG(2131234289);
    this.qfA.setIsAllowEnterCharacter(true);
    this.qfA.setCallBack(new MMTagPanel.a()
    {
      public final void B(boolean paramAnonymousBoolean, int paramAnonymousInt)
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
      
      public final void Uk(String paramAnonymousString)
      {
        AppMethodBeat.i(106913);
        FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
        FavTagEditUI.f(FavTagEditUI.this).YD(paramAnonymousString);
        if (FavTagEditUI.g(FavTagEditUI.this) != null) {
          FavTagEditUI.g(FavTagEditUI.this).cD(paramAnonymousString, false);
        }
        FavTagEditUI.c(FavTagEditUI.this);
        AppMethodBeat.o(106913);
      }
      
      public final void Ul(String paramAnonymousString) {}
      
      public final void Um(String paramAnonymousString)
      {
        AppMethodBeat.i(106914);
        FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
        FavTagEditUI.f(FavTagEditUI.this).YD(paramAnonymousString);
        if (FavTagEditUI.g(FavTagEditUI.this) != null) {
          FavTagEditUI.g(FavTagEditUI.this).cD(paramAnonymousString, false);
        }
        FavTagEditUI.c(FavTagEditUI.this);
        AppMethodBeat.o(106914);
      }
      
      public final void Un(String paramAnonymousString)
      {
        AppMethodBeat.i(106915);
        if (!bt.isNullOrNil(paramAnonymousString))
        {
          d locald = FavTagEditUI.h(FavTagEditUI.this);
          locald.qhj.clear();
          locald.qhi.clear();
          locald.oiJ = bt.by(paramAnonymousString, "");
          Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr();
          boolean bool = bt.isNullOrNil(paramAnonymousString);
          ArrayList localArrayList = new ArrayList(16);
          localObject = ((l)localObject).qah.rNO.iterator();
          while (((Iterator)localObject).hasNext())
          {
            Iterator localIterator = ((agz)((Iterator)localObject).next()).DiP.iterator();
            while (localIterator.hasNext())
            {
              agy localagy = (agy)localIterator.next();
              if ((bool) || (localagy.xXR.contains(paramAnonymousString))) {
                localArrayList.add(localagy.xXR);
              }
            }
          }
          locald.qhi.addAll(localArrayList);
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
      
      public final void Uo(String paramAnonymousString)
      {
        AppMethodBeat.i(106916);
        if (bt.isNullOrNil(paramAnonymousString))
        {
          ad.d("MicroMsg.FavTagEditUI", "on create tag, fail, tag is empty");
          AppMethodBeat.o(106916);
          return;
        }
        FavTagEditUI.d(FavTagEditUI.this).cC(paramAnonymousString, true);
        FavTagEditUI.c(FavTagEditUI.this);
        AppMethodBeat.o(106916);
      }
      
      public final void bXc() {}
    });
    this.qfA.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106918);
        FavTagEditUI.d(FavTagEditUI.this).eTb();
        FavTagEditUI.this.showVKB();
        AppMethodBeat.o(106918);
      }
    }, 100L);
    Object localObject;
    if (this.qfx != null)
    {
      this.qfA.a(this.qfx.field_tagProto.DiR, this.qfx.field_tagProto.DiR);
      this.qfE = new c(getContext())
      {
        public final void Yy(String paramAnonymousString)
        {
          AppMethodBeat.i(106919);
          FavTagEditUI.d(FavTagEditUI.this).cC(paramAnonymousString, true);
          if (FavTagEditUI.g(FavTagEditUI.this) != null) {
            FavTagEditUI.g(FavTagEditUI.this).cD(paramAnonymousString, true);
          }
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106919);
        }
        
        public final void Yz(String paramAnonymousString)
        {
          AppMethodBeat.i(106920);
          FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
          if (FavTagEditUI.g(FavTagEditUI.this) != null) {
            FavTagEditUI.g(FavTagEditUI.this).cD(paramAnonymousString, false);
          }
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106920);
        }
      };
      localObject = this.qfE;
      if (this.qfx != null) {
        break label633;
      }
    }
    label633:
    for (paramBundle = null;; paramBundle = this.qfx.field_tagProto.DiR)
    {
      ((c)localObject).dp(paramBundle);
      if ((this.qfx != null) && (!this.qfx.field_tagProto.DiQ.isEmpty()))
      {
        paramBundle = View.inflate(getContext(), 2131493981, null);
        localObject = (TextView)paramBundle.findViewById(2131299815);
        ((TextView)localObject).setText(getString(2131758956));
        ((TextView)localObject).setVisibility(0);
        int i = getResources().getDimensionPixelSize(2131165366);
        this.qfz = ((FavTagPanel)paramBundle.findViewById(2131299845));
        this.qfz.setVisibility(0);
        this.qfz.a(this.qfx.field_tagProto.DiR, this.qfx.field_tagProto.DiQ);
        this.qfz.setBackgroundResource(2131232878);
        this.qfz.setPadding(0, 0, 0, i);
        this.qfz.setCallBack(new MMTagPanel.a()
        {
          public final void B(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
          
          public final void Uk(String paramAnonymousString)
          {
            AppMethodBeat.i(106921);
            FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
            FavTagEditUI.f(FavTagEditUI.this).YD(paramAnonymousString);
            FavTagEditUI.c(FavTagEditUI.this);
            AppMethodBeat.o(106921);
          }
          
          public final void Ul(String paramAnonymousString)
          {
            AppMethodBeat.i(106922);
            FavTagEditUI.d(FavTagEditUI.this).cC(paramAnonymousString, true);
            FavTagEditUI.f(FavTagEditUI.this).YC(paramAnonymousString);
            FavTagEditUI.c(FavTagEditUI.this);
            AppMethodBeat.o(106922);
          }
          
          public final void Um(String paramAnonymousString) {}
          
          public final void Un(String paramAnonymousString) {}
          
          public final void Uo(String paramAnonymousString) {}
          
          public final void bXc() {}
        });
        this.qfB.addHeaderView(paramBundle);
      }
      if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().chO() > 0) {
        this.qfB.addHeaderView(View.inflate(getContext(), 2131493980, null));
      }
      this.qfB.setAdapter(this.qfE);
      this.qfB.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(106923);
          FavTagEditUI.d(FavTagEditUI.this).eTc();
          AppMethodBeat.o(106923);
          return false;
        }
      });
      this.qfF = new d(getContext())
      {
        public final void Ve(String paramAnonymousString)
        {
          AppMethodBeat.i(106924);
          FavTagEditUI.d(FavTagEditUI.this).cC(paramAnonymousString, true);
          FavTagEditUI.f(FavTagEditUI.this).YC(paramAnonymousString);
          FavTagEditUI.d(FavTagEditUI.this).eTa();
          FavTagEditUI.d(FavTagEditUI.this).eTc();
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106924);
        }
      };
      this.qfC.setAdapter(this.qfF);
      this.qfC.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(106910);
          FavTagEditUI.d(FavTagEditUI.this).eTc();
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
          if (!bt.isNullOrNil((String)localObject1))
          {
            paramAnonymousMenuItem.remove(localObject1);
            paramAnonymousMenuItem.add(localObject1);
          }
          FavTagEditUI.a(FavTagEditUI.this, ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(l));
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
      }, null, r.b.FOB);
      cjf();
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().a(this.qfE);
      AppMethodBeat.o(106925);
      return;
      if (this.qfy == null) {
        break;
      }
      this.qfA.a(this.qfy, this.qfy);
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106927);
    super.onDestroy();
    l locall = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr();
    c localc = this.qfE;
    if (localc == null)
    {
      AppMethodBeat.o(106927);
      return;
    }
    locall.byu.remove(localc.toString());
    AppMethodBeat.o(106927);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106928);
    if (paramInt == 4)
    {
      LS();
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