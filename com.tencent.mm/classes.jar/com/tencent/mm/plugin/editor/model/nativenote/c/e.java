package com.tencent.mm.plugin.editor.model.nativenote.c;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;

public final class e
  implements a.a
{
  public static boolean mHasInit = false;
  public static volatile e qSp = null;
  public MMHandler mHandler = null;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public int qSA = 0;
  public int[] qSB = null;
  public int[] qSC = null;
  public int[] qSD = null;
  public int[] qSE = null;
  public PopupWindow qSF = null;
  public PopupWindow qSG = null;
  public PopupWindow qSH = null;
  public PopupWindow qSI = null;
  public com.tencent.mm.plugin.editor.model.nativenote.b.a qSJ = null;
  public d qSK = null;
  public b qSL = null;
  public MTimerHandler qSM = null;
  public MTimerHandler qSN = null;
  public TextView qSO = null;
  public TextView qSP = null;
  public TextView qSQ = null;
  public TextView qSR = null;
  public TextView qSS = null;
  public TextView qST = null;
  public TextView qSU = null;
  public TextView qSV = null;
  public boolean qSq = true;
  public int qSr = 0;
  public int qSs = 0;
  public int qSt = 14;
  public int qSu = 0;
  public int qSv = 0;
  public int qSw = 0;
  public int qSx = 0;
  public int qSy = 0;
  public int qSz = 0;
  
  private e()
  {
    mHasInit = false;
  }
  
  private static boolean A(int[] paramArrayOfInt)
  {
    return (mHasInit) && (paramArrayOfInt != null) && (paramArrayOfInt.length == 2) && (paramArrayOfInt[0] != -1) && (paramArrayOfInt[1] != -1);
  }
  
  private boolean FC(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(181884);
    if ((this.qSL != null) && (this.qSL.qcr == paramInt) && (this.qSL.getType() == 1))
    {
      AppMethodBeat.o(181884);
      return false;
    }
    if ((paramInt == 2) && (this.qSF != null))
    {
      this.qSF.dismiss();
      Y(2, -1, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(181884);
      return bool;
      if ((paramInt == 3) && (this.qSG != null))
      {
        this.qSG.dismiss();
        Y(3, -1, -1);
      }
      else if ((paramInt == 4) && (this.qSH != null))
      {
        this.qSH.dismiss();
        Y(4, -1, -1);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private void Y(int paramInt1, int paramInt2, int paramInt3)
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
        } while ((this.qSC == null) || (this.qSC.length != 2));
        this.qSC[0] = paramInt2;
        this.qSC[1] = paramInt3;
        return;
      } while ((this.qSD == null) || (this.qSD.length != 2));
      this.qSD[0] = paramInt2;
      this.qSD[1] = paramInt3;
      return;
    } while ((this.qSE == null) || (this.qSE.length != 2));
    this.qSE[0] = paramInt2;
    this.qSE[1] = paramInt3;
  }
  
  private int Z(int paramInt1, int paramInt2, int paramInt3)
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
      if ((this.qSK == null) || (paramInt2 > this.qSK.endPos) || ((paramInt2 == this.qSK.endPos) && (paramInt3 >= this.qSK.qSo)))
      {
        AppMethodBeat.o(181892);
        return 1;
      }
      bool = B(paramInt2, paramInt3, this.qSK.endPos, this.qSK.qSo);
      continue;
      if ((this.qSK == null) || (paramInt2 < this.qSK.bNu) || ((paramInt2 == this.qSK.bNu) && (paramInt3 <= this.qSK.startOffset)))
      {
        AppMethodBeat.o(181892);
        return 1;
      }
      bool = B(this.qSK.bNu, this.qSK.startOffset, paramInt2, paramInt3);
    }
    AppMethodBeat.o(181892);
    return 2;
  }
  
  private static SpannableStringBuilder a(j paramj, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    AppMethodBeat.i(181902);
    if (paramj == null)
    {
      Log.e("EditorSelectManager", "processTextDataItem: textDataItem is null");
      AppMethodBeat.o(181902);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.a.a.alS(paramj.content);
    if (localObject == null)
    {
      Log.e("EditorSelectManager", "processTextDataItem: spannedText is null");
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
        Log.e("EditorSelectManager", "processTextDataItem: incorrect offset");
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
        if (!Util.isNullOrNil(str))
        {
          Spanned localSpanned = com.tencent.mm.plugin.editor.model.nativenote.a.a.alS(str);
          paramInt1 = paramInt2;
          if (localSpanned != null) {
            paramInt1 = paramInt2 + localSpanned.length();
          }
        }
        paramj.content = (com.tencent.mm.plugin.editor.model.nativenote.a.b.a(paramString) + str + com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)localObject));
      }
      if (paramBoolean3) {
        paramj.qPA = true;
      }
      for (paramj.qPC = paramInt1;; paramj.qPC = -1)
      {
        AppMethodBeat.o(181902);
        return localSpannableStringBuilder;
        paramj.qPA = false;
      }
    }
  }
  
  private SpannableStringBuilder a(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(181900);
    d locald = cDV();
    cDY();
    int j = locald.getSelectType();
    if ((j != 1) && (j != 2))
    {
      Log.e("EditorSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
      AppMethodBeat.o(181900);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(locald.bNu);
    if (localObject == null)
    {
      Log.e("EditorSelectManager", "getAndProcessSelectedDataInSingleSelect: item is null");
      AppMethodBeat.o(181900);
      return null;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1)
    {
      if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramString = a((j)localObject, locald.startOffset, locald.qSo, false, false, "", true);
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().a(paramArrayList, 0, locald.bNu, locald.startOffset, locald.qSo);
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().fx(locald.bNu, locald.bNu + paramArrayList.size() + 1);
        paramArrayList = paramString;
      }
      for (;;)
      {
        AppMethodBeat.o(181900);
        return paramArrayList;
        paramString = a((j)localObject, locald.startOffset, locald.qSo, false, paramBoolean, paramString, true);
        if (this.qSJ != null) {
          this.qSJ.Fr(locald.bNu);
        }
        paramArrayList = paramString;
        if (paramBoolean)
        {
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDy();
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
      if (Util.isNullOrNil(paramString)) {
        break label411;
      }
      paramArrayList = new ArrayList();
      localObject = new j();
      ((j)localObject).content = paramString;
      ((j)localObject).qPA = false;
      ((j)localObject).qPC = -1;
      paramArrayList.add(localObject);
    }
    label411:
    label420:
    for (;;)
    {
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().a(paramArrayList, i, locald.bNu, locald.startOffset, locald.qSo);
      paramString = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo();
      i = locald.bNu;
      j = locald.bNu;
      paramString.fx(i - 1, paramArrayList.size() + j + 1);
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
    paramView = f.dG(paramView);
    if (paramView == null)
    {
      FC(paramInt1);
      AppMethodBeat.o(181886);
      return;
    }
    if (paramView.qSl != null) {
      paramView = paramView.qSl;
    }
    for (;;)
    {
      if (paramView == null)
      {
        FC(paramInt1);
        AppMethodBeat.o(181886);
        return;
        if ((paramView.qSm != null) && (paramView.qSn != null))
        {
          if (paramInt2 == 0)
          {
            paramView = paramView.qSm;
            paramInt2 = 0;
            continue;
          }
          if (paramInt2 == 1)
          {
            paramView = paramView.qSn;
            paramInt2 = 0;
          }
        }
      }
      else
      {
        Object localObject = paramView.getText();
        if ((localObject == null) || (paramInt2 < 0) || (paramInt2 > ((Editable)localObject).length()))
        {
          FC(paramInt1);
          AppMethodBeat.o(181886);
          return;
        }
        localObject = paramView.getLayout();
        if (localObject == null)
        {
          FC(paramInt1);
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
          f3 = f3 + paramView.getHeight() - this.qSr;
          if (paramInt1 == 3)
          {
            f1 = f4 + this.qSA;
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
            FC(paramInt1);
          }
          AppMethodBeat.o(181886);
          return;
          f1 = f4;
          f2 = f3;
          if (paramInt1 != 4) {
            break;
          }
          f1 = f4 - this.qSA;
          f2 = f3;
          break;
          bool = a(2, paramRecyclerView, this.qSF, (int)(f1 + localObject[0] - this.qSz), (int)(localObject[1] + f2));
          continue;
          bool = a(3, paramRecyclerView, this.qSG, (int)(f1 + localObject[0] - this.qSG.getWidth()), (int)(localObject[1] + f2));
          continue;
          bool = a(4, paramRecyclerView, this.qSH, (int)(f1 + localObject[0]), (int)(localObject[1] + f2));
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
    if ((paramInt3 < j(paramRecyclerView)) || (paramInt3 > this.mScreenHeight - cDU()))
    {
      AppMethodBeat.o(181887);
      return false;
    }
    if (paramPopupWindow.isShowing())
    {
      paramPopupWindow.update(paramInt2, paramInt3, -1, -1, false);
      Y(paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      if (paramInt1 == 2)
      {
        cEd();
        this.qSN.startTimer(3000L, 0L);
      }
      AppMethodBeat.o(181887);
      return true;
      paramPopupWindow.showAtLocation(paramRecyclerView, 0, paramInt2, paramInt3);
      Y(paramInt1, paramInt2, paramInt3);
    }
  }
  
  private ArrayList<com.tencent.mm.plugin.editor.model.a.a> b(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList, String paramString)
  {
    AppMethodBeat.i(181901);
    d locald = cDV();
    cDY();
    ArrayList localArrayList = new ArrayList();
    if (locald.getSelectType() != 3)
    {
      Log.e("EditorSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
      AppMethodBeat.o(181901);
      return null;
    }
    int i = locald.bNu;
    int j = locald.endPos;
    if (j >= locald.bNu)
    {
      Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(j);
      SpannableStringBuilder localSpannableStringBuilder;
      j localj;
      if (localObject != null) {
        if ((j == locald.endPos) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
        {
          localObject = (j)localObject;
          localSpannableStringBuilder = a((j)localObject, 0, locald.qSo, false, paramBoolean, "", false);
          if (!Util.isNullOrNil(localSpannableStringBuilder))
          {
            localj = new j();
            localj.content = com.tencent.mm.plugin.editor.model.nativenote.a.b.a(localSpannableStringBuilder);
            localj.qPC = -1;
            localj.qPA = false;
            localArrayList.add(localj);
          }
          if ((paramBoolean) && (Util.isNullOrNil(((j)localObject).content))) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().ae(j, true);
          }
        }
      }
      for (;;)
      {
        j -= 1;
        break;
        if ((j == locald.bNu) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
        {
          localObject = (j)localObject;
          localSpannableStringBuilder = a((j)localObject, locald.startOffset, 0, true, paramBoolean, "", false);
          if (!Util.isNullOrNil(localSpannableStringBuilder))
          {
            localj = new j();
            localj.content = com.tencent.mm.plugin.editor.model.nativenote.a.b.a(localSpannableStringBuilder);
            localj.qPC = -1;
            localj.qPA = false;
            localArrayList.add(localj);
          }
          if ((paramBoolean) && (Util.isNullOrNil(((j)localObject).content))) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().ae(j, true);
          } else {
            i += 1;
          }
        }
        else
        {
          localArrayList.add(com.tencent.mm.plugin.editor.b.a((com.tencent.mm.plugin.editor.model.a.a)localObject));
          if (paramBoolean) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().ae(j, true);
          }
        }
      }
    }
    if (paramBoolean)
    {
      j = i + 1;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().b(i, paramArrayList);
        j = paramArrayList.size() + i;
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().fx(i - 1, j);
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
      paramArrayList.qPA = false;
      paramArrayList.qPC = -1;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().a(i, paramArrayList);
      break;
      paramString = "";
    }
  }
  
  public static e cDT()
  {
    AppMethodBeat.i(181865);
    if (qSp == null) {}
    try
    {
      if (qSp == null) {
        qSp = new e();
      }
      e locale = qSp;
      AppMethodBeat.o(181865);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(181865);
    }
  }
  
  private int cDU()
  {
    AppMethodBeat.i(181867);
    if (this.qSJ != null)
    {
      int i = this.qSJ.cCE();
      int j = this.qSJ.cCF();
      AppMethodBeat.o(181867);
      return i + j;
    }
    AppMethodBeat.o(181867);
    return 0;
  }
  
  private void cDW()
  {
    AppMethodBeat.i(181871);
    B(-1, -1, -1, -1);
    AppMethodBeat.o(181871);
  }
  
  private void cDX()
  {
    AppMethodBeat.i(181873);
    if (this.qSJ != null) {
      this.qSJ.cCD();
    }
    AppMethodBeat.o(181873);
  }
  
  private void cEd()
  {
    AppMethodBeat.i(181888);
    if (this.qSN == null)
    {
      this.qSN = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(181858);
          if ((e.this.getSelectType() == 1) && (e.b(e.this))) {
            e.this.cEa();
          }
          AppMethodBeat.o(181858);
          return true;
        }
      }, false);
      AppMethodBeat.o(181888);
      return;
    }
    this.qSN.stopTimer();
    AppMethodBeat.o(181888);
  }
  
  private void cEe()
  {
    AppMethodBeat.i(181893);
    if (this.qSL == null)
    {
      this.qSL = new b();
      AppMethodBeat.o(181893);
      return;
    }
    this.qSL.reset();
    AppMethodBeat.o(181893);
  }
  
  private void cEf()
  {
    AppMethodBeat.i(181894);
    if (this.qSM == null)
    {
      this.qSM = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(181860);
          Log.d("EditorSelectManager", "onTimerExpired: ");
          RecyclerView localRecyclerView = e.a(e.this);
          int i;
          int j;
          if ((e.c(e.this) != null) && (e.c(e.this).qSe < e.a(e.this, localRecyclerView)))
          {
            i = 1;
            if ((e.c(e.this) == null) || (e.c(e.this).qSe <= e.d(e.this))) {
              break label206;
            }
            j = 1;
            label89:
            if ((!e.WA()) || (localRecyclerView == null) || (e.c(e.this) == null) || (e.c(e.this).getType() != 1) || ((i == 0) && (j == 0))) {
              break label256;
            }
            if ((i == 0) || (!localRecyclerView.canScrollVertically(-1))) {
              break label211;
            }
            if (e.c(e.this).qcr == 3) {
              e.e(e.this);
            }
            e.f(e.this);
            e.this.cEc();
            e.this.cEa();
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
              e.this.cEc();
              e.this.cEa();
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
    this.qSM.stopTimer();
    AppMethodBeat.o(181894);
  }
  
  private int cEg()
  {
    AppMethodBeat.i(181896);
    int j = 0;
    if (this.qSJ != null) {
      j = this.qSJ.cCE();
    }
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.qSJ != null) {
        i = this.qSJ.cCF();
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
  
  private void cEh()
  {
    AppMethodBeat.i(181898);
    if (this.qSJ != null) {
      this.qSJ.cCC();
    }
    AppMethodBeat.o(181898);
  }
  
  private boolean cEj()
  {
    AppMethodBeat.i(181903);
    boolean bool1 = o(this.qSO, false);
    boolean bool2 = o(this.qSP, false);
    boolean bool3 = o(this.qSQ, cEk());
    boolean bool4 = o(this.qSR, cEl());
    boolean bool5 = o(this.qSS, cEm());
    boolean bool6 = o(this.qST, cEn());
    boolean bool7 = o(this.qSU, cEo());
    boolean bool8 = o(this.qSV, cEp());
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5) || (bool6) || (bool7) || (bool8))
    {
      AppMethodBeat.o(181903);
      return true;
    }
    AppMethodBeat.o(181903);
    return false;
  }
  
  private boolean cEk()
  {
    AppMethodBeat.i(181905);
    if (getSelectType() != 1)
    {
      AppMethodBeat.o(181905);
      return false;
    }
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(this.qSK.bNu);
    if ((locala != null) && ((com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().size() > 1) || (locala.getType() != 1) || (!Util.isNullOrNil(((j)locala).content))))
    {
      AppMethodBeat.o(181905);
      return true;
    }
    AppMethodBeat.o(181905);
    return false;
  }
  
  private boolean cEl()
  {
    AppMethodBeat.i(181906);
    int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDz();
    int j = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDA();
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(i);
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(j);
    if ((localObject == null) || (locala == null))
    {
      AppMethodBeat.o(181906);
      return false;
    }
    if ((this.qSK != null) && (this.qSK.bNu == i) && (this.qSK.startOffset == 0) && (this.qSK.endPos == j)) {
      if (locala.getType() == 1)
      {
        localObject = com.tencent.mm.plugin.editor.model.nativenote.a.a.alS(((j)locala).content);
        if (localObject == null)
        {
          AppMethodBeat.o(181906);
          return false;
        }
        if (this.qSK.qSo == ((Spanned)localObject).length())
        {
          AppMethodBeat.o(181906);
          return false;
        }
      }
      else if ((locala.getType() != 1) && (this.qSK.qSo == 1))
      {
        AppMethodBeat.o(181906);
        return false;
      }
    }
    AppMethodBeat.o(181906);
    return true;
  }
  
  private boolean cEm()
  {
    boolean bool2 = true;
    AppMethodBeat.i(181907);
    if (!this.qSq)
    {
      AppMethodBeat.o(181907);
      return false;
    }
    int i = getSelectType();
    if ((i == 0) || (i == 1))
    {
      AppMethodBeat.o(181907);
      return false;
    }
    boolean bool1 = bool2;
    if (this.qSJ != null) {
      if (this.qSJ.cCG()) {
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
  
  private boolean cEn()
  {
    AppMethodBeat.i(181908);
    int i = getSelectType();
    if ((this.qSq) && ((i == 2) || (i == 3)))
    {
      AppMethodBeat.o(181908);
      return true;
    }
    AppMethodBeat.o(181908);
    return false;
  }
  
  private boolean cEo()
  {
    AppMethodBeat.i(181909);
    int i = getSelectType();
    if ((i == 2) || (i == 3))
    {
      AppMethodBeat.o(181909);
      return true;
    }
    AppMethodBeat.o(181909);
    return false;
  }
  
  private boolean cEp()
  {
    AppMethodBeat.i(181910);
    if ((!this.qSq) || (getSelectType() == 0))
    {
      AppMethodBeat.o(181910);
      return false;
    }
    MMApplicationContext.getContext();
    if (com.tencent.mm.plugin.editor.model.nativenote.manager.b.cDn() != 1)
    {
      AppMethodBeat.o(181910);
      return true;
    }
    AppMethodBeat.o(181910);
    return false;
  }
  
  private boolean d(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181889);
    if ((!mHasInit) || (paramRecyclerView == null) || (this.qSI == null))
    {
      AppMethodBeat.o(181889);
      return false;
    }
    if ((paramInt2 < j(paramRecyclerView)) || (paramInt2 > this.mScreenHeight - cDU()))
    {
      AppMethodBeat.o(181889);
      return false;
    }
    if (this.qSI.isShowing()) {
      this.qSI.update(paramInt1, paramInt2, -1, -1, false);
    }
    for (;;)
    {
      AppMethodBeat.o(181889);
      return true;
      this.qSI.showAtLocation(paramRecyclerView, 0, paramInt1, paramInt2);
    }
  }
  
  private RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(181866);
    if (this.qSJ != null)
    {
      RecyclerView localRecyclerView = this.qSJ.cCH();
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
  
  public static boolean isEnabled()
  {
    return mHasInit;
  }
  
  private int j(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(181895);
    int j = 150;
    int i = j;
    if (paramRecyclerView != null)
    {
      paramRecyclerView.getLocationOnScreen(this.qSB);
      i = j;
      if (A(this.qSB)) {
        i = this.qSB[1];
      }
    }
    AppMethodBeat.o(181895);
    return i;
  }
  
  private void lo(boolean paramBoolean)
  {
    AppMethodBeat.i(181891);
    if ((!mHasInit) || (this.qSF == null) || (this.qSG == null) || (this.qSH == null) || (this.qSK == null))
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
    if ((this.qSL == null) || (this.qSL.getType() != 1))
    {
      AppMethodBeat.o(181891);
      return;
    }
    int k = this.qSL.qcr;
    if ((k != 2) && (k != 3) && (k != 4))
    {
      AppMethodBeat.o(181891);
      return;
    }
    float f2 = this.qSL.qSd - this.qSL.deo;
    float f1 = this.qSL.qSe;
    float f3 = this.qSL.dep;
    f3 = this.qSr / 2 + (f1 - f3);
    View localView;
    Object localObject2;
    Object localObject1;
    int i;
    if (k == 2)
    {
      f1 = f2 + this.qSF.getWidth() / 2;
      localRecyclerView.getLocationOnScreen(this.qSB);
      localView = localRecyclerView.o(f1 - this.qSB[0], f3 - this.qSB[1]);
      localObject2 = f.dG(localView);
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
        f1 = f2 + this.qSG.getWidth();
        break;
        if (((c)localObject2).qSl != null)
        {
          localObject1 = ((c)localObject2).qSl;
          localObject2 = new int[2];
          ((WXRTEditText)localObject1).getLocationOnScreen((int[])localObject2);
          i = ((WXRTEditText)localObject1).getOffsetForPosition(f1 - localObject2[0], f3 - localObject2[1]);
          i = Z(k, ((WXRTEditText)localObject1).getPosInDataList(), i);
        }
        else if ((((c)localObject2).qSm != null) && (((c)localObject2).qSn != null))
        {
          if (k == 3)
          {
            localObject2 = ((c)localObject2).qSm;
            j = Z(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.qSG, (int)(this.qSL.qSd - this.qSL.deo), (int)(this.qSL.qSe - this.qSL.dep));
              i = j;
              localObject1 = localObject2;
            }
          }
          else if (k == 4)
          {
            localObject2 = ((c)localObject2).qSn;
            j = Z(k, ((WXRTEditText)localObject2).getPosInDataList(), 1);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.qSH, (int)(this.qSL.qSd - this.qSL.deo), (int)(this.qSL.qSe - this.qSL.dep));
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
            localObject2 = ((c)localObject2).qSm;
          }
          for (int j = Z(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);; j = Z(k, ((WXRTEditText)localObject2).getPosInDataList(), 1))
          {
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.qSF, (int)(this.qSL.qSd - this.qSL.deo), (int)(this.qSL.qSe - this.qSL.dep));
              localObject1 = localObject2;
              i = j;
            }
            break;
            localObject2 = ((c)localObject2).qSn;
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
          if ((!paramBoolean) || ((this.qSL.qSe >= j(localRecyclerView)) && (this.qSL.qSe <= cEg())) || ((this.qSM != null) && (!this.qSM.stopped()))) {
            break label1163;
          }
          cEf();
          this.qSM.startTimer(100L);
          AppMethodBeat.o(181891);
          return;
          i = 1;
          continue;
          localObject2 = ((WXRTEditText)localObject1).getText();
          i = getSelectType();
          if ((this.qSq) && (localObject2 != null) && (i == 1))
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
                cDX();
              }
              cEa();
              f(true, 0L);
              if (k != 4) {
                break label1147;
              }
            }
          }
          label1147:
          for (i = this.qSK.qSo;; i = this.qSK.startOffset)
          {
            a(k, localRecyclerView, localView, i);
            i = 1;
            break;
            if (this.qSK.startOffset > ((Editable)localObject2).length()) {
              break label912;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.qSK.startOffset);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label912;
            if ((!this.qSq) || (localObject2 == null) || (i != 2) || (!((WXRTEditText)localObject1).hasFocus())) {
              break label912;
            }
            if ((((WXRTEditText)localObject1).getEditTextType() == 1) || (((WXRTEditText)localObject1).getEditTextType() == 2))
            {
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
              ((WXRTEditText)localObject1).setSelection(0);
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
              break label912;
            }
            if ((this.qSK.startOffset > ((Editable)localObject2).length()) || (this.qSK.qSo > ((Editable)localObject2).length())) {
              break label912;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.qSK.startOffset, this.qSK.qSo);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label912;
          }
        }
        label912:
        cEf();
        label1163:
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
  
  public final boolean B(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(181870);
    if (!mHasInit)
    {
      AppMethodBeat.o(181870);
      return false;
    }
    boolean bool;
    if (this.qSK == null)
    {
      this.qSK = new d(paramInt1, paramInt2, paramInt3, paramInt4);
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        Log.d("EditorSelectManager", "setSelectInfo: %d:%d - %d:%d", new Object[] { Integer.valueOf(this.qSK.bNu), Integer.valueOf(this.qSK.startOffset), Integer.valueOf(this.qSK.endPos), Integer.valueOf(this.qSK.qSo) });
      }
      AppMethodBeat.o(181870);
      return bool;
      if ((this.qSK.bNu != paramInt1) || (this.qSK.startOffset != paramInt2) || (this.qSK.endPos != paramInt3) || (this.qSK.qSo != paramInt4))
      {
        this.qSK.set(paramInt1, paramInt2, paramInt3, paramInt4);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final int FB(int paramInt)
  {
    AppMethodBeat.i(181872);
    if ((!mHasInit) || (this.qSK == null))
    {
      AppMethodBeat.o(181872);
      return 0;
    }
    if ((getSelectType() == 0) || (paramInt < this.qSK.bNu) || (paramInt > this.qSK.endPos))
    {
      AppMethodBeat.o(181872);
      return 0;
    }
    if ((paramInt == this.qSK.bNu) && (paramInt == this.qSK.endPos))
    {
      AppMethodBeat.o(181872);
      return 1;
    }
    if ((paramInt > this.qSK.bNu) && (paramInt < this.qSK.endPos))
    {
      AppMethodBeat.o(181872);
      return 2;
    }
    if ((paramInt == this.qSK.bNu) && (paramInt < this.qSK.endPos))
    {
      AppMethodBeat.o(181872);
      return 4;
    }
    if ((paramInt > this.qSK.bNu) && (paramInt == this.qSK.endPos))
    {
      AppMethodBeat.o(181872);
      return 3;
    }
    AppMethodBeat.o(181872);
    return 0;
  }
  
  public final void I(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(181875);
    if (!mHasInit)
    {
      AppMethodBeat.o(181875);
      return;
    }
    cEc();
    cEa();
    f(true, 50L);
    ln(paramBoolean1);
    ll(paramBoolean2);
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
    if ((this.qSL != null) && (this.qSL.getType() == 1) && (this.qSL.qcr != paramInt))
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
      cEe();
      if (!cDZ()) {
        lm(true);
      }
      this.qSL.a(paramInt, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), 0);
      AppMethodBeat.o(181890);
      return;
      if ((this.qSL != null) && (this.qSL.getType() == 1))
      {
        this.qSL.qSd = paramMotionEvent.getRawX();
        this.qSL.qSe = paramMotionEvent.getRawY();
        lo(true);
        AppMethodBeat.o(181890);
        return;
        cEe();
        this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(181859);
            e.this.ln(true);
            e.this.lm(true);
            AppMethodBeat.o(181859);
          }
        }, 200L);
      }
    }
  }
  
  public final void a(View paramView1, View paramView2, View paramView3, int paramInt)
  {
    AppMethodBeat.i(181877);
    if ((!mHasInit) || (paramView1 == null) || (paramView2 == null) || (paramView3 == null) || (this.qSK == null))
    {
      AppMethodBeat.o(181877);
      return;
    }
    switch (FB(paramInt))
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
      if (this.qSK.startOffset == this.qSK.qSo) {
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
      if (this.qSK.startOffset == 0)
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
    } while (this.qSK.qSo == 0);
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
    paramView3.setVisibility(4);
    AppMethodBeat.o(181877);
  }
  
  public final d cDV()
  {
    AppMethodBeat.i(181869);
    if (!mHasInit)
    {
      locald = new d();
      AppMethodBeat.o(181869);
      return locald;
    }
    if (this.qSK == null) {
      this.qSK = new d();
    }
    d locald = new d(this.qSK.bNu, this.qSK.startOffset, this.qSK.endPos, this.qSK.qSo);
    AppMethodBeat.o(181869);
    return locald;
  }
  
  public final void cDY()
  {
    AppMethodBeat.i(181874);
    if (!mHasInit)
    {
      AppMethodBeat.o(181874);
      return;
    }
    cDW();
    f(true, 0L);
    cEc();
    cEa();
    AppMethodBeat.o(181874);
  }
  
  public final boolean cDZ()
  {
    AppMethodBeat.i(181878);
    if ((this.qSI != null) && (this.qSI.isShowing()))
    {
      AppMethodBeat.o(181878);
      return true;
    }
    AppMethodBeat.o(181878);
    return false;
  }
  
  public final void cEa()
  {
    AppMethodBeat.i(181879);
    if (this.qSI != null) {
      this.qSI.dismiss();
    }
    AppMethodBeat.o(181879);
  }
  
  public final boolean cEb()
  {
    AppMethodBeat.i(181882);
    if ((this.qSF != null) && (this.qSF.isShowing()))
    {
      AppMethodBeat.o(181882);
      return true;
    }
    AppMethodBeat.o(181882);
    return false;
  }
  
  public final void cEc()
  {
    AppMethodBeat.i(181883);
    if (!mHasInit)
    {
      AppMethodBeat.o(181883);
      return;
    }
    FC(2);
    FC(3);
    FC(4);
    AppMethodBeat.o(181883);
  }
  
  public final void cEi()
  {
    AppMethodBeat.i(181899);
    Log.i("EditorSelectManager", "deleteSelectedData");
    if (!mHasInit)
    {
      Log.e("EditorSelectManager", "deleteSelectedData: not init");
      AppMethodBeat.o(181899);
      return;
    }
    cEa();
    int i = getSelectType();
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
    Log.e("EditorSelectManager", "deleteSelectedData: not in select");
    cEh();
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
          c localc = f.dG((View)localObject);
          if (localc != null)
          {
            if (localc.qSl == null) {
              break label78;
            }
            if (paramBoolean) {
              localc.qSl.postInvalidate();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label78:
            if ((localc.qSm != null) && (localc.qSn != null))
            {
              LinearLayout localLinearLayout1 = (LinearLayout)((View)localObject).findViewById(2131305733);
              LinearLayout localLinearLayout2 = (LinearLayout)((View)localObject).findViewById(2131305741);
              localObject = (LinearLayout)((View)localObject).findViewById(2131305736);
              e.this.a(localLinearLayout1, localLinearLayout2, (View)localObject, localc.qSm.getPosInDataList());
            }
          }
        }
        AppMethodBeat.o(181852);
      }
    }, paramLong);
    AppMethodBeat.o(181876);
  }
  
  public final int getSelectType()
  {
    AppMethodBeat.i(181868);
    if (!mHasInit)
    {
      AppMethodBeat.o(181868);
      return 0;
    }
    if (this.qSK == null) {
      this.qSK = new d();
    }
    int i = this.qSK.getSelectType();
    AppMethodBeat.o(181868);
    return i;
  }
  
  public final boolean isEditable()
  {
    return (mHasInit) && (this.qSq);
  }
  
  public final void ll(final boolean paramBoolean)
  {
    AppMethodBeat.i(181880);
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181857);
        e.this.lm(paramBoolean);
        AppMethodBeat.o(181857);
      }
    }, 50L);
    AppMethodBeat.o(181880);
  }
  
  public final void lm(boolean paramBoolean)
  {
    AppMethodBeat.i(181881);
    if ((!mHasInit) || (this.qSI == null))
    {
      AppMethodBeat.o(181881);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = getSelectType();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)) || ((this.qSL != null) && (this.qSL.getType() == 1)))
    {
      cEa();
      AppMethodBeat.o(181881);
      return;
    }
    if (!cEj())
    {
      cEa();
      AppMethodBeat.o(181881);
      return;
    }
    int i1 = -1;
    int i2 = -1000;
    int i4 = j(localRecyclerView);
    int i5 = cEg();
    int k = 0;
    int m = 0;
    i = m;
    int j = k;
    if (this.qSI != null)
    {
      i = m;
      j = k;
      if (this.qSI.getContentView() != null)
      {
        this.qSI.getContentView().measure(0, 0);
        i = this.qSI.getContentView().getMeasuredHeight();
        j = this.qSu * 2 + i;
        i = this.qSI.getContentView().getMeasuredWidth() + this.qSu * 2;
      }
    }
    int i3;
    int n;
    if (j == 0)
    {
      i3 = this.qSw;
      if (i != 0) {
        break label414;
      }
      n = this.qSx;
      label229:
      if ((this.qSF == null) || (!this.qSF.isShowing()) || (!A(this.qSC))) {
        break label458;
      }
      j = this.qSC[1] - i3;
      i = this.qSC[1] + this.qSF.getHeight() - this.qSy;
      if ((j < i4) || (j > i5)) {
        break label420;
      }
      k = this.qSC[0];
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
        j = ((LinearLayoutManager)localObject).ks();
        k = ((LinearLayoutManager)localObject).ku();
        if ((this.qSK.bNu > j) || (this.qSK.endPos < k)) {
          break label911;
        }
        k = 300;
        j = -1000;
      }
      for (;;)
      {
        if (k == -1)
        {
          cEa();
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
          j = this.qSC[0];
          break label311;
          label458:
          i = i2;
          j = i1;
          if (this.qSG != null)
          {
            i = i2;
            j = i1;
            if (this.qSG.isShowing())
            {
              i = i2;
              j = i1;
              if (A(this.qSD))
              {
                j = this.qSD[1] - i3;
                k = this.qSD[1] + this.qSG.getHeight() - this.qSy;
                if ((j < i4) || (j > i5)) {
                  break label662;
                }
                i = this.qSD[0];
              }
            }
          }
          for (;;)
          {
            m = i;
            k = j;
            if (this.qSH == null) {
              break label921;
            }
            m = i;
            k = j;
            if (!this.qSH.isShowing()) {
              break label921;
            }
            m = i;
            k = j;
            if (!A(this.qSE)) {
              break label921;
            }
            k = this.qSE[1] - i3;
            i1 = this.qSE[1] + this.qSH.getHeight() - this.qSy;
            if (j != -1) {
              break label740;
            }
            if ((k < i4) || (k > i5)) {
              break label701;
            }
            j = this.qSE[0];
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
                i = this.qSD[0];
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
          j = this.qSE[0];
          i = i1;
          break label311;
          label740:
          m = i;
          k = j;
          if (j + i3 <= this.qSE[1]) {
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
          j = this.qSE[0];
          i = i1;
          break label311;
        }
        i = this.mScreenWidth / 3;
        m = this.mScreenWidth * 2 / 3;
        if ((j == -1000) || ((j >= i) && (j <= m)))
        {
          d(localRecyclerView, (this.mScreenWidth - n) / 2, k);
          AppMethodBeat.o(181881);
          return;
        }
        if (j < i)
        {
          d(localRecyclerView, this.qSv, k);
          AppMethodBeat.o(181881);
          return;
        }
        d(localRecyclerView, this.mScreenWidth - n - this.qSv, k);
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
  
  public final void ln(boolean paramBoolean)
  {
    AppMethodBeat.i(181885);
    if (!mHasInit)
    {
      AppMethodBeat.o(181885);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = getSelectType();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)))
    {
      cEc();
      AppMethodBeat.o(181885);
      return;
    }
    View localView1 = f.d(localRecyclerView, this.qSK.bNu);
    View localView2 = f.d(localRecyclerView, this.qSK.endPos);
    if (i == 1)
    {
      FC(3);
      FC(4);
      a(2, localRecyclerView, localView1, this.qSK.startOffset);
      AppMethodBeat.o(181885);
      return;
    }
    FC(2);
    a(3, localRecyclerView, localView1, this.qSK.startOffset);
    a(4, localRecyclerView, localView2, this.qSK.qSo);
    AppMethodBeat.o(181885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.c.e
 * JD-Core Version:    0.7.0.1
 */