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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collections;

public final class e
  implements a.a
{
  public static boolean mHasInit = false;
  public static volatile e opj = null;
  public ap mHandler = null;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public PopupWindow opA = null;
  public PopupWindow opB = null;
  public PopupWindow opC = null;
  public com.tencent.mm.plugin.editor.model.nativenote.b.a opD = null;
  public d opE = null;
  public b opF = null;
  public av opG = null;
  public av opH = null;
  public TextView opI = null;
  public TextView opJ = null;
  public TextView opK = null;
  public TextView opL = null;
  public TextView opM = null;
  public TextView opN = null;
  public TextView opO = null;
  public TextView opP = null;
  public boolean opk = true;
  public int opl = 0;
  public int opm = 0;
  public int opn = 14;
  public int opo = 0;
  public int opp = 0;
  public int opq = 0;
  public int opr = 0;
  public int ops = 0;
  public int opt = 0;
  public int opu = 0;
  public int[] opv = null;
  public int[] opw = null;
  public int[] opx = null;
  public int[] opy = null;
  public PopupWindow opz = null;
  
  private e()
  {
    mHasInit = false;
  }
  
  private boolean Ag(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(181884);
    if ((this.opF != null) && (this.opF.nBH == paramInt) && (this.opF.getType() == 1))
    {
      AppMethodBeat.o(181884);
      return false;
    }
    if ((paramInt == 2) && (this.opz != null))
    {
      this.opz.dismiss();
      U(2, -1, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(181884);
      return bool;
      if ((paramInt == 3) && (this.opA != null))
      {
        this.opA.dismiss();
        U(3, -1, -1);
      }
      else if ((paramInt == 4) && (this.opB != null))
      {
        this.opB.dismiss();
        U(4, -1, -1);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private void U(int paramInt1, int paramInt2, int paramInt3)
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
        } while ((this.opw == null) || (this.opw.length != 2));
        this.opw[0] = paramInt2;
        this.opw[1] = paramInt3;
        return;
      } while ((this.opx == null) || (this.opx.length != 2));
      this.opx[0] = paramInt2;
      this.opx[1] = paramInt3;
      return;
    } while ((this.opy == null) || (this.opy.length != 2));
    this.opy[0] = paramInt2;
    this.opy[1] = paramInt3;
  }
  
  private int V(int paramInt1, int paramInt2, int paramInt3)
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
      bool = A(paramInt2, paramInt3, paramInt2, paramInt3);
    }
    while (bool)
    {
      AppMethodBeat.o(181892);
      return 3;
      if ((this.opE == null) || (paramInt2 > this.opE.endPos) || ((paramInt2 == this.opE.endPos) && (paramInt3 >= this.opE.opi)))
      {
        AppMethodBeat.o(181892);
        return 1;
      }
      bool = A(paramInt2, paramInt3, this.opE.endPos, this.opE.opi);
      continue;
      if ((this.opE == null) || (paramInt2 < this.opE.cWU) || ((paramInt2 == this.opE.cWU) && (paramInt3 <= this.opE.startOffset)))
      {
        AppMethodBeat.o(181892);
        return 1;
      }
      bool = A(this.opE.cWU, this.opE.startOffset, paramInt2, paramInt3);
    }
    AppMethodBeat.o(181892);
    return 2;
  }
  
  private static SpannableStringBuilder a(j paramj, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    AppMethodBeat.i(181902);
    if (paramj == null)
    {
      ad.e("EditorSelectManager", "processTextDataItem: textDataItem is null");
      AppMethodBeat.o(181902);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.a.a.Tc(paramj.content);
    if (localObject == null)
    {
      ad.e("EditorSelectManager", "processTextDataItem: spannedText is null");
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
        ad.e("EditorSelectManager", "processTextDataItem: incorrect offset");
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
        if (!bt.isNullOrNil(str))
        {
          Spanned localSpanned = com.tencent.mm.plugin.editor.model.nativenote.a.a.Tc(str);
          paramInt1 = paramInt2;
          if (localSpanned != null) {
            paramInt1 = paramInt2 + localSpanned.length();
          }
        }
        paramj.content = (com.tencent.mm.plugin.editor.model.nativenote.a.b.a(paramString) + str + com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)localObject));
      }
      if (paramBoolean3) {
        paramj.omv = true;
      }
      for (paramj.omx = paramInt1;; paramj.omx = -1)
      {
        AppMethodBeat.o(181902);
        return localSpannableStringBuilder;
        paramj.omv = false;
      }
    }
  }
  
  private SpannableStringBuilder a(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(181900);
    d locald = bSY();
    bTb();
    int j = locald.bSV();
    if ((j != 1) && (j != 2))
    {
      ad.e("EditorSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
      AppMethodBeat.o(181900);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().Aa(locald.cWU);
    if (localObject == null)
    {
      ad.e("EditorSelectManager", "getAndProcessSelectedDataInSingleSelect: item is null");
      AppMethodBeat.o(181900);
      return null;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1)
    {
      if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramString = a((j)localObject, locald.startOffset, locald.opi, false, false, "", true);
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().a(paramArrayList, 0, locald.cWU, locald.startOffset, locald.opi);
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().eZ(locald.cWU, locald.cWU + paramArrayList.size() + 1);
        paramArrayList = paramString;
      }
      for (;;)
      {
        AppMethodBeat.o(181900);
        return paramArrayList;
        paramString = a((j)localObject, locald.startOffset, locald.opi, false, paramBoolean, paramString, true);
        if (this.opD != null) {
          this.opD.zV(locald.cWU);
        }
        paramArrayList = paramString;
        if (paramBoolean)
        {
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().bSA();
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
      if (bt.isNullOrNil(paramString)) {
        break label411;
      }
      paramArrayList = new ArrayList();
      localObject = new j();
      ((j)localObject).content = paramString;
      ((j)localObject).omv = false;
      ((j)localObject).omx = -1;
      paramArrayList.add(localObject);
    }
    label411:
    label420:
    for (;;)
    {
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().a(paramArrayList, i, locald.cWU, locald.startOffset, locald.opi);
      paramString = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq();
      i = locald.cWU;
      j = locald.cWU;
      paramString.eZ(i - 1, paramArrayList.size() + j + 1);
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
    paramView = f.dJ(paramView);
    if (paramView == null)
    {
      Ag(paramInt1);
      AppMethodBeat.o(181886);
      return;
    }
    if (paramView.opf != null) {
      paramView = paramView.opf;
    }
    for (;;)
    {
      if (paramView == null)
      {
        Ag(paramInt1);
        AppMethodBeat.o(181886);
        return;
        if ((paramView.opg != null) && (paramView.oph != null))
        {
          if (paramInt2 == 0)
          {
            paramView = paramView.opg;
            paramInt2 = 0;
            continue;
          }
          if (paramInt2 == 1)
          {
            paramView = paramView.oph;
            paramInt2 = 0;
          }
        }
      }
      else
      {
        Object localObject = paramView.getText();
        if ((localObject == null) || (paramInt2 < 0) || (paramInt2 > ((Editable)localObject).length()))
        {
          Ag(paramInt1);
          AppMethodBeat.o(181886);
          return;
        }
        localObject = paramView.getLayout();
        if (localObject == null)
        {
          Ag(paramInt1);
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
          f3 = f3 + paramView.getHeight() - this.opl;
          if (paramInt1 == 3)
          {
            f1 = f4 + this.opu;
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
            Ag(paramInt1);
          }
          AppMethodBeat.o(181886);
          return;
          f1 = f4;
          f2 = f3;
          if (paramInt1 != 4) {
            break;
          }
          f1 = f4 - this.opu;
          f2 = f3;
          break;
          bool = a(2, paramRecyclerView, this.opz, (int)(f1 + localObject[0] - this.opt), (int)(localObject[1] + f2));
          continue;
          bool = a(3, paramRecyclerView, this.opA, (int)(f1 + localObject[0] - this.opA.getWidth()), (int)(localObject[1] + f2));
          continue;
          bool = a(4, paramRecyclerView, this.opB, (int)(f1 + localObject[0]), (int)(localObject[1] + f2));
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
    if ((paramInt3 < p(paramRecyclerView)) || (paramInt3 > this.mScreenHeight - bSX()))
    {
      AppMethodBeat.o(181887);
      return false;
    }
    if (paramPopupWindow.isShowing())
    {
      paramPopupWindow.update(paramInt2, paramInt3, -1, -1, false);
      U(paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      if (paramInt1 == 2)
      {
        bTg();
        this.opH.av(3000L, 0L);
      }
      AppMethodBeat.o(181887);
      return true;
      paramPopupWindow.showAtLocation(paramRecyclerView, 0, paramInt2, paramInt3);
      U(paramInt1, paramInt2, paramInt3);
    }
  }
  
  private ArrayList<com.tencent.mm.plugin.editor.model.a.a> b(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList, String paramString)
  {
    AppMethodBeat.i(181901);
    d locald = bSY();
    bTb();
    ArrayList localArrayList = new ArrayList();
    if (locald.bSV() != 3)
    {
      ad.e("EditorSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
      AppMethodBeat.o(181901);
      return null;
    }
    int i = locald.cWU;
    int j = locald.endPos;
    if (j >= locald.cWU)
    {
      Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().Aa(j);
      SpannableStringBuilder localSpannableStringBuilder;
      j localj;
      if (localObject != null) {
        if ((j == locald.endPos) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
        {
          localObject = (j)localObject;
          localSpannableStringBuilder = a((j)localObject, 0, locald.opi, false, paramBoolean, "", false);
          if (!bt.ai(localSpannableStringBuilder))
          {
            localj = new j();
            localj.content = com.tencent.mm.plugin.editor.model.nativenote.a.b.a(localSpannableStringBuilder);
            localj.omx = -1;
            localj.omv = false;
            localArrayList.add(localj);
          }
          if ((paramBoolean) && (bt.isNullOrNil(((j)localObject).content))) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().W(j, true);
          }
        }
      }
      for (;;)
      {
        j -= 1;
        break;
        if ((j == locald.cWU) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
        {
          localObject = (j)localObject;
          localSpannableStringBuilder = a((j)localObject, locald.startOffset, 0, true, paramBoolean, "", false);
          if (!bt.ai(localSpannableStringBuilder))
          {
            localj = new j();
            localj.content = com.tencent.mm.plugin.editor.model.nativenote.a.b.a(localSpannableStringBuilder);
            localj.omx = -1;
            localj.omv = false;
            localArrayList.add(localj);
          }
          if ((paramBoolean) && (bt.isNullOrNil(((j)localObject).content))) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().W(j, true);
          } else {
            i += 1;
          }
        }
        else
        {
          localArrayList.add(com.tencent.mm.plugin.editor.b.a((com.tencent.mm.plugin.editor.model.a.a)localObject));
          if (paramBoolean) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().W(j, true);
          }
        }
      }
    }
    if (paramBoolean)
    {
      j = i + 1;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().b(i, paramArrayList);
        j = paramArrayList.size() + i;
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().eZ(i - 1, j);
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
      paramArrayList.omv = false;
      paramArrayList.omx = -1;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().a(i, paramArrayList);
      break;
      paramString = "";
    }
  }
  
  public static e bSW()
  {
    AppMethodBeat.i(181865);
    if (opj == null) {}
    try
    {
      if (opj == null) {
        opj = new e();
      }
      e locale = opj;
      AppMethodBeat.o(181865);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(181865);
    }
  }
  
  private int bSX()
  {
    AppMethodBeat.i(181867);
    if (this.opD != null)
    {
      int i = this.opD.bRG();
      int j = this.opD.bRH();
      AppMethodBeat.o(181867);
      return i + j;
    }
    AppMethodBeat.o(181867);
    return 0;
  }
  
  private void bSZ()
  {
    AppMethodBeat.i(181871);
    A(-1, -1, -1, -1);
    AppMethodBeat.o(181871);
  }
  
  private void bTa()
  {
    AppMethodBeat.i(181873);
    if (this.opD != null) {
      this.opD.bRF();
    }
    AppMethodBeat.o(181873);
  }
  
  private void bTg()
  {
    AppMethodBeat.i(181888);
    if (this.opH == null)
    {
      this.opH = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(181858);
          if ((e.this.bSV() == 1) && (e.b(e.this))) {
            e.this.bTd();
          }
          AppMethodBeat.o(181858);
          return true;
        }
      }, false);
      AppMethodBeat.o(181888);
      return;
    }
    this.opH.stopTimer();
    AppMethodBeat.o(181888);
  }
  
  private void bTh()
  {
    AppMethodBeat.i(181893);
    if (this.opF == null)
    {
      this.opF = new b();
      AppMethodBeat.o(181893);
      return;
    }
    this.opF.reset();
    AppMethodBeat.o(181893);
  }
  
  private void bTi()
  {
    AppMethodBeat.i(181894);
    if (this.opG == null)
    {
      this.opG = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(181860);
          ad.d("EditorSelectManager", "onTimerExpired: ");
          RecyclerView localRecyclerView = e.a(e.this);
          int i;
          int j;
          if ((e.c(e.this) != null) && (e.c(e.this).ooY < e.a(e.this, localRecyclerView)))
          {
            i = 1;
            if ((e.c(e.this) == null) || (e.c(e.this).ooY <= e.d(e.this))) {
              break label206;
            }
            j = 1;
            label89:
            if ((!e.bTt()) || (localRecyclerView == null) || (e.c(e.this) == null) || (e.c(e.this).getType() != 1) || ((i == 0) && (j == 0))) {
              break label256;
            }
            if ((i == 0) || (!localRecyclerView.canScrollVertically(-1))) {
              break label211;
            }
            if (e.c(e.this).nBH == 3) {
              e.e(e.this);
            }
            e.f(e.this);
            e.this.bTf();
            e.this.bTd();
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
              e.this.bTf();
              e.this.bTd();
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
    this.opG.stopTimer();
    AppMethodBeat.o(181894);
  }
  
  private int bTj()
  {
    AppMethodBeat.i(181896);
    int j = 0;
    if (this.opD != null) {
      j = this.opD.bRG();
    }
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.opD != null) {
        i = this.opD.bRH();
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
  
  private void bTk()
  {
    AppMethodBeat.i(181898);
    if (this.opD != null) {
      this.opD.bRE();
    }
    AppMethodBeat.o(181898);
  }
  
  private boolean bTm()
  {
    AppMethodBeat.i(181903);
    boolean bool1 = o(this.opI, false);
    boolean bool2 = o(this.opJ, false);
    boolean bool3 = o(this.opK, bTn());
    boolean bool4 = o(this.opL, bTo());
    boolean bool5 = o(this.opM, bTp());
    boolean bool6 = o(this.opN, bTq());
    boolean bool7 = o(this.opO, bTr());
    boolean bool8 = o(this.opP, bTs());
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5) || (bool6) || (bool7) || (bool8))
    {
      AppMethodBeat.o(181903);
      return true;
    }
    AppMethodBeat.o(181903);
    return false;
  }
  
  private boolean bTn()
  {
    AppMethodBeat.i(181905);
    if (bSV() != 1)
    {
      AppMethodBeat.o(181905);
      return false;
    }
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().Aa(this.opE.cWU);
    if ((locala != null) && ((com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().size() > 1) || (locala.getType() != 1) || (!bt.isNullOrNil(((j)locala).content))))
    {
      AppMethodBeat.o(181905);
      return true;
    }
    AppMethodBeat.o(181905);
    return false;
  }
  
  private boolean bTo()
  {
    AppMethodBeat.i(181906);
    int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().bSB();
    int j = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().bSC();
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().Aa(i);
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().Aa(j);
    if ((localObject == null) || (locala == null))
    {
      AppMethodBeat.o(181906);
      return false;
    }
    if ((this.opE != null) && (this.opE.cWU == i) && (this.opE.startOffset == 0) && (this.opE.endPos == j)) {
      if (locala.getType() == 1)
      {
        localObject = com.tencent.mm.plugin.editor.model.nativenote.a.a.Tc(((j)locala).content);
        if (localObject == null)
        {
          AppMethodBeat.o(181906);
          return false;
        }
        if (this.opE.opi == ((Spanned)localObject).length())
        {
          AppMethodBeat.o(181906);
          return false;
        }
      }
      else if ((locala.getType() != 1) && (this.opE.opi == 1))
      {
        AppMethodBeat.o(181906);
        return false;
      }
    }
    AppMethodBeat.o(181906);
    return true;
  }
  
  private boolean bTp()
  {
    boolean bool2 = true;
    AppMethodBeat.i(181907);
    if (!this.opk)
    {
      AppMethodBeat.o(181907);
      return false;
    }
    int i = bSV();
    if ((i == 0) || (i == 1))
    {
      AppMethodBeat.o(181907);
      return false;
    }
    boolean bool1 = bool2;
    if (this.opD != null) {
      if (this.opD.bRI()) {
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
  
  private boolean bTq()
  {
    AppMethodBeat.i(181908);
    int i = bSV();
    if ((this.opk) && ((i == 2) || (i == 3)))
    {
      AppMethodBeat.o(181908);
      return true;
    }
    AppMethodBeat.o(181908);
    return false;
  }
  
  private boolean bTr()
  {
    AppMethodBeat.i(181909);
    int i = bSV();
    if ((i == 2) || (i == 3))
    {
      AppMethodBeat.o(181909);
      return true;
    }
    AppMethodBeat.o(181909);
    return false;
  }
  
  private boolean bTs()
  {
    AppMethodBeat.i(181910);
    if ((!this.opk) || (bSV() == 0))
    {
      AppMethodBeat.o(181910);
      return false;
    }
    aj.getContext();
    if (com.tencent.mm.plugin.editor.model.nativenote.manager.b.bSp() != 1)
    {
      AppMethodBeat.o(181910);
      return true;
    }
    AppMethodBeat.o(181910);
    return false;
  }
  
  private RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(181866);
    if (this.opD != null)
    {
      RecyclerView localRecyclerView = this.opD.bRJ();
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
    if ((!mHasInit) || (paramRecyclerView == null) || (this.opC == null))
    {
      AppMethodBeat.o(181889);
      return false;
    }
    if ((paramInt2 < p(paramRecyclerView)) || (paramInt2 > this.mScreenHeight - bSX()))
    {
      AppMethodBeat.o(181889);
      return false;
    }
    if (this.opC.isShowing()) {
      this.opC.update(paramInt1, paramInt2, -1, -1, false);
    }
    for (;;)
    {
      AppMethodBeat.o(181889);
      return true;
      this.opC.showAtLocation(paramRecyclerView, 0, paramInt1, paramInt2);
    }
  }
  
  public static boolean isEnabled()
  {
    return mHasInit;
  }
  
  private void jy(boolean paramBoolean)
  {
    AppMethodBeat.i(181891);
    if ((!mHasInit) || (this.opz == null) || (this.opA == null) || (this.opB == null) || (this.opE == null))
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
    if ((this.opF == null) || (this.opF.getType() != 1))
    {
      AppMethodBeat.o(181891);
      return;
    }
    int k = this.opF.nBH;
    if ((k != 2) && (k != 3) && (k != 4))
    {
      AppMethodBeat.o(181891);
      return;
    }
    float f2 = this.opF.ooX - this.opF.cEZ;
    float f1 = this.opF.ooY;
    float f3 = this.opF.cFa;
    f3 = this.opl / 2 + (f1 - f3);
    View localView;
    Object localObject2;
    Object localObject1;
    int i;
    if (k == 2)
    {
      f1 = f2 + this.opz.getWidth() / 2;
      localRecyclerView.getLocationOnScreen(this.opv);
      localView = localRecyclerView.o(f1 - this.opv[0], f3 - this.opv[1]);
      localObject2 = f.dJ(localView);
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
        f1 = f2 + this.opA.getWidth();
        break;
        if (((c)localObject2).opf != null)
        {
          localObject1 = ((c)localObject2).opf;
          localObject2 = new int[2];
          ((WXRTEditText)localObject1).getLocationOnScreen((int[])localObject2);
          i = ((WXRTEditText)localObject1).getOffsetForPosition(f1 - localObject2[0], f3 - localObject2[1]);
          i = V(k, ((WXRTEditText)localObject1).getPosInDataList(), i);
        }
        else if ((((c)localObject2).opg != null) && (((c)localObject2).oph != null))
        {
          if (k == 3)
          {
            localObject2 = ((c)localObject2).opg;
            j = V(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.opA, (int)(this.opF.ooX - this.opF.cEZ), (int)(this.opF.ooY - this.opF.cFa));
              i = j;
              localObject1 = localObject2;
            }
          }
          else if (k == 4)
          {
            localObject2 = ((c)localObject2).oph;
            j = V(k, ((WXRTEditText)localObject2).getPosInDataList(), 1);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.opB, (int)(this.opF.ooX - this.opF.cEZ), (int)(this.opF.ooY - this.opF.cFa));
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
            localObject2 = ((c)localObject2).opg;
          }
          for (int j = V(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);; j = V(k, ((WXRTEditText)localObject2).getPosInDataList(), 1))
          {
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.opz, (int)(this.opF.ooX - this.opF.cEZ), (int)(this.opF.ooY - this.opF.cFa));
              localObject1 = localObject2;
              i = j;
            }
            break;
            localObject2 = ((c)localObject2).oph;
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
          if ((!paramBoolean) || ((this.opF.ooY >= p(localRecyclerView)) && (this.opF.ooY <= bTj())) || ((this.opG != null) && (!this.opG.eFX()))) {
            break label1166;
          }
          bTi();
          this.opG.av(100L, 100L);
          AppMethodBeat.o(181891);
          return;
          i = 1;
          continue;
          localObject2 = ((WXRTEditText)localObject1).getText();
          i = bSV();
          if ((this.opk) && (localObject2 != null) && (i == 1))
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
                bTa();
              }
              bTd();
              f(true, 0L);
              if (k != 4) {
                break label1150;
              }
            }
          }
          label1150:
          for (i = this.opE.opi;; i = this.opE.startOffset)
          {
            a(k, localRecyclerView, localView, i);
            i = 1;
            break;
            if (this.opE.startOffset > ((Editable)localObject2).length()) {
              break label915;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.opE.startOffset);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label915;
            if ((!this.opk) || (localObject2 == null) || (i != 2) || (!((WXRTEditText)localObject1).hasFocus())) {
              break label915;
            }
            if ((((WXRTEditText)localObject1).getEditTextType() == 1) || (((WXRTEditText)localObject1).getEditTextType() == 2))
            {
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
              ((WXRTEditText)localObject1).setSelection(0);
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
              break label915;
            }
            if ((this.opE.startOffset > ((Editable)localObject2).length()) || (this.opE.opi > ((Editable)localObject2).length())) {
              break label915;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.opE.startOffset, this.opE.opi);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label915;
          }
        }
        label915:
        bTi();
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
      paramRecyclerView.getLocationOnScreen(this.opv);
      i = j;
      if (w(this.opv)) {
        i = this.opv[1];
      }
    }
    AppMethodBeat.o(181895);
    return i;
  }
  
  private static boolean w(int[] paramArrayOfInt)
  {
    return (mHasInit) && (paramArrayOfInt != null) && (paramArrayOfInt.length == 2) && (paramArrayOfInt[0] != -1) && (paramArrayOfInt[1] != -1);
  }
  
  public final boolean A(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(181870);
    if (!mHasInit)
    {
      AppMethodBeat.o(181870);
      return false;
    }
    boolean bool;
    if (this.opE == null)
    {
      this.opE = new d(paramInt1, paramInt2, paramInt3, paramInt4);
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        ad.d("EditorSelectManager", "setSelectInfo: %d:%d - %d:%d", new Object[] { Integer.valueOf(this.opE.cWU), Integer.valueOf(this.opE.startOffset), Integer.valueOf(this.opE.endPos), Integer.valueOf(this.opE.opi) });
      }
      AppMethodBeat.o(181870);
      return bool;
      if ((this.opE.cWU != paramInt1) || (this.opE.startOffset != paramInt2) || (this.opE.endPos != paramInt3) || (this.opE.opi != paramInt4))
      {
        this.opE.set(paramInt1, paramInt2, paramInt3, paramInt4);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final int Af(int paramInt)
  {
    AppMethodBeat.i(181872);
    if ((!mHasInit) || (this.opE == null))
    {
      AppMethodBeat.o(181872);
      return 0;
    }
    if ((bSV() == 0) || (paramInt < this.opE.cWU) || (paramInt > this.opE.endPos))
    {
      AppMethodBeat.o(181872);
      return 0;
    }
    if ((paramInt == this.opE.cWU) && (paramInt == this.opE.endPos))
    {
      AppMethodBeat.o(181872);
      return 1;
    }
    if ((paramInt > this.opE.cWU) && (paramInt < this.opE.endPos))
    {
      AppMethodBeat.o(181872);
      return 2;
    }
    if ((paramInt == this.opE.cWU) && (paramInt < this.opE.endPos))
    {
      AppMethodBeat.o(181872);
      return 4;
    }
    if ((paramInt > this.opE.cWU) && (paramInt == this.opE.endPos))
    {
      AppMethodBeat.o(181872);
      return 3;
    }
    AppMethodBeat.o(181872);
    return 0;
  }
  
  public final void H(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(181875);
    if (!mHasInit)
    {
      AppMethodBeat.o(181875);
      return;
    }
    bTf();
    bTd();
    f(true, 50L);
    jx(paramBoolean1);
    jv(paramBoolean2);
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
    if ((this.opF != null) && (this.opF.getType() == 1) && (this.opF.nBH != paramInt))
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
      bTh();
      if (!bTc()) {
        jw(true);
      }
      this.opF.a(paramInt, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), 0);
      AppMethodBeat.o(181890);
      return;
      if ((this.opF != null) && (this.opF.getType() == 1))
      {
        this.opF.ooX = paramMotionEvent.getRawX();
        this.opF.ooY = paramMotionEvent.getRawY();
        jy(true);
        AppMethodBeat.o(181890);
        return;
        bTh();
        this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(181859);
            e.this.jx(true);
            e.this.jw(true);
            AppMethodBeat.o(181859);
          }
        }, 200L);
      }
    }
  }
  
  public final void a(View paramView1, View paramView2, View paramView3, int paramInt)
  {
    AppMethodBeat.i(181877);
    if ((!mHasInit) || (paramView1 == null) || (paramView2 == null) || (paramView3 == null) || (this.opE == null))
    {
      AppMethodBeat.o(181877);
      return;
    }
    switch (Af(paramInt))
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
      if (this.opE.startOffset == this.opE.opi) {
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
      if (this.opE.startOffset == 0)
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
    } while (this.opE.opi == 0);
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
    paramView3.setVisibility(4);
    AppMethodBeat.o(181877);
  }
  
  public final int bSV()
  {
    AppMethodBeat.i(181868);
    if (!mHasInit)
    {
      AppMethodBeat.o(181868);
      return 0;
    }
    if (this.opE == null) {
      this.opE = new d();
    }
    int i = this.opE.bSV();
    AppMethodBeat.o(181868);
    return i;
  }
  
  public final d bSY()
  {
    AppMethodBeat.i(181869);
    if (!mHasInit)
    {
      locald = new d();
      AppMethodBeat.o(181869);
      return locald;
    }
    if (this.opE == null) {
      this.opE = new d();
    }
    d locald = new d(this.opE.cWU, this.opE.startOffset, this.opE.endPos, this.opE.opi);
    AppMethodBeat.o(181869);
    return locald;
  }
  
  public final void bTb()
  {
    AppMethodBeat.i(181874);
    if (!mHasInit)
    {
      AppMethodBeat.o(181874);
      return;
    }
    bSZ();
    f(true, 0L);
    bTf();
    bTd();
    AppMethodBeat.o(181874);
  }
  
  public final boolean bTc()
  {
    AppMethodBeat.i(181878);
    if ((this.opC != null) && (this.opC.isShowing()))
    {
      AppMethodBeat.o(181878);
      return true;
    }
    AppMethodBeat.o(181878);
    return false;
  }
  
  public final void bTd()
  {
    AppMethodBeat.i(181879);
    if (this.opC != null) {
      this.opC.dismiss();
    }
    AppMethodBeat.o(181879);
  }
  
  public final boolean bTe()
  {
    AppMethodBeat.i(181882);
    if ((this.opz != null) && (this.opz.isShowing()))
    {
      AppMethodBeat.o(181882);
      return true;
    }
    AppMethodBeat.o(181882);
    return false;
  }
  
  public final void bTf()
  {
    AppMethodBeat.i(181883);
    if (!mHasInit)
    {
      AppMethodBeat.o(181883);
      return;
    }
    Ag(2);
    Ag(3);
    Ag(4);
    AppMethodBeat.o(181883);
  }
  
  public final void bTl()
  {
    AppMethodBeat.i(181899);
    ad.i("EditorSelectManager", "deleteSelectedData");
    if (!mHasInit)
    {
      ad.e("EditorSelectManager", "deleteSelectedData: not init");
      AppMethodBeat.o(181899);
      return;
    }
    bTd();
    int i = bSV();
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
    ad.e("EditorSelectManager", "deleteSelectedData: not in select");
    bTk();
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
          c localc = f.dJ((View)localObject);
          if (localc != null)
          {
            if (localc.opf == null) {
              break label78;
            }
            if (paramBoolean) {
              localc.opf.postInvalidate();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label78:
            if ((localc.opg != null) && (localc.oph != null))
            {
              LinearLayout localLinearLayout1 = (LinearLayout)((View)localObject).findViewById(2131303103);
              LinearLayout localLinearLayout2 = (LinearLayout)((View)localObject).findViewById(2131303110);
              localObject = (LinearLayout)((View)localObject).findViewById(2131303105);
              e.this.a(localLinearLayout1, localLinearLayout2, (View)localObject, localc.opg.getPosInDataList());
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
    return (mHasInit) && (this.opk);
  }
  
  public final void jv(final boolean paramBoolean)
  {
    AppMethodBeat.i(181880);
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181857);
        e.this.jw(paramBoolean);
        AppMethodBeat.o(181857);
      }
    }, 50L);
    AppMethodBeat.o(181880);
  }
  
  public final void jw(boolean paramBoolean)
  {
    AppMethodBeat.i(181881);
    if ((!mHasInit) || (this.opC == null))
    {
      AppMethodBeat.o(181881);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = bSV();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)) || ((this.opF != null) && (this.opF.getType() == 1)))
    {
      bTd();
      AppMethodBeat.o(181881);
      return;
    }
    if (!bTm())
    {
      bTd();
      AppMethodBeat.o(181881);
      return;
    }
    int i1 = -1;
    int i2 = -1000;
    int i4 = p(localRecyclerView);
    int i5 = bTj();
    int k = 0;
    int m = 0;
    i = m;
    int j = k;
    if (this.opC != null)
    {
      i = m;
      j = k;
      if (this.opC.getContentView() != null)
      {
        this.opC.getContentView().measure(0, 0);
        i = this.opC.getContentView().getMeasuredHeight();
        j = this.opo * 2 + i;
        i = this.opC.getContentView().getMeasuredWidth() + this.opo * 2;
      }
    }
    int i3;
    int n;
    if (j == 0)
    {
      i3 = this.opq;
      if (i != 0) {
        break label414;
      }
      n = this.opr;
      label229:
      if ((this.opz == null) || (!this.opz.isShowing()) || (!w(this.opw))) {
        break label458;
      }
      j = this.opw[1] - i3;
      i = this.opw[1] + this.opz.getHeight() - this.ops;
      if ((j < i4) || (j > i5)) {
        break label420;
      }
      k = this.opw[0];
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
        j = ((LinearLayoutManager)localObject).jO();
        k = ((LinearLayoutManager)localObject).jQ();
        if ((this.opE.cWU > j) || (this.opE.endPos < k)) {
          break label911;
        }
        k = 300;
        j = -1000;
      }
      for (;;)
      {
        if (k == -1)
        {
          bTd();
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
          j = this.opw[0];
          break label311;
          label458:
          i = i2;
          j = i1;
          if (this.opA != null)
          {
            i = i2;
            j = i1;
            if (this.opA.isShowing())
            {
              i = i2;
              j = i1;
              if (w(this.opx))
              {
                j = this.opx[1] - i3;
                k = this.opx[1] + this.opA.getHeight() - this.ops;
                if ((j < i4) || (j > i5)) {
                  break label662;
                }
                i = this.opx[0];
              }
            }
          }
          for (;;)
          {
            m = i;
            k = j;
            if (this.opB == null) {
              break label921;
            }
            m = i;
            k = j;
            if (!this.opB.isShowing()) {
              break label921;
            }
            m = i;
            k = j;
            if (!w(this.opy)) {
              break label921;
            }
            k = this.opy[1] - i3;
            i1 = this.opy[1] + this.opB.getHeight() - this.ops;
            if (j != -1) {
              break label740;
            }
            if ((k < i4) || (k > i5)) {
              break label701;
            }
            j = this.opy[0];
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
                i = this.opx[0];
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
          j = this.opy[0];
          i = i1;
          break label311;
          label740:
          m = i;
          k = j;
          if (j + i3 <= this.opy[1]) {
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
          j = this.opy[0];
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
          i(localRecyclerView, this.opp, k);
          AppMethodBeat.o(181881);
          return;
        }
        i(localRecyclerView, this.mScreenWidth - n - this.opp, k);
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
  
  public final void jx(boolean paramBoolean)
  {
    AppMethodBeat.i(181885);
    if (!mHasInit)
    {
      AppMethodBeat.o(181885);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = bSV();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)))
    {
      bTf();
      AppMethodBeat.o(181885);
      return;
    }
    View localView1 = f.e(localRecyclerView, this.opE.cWU);
    View localView2 = f.e(localRecyclerView, this.opE.endPos);
    if (i == 1)
    {
      Ag(3);
      Ag(4);
      a(2, localRecyclerView, localView1, this.opE.startOffset);
      AppMethodBeat.o(181885);
      return;
    }
    Ag(2);
    a(3, localRecyclerView, localView1, this.opE.startOffset);
    a(4, localRecyclerView, localView2, this.opE.opi);
    AppMethodBeat.o(181885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.c.e
 * JD-Core Version:    0.7.0.1
 */