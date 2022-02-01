package com.tencent.mm.plugin.editor.model.nativenote.c;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.a.j;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Collections;

public final class e
  implements a.a
{
  public static boolean mHasInit = false;
  public static volatile e pCX = null;
  public aq mHandler = null;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public boolean pCY = true;
  public int pCZ = 0;
  public TextView pDA = null;
  public TextView pDB = null;
  public TextView pDC = null;
  public TextView pDD = null;
  public int pDa = 0;
  public int pDb = 14;
  public int pDc = 0;
  public int pDd = 0;
  public int pDe = 0;
  public int pDf = 0;
  public int pDg = 0;
  public int pDh = 0;
  public int pDi = 0;
  public int[] pDj = null;
  public int[] pDk = null;
  public int[] pDl = null;
  public int[] pDm = null;
  public PopupWindow pDn = null;
  public PopupWindow pDo = null;
  public PopupWindow pDp = null;
  public PopupWindow pDq = null;
  public com.tencent.mm.plugin.editor.model.nativenote.b.a pDr = null;
  public d pDs = null;
  public b pDt = null;
  public aw pDu = null;
  public aw pDv = null;
  public TextView pDw = null;
  public TextView pDx = null;
  public TextView pDy = null;
  public TextView pDz = null;
  
  private e()
  {
    mHasInit = false;
  }
  
  private boolean BS(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(181884);
    if ((this.pDt != null) && (this.pDt.oOD == paramInt) && (this.pDt.getType() == 1))
    {
      AppMethodBeat.o(181884);
      return false;
    }
    if ((paramInt == 2) && (this.pDn != null))
    {
      this.pDn.dismiss();
      X(2, -1, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(181884);
      return bool;
      if ((paramInt == 3) && (this.pDo != null))
      {
        this.pDo.dismiss();
        X(3, -1, -1);
      }
      else if ((paramInt == 4) && (this.pDp != null))
      {
        this.pDp.dismiss();
        X(4, -1, -1);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private void X(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!mHasInit) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt1)
          {
          default: 
            return;
          }
        } while ((this.pDk == null) || (this.pDk.length != 2));
        this.pDk[0] = paramInt2;
        this.pDk[1] = paramInt3;
        return;
      } while ((this.pDl == null) || (this.pDl.length != 2));
      this.pDl[0] = paramInt2;
      this.pDl[1] = paramInt3;
      return;
    } while ((this.pDm == null) || (this.pDm.length != 2));
    this.pDm[0] = paramInt2;
    this.pDm[1] = paramInt3;
  }
  
  private int Y(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(181892);
    if (!mHasInit)
    {
      AppMethodBeat.o(181892);
      return 0;
    }
    boolean bool;
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(181892);
      return 0;
    case 2: 
      bool = B(paramInt2, paramInt3, paramInt2, paramInt3);
    }
    while (bool)
    {
      AppMethodBeat.o(181892);
      return 3;
      if ((this.pDs == null) || (paramInt2 > this.pDs.endPos) || ((paramInt2 == this.pDs.endPos) && (paramInt3 >= this.pDs.pCW)))
      {
        AppMethodBeat.o(181892);
        return 1;
      }
      bool = B(paramInt2, paramInt3, this.pDs.endPos, this.pDs.pCW);
      continue;
      if ((this.pDs == null) || (paramInt2 < this.pDs.dgI) || ((paramInt2 == this.pDs.dgI) && (paramInt3 <= this.pDs.startOffset)))
      {
        AppMethodBeat.o(181892);
        return 1;
      }
      bool = B(this.pDs.dgI, this.pDs.startOffset, paramInt2, paramInt3);
    }
    AppMethodBeat.o(181892);
    return 2;
  }
  
  private static SpannableStringBuilder a(j paramj, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    AppMethodBeat.i(181902);
    if (paramj == null)
    {
      ae.e("EditorSelectManager", "processTextDataItem: textDataItem is null");
      AppMethodBeat.o(181902);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.a.a.abM(paramj.content);
    if (localObject == null)
    {
      ae.e("EditorSelectManager", "processTextDataItem: spannedText is null");
      AppMethodBeat.o(181902);
      return null;
    }
    if (paramBoolean1) {
      paramInt2 = ((Spanned)localObject).length();
    }
    for (;;)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      if ((paramInt1 < 0) || (paramInt1 > ((Spanned)localObject).length()) || (paramInt2 < 0) || (paramInt2 > ((Spanned)localObject).length()) || (paramInt1 > paramInt2))
      {
        ae.e("EditorSelectManager", "processTextDataItem: incorrect offset");
        AppMethodBeat.o(181902);
        return null;
      }
      paramString = (SpannableStringBuilder)((Spanned)localObject).subSequence(0, paramInt1);
      SpannableStringBuilder localSpannableStringBuilder = (SpannableStringBuilder)((Spanned)localObject).subSequence(paramInt1, paramInt2);
      localObject = (SpannableStringBuilder)((Spanned)localObject).subSequence(paramInt2, ((Spanned)localObject).length());
      paramInt1 = paramInt2;
      if (paramBoolean2)
      {
        paramInt2 = paramString.length();
        paramInt1 = paramInt2;
        if (!bu.isNullOrNil(str))
        {
          Spanned localSpanned = com.tencent.mm.plugin.editor.model.nativenote.a.a.abM(str);
          paramInt1 = paramInt2;
          if (localSpanned != null) {
            paramInt1 = paramInt2 + localSpanned.length();
          }
        }
        paramj.content = (com.tencent.mm.plugin.editor.model.nativenote.a.b.a(paramString) + str + com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)localObject));
      }
      if (paramBoolean3) {
        paramj.pAj = true;
      }
      for (paramj.pAl = paramInt1;; paramj.pAl = -1)
      {
        AppMethodBeat.o(181902);
        return localSpannableStringBuilder;
        paramj.pAj = false;
      }
    }
  }
  
  private SpannableStringBuilder a(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(181900);
    d locald = cgg();
    cgj();
    int j = locald.cgd();
    if ((j != 1) && (j != 2))
    {
      ae.e("EditorSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
      AppMethodBeat.o(181900);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().BM(locald.dgI);
    if (localObject == null)
    {
      ae.e("EditorSelectManager", "getAndProcessSelectedDataInSingleSelect: item is null");
      AppMethodBeat.o(181900);
      return null;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1)
    {
      if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramString = a((j)localObject, locald.startOffset, locald.pCW, false, false, "", true);
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().a(paramArrayList, 0, locald.dgI, locald.startOffset, locald.pCW);
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().fh(locald.dgI, locald.dgI + paramArrayList.size() + 1);
        paramArrayList = paramString;
      }
      for (;;)
      {
        AppMethodBeat.o(181900);
        return paramArrayList;
        paramString = a((j)localObject, locald.startOffset, locald.pCW, false, paramBoolean, paramString, true);
        if (this.pDr != null) {
          this.pDr.BH(locald.dgI);
        }
        paramArrayList = paramString;
        if (paramBoolean)
        {
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().cfI();
          paramArrayList = paramString;
        }
      }
    }
    if ((j == 1) && (paramBoolean))
    {
      if (locald.startOffset == 0) {
        i = 1;
      }
      if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
        break label420;
      }
      if (bu.isNullOrNil(paramString)) {
        break label411;
      }
      paramArrayList = new ArrayList();
      localObject = new j();
      ((j)localObject).content = paramString;
      ((j)localObject).pAj = false;
      ((j)localObject).pAl = -1;
      paramArrayList.add(localObject);
    }
    label411:
    label420:
    for (;;)
    {
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().a(paramArrayList, i, locald.dgI, locald.startOffset, locald.pCW);
      paramString = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy();
      i = locald.dgI;
      j = locald.dgI;
      paramString.fh(i - 1, paramArrayList.size() + j + 1);
      paramArrayList = localSpannableStringBuilder;
      break;
      AppMethodBeat.o(181900);
      return localSpannableStringBuilder;
    }
  }
  
  private void a(int paramInt1, RecyclerView paramRecyclerView, View paramView, int paramInt2)
  {
    AppMethodBeat.i(181886);
    if ((!mHasInit) || (paramRecyclerView == null))
    {
      AppMethodBeat.o(181886);
      return;
    }
    paramView = f.dO(paramView);
    if (paramView == null)
    {
      BS(paramInt1);
      AppMethodBeat.o(181886);
      return;
    }
    if (paramView.pCT != null) {
      paramView = paramView.pCT;
    }
    for (;;)
    {
      if (paramView == null)
      {
        BS(paramInt1);
        AppMethodBeat.o(181886);
        return;
        if ((paramView.pCU != null) && (paramView.pCV != null))
        {
          if (paramInt2 == 0)
          {
            paramView = paramView.pCU;
            paramInt2 = 0;
            continue;
          }
          if (paramInt2 == 1)
          {
            paramView = paramView.pCV;
            paramInt2 = 0;
          }
        }
      }
      else
      {
        Object localObject = paramView.getText();
        if ((localObject == null) || (paramInt2 < 0) || (paramInt2 > ((Editable)localObject).length()))
        {
          BS(paramInt1);
          AppMethodBeat.o(181886);
          return;
        }
        localObject = paramView.getLayout();
        if (localObject == null)
        {
          BS(paramInt1);
          AppMethodBeat.o(181886);
          return;
        }
        float f4 = ((Layout)localObject).getPrimaryHorizontal(paramInt2) + paramView.getPaddingLeft();
        int i = paramView.getPaddingTop();
        float f3 = ((Layout)localObject).getLineTop(((Layout)localObject).getLineForOffset(paramInt2)) + i;
        float f1 = f4;
        float f2 = f3;
        boolean bool;
        if (paramView.getEditTextType() != 0)
        {
          f3 = f3 + paramView.getHeight() - this.pCZ;
          if (paramInt1 == 3)
          {
            f1 = f4 + this.pDi;
            f2 = f3;
          }
        }
        else
        {
          localObject = new int[2];
          paramView.getLocationOnScreen((int[])localObject);
          switch (paramInt1)
          {
          default: 
            bool = false;
          }
        }
        for (;;)
        {
          if (!bool) {
            BS(paramInt1);
          }
          AppMethodBeat.o(181886);
          return;
          f1 = f4;
          f2 = f3;
          if (paramInt1 != 4) {
            break;
          }
          f1 = f4 - this.pDi;
          f2 = f3;
          break;
          bool = a(2, paramRecyclerView, this.pDn, (int)(f1 + localObject[0] - this.pDh), (int)(localObject[1] + f2));
          continue;
          bool = a(3, paramRecyclerView, this.pDo, (int)(f1 + localObject[0] - this.pDo.getWidth()), (int)(localObject[1] + f2));
          continue;
          bool = a(4, paramRecyclerView, this.pDp, (int)(f1 + localObject[0]), (int)(localObject[1] + f2));
        }
      }
      paramView = null;
    }
  }
  
  private boolean a(int paramInt1, RecyclerView paramRecyclerView, PopupWindow paramPopupWindow, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(181887);
    if ((!mHasInit) || (paramRecyclerView == null) || (paramPopupWindow == null))
    {
      AppMethodBeat.o(181887);
      return false;
    }
    if ((paramInt3 < p(paramRecyclerView)) || (paramInt3 > this.mScreenHeight - cgf()))
    {
      AppMethodBeat.o(181887);
      return false;
    }
    if (paramPopupWindow.isShowing())
    {
      paramPopupWindow.update(paramInt2, paramInt3, -1, -1, false);
      X(paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      if (paramInt1 == 2)
      {
        cgo();
        this.pDv.ay(3000L, 0L);
      }
      AppMethodBeat.o(181887);
      return true;
      paramPopupWindow.showAtLocation(paramRecyclerView, 0, paramInt2, paramInt3);
      X(paramInt1, paramInt2, paramInt3);
    }
  }
  
  private ArrayList<com.tencent.mm.plugin.editor.model.a.a> b(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList, String paramString)
  {
    AppMethodBeat.i(181901);
    d locald = cgg();
    cgj();
    ArrayList localArrayList = new ArrayList();
    if (locald.cgd() != 3)
    {
      ae.e("EditorSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
      AppMethodBeat.o(181901);
      return null;
    }
    int i = locald.dgI;
    int j = locald.endPos;
    if (j >= locald.dgI)
    {
      Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().BM(j);
      SpannableStringBuilder localSpannableStringBuilder;
      j localj;
      if (localObject != null) {
        if ((j == locald.endPos) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
        {
          localObject = (j)localObject;
          localSpannableStringBuilder = a((j)localObject, 0, locald.pCW, false, paramBoolean, "", false);
          if (!bu.ah(localSpannableStringBuilder))
          {
            localj = new j();
            localj.content = com.tencent.mm.plugin.editor.model.nativenote.a.b.a(localSpannableStringBuilder);
            localj.pAl = -1;
            localj.pAj = false;
            localArrayList.add(localj);
          }
          if ((paramBoolean) && (bu.isNullOrNil(((j)localObject).content))) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().Y(j, true);
          }
        }
      }
      for (;;)
      {
        j -= 1;
        break;
        if ((j == locald.dgI) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
        {
          localObject = (j)localObject;
          localSpannableStringBuilder = a((j)localObject, locald.startOffset, 0, true, paramBoolean, "", false);
          if (!bu.ah(localSpannableStringBuilder))
          {
            localj = new j();
            localj.content = com.tencent.mm.plugin.editor.model.nativenote.a.b.a(localSpannableStringBuilder);
            localj.pAl = -1;
            localj.pAj = false;
            localArrayList.add(localj);
          }
          if ((paramBoolean) && (bu.isNullOrNil(((j)localObject).content))) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().Y(j, true);
          } else {
            i += 1;
          }
        }
        else
        {
          localArrayList.add(com.tencent.mm.plugin.editor.b.a((com.tencent.mm.plugin.editor.model.a.a)localObject));
          if (paramBoolean) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().Y(j, true);
          }
        }
      }
    }
    if (paramBoolean)
    {
      j = i + 1;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().b(i, paramArrayList);
        j = paramArrayList.size() + i;
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().fh(i - 1, j);
      }
    }
    else
    {
      Collections.reverse(localArrayList);
      AppMethodBeat.o(181901);
      return localArrayList;
    }
    paramArrayList = new j();
    if (paramString != null) {}
    for (;;)
    {
      paramArrayList.content = paramString;
      paramArrayList.pAj = false;
      paramArrayList.pAl = -1;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().a(i, paramArrayList);
      break;
      paramString = "";
    }
  }
  
  private boolean cgA()
  {
    AppMethodBeat.i(181910);
    if ((!this.pCY) || (cgd() == 0))
    {
      AppMethodBeat.o(181910);
      return false;
    }
    ak.getContext();
    if (com.tencent.mm.plugin.editor.model.nativenote.manager.b.cfx() != 1)
    {
      AppMethodBeat.o(181910);
      return true;
    }
    AppMethodBeat.o(181910);
    return false;
  }
  
  public static e cge()
  {
    AppMethodBeat.i(181865);
    if (pCX == null) {}
    try
    {
      if (pCX == null) {
        pCX = new e();
      }
      e locale = pCX;
      AppMethodBeat.o(181865);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(181865);
    }
  }
  
  private int cgf()
  {
    AppMethodBeat.i(181867);
    if (this.pDr != null)
    {
      int i = this.pDr.ceO();
      int j = this.pDr.ceP();
      AppMethodBeat.o(181867);
      return i + j;
    }
    AppMethodBeat.o(181867);
    return 0;
  }
  
  private void cgh()
  {
    AppMethodBeat.i(181871);
    B(-1, -1, -1, -1);
    AppMethodBeat.o(181871);
  }
  
  private void cgi()
  {
    AppMethodBeat.i(181873);
    if (this.pDr != null) {
      this.pDr.ceN();
    }
    AppMethodBeat.o(181873);
  }
  
  private void cgo()
  {
    AppMethodBeat.i(181888);
    if (this.pDv == null)
    {
      this.pDv = new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(181858);
          if ((e.this.cgd() == 1) && (e.b(e.this))) {
            e.this.cgl();
          }
          AppMethodBeat.o(181858);
          return true;
        }
      }, false);
      AppMethodBeat.o(181888);
      return;
    }
    this.pDv.stopTimer();
    AppMethodBeat.o(181888);
  }
  
  private void cgp()
  {
    AppMethodBeat.i(181893);
    if (this.pDt == null)
    {
      this.pDt = new b();
      AppMethodBeat.o(181893);
      return;
    }
    this.pDt.reset();
    AppMethodBeat.o(181893);
  }
  
  private void cgq()
  {
    AppMethodBeat.i(181894);
    if (this.pDu == null)
    {
      this.pDu = new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(181860);
          ae.d("EditorSelectManager", "onTimerExpired: ");
          RecyclerView localRecyclerView = e.a(e.this);
          int i;
          int j;
          if ((e.c(e.this) != null) && (e.c(e.this).pCM < e.a(e.this, localRecyclerView)))
          {
            i = 1;
            if ((e.c(e.this) == null) || (e.c(e.this).pCM <= e.d(e.this))) {
              break label206;
            }
            j = 1;
            label89:
            if ((!e.cgB()) || (localRecyclerView == null) || (e.c(e.this) == null) || (e.c(e.this).getType() != 1) || ((i == 0) && (j == 0))) {
              break label256;
            }
            if ((i == 0) || (!localRecyclerView.canScrollVertically(-1))) {
              break label211;
            }
            if (e.c(e.this).oOD == 3) {
              e.e(e.this);
            }
            e.f(e.this);
            e.this.cgn();
            e.this.cgl();
            localRecyclerView.a(0, -300, null);
          }
          label256:
          for (;;)
          {
            AppMethodBeat.o(181860);
            return true;
            i = 0;
            break;
            label206:
            j = 0;
            break label89;
            label211:
            if ((j != 0) && (localRecyclerView.canScrollVertically(1)))
            {
              e.f(e.this);
              e.this.cgn();
              e.this.cgl();
              localRecyclerView.a(0, 300, null);
              continue;
              if (e.g(e.this) != null) {
                e.g(e.this).stopTimer();
              }
            }
          }
        }
      }, true);
      AppMethodBeat.o(181894);
      return;
    }
    this.pDu.stopTimer();
    AppMethodBeat.o(181894);
  }
  
  private int cgr()
  {
    AppMethodBeat.i(181896);
    int j = 0;
    if (this.pDr != null) {
      j = this.pDr.ceO();
    }
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.pDr != null) {
        i = this.pDr.ceP();
      }
    }
    j = i;
    if (i == 0) {
      j = 150;
    }
    i = this.mScreenHeight;
    AppMethodBeat.o(181896);
    return i - j;
  }
  
  private void cgs()
  {
    AppMethodBeat.i(181898);
    if (this.pDr != null) {
      this.pDr.ceM();
    }
    AppMethodBeat.o(181898);
  }
  
  private boolean cgu()
  {
    AppMethodBeat.i(181903);
    boolean bool1 = o(this.pDw, false);
    boolean bool2 = o(this.pDx, false);
    boolean bool3 = o(this.pDy, cgv());
    boolean bool4 = o(this.pDz, cgw());
    boolean bool5 = o(this.pDA, cgx());
    boolean bool6 = o(this.pDB, cgy());
    boolean bool7 = o(this.pDC, cgz());
    boolean bool8 = o(this.pDD, cgA());
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5) || (bool6) || (bool7) || (bool8))
    {
      AppMethodBeat.o(181903);
      return true;
    }
    AppMethodBeat.o(181903);
    return false;
  }
  
  private boolean cgv()
  {
    AppMethodBeat.i(181905);
    if (cgd() != 1)
    {
      AppMethodBeat.o(181905);
      return false;
    }
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().BM(this.pDs.dgI);
    if ((locala != null) && ((com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().size() > 1) || (locala.getType() != 1) || (!bu.isNullOrNil(((j)locala).content))))
    {
      AppMethodBeat.o(181905);
      return true;
    }
    AppMethodBeat.o(181905);
    return false;
  }
  
  private boolean cgw()
  {
    AppMethodBeat.i(181906);
    int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().cfJ();
    int j = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().cfK();
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().BM(i);
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().BM(j);
    if ((localObject == null) || (locala == null))
    {
      AppMethodBeat.o(181906);
      return false;
    }
    if ((this.pDs != null) && (this.pDs.dgI == i) && (this.pDs.startOffset == 0) && (this.pDs.endPos == j)) {
      if (locala.getType() == 1)
      {
        localObject = com.tencent.mm.plugin.editor.model.nativenote.a.a.abM(((j)locala).content);
        if (localObject == null)
        {
          AppMethodBeat.o(181906);
          return false;
        }
        if (this.pDs.pCW == ((Spanned)localObject).length())
        {
          AppMethodBeat.o(181906);
          return false;
        }
      }
      else if ((locala.getType() != 1) && (this.pDs.pCW == 1))
      {
        AppMethodBeat.o(181906);
        return false;
      }
    }
    AppMethodBeat.o(181906);
    return true;
  }
  
  private boolean cgx()
  {
    boolean bool2 = true;
    AppMethodBeat.i(181907);
    if (!this.pCY)
    {
      AppMethodBeat.o(181907);
      return false;
    }
    int i = cgd();
    if ((i == 0) || (i == 1))
    {
      AppMethodBeat.o(181907);
      return false;
    }
    boolean bool1 = bool2;
    if (this.pDr != null) {
      if (this.pDr.ceQ()) {
        break label76;
      }
    }
    label76:
    for (bool1 = bool2;; bool1 = false)
    {
      AppMethodBeat.o(181907);
      return bool1;
    }
  }
  
  private boolean cgy()
  {
    AppMethodBeat.i(181908);
    int i = cgd();
    if ((this.pCY) && ((i == 2) || (i == 3)))
    {
      AppMethodBeat.o(181908);
      return true;
    }
    AppMethodBeat.o(181908);
    return false;
  }
  
  private boolean cgz()
  {
    AppMethodBeat.i(181909);
    int i = cgd();
    if ((i == 2) || (i == 3))
    {
      AppMethodBeat.o(181909);
      return true;
    }
    AppMethodBeat.o(181909);
    return false;
  }
  
  private RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(181866);
    if (this.pDr != null)
    {
      RecyclerView localRecyclerView = this.pDr.ceR();
      AppMethodBeat.o(181866);
      return localRecyclerView;
    }
    AppMethodBeat.o(181866);
    return null;
  }
  
  public static void i(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(181897);
    if (paramTextView != null) {
      paramTextView.setTextSize(1, paramInt);
    }
    AppMethodBeat.o(181897);
  }
  
  private boolean i(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181889);
    if ((!mHasInit) || (paramRecyclerView == null) || (this.pDq == null))
    {
      AppMethodBeat.o(181889);
      return false;
    }
    if ((paramInt2 < p(paramRecyclerView)) || (paramInt2 > this.mScreenHeight - cgf()))
    {
      AppMethodBeat.o(181889);
      return false;
    }
    if (this.pDq.isShowing()) {
      this.pDq.update(paramInt1, paramInt2, -1, -1, false);
    }
    for (;;)
    {
      AppMethodBeat.o(181889);
      return true;
      this.pDq.showAtLocation(paramRecyclerView, 0, paramInt1, paramInt2);
    }
  }
  
  public static boolean isEnabled()
  {
    return mHasInit;
  }
  
  private void kl(boolean paramBoolean)
  {
    AppMethodBeat.i(181891);
    if ((!mHasInit) || (this.pDn == null) || (this.pDo == null) || (this.pDp == null) || (this.pDs == null))
    {
      AppMethodBeat.o(181891);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    if (localRecyclerView == null)
    {
      AppMethodBeat.o(181891);
      return;
    }
    if ((this.pDt == null) || (this.pDt.getType() != 1))
    {
      AppMethodBeat.o(181891);
      return;
    }
    int k = this.pDt.oOD;
    if ((k != 2) && (k != 3) && (k != 4))
    {
      AppMethodBeat.o(181891);
      return;
    }
    float f2 = this.pDt.pCL - this.pDt.cNQ;
    float f1 = this.pDt.pCM;
    float f3 = this.pDt.cNR;
    f3 = this.pCZ / 2 + (f1 - f3);
    View localView;
    Object localObject2;
    Object localObject1;
    int i;
    if (k == 2)
    {
      f1 = f2 + this.pDn.getWidth() / 2;
      localRecyclerView.getLocationOnScreen(this.pDj);
      localView = localRecyclerView.o(f1 - this.pDj[0], f3 - this.pDj[1]);
      localObject2 = f.dO(localView);
      localObject1 = null;
      if (localObject2 != null) {
        break label301;
      }
      i = 2;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(181891);
        return;
        f1 = f2;
        if (k != 3) {
          break;
        }
        f1 = f2 + this.pDo.getWidth();
        break;
        if (((c)localObject2).pCT != null)
        {
          localObject1 = ((c)localObject2).pCT;
          localObject2 = new int[2];
          ((WXRTEditText)localObject1).getLocationOnScreen((int[])localObject2);
          i = ((WXRTEditText)localObject1).getOffsetForPosition(f1 - localObject2[0], f3 - localObject2[1]);
          i = Y(k, ((WXRTEditText)localObject1).getPosInDataList(), i);
        }
        else if ((((c)localObject2).pCU != null) && (((c)localObject2).pCV != null))
        {
          if (k == 3)
          {
            localObject2 = ((c)localObject2).pCU;
            j = Y(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.pDo, (int)(this.pDt.pCL - this.pDt.cNQ), (int)(this.pDt.pCM - this.pDt.cNR));
              i = j;
              localObject1 = localObject2;
            }
          }
          else if (k == 4)
          {
            localObject2 = ((c)localObject2).pCV;
            j = Y(k, ((WXRTEditText)localObject2).getPosInDataList(), 1);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.pDp, (int)(this.pDt.pCL - this.pDt.cNQ), (int)(this.pDt.pCM - this.pDt.cNR));
              i = j;
              localObject1 = localObject2;
            }
          }
          else
          {
            localObject1 = new int[2];
            localView.getLocationOnScreen((int[])localObject1);
            if (f1 > localObject1[0] + localView.getWidth() / 2) {
              break label717;
            }
            localObject2 = ((c)localObject2).pCU;
          }
          for (int j = Y(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);; j = Y(k, ((WXRTEditText)localObject2).getPosInDataList(), 1))
          {
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.pDn, (int)(this.pDt.pCL - this.pDt.cNQ), (int)(this.pDt.pCM - this.pDt.cNR));
              localObject1 = localObject2;
              i = j;
            }
            break;
            localObject2 = ((c)localObject2).pCV;
          }
        }
        break;
      case 1: 
        i = 0;
      case 2: 
      case 3: 
        label301:
        label717:
        while (i != 0)
        {
          if ((!paramBoolean) || ((this.pDt.pCM >= p(localRecyclerView)) && (this.pDt.pCM <= cgr())) || ((this.pDu != null) && (!this.pDu.foU()))) {
            break label1166;
          }
          cgq();
          this.pDu.ay(100L, 100L);
          AppMethodBeat.o(181891);
          return;
          i = 1;
          continue;
          localObject2 = ((WXRTEditText)localObject1).getText();
          i = cgd();
          if ((this.pCY) && (localObject2 != null) && (i == 1))
          {
            if (!((WXRTEditText)localObject1).hasFocus()) {
              ((WXRTEditText)localObject1).requestFocus();
            }
            if ((((WXRTEditText)localObject1).getEditTextType() == 1) || (((WXRTEditText)localObject1).getEditTextType() == 2))
            {
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
              ((WXRTEditText)localObject1).setSelection(0);
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
              if ((i == 3) || (i == 0)) {
                cgi();
              }
              cgl();
              f(true, 0L);
              if (k != 4) {
                break label1150;
              }
            }
          }
          label1150:
          for (i = this.pDs.pCW;; i = this.pDs.startOffset)
          {
            a(k, localRecyclerView, localView, i);
            i = 1;
            break;
            if (this.pDs.startOffset > ((Editable)localObject2).length()) {
              break label915;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.pDs.startOffset);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label915;
            if ((!this.pCY) || (localObject2 == null) || (i != 2) || (!((WXRTEditText)localObject1).hasFocus())) {
              break label915;
            }
            if ((((WXRTEditText)localObject1).getEditTextType() == 1) || (((WXRTEditText)localObject1).getEditTextType() == 2))
            {
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
              ((WXRTEditText)localObject1).setSelection(0);
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
              break label915;
            }
            if ((this.pDs.startOffset > ((Editable)localObject2).length()) || (this.pDs.pCW > ((Editable)localObject2).length())) {
              break label915;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.pDs.startOffset, this.pDs.pCW);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label915;
          }
        }
        label915:
        cgq();
        label1166:
        AppMethodBeat.o(181891);
        return;
        i = 0;
      }
    }
  }
  
  private static boolean o(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(181904);
    if (paramView == null)
    {
      AppMethodBeat.o(181904);
      return false;
    }
    if (paramBoolean)
    {
      paramView.setVisibility(0);
      AppMethodBeat.o(181904);
      return true;
    }
    paramView.setVisibility(8);
    AppMethodBeat.o(181904);
    return false;
  }
  
  private int p(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(181895);
    int j = 150;
    int i = j;
    if (paramRecyclerView != null)
    {
      paramRecyclerView.getLocationOnScreen(this.pDj);
      i = j;
      if (y(this.pDj)) {
        i = this.pDj[1];
      }
    }
    AppMethodBeat.o(181895);
    return i;
  }
  
  private static boolean y(int[] paramArrayOfInt)
  {
    return (mHasInit) && (paramArrayOfInt != null) && (paramArrayOfInt.length == 2) && (paramArrayOfInt[0] != -1) && (paramArrayOfInt[1] != -1);
  }
  
  public final boolean B(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(181870);
    if (!mHasInit)
    {
      AppMethodBeat.o(181870);
      return false;
    }
    boolean bool;
    if (this.pDs == null)
    {
      this.pDs = new d(paramInt1, paramInt2, paramInt3, paramInt4);
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        ae.d("EditorSelectManager", "setSelectInfo: %d:%d - %d:%d", new Object[] { Integer.valueOf(this.pDs.dgI), Integer.valueOf(this.pDs.startOffset), Integer.valueOf(this.pDs.endPos), Integer.valueOf(this.pDs.pCW) });
      }
      AppMethodBeat.o(181870);
      return bool;
      if ((this.pDs.dgI != paramInt1) || (this.pDs.startOffset != paramInt2) || (this.pDs.endPos != paramInt3) || (this.pDs.pCW != paramInt4))
      {
        this.pDs.set(paramInt1, paramInt2, paramInt3, paramInt4);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final int BR(int paramInt)
  {
    AppMethodBeat.i(181872);
    if ((!mHasInit) || (this.pDs == null))
    {
      AppMethodBeat.o(181872);
      return 0;
    }
    if ((cgd() == 0) || (paramInt < this.pDs.dgI) || (paramInt > this.pDs.endPos))
    {
      AppMethodBeat.o(181872);
      return 0;
    }
    if ((paramInt == this.pDs.dgI) && (paramInt == this.pDs.endPos))
    {
      AppMethodBeat.o(181872);
      return 1;
    }
    if ((paramInt > this.pDs.dgI) && (paramInt < this.pDs.endPos))
    {
      AppMethodBeat.o(181872);
      return 2;
    }
    if ((paramInt == this.pDs.dgI) && (paramInt < this.pDs.endPos))
    {
      AppMethodBeat.o(181872);
      return 4;
    }
    if ((paramInt > this.pDs.dgI) && (paramInt == this.pDs.endPos))
    {
      AppMethodBeat.o(181872);
      return 3;
    }
    AppMethodBeat.o(181872);
    return 0;
  }
  
  public final void J(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(181875);
    if (!mHasInit)
    {
      AppMethodBeat.o(181875);
      return;
    }
    cgn();
    cgl();
    f(true, 50L);
    kk(paramBoolean1);
    ki(paramBoolean2);
    AppMethodBeat.o(181875);
  }
  
  public final void a(int paramInt, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(181890);
    if ((!mHasInit) || (this.mHandler == null))
    {
      AppMethodBeat.o(181890);
      return;
    }
    if ((this.pDt != null) && (this.pDt.getType() == 1) && (this.pDt.oOD != paramInt))
    {
      AppMethodBeat.o(181890);
      return;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(181890);
      return;
      cgp();
      if (!cgk()) {
        kj(true);
      }
      this.pDt.a(paramInt, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), 0);
      AppMethodBeat.o(181890);
      return;
      if ((this.pDt != null) && (this.pDt.getType() == 1))
      {
        this.pDt.pCL = paramMotionEvent.getRawX();
        this.pDt.pCM = paramMotionEvent.getRawY();
        kl(true);
        AppMethodBeat.o(181890);
        return;
        cgp();
        this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(181859);
            e.this.kk(true);
            e.this.kj(true);
            AppMethodBeat.o(181859);
          }
        }, 200L);
      }
    }
  }
  
  public final void a(View paramView1, View paramView2, View paramView3, int paramInt)
  {
    AppMethodBeat.i(181877);
    if ((!mHasInit) || (paramView1 == null) || (paramView2 == null) || (paramView3 == null) || (this.pDs == null))
    {
      AppMethodBeat.o(181877);
      return;
    }
    switch (BR(paramInt))
    {
    }
    do
    {
      paramView1.setVisibility(8);
      paramView2.setVisibility(4);
      paramView3.setVisibility(4);
      AppMethodBeat.o(181877);
      return;
      paramView1.setVisibility(8);
      paramView2.setVisibility(4);
      paramView3.setVisibility(4);
      AppMethodBeat.o(181877);
      return;
      if (this.pDs.startOffset == this.pDs.pCW) {
        paramView1.setVisibility(8);
      }
      for (;;)
      {
        paramView2.setVisibility(4);
        paramView3.setVisibility(4);
        AppMethodBeat.o(181877);
        return;
        paramView1.setVisibility(0);
      }
      paramView1.setVisibility(0);
      paramView2.setVisibility(0);
      paramView3.setVisibility(0);
      AppMethodBeat.o(181877);
      return;
      if (this.pDs.startOffset == 0)
      {
        paramView1.setVisibility(0);
        paramView2.setVisibility(4);
        paramView3.setVisibility(0);
        AppMethodBeat.o(181877);
        return;
      }
      paramView1.setVisibility(8);
      paramView2.setVisibility(4);
      paramView3.setVisibility(4);
      AppMethodBeat.o(181877);
      return;
    } while (this.pDs.pCW == 0);
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
    paramView3.setVisibility(4);
    AppMethodBeat.o(181877);
  }
  
  public final int cgd()
  {
    AppMethodBeat.i(181868);
    if (!mHasInit)
    {
      AppMethodBeat.o(181868);
      return 0;
    }
    if (this.pDs == null) {
      this.pDs = new d();
    }
    int i = this.pDs.cgd();
    AppMethodBeat.o(181868);
    return i;
  }
  
  public final d cgg()
  {
    AppMethodBeat.i(181869);
    if (!mHasInit)
    {
      locald = new d();
      AppMethodBeat.o(181869);
      return locald;
    }
    if (this.pDs == null) {
      this.pDs = new d();
    }
    d locald = new d(this.pDs.dgI, this.pDs.startOffset, this.pDs.endPos, this.pDs.pCW);
    AppMethodBeat.o(181869);
    return locald;
  }
  
  public final void cgj()
  {
    AppMethodBeat.i(181874);
    if (!mHasInit)
    {
      AppMethodBeat.o(181874);
      return;
    }
    cgh();
    f(true, 0L);
    cgn();
    cgl();
    AppMethodBeat.o(181874);
  }
  
  public final boolean cgk()
  {
    AppMethodBeat.i(181878);
    if ((this.pDq != null) && (this.pDq.isShowing()))
    {
      AppMethodBeat.o(181878);
      return true;
    }
    AppMethodBeat.o(181878);
    return false;
  }
  
  public final void cgl()
  {
    AppMethodBeat.i(181879);
    if (this.pDq != null) {
      this.pDq.dismiss();
    }
    AppMethodBeat.o(181879);
  }
  
  public final boolean cgm()
  {
    AppMethodBeat.i(181882);
    if ((this.pDn != null) && (this.pDn.isShowing()))
    {
      AppMethodBeat.o(181882);
      return true;
    }
    AppMethodBeat.o(181882);
    return false;
  }
  
  public final void cgn()
  {
    AppMethodBeat.i(181883);
    if (!mHasInit)
    {
      AppMethodBeat.o(181883);
      return;
    }
    BS(2);
    BS(3);
    BS(4);
    AppMethodBeat.o(181883);
  }
  
  public final void cgt()
  {
    AppMethodBeat.i(181899);
    ae.i("EditorSelectManager", "deleteSelectedData");
    if (!mHasInit)
    {
      ae.e("EditorSelectManager", "deleteSelectedData: not init");
      AppMethodBeat.o(181899);
      return;
    }
    cgl();
    int i = cgd();
    if (i == 2)
    {
      a(true, null, "");
      AppMethodBeat.o(181899);
      return;
    }
    if (i == 3)
    {
      b(true, null, "");
      AppMethodBeat.o(181899);
      return;
    }
    ae.e("EditorSelectManager", "deleteSelectedData: not in select");
    cgs();
    AppMethodBeat.o(181899);
  }
  
  public final void f(final boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(181876);
    if ((!mHasInit) || (this.mHandler == null))
    {
      AppMethodBeat.o(181876);
      return;
    }
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181852);
        RecyclerView localRecyclerView = e.a(e.this);
        if (localRecyclerView == null)
        {
          AppMethodBeat.o(181852);
          return;
        }
        int i = 0;
        if (i < localRecyclerView.getChildCount())
        {
          Object localObject = localRecyclerView.getChildAt(i);
          c localc = f.dO((View)localObject);
          if (localc != null)
          {
            if (localc.pCT == null) {
              break label78;
            }
            if (paramBoolean) {
              localc.pCT.postInvalidate();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label78:
            if ((localc.pCU != null) && (localc.pCV != null))
            {
              LinearLayout localLinearLayout1 = (LinearLayout)((View)localObject).findViewById(2131303103);
              LinearLayout localLinearLayout2 = (LinearLayout)((View)localObject).findViewById(2131303110);
              localObject = (LinearLayout)((View)localObject).findViewById(2131303105);
              e.this.a(localLinearLayout1, localLinearLayout2, (View)localObject, localc.pCU.getPosInDataList());
            }
          }
        }
        AppMethodBeat.o(181852);
      }
    }, paramLong);
    AppMethodBeat.o(181876);
  }
  
  public final boolean isEditable()
  {
    return (mHasInit) && (this.pCY);
  }
  
  public final void ki(final boolean paramBoolean)
  {
    AppMethodBeat.i(181880);
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181857);
        e.this.kj(paramBoolean);
        AppMethodBeat.o(181857);
      }
    }, 50L);
    AppMethodBeat.o(181880);
  }
  
  public final void kj(boolean paramBoolean)
  {
    AppMethodBeat.i(181881);
    if ((!mHasInit) || (this.pDq == null))
    {
      AppMethodBeat.o(181881);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = cgd();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)) || ((this.pDt != null) && (this.pDt.getType() == 1)))
    {
      cgl();
      AppMethodBeat.o(181881);
      return;
    }
    if (!cgu())
    {
      cgl();
      AppMethodBeat.o(181881);
      return;
    }
    int i1 = -1;
    int i2 = -1000;
    int i4 = p(localRecyclerView);
    int i5 = cgr();
    int k = 0;
    int m = 0;
    i = m;
    int j = k;
    if (this.pDq != null)
    {
      i = m;
      j = k;
      if (this.pDq.getContentView() != null)
      {
        this.pDq.getContentView().measure(0, 0);
        i = this.pDq.getContentView().getMeasuredHeight();
        j = this.pDc * 2 + i;
        i = this.pDq.getContentView().getMeasuredWidth() + this.pDc * 2;
      }
    }
    int i3;
    int n;
    if (j == 0)
    {
      i3 = this.pDe;
      if (i != 0) {
        break label414;
      }
      n = this.pDf;
      label229:
      if ((this.pDn == null) || (!this.pDn.isShowing()) || (!y(this.pDk))) {
        break label458;
      }
      j = this.pDk[1] - i3;
      i = this.pDk[1] + this.pDn.getHeight() - this.pDg;
      if ((j < i4) || (j > i5)) {
        break label420;
      }
      k = this.pDk[0];
      i = j;
      j = k;
    }
    for (;;)
    {
      label311:
      k = i;
      if (i == -1)
      {
        Object localObject = localRecyclerView.getLayoutManager();
        if ((localObject == null) || (!(localObject instanceof LinearLayoutManager))) {
          break label911;
        }
        localObject = (LinearLayoutManager)localObject;
        j = ((LinearLayoutManager)localObject).km();
        k = ((LinearLayoutManager)localObject).ko();
        if ((this.pDs.dgI > j) || (this.pDs.endPos < k)) {
          break label911;
        }
        k = 300;
        j = -1000;
      }
      for (;;)
      {
        if (k == -1)
        {
          cgl();
          AppMethodBeat.o(181881);
          return;
          i3 = j;
          break;
          label414:
          n = i;
          break label229;
          label420:
          m = i2;
          k = i1;
          if (i < i4) {
            break label921;
          }
          m = i2;
          k = i1;
          if (i > i5) {
            break label921;
          }
          j = this.pDk[0];
          break label311;
          label458:
          i = i2;
          j = i1;
          if (this.pDo != null)
          {
            i = i2;
            j = i1;
            if (this.pDo.isShowing())
            {
              i = i2;
              j = i1;
              if (y(this.pDl))
              {
                j = this.pDl[1] - i3;
                k = this.pDl[1] + this.pDo.getHeight() - this.pDg;
                if ((j < i4) || (j > i5)) {
                  break label662;
                }
                i = this.pDl[0];
              }
            }
          }
          for (;;)
          {
            m = i;
            k = j;
            if (this.pDp == null) {
              break label921;
            }
            m = i;
            k = j;
            if (!this.pDp.isShowing()) {
              break label921;
            }
            m = i;
            k = j;
            if (!y(this.pDm)) {
              break label921;
            }
            k = this.pDm[1] - i3;
            i1 = this.pDm[1] + this.pDp.getHeight() - this.pDg;
            if (j != -1) {
              break label740;
            }
            if ((k < i4) || (k > i5)) {
              break label701;
            }
            j = this.pDm[0];
            i = k;
            break;
            label662:
            i = i2;
            j = i1;
            if (k >= i4)
            {
              i = i2;
              j = i1;
              if (k <= i5)
              {
                i = this.pDl[0];
                j = k;
              }
            }
          }
          label701:
          m = i;
          k = j;
          if (i1 < i4) {
            break label921;
          }
          m = i;
          k = j;
          if (i1 > i5) {
            break label921;
          }
          j = this.pDm[0];
          i = i1;
          break label311;
          label740:
          m = i;
          k = j;
          if (j + i3 <= this.pDm[1]) {
            break label921;
          }
          m = i;
          k = j;
          if (i1 < i4) {
            break label921;
          }
          m = i;
          k = j;
          if (i1 > i5) {
            break label921;
          }
          j = this.pDm[0];
          i = i1;
          break label311;
        }
        i = this.mScreenWidth / 3;
        m = this.mScreenWidth * 2 / 3;
        if ((j == -1000) || ((j >= i) && (j <= m)))
        {
          i(localRecyclerView, (this.mScreenWidth - n) / 2, k);
          AppMethodBeat.o(181881);
          return;
        }
        if (j < i)
        {
          i(localRecyclerView, this.pDd, k);
          AppMethodBeat.o(181881);
          return;
        }
        i(localRecyclerView, this.mScreenWidth - n - this.pDd, k);
        AppMethodBeat.o(181881);
        return;
        label911:
        j = -1000;
        k = i;
      }
      label921:
      j = m;
      i = k;
    }
  }
  
  public final void kk(boolean paramBoolean)
  {
    AppMethodBeat.i(181885);
    if (!mHasInit)
    {
      AppMethodBeat.o(181885);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = cgd();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)))
    {
      cgn();
      AppMethodBeat.o(181885);
      return;
    }
    View localView1 = f.e(localRecyclerView, this.pDs.dgI);
    View localView2 = f.e(localRecyclerView, this.pDs.endPos);
    if (i == 1)
    {
      BS(3);
      BS(4);
      a(2, localRecyclerView, localView1, this.pDs.startOffset);
      AppMethodBeat.o(181885);
      return;
    }
    BS(2);
    a(3, localRecyclerView, localView1, this.pDs.startOffset);
    a(4, localRecyclerView, localView2, this.pDs.pCW);
    AppMethodBeat.o(181885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.c.e
 * JD-Core Version:    0.7.0.1
 */