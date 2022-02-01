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
import com.tencent.mm.protocal.protobuf.ahx;
import com.tencent.mm.protocal.protobuf.ahy;
import com.tencent.mm.protocal.protobuf.ahz;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private com.tencent.mm.plugin.fav.a.g qNZ;
  private List<String> qOa;
  private FavTagPanel qOb;
  private FavTagPanel qOc;
  private ListView qOd;
  private ListView qOe;
  private TextView qOf;
  private c qOg;
  private d qOh;
  private boolean qOi;
  
  private void LQ()
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
    ac.d("MicroMsg.FavTagEditUI", "mod tags %s", new Object[] { paramCollection });
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(paramg.field_tagProto.EBX);
    paramg.field_tagProto.EBX.clear();
    if ((paramCollection == null) || (paramCollection.isEmpty())) {}
    for (;;)
    {
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      b.p(paramg);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().f(localHashSet);
      b.a(paramg, paramInt);
      AppMethodBeat.o(106930);
      return;
      paramg.field_tagProto.EBX.addAll(paramCollection);
      localHashSet.removeAll(paramCollection);
    }
  }
  
  private void cqM()
  {
    AppMethodBeat.i(106926);
    if (this.qOi)
    {
      ac.w("MicroMsg.FavTagEditUI", "match max length, disable finish button");
      if (isOptionMenuEnable(0)) {
        enableOptionMenu(0, false);
      }
      AppMethodBeat.o(106926);
      return;
    }
    if (this.qNZ == null)
    {
      if ((this.qOc.getTagCount() <= 0) && (this.qOc.getEditText().length() <= 0))
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
    else if ((this.qNZ.field_tagProto.EBX.size() != this.qOc.getTagCount()) || (this.qOc.getEditText().length() > 0))
    {
      if (!isOptionMenuEnable(0))
      {
        enableOptionMenu(0, true);
        AppMethodBeat.o(106926);
      }
    }
    else
    {
      ArrayList localArrayList = this.qOc.getTagList();
      int i = 0;
      while (i < localArrayList.size())
      {
        if (!((String)localArrayList.get(i)).equals(this.qNZ.field_tagProto.EBX.get(i)))
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
      this.qNZ = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(l);
    }
    this.qOa = getIntent().getStringArrayListExtra("key_fav_result_list");
    this.qOc = ((FavTagPanel)findViewById(2131299843));
    this.qOd = ((ListView)findViewById(2131305632));
    this.qOe = ((ListView)findViewById(2131304449));
    this.qOf = ((TextView)findViewById(2131302197));
    this.qOc.wR(true);
    this.qOc.setTagEditTextBG(2131234289);
    this.qOc.setIsAllowEnterCharacter(true);
    this.qOc.setCallBack(new MMTagPanel.a()
    {
      public final void C(boolean paramAnonymousBoolean, int paramAnonymousInt)
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
      
      public final void YA(String paramAnonymousString)
      {
        AppMethodBeat.i(106916);
        if (bs.isNullOrNil(paramAnonymousString))
        {
          ac.d("MicroMsg.FavTagEditUI", "on create tag, fail, tag is empty");
          AppMethodBeat.o(106916);
          return;
        }
        FavTagEditUI.d(FavTagEditUI.this).cI(paramAnonymousString, true);
        FavTagEditUI.c(FavTagEditUI.this);
        AppMethodBeat.o(106916);
      }
      
      public final void Yw(String paramAnonymousString)
      {
        AppMethodBeat.i(106913);
        FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
        FavTagEditUI.f(FavTagEditUI.this).acZ(paramAnonymousString);
        if (FavTagEditUI.g(FavTagEditUI.this) != null) {
          FavTagEditUI.g(FavTagEditUI.this).cJ(paramAnonymousString, false);
        }
        FavTagEditUI.c(FavTagEditUI.this);
        AppMethodBeat.o(106913);
      }
      
      public final void Yx(String paramAnonymousString) {}
      
      public final void Yy(String paramAnonymousString)
      {
        AppMethodBeat.i(106914);
        FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
        FavTagEditUI.f(FavTagEditUI.this).acZ(paramAnonymousString);
        if (FavTagEditUI.g(FavTagEditUI.this) != null) {
          FavTagEditUI.g(FavTagEditUI.this).cJ(paramAnonymousString, false);
        }
        FavTagEditUI.c(FavTagEditUI.this);
        AppMethodBeat.o(106914);
      }
      
      public final void Yz(String paramAnonymousString)
      {
        AppMethodBeat.i(106915);
        if (!bs.isNullOrNil(paramAnonymousString))
        {
          d locald = FavTagEditUI.h(FavTagEditUI.this);
          locald.qPL.clear();
          locald.qPK.clear();
          locald.oMj = bs.bG(paramAnonymousString, "");
          Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr();
          boolean bool = bs.isNullOrNil(paramAnonymousString);
          ArrayList localArrayList = new ArrayList(16);
          localObject = ((l)localObject).qIN.sVE.iterator();
          while (((Iterator)localObject).hasNext())
          {
            Iterator localIterator = ((ahy)((Iterator)localObject).next()).EBV.iterator();
            while (localIterator.hasNext())
            {
              ahx localahx = (ahx)localIterator.next();
              if ((bool) || (localahx.zkN.contains(paramAnonymousString))) {
                localArrayList.add(localahx.zkN);
              }
            }
          }
          locald.qPK.addAll(localArrayList);
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
      
      public final void cep() {}
    });
    this.qOc.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106918);
        FavTagEditUI.d(FavTagEditUI.this).fiL();
        FavTagEditUI.this.showVKB();
        AppMethodBeat.o(106918);
      }
    }, 100L);
    Object localObject;
    if (this.qNZ != null)
    {
      this.qOc.a(this.qNZ.field_tagProto.EBX, this.qNZ.field_tagProto.EBX);
      this.qOg = new c(getContext())
      {
        public final void acU(String paramAnonymousString)
        {
          AppMethodBeat.i(106919);
          FavTagEditUI.d(FavTagEditUI.this).cI(paramAnonymousString, true);
          if (FavTagEditUI.g(FavTagEditUI.this) != null) {
            FavTagEditUI.g(FavTagEditUI.this).cJ(paramAnonymousString, true);
          }
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106919);
        }
        
        public final void acV(String paramAnonymousString)
        {
          AppMethodBeat.i(106920);
          FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
          if (FavTagEditUI.g(FavTagEditUI.this) != null) {
            FavTagEditUI.g(FavTagEditUI.this).cJ(paramAnonymousString, false);
          }
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106920);
        }
      };
      localObject = this.qOg;
      if (this.qNZ != null) {
        break label633;
      }
    }
    label633:
    for (paramBundle = null;; paramBundle = this.qNZ.field_tagProto.EBX)
    {
      ((c)localObject).dr(paramBundle);
      if ((this.qNZ != null) && (!this.qNZ.field_tagProto.EBW.isEmpty()))
      {
        paramBundle = View.inflate(getContext(), 2131493981, null);
        localObject = (TextView)paramBundle.findViewById(2131299815);
        ((TextView)localObject).setText(getString(2131758956));
        ((TextView)localObject).setVisibility(0);
        int i = getResources().getDimensionPixelSize(2131165366);
        this.qOb = ((FavTagPanel)paramBundle.findViewById(2131299845));
        this.qOb.setVisibility(0);
        this.qOb.a(this.qNZ.field_tagProto.EBX, this.qNZ.field_tagProto.EBW);
        this.qOb.setBackgroundResource(2131232878);
        this.qOb.setPadding(0, 0, 0, i);
        this.qOb.setCallBack(new MMTagPanel.a()
        {
          public final void C(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
          
          public final void YA(String paramAnonymousString) {}
          
          public final void Yw(String paramAnonymousString)
          {
            AppMethodBeat.i(106921);
            FavTagEditUI.d(FavTagEditUI.this).removeTag(paramAnonymousString);
            FavTagEditUI.f(FavTagEditUI.this).acZ(paramAnonymousString);
            FavTagEditUI.c(FavTagEditUI.this);
            AppMethodBeat.o(106921);
          }
          
          public final void Yx(String paramAnonymousString)
          {
            AppMethodBeat.i(106922);
            FavTagEditUI.d(FavTagEditUI.this).cI(paramAnonymousString, true);
            FavTagEditUI.f(FavTagEditUI.this).acY(paramAnonymousString);
            FavTagEditUI.c(FavTagEditUI.this);
            AppMethodBeat.o(106922);
          }
          
          public final void Yy(String paramAnonymousString) {}
          
          public final void Yz(String paramAnonymousString) {}
          
          public final void cep() {}
        });
        this.qOd.addHeaderView(paramBundle);
      }
      if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().cpv() > 0) {
        this.qOd.addHeaderView(View.inflate(getContext(), 2131493980, null));
      }
      this.qOd.setAdapter(this.qOg);
      this.qOd.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(106923);
          FavTagEditUI.d(FavTagEditUI.this).fiM();
          AppMethodBeat.o(106923);
          return false;
        }
      });
      this.qOh = new d(getContext())
      {
        public final void Zq(String paramAnonymousString)
        {
          AppMethodBeat.i(106924);
          FavTagEditUI.d(FavTagEditUI.this).cI(paramAnonymousString, true);
          FavTagEditUI.f(FavTagEditUI.this).acY(paramAnonymousString);
          FavTagEditUI.d(FavTagEditUI.this).fiK();
          FavTagEditUI.d(FavTagEditUI.this).fiM();
          FavTagEditUI.c(FavTagEditUI.this);
          AppMethodBeat.o(106924);
        }
      };
      this.qOe.setAdapter(this.qOh);
      this.qOe.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(106910);
          FavTagEditUI.d(FavTagEditUI.this).fiM();
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
          if (!bs.isNullOrNil((String)localObject1))
          {
            paramAnonymousMenuItem.remove(localObject1);
            paramAnonymousMenuItem.add(localObject1);
          }
          FavTagEditUI.a(FavTagEditUI.this, ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(l));
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
      }, null, s.b.Hom);
      cqM();
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().a(this.qOg);
      AppMethodBeat.o(106925);
      return;
      if (this.qOa == null) {
        break;
      }
      this.qOc.a(this.qOa, this.qOa);
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106927);
    super.onDestroy();
    l locall = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr();
    c localc = this.qOg;
    if (localc == null)
    {
      AppMethodBeat.o(106927);
      return;
    }
    locall.bwc.remove(localc.toString());
    AppMethodBeat.o(106927);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106928);
    if (paramInt == 4)
    {
      LQ();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTagEditUI
 * JD-Core Version:    0.7.0.1
 */