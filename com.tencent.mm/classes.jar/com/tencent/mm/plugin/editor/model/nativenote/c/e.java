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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Collections;

public final class e
  implements a.a
{
  public static boolean mHasInit = false;
  public static volatile e oSJ = null;
  public ao mHandler = null;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public boolean oSK = true;
  public int oSL = 0;
  public int oSM = 0;
  public int oSN = 14;
  public int oSO = 0;
  public int oSP = 0;
  public int oSQ = 0;
  public int oSR = 0;
  public int oSS = 0;
  public int oST = 0;
  public int oSU = 0;
  public int[] oSV = null;
  public int[] oSW = null;
  public int[] oSX = null;
  public int[] oSY = null;
  public PopupWindow oSZ = null;
  public PopupWindow oTa = null;
  public PopupWindow oTb = null;
  public PopupWindow oTc = null;
  public com.tencent.mm.plugin.editor.model.nativenote.b.a oTd = null;
  public d oTe = null;
  public b oTf = null;
  public au oTg = null;
  public au oTh = null;
  public TextView oTi = null;
  public TextView oTj = null;
  public TextView oTk = null;
  public TextView oTl = null;
  public TextView oTm = null;
  public TextView oTn = null;
  public TextView oTo = null;
  public TextView oTp = null;
  
  private e()
  {
    mHasInit = false;
  }
  
  private boolean AY(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(181884);
    if ((this.oTf != null) && (this.oTf.oeH == paramInt) && (this.oTf.getType() == 1))
    {
      AppMethodBeat.o(181884);
      return false;
    }
    if ((paramInt == 2) && (this.oSZ != null))
    {
      this.oSZ.dismiss();
      V(2, -1, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(181884);
      return bool;
      if ((paramInt == 3) && (this.oTa != null))
      {
        this.oTa.dismiss();
        V(3, -1, -1);
      }
      else if ((paramInt == 4) && (this.oTb != null))
      {
        this.oTb.dismiss();
        V(4, -1, -1);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private void V(int paramInt1, int paramInt2, int paramInt3)
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
        } while ((this.oSW == null) || (this.oSW.length != 2));
        this.oSW[0] = paramInt2;
        this.oSW[1] = paramInt3;
        return;
      } while ((this.oSX == null) || (this.oSX.length != 2));
      this.oSX[0] = paramInt2;
      this.oSX[1] = paramInt3;
      return;
    } while ((this.oSY == null) || (this.oSY.length != 2));
    this.oSY[0] = paramInt2;
    this.oSY[1] = paramInt3;
  }
  
  private int W(int paramInt1, int paramInt2, int paramInt3)
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
      if ((this.oTe == null) || (paramInt2 > this.oTe.endPos) || ((paramInt2 == this.oTe.endPos) && (paramInt3 >= this.oTe.oSI)))
      {
        AppMethodBeat.o(181892);
        return 1;
      }
      bool = A(paramInt2, paramInt3, this.oTe.endPos, this.oTe.oSI);
      continue;
      if ((this.oTe == null) || (paramInt2 < this.oTe.cUq) || ((paramInt2 == this.oTe.cUq) && (paramInt3 <= this.oTe.startOffset)))
      {
        AppMethodBeat.o(181892);
        return 1;
      }
      bool = A(this.oTe.cUq, this.oTe.startOffset, paramInt2, paramInt3);
    }
    AppMethodBeat.o(181892);
    return 2;
  }
  
  private static SpannableStringBuilder a(j paramj, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    AppMethodBeat.i(181902);
    if (paramj == null)
    {
      ac.e("EditorSelectManager", "processTextDataItem: textDataItem is null");
      AppMethodBeat.o(181902);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.a.a.Xo(paramj.content);
    if (localObject == null)
    {
      ac.e("EditorSelectManager", "processTextDataItem: spannedText is null");
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
        ac.e("EditorSelectManager", "processTextDataItem: incorrect offset");
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
        if (!bs.isNullOrNil(str))
        {
          Spanned localSpanned = com.tencent.mm.plugin.editor.model.nativenote.a.a.Xo(str);
          paramInt1 = paramInt2;
          if (localSpanned != null) {
            paramInt1 = paramInt2 + localSpanned.length();
          }
        }
        paramj.content = (com.tencent.mm.plugin.editor.model.nativenote.a.b.a(paramString) + str + com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)localObject));
      }
      if (paramBoolean3) {
        paramj.oPV = true;
      }
      for (paramj.oPX = paramInt1;; paramj.oPX = -1)
      {
        AppMethodBeat.o(181902);
        return localSpannableStringBuilder;
        paramj.oPV = false;
      }
    }
  }
  
  private SpannableStringBuilder a(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(181900);
    d locald = can();
    caq();
    int j = locald.cak();
    if ((j != 1) && (j != 2))
    {
      ac.e("EditorSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
      AppMethodBeat.o(181900);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().AS(locald.cUq);
    if (localObject == null)
    {
      ac.e("EditorSelectManager", "getAndProcessSelectedDataInSingleSelect: item is null");
      AppMethodBeat.o(181900);
      return null;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1)
    {
      if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramString = a((j)localObject, locald.startOffset, locald.oSI, false, false, "", true);
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().a(paramArrayList, 0, locald.cUq, locald.startOffset, locald.oSI);
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().fc(locald.cUq, locald.cUq + paramArrayList.size() + 1);
        paramArrayList = paramString;
      }
      for (;;)
      {
        AppMethodBeat.o(181900);
        return paramArrayList;
        paramString = a((j)localObject, locald.startOffset, locald.oSI, false, paramBoolean, paramString, true);
        if (this.oTd != null) {
          this.oTd.AN(locald.cUq);
        }
        paramArrayList = paramString;
        if (paramBoolean)
        {
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().bZP();
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
      if (bs.isNullOrNil(paramString)) {
        break label411;
      }
      paramArrayList = new ArrayList();
      localObject = new j();
      ((j)localObject).content = paramString;
      ((j)localObject).oPV = false;
      ((j)localObject).oPX = -1;
      paramArrayList.add(localObject);
    }
    label411:
    label420:
    for (;;)
    {
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().a(paramArrayList, i, locald.cUq, locald.startOffset, locald.oSI);
      paramString = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF();
      i = locald.cUq;
      j = locald.cUq;
      paramString.fc(i - 1, paramArrayList.size() + j + 1);
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
    paramView = f.dL(paramView);
    if (paramView == null)
    {
      AY(paramInt1);
      AppMethodBeat.o(181886);
      return;
    }
    if (paramView.oSF != null) {
      paramView = paramView.oSF;
    }
    for (;;)
    {
      if (paramView == null)
      {
        AY(paramInt1);
        AppMethodBeat.o(181886);
        return;
        if ((paramView.oSG != null) && (paramView.oSH != null))
        {
          if (paramInt2 == 0)
          {
            paramView = paramView.oSG;
            paramInt2 = 0;
            continue;
          }
          if (paramInt2 == 1)
          {
            paramView = paramView.oSH;
            paramInt2 = 0;
          }
        }
      }
      else
      {
        Object localObject = paramView.getText();
        if ((localObject == null) || (paramInt2 < 0) || (paramInt2 > ((Editable)localObject).length()))
        {
          AY(paramInt1);
          AppMethodBeat.o(181886);
          return;
        }
        localObject = paramView.getLayout();
        if (localObject == null)
        {
          AY(paramInt1);
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
          f3 = f3 + paramView.getHeight() - this.oSL;
          if (paramInt1 == 3)
          {
            f1 = f4 + this.oSU;
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
            AY(paramInt1);
          }
          AppMethodBeat.o(181886);
          return;
          f1 = f4;
          f2 = f3;
          if (paramInt1 != 4) {
            break;
          }
          f1 = f4 - this.oSU;
          f2 = f3;
          break;
          bool = a(2, paramRecyclerView, this.oSZ, (int)(f1 + localObject[0] - this.oST), (int)(localObject[1] + f2));
          continue;
          bool = a(3, paramRecyclerView, this.oTa, (int)(f1 + localObject[0] - this.oTa.getWidth()), (int)(localObject[1] + f2));
          continue;
          bool = a(4, paramRecyclerView, this.oTb, (int)(f1 + localObject[0]), (int)(localObject[1] + f2));
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
    if ((paramInt3 < p(paramRecyclerView)) || (paramInt3 > this.mScreenHeight - cam()))
    {
      AppMethodBeat.o(181887);
      return false;
    }
    if (paramPopupWindow.isShowing())
    {
      paramPopupWindow.update(paramInt2, paramInt3, -1, -1, false);
      V(paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      if (paramInt1 == 2)
      {
        cav();
        this.oTh.au(3000L, 0L);
      }
      AppMethodBeat.o(181887);
      return true;
      paramPopupWindow.showAtLocation(paramRecyclerView, 0, paramInt2, paramInt3);
      V(paramInt1, paramInt2, paramInt3);
    }
  }
  
  private ArrayList<com.tencent.mm.plugin.editor.model.a.a> b(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList, String paramString)
  {
    AppMethodBeat.i(181901);
    d locald = can();
    caq();
    ArrayList localArrayList = new ArrayList();
    if (locald.cak() != 3)
    {
      ac.e("EditorSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
      AppMethodBeat.o(181901);
      return null;
    }
    int i = locald.cUq;
    int j = locald.endPos;
    if (j >= locald.cUq)
    {
      Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().AS(j);
      SpannableStringBuilder localSpannableStringBuilder;
      j localj;
      if (localObject != null) {
        if ((j == locald.endPos) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
        {
          localObject = (j)localObject;
          localSpannableStringBuilder = a((j)localObject, 0, locald.oSI, false, paramBoolean, "", false);
          if (!bs.aj(localSpannableStringBuilder))
          {
            localj = new j();
            localj.content = com.tencent.mm.plugin.editor.model.nativenote.a.b.a(localSpannableStringBuilder);
            localj.oPX = -1;
            localj.oPV = false;
            localArrayList.add(localj);
          }
          if ((paramBoolean) && (bs.isNullOrNil(((j)localObject).content))) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().W(j, true);
          }
        }
      }
      for (;;)
      {
        j -= 1;
        break;
        if ((j == locald.cUq) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
        {
          localObject = (j)localObject;
          localSpannableStringBuilder = a((j)localObject, locald.startOffset, 0, true, paramBoolean, "", false);
          if (!bs.aj(localSpannableStringBuilder))
          {
            localj = new j();
            localj.content = com.tencent.mm.plugin.editor.model.nativenote.a.b.a(localSpannableStringBuilder);
            localj.oPX = -1;
            localj.oPV = false;
            localArrayList.add(localj);
          }
          if ((paramBoolean) && (bs.isNullOrNil(((j)localObject).content))) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().W(j, true);
          } else {
            i += 1;
          }
        }
        else
        {
          localArrayList.add(com.tencent.mm.plugin.editor.b.a((com.tencent.mm.plugin.editor.model.a.a)localObject));
          if (paramBoolean) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().W(j, true);
          }
        }
      }
    }
    if (paramBoolean)
    {
      j = i + 1;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().b(i, paramArrayList);
        j = paramArrayList.size() + i;
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().fc(i - 1, j);
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
      paramArrayList.oPV = false;
      paramArrayList.oPX = -1;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().a(i, paramArrayList);
      break;
      paramString = "";
    }
  }
  
  private boolean caB()
  {
    AppMethodBeat.i(181903);
    boolean bool1 = o(this.oTi, false);
    boolean bool2 = o(this.oTj, false);
    boolean bool3 = o(this.oTk, caC());
    boolean bool4 = o(this.oTl, caD());
    boolean bool5 = o(this.oTm, caE());
    boolean bool6 = o(this.oTn, caF());
    boolean bool7 = o(this.oTo, caG());
    boolean bool8 = o(this.oTp, caH());
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5) || (bool6) || (bool7) || (bool8))
    {
      AppMethodBeat.o(181903);
      return true;
    }
    AppMethodBeat.o(181903);
    return false;
  }
  
  private boolean caC()
  {
    AppMethodBeat.i(181905);
    if (cak() != 1)
    {
      AppMethodBeat.o(181905);
      return false;
    }
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().AS(this.oTe.cUq);
    if ((locala != null) && ((com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().size() > 1) || (locala.getType() != 1) || (!bs.isNullOrNil(((j)locala).content))))
    {
      AppMethodBeat.o(181905);
      return true;
    }
    AppMethodBeat.o(181905);
    return false;
  }
  
  private boolean caD()
  {
    AppMethodBeat.i(181906);
    int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().bZQ();
    int j = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().bZR();
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().AS(i);
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().AS(j);
    if ((localObject == null) || (locala == null))
    {
      AppMethodBeat.o(181906);
      return false;
    }
    if ((this.oTe != null) && (this.oTe.cUq == i) && (this.oTe.startOffset == 0) && (this.oTe.endPos == j)) {
      if (locala.getType() == 1)
      {
        localObject = com.tencent.mm.plugin.editor.model.nativenote.a.a.Xo(((j)locala).content);
        if (localObject == null)
        {
          AppMethodBeat.o(181906);
          return false;
        }
        if (this.oTe.oSI == ((Spanned)localObject).length())
        {
          AppMethodBeat.o(181906);
          return false;
        }
      }
      else if ((locala.getType() != 1) && (this.oTe.oSI == 1))
      {
        AppMethodBeat.o(181906);
        return false;
      }
    }
    AppMethodBeat.o(181906);
    return true;
  }
  
  private boolean caE()
  {
    boolean bool2 = true;
    AppMethodBeat.i(181907);
    if (!this.oSK)
    {
      AppMethodBeat.o(181907);
      return false;
    }
    int i = cak();
    if ((i == 0) || (i == 1))
    {
      AppMethodBeat.o(181907);
      return false;
    }
    boolean bool1 = bool2;
    if (this.oTd != null) {
      if (this.oTd.bYX()) {
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
  
  private boolean caF()
  {
    AppMethodBeat.i(181908);
    int i = cak();
    if ((this.oSK) && ((i == 2) || (i == 3)))
    {
      AppMethodBeat.o(181908);
      return true;
    }
    AppMethodBeat.o(181908);
    return false;
  }
  
  private boolean caG()
  {
    AppMethodBeat.i(181909);
    int i = cak();
    if ((i == 2) || (i == 3))
    {
      AppMethodBeat.o(181909);
      return true;
    }
    AppMethodBeat.o(181909);
    return false;
  }
  
  private boolean caH()
  {
    AppMethodBeat.i(181910);
    if ((!this.oSK) || (cak() == 0))
    {
      AppMethodBeat.o(181910);
      return false;
    }
    ai.getContext();
    if (com.tencent.mm.plugin.editor.model.nativenote.manager.b.bZE() != 1)
    {
      AppMethodBeat.o(181910);
      return true;
    }
    AppMethodBeat.o(181910);
    return false;
  }
  
  public static e cal()
  {
    AppMethodBeat.i(181865);
    if (oSJ == null) {}
    try
    {
      if (oSJ == null) {
        oSJ = new e();
      }
      e locale = oSJ;
      AppMethodBeat.o(181865);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(181865);
    }
  }
  
  private int cam()
  {
    AppMethodBeat.i(181867);
    if (this.oTd != null)
    {
      int i = this.oTd.bYV();
      int j = this.oTd.bYW();
      AppMethodBeat.o(181867);
      return i + j;
    }
    AppMethodBeat.o(181867);
    return 0;
  }
  
  private void cao()
  {
    AppMethodBeat.i(181871);
    A(-1, -1, -1, -1);
    AppMethodBeat.o(181871);
  }
  
  private void cap()
  {
    AppMethodBeat.i(181873);
    if (this.oTd != null) {
      this.oTd.bYU();
    }
    AppMethodBeat.o(181873);
  }
  
  private void cav()
  {
    AppMethodBeat.i(181888);
    if (this.oTh == null)
    {
      this.oTh = new au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(181858);
          if ((e.this.cak() == 1) && (e.b(e.this))) {
            e.this.cas();
          }
          AppMethodBeat.o(181858);
          return true;
        }
      }, false);
      AppMethodBeat.o(181888);
      return;
    }
    this.oTh.stopTimer();
    AppMethodBeat.o(181888);
  }
  
  private void caw()
  {
    AppMethodBeat.i(181893);
    if (this.oTf == null)
    {
      this.oTf = new b();
      AppMethodBeat.o(181893);
      return;
    }
    this.oTf.reset();
    AppMethodBeat.o(181893);
  }
  
  private void cax()
  {
    AppMethodBeat.i(181894);
    if (this.oTg == null)
    {
      this.oTg = new au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(181860);
          ac.d("EditorSelectManager", "onTimerExpired: ");
          RecyclerView localRecyclerView = e.a(e.this);
          int i;
          int j;
          if ((e.c(e.this) != null) && (e.c(e.this).oSy < e.a(e.this, localRecyclerView)))
          {
            i = 1;
            if ((e.c(e.this) == null) || (e.c(e.this).oSy <= e.d(e.this))) {
              break label206;
            }
            j = 1;
            label89:
            if ((!e.KO()) || (localRecyclerView == null) || (e.c(e.this) == null) || (e.c(e.this).getType() != 1) || ((i == 0) && (j == 0))) {
              break label256;
            }
            if ((i == 0) || (!localRecyclerView.canScrollVertically(-1))) {
              break label211;
            }
            if (e.c(e.this).oeH == 3) {
              e.e(e.this);
            }
            e.f(e.this);
            e.this.cau();
            e.this.cas();
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
              e.this.cau();
              e.this.cas();
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
    this.oTg.stopTimer();
    AppMethodBeat.o(181894);
  }
  
  private int cay()
  {
    AppMethodBeat.i(181896);
    int j = 0;
    if (this.oTd != null) {
      j = this.oTd.bYV();
    }
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.oTd != null) {
        i = this.oTd.bYW();
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
  
  private void caz()
  {
    AppMethodBeat.i(181898);
    if (this.oTd != null) {
      this.oTd.bYT();
    }
    AppMethodBeat.o(181898);
  }
  
  private RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(181866);
    if (this.oTd != null)
    {
      RecyclerView localRecyclerView = this.oTd.bYY();
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
    if ((!mHasInit) || (paramRecyclerView == null) || (this.oTc == null))
    {
      AppMethodBeat.o(181889);
      return false;
    }
    if ((paramInt2 < p(paramRecyclerView)) || (paramInt2 > this.mScreenHeight - cam()))
    {
      AppMethodBeat.o(181889);
      return false;
    }
    if (this.oTc.isShowing()) {
      this.oTc.update(paramInt1, paramInt2, -1, -1, false);
    }
    for (;;)
    {
      AppMethodBeat.o(181889);
      return true;
      this.oTc.showAtLocation(paramRecyclerView, 0, paramInt1, paramInt2);
    }
  }
  
  public static boolean isEnabled()
  {
    return mHasInit;
  }
  
  private void kb(boolean paramBoolean)
  {
    AppMethodBeat.i(181891);
    if ((!mHasInit) || (this.oSZ == null) || (this.oTa == null) || (this.oTb == null) || (this.oTe == null))
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
    if ((this.oTf == null) || (this.oTf.getType() != 1))
    {
      AppMethodBeat.o(181891);
      return;
    }
    int k = this.oTf.oeH;
    if ((k != 2) && (k != 3) && (k != 4))
    {
      AppMethodBeat.o(181891);
      return;
    }
    float f2 = this.oTf.oSx - this.oTf.cCh;
    float f1 = this.oTf.oSy;
    float f3 = this.oTf.cCi;
    f3 = this.oSL / 2 + (f1 - f3);
    View localView;
    Object localObject2;
    Object localObject1;
    int i;
    if (k == 2)
    {
      f1 = f2 + this.oSZ.getWidth() / 2;
      localRecyclerView.getLocationOnScreen(this.oSV);
      localView = localRecyclerView.o(f1 - this.oSV[0], f3 - this.oSV[1]);
      localObject2 = f.dL(localView);
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
        f1 = f2 + this.oTa.getWidth();
        break;
        if (((c)localObject2).oSF != null)
        {
          localObject1 = ((c)localObject2).oSF;
          localObject2 = new int[2];
          ((WXRTEditText)localObject1).getLocationOnScreen((int[])localObject2);
          i = ((WXRTEditText)localObject1).getOffsetForPosition(f1 - localObject2[0], f3 - localObject2[1]);
          i = W(k, ((WXRTEditText)localObject1).getPosInDataList(), i);
        }
        else if ((((c)localObject2).oSG != null) && (((c)localObject2).oSH != null))
        {
          if (k == 3)
          {
            localObject2 = ((c)localObject2).oSG;
            j = W(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.oTa, (int)(this.oTf.oSx - this.oTf.cCh), (int)(this.oTf.oSy - this.oTf.cCi));
              i = j;
              localObject1 = localObject2;
            }
          }
          else if (k == 4)
          {
            localObject2 = ((c)localObject2).oSH;
            j = W(k, ((WXRTEditText)localObject2).getPosInDataList(), 1);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.oTb, (int)(this.oTf.oSx - this.oTf.cCh), (int)(this.oTf.oSy - this.oTf.cCi));
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
            localObject2 = ((c)localObject2).oSG;
          }
          for (int j = W(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);; j = W(k, ((WXRTEditText)localObject2).getPosInDataList(), 1))
          {
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.oSZ, (int)(this.oTf.oSx - this.oTf.cCh), (int)(this.oTf.oSy - this.oTf.cCi));
              localObject1 = localObject2;
              i = j;
            }
            break;
            localObject2 = ((c)localObject2).oSH;
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
          if ((!paramBoolean) || ((this.oTf.oSy >= p(localRecyclerView)) && (this.oTf.oSy <= cay())) || ((this.oTg != null) && (!this.oTg.eVs()))) {
            break label1166;
          }
          cax();
          this.oTg.au(100L, 100L);
          AppMethodBeat.o(181891);
          return;
          i = 1;
          continue;
          localObject2 = ((WXRTEditText)localObject1).getText();
          i = cak();
          if ((this.oSK) && (localObject2 != null) && (i == 1))
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
                cap();
              }
              cas();
              f(true, 0L);
              if (k != 4) {
                break label1150;
              }
            }
          }
          label1150:
          for (i = this.oTe.oSI;; i = this.oTe.startOffset)
          {
            a(k, localRecyclerView, localView, i);
            i = 1;
            break;
            if (this.oTe.startOffset > ((Editable)localObject2).length()) {
              break label915;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.oTe.startOffset);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label915;
            if ((!this.oSK) || (localObject2 == null) || (i != 2) || (!((WXRTEditText)localObject1).hasFocus())) {
              break label915;
            }
            if ((((WXRTEditText)localObject1).getEditTextType() == 1) || (((WXRTEditText)localObject1).getEditTextType() == 2))
            {
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
              ((WXRTEditText)localObject1).setSelection(0);
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
              break label915;
            }
            if ((this.oTe.startOffset > ((Editable)localObject2).length()) || (this.oTe.oSI > ((Editable)localObject2).length())) {
              break label915;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.oTe.startOffset, this.oTe.oSI);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label915;
          }
        }
        label915:
        cax();
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
      paramRecyclerView.getLocationOnScreen(this.oSV);
      i = j;
      if (x(this.oSV)) {
        i = this.oSV[1];
      }
    }
    AppMethodBeat.o(181895);
    return i;
  }
  
  private static boolean x(int[] paramArrayOfInt)
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
    if (this.oTe == null)
    {
      this.oTe = new d(paramInt1, paramInt2, paramInt3, paramInt4);
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        ac.d("EditorSelectManager", "setSelectInfo: %d:%d - %d:%d", new Object[] { Integer.valueOf(this.oTe.cUq), Integer.valueOf(this.oTe.startOffset), Integer.valueOf(this.oTe.endPos), Integer.valueOf(this.oTe.oSI) });
      }
      AppMethodBeat.o(181870);
      return bool;
      if ((this.oTe.cUq != paramInt1) || (this.oTe.startOffset != paramInt2) || (this.oTe.endPos != paramInt3) || (this.oTe.oSI != paramInt4))
      {
        this.oTe.set(paramInt1, paramInt2, paramInt3, paramInt4);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final int AX(int paramInt)
  {
    AppMethodBeat.i(181872);
    if ((!mHasInit) || (this.oTe == null))
    {
      AppMethodBeat.o(181872);
      return 0;
    }
    if ((cak() == 0) || (paramInt < this.oTe.cUq) || (paramInt > this.oTe.endPos))
    {
      AppMethodBeat.o(181872);
      return 0;
    }
    if ((paramInt == this.oTe.cUq) && (paramInt == this.oTe.endPos))
    {
      AppMethodBeat.o(181872);
      return 1;
    }
    if ((paramInt > this.oTe.cUq) && (paramInt < this.oTe.endPos))
    {
      AppMethodBeat.o(181872);
      return 2;
    }
    if ((paramInt == this.oTe.cUq) && (paramInt < this.oTe.endPos))
    {
      AppMethodBeat.o(181872);
      return 4;
    }
    if ((paramInt > this.oTe.cUq) && (paramInt == this.oTe.endPos))
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
    cau();
    cas();
    f(true, 50L);
    ka(paramBoolean1);
    jY(paramBoolean2);
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
    if ((this.oTf != null) && (this.oTf.getType() == 1) && (this.oTf.oeH != paramInt))
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
      caw();
      if (!car()) {
        jZ(true);
      }
      this.oTf.a(paramInt, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), 0);
      AppMethodBeat.o(181890);
      return;
      if ((this.oTf != null) && (this.oTf.getType() == 1))
      {
        this.oTf.oSx = paramMotionEvent.getRawX();
        this.oTf.oSy = paramMotionEvent.getRawY();
        kb(true);
        AppMethodBeat.o(181890);
        return;
        caw();
        this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(181859);
            e.this.ka(true);
            e.this.jZ(true);
            AppMethodBeat.o(181859);
          }
        }, 200L);
      }
    }
  }
  
  public final void a(View paramView1, View paramView2, View paramView3, int paramInt)
  {
    AppMethodBeat.i(181877);
    if ((!mHasInit) || (paramView1 == null) || (paramView2 == null) || (paramView3 == null) || (this.oTe == null))
    {
      AppMethodBeat.o(181877);
      return;
    }
    switch (AX(paramInt))
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
      if (this.oTe.startOffset == this.oTe.oSI) {
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
      if (this.oTe.startOffset == 0)
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
    } while (this.oTe.oSI == 0);
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
    paramView3.setVisibility(4);
    AppMethodBeat.o(181877);
  }
  
  public final void caA()
  {
    AppMethodBeat.i(181899);
    ac.i("EditorSelectManager", "deleteSelectedData");
    if (!mHasInit)
    {
      ac.e("EditorSelectManager", "deleteSelectedData: not init");
      AppMethodBeat.o(181899);
      return;
    }
    cas();
    int i = cak();
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
    ac.e("EditorSelectManager", "deleteSelectedData: not in select");
    caz();
    AppMethodBeat.o(181899);
  }
  
  public final int cak()
  {
    AppMethodBeat.i(181868);
    if (!mHasInit)
    {
      AppMethodBeat.o(181868);
      return 0;
    }
    if (this.oTe == null) {
      this.oTe = new d();
    }
    int i = this.oTe.cak();
    AppMethodBeat.o(181868);
    return i;
  }
  
  public final d can()
  {
    AppMethodBeat.i(181869);
    if (!mHasInit)
    {
      locald = new d();
      AppMethodBeat.o(181869);
      return locald;
    }
    if (this.oTe == null) {
      this.oTe = new d();
    }
    d locald = new d(this.oTe.cUq, this.oTe.startOffset, this.oTe.endPos, this.oTe.oSI);
    AppMethodBeat.o(181869);
    return locald;
  }
  
  public final void caq()
  {
    AppMethodBeat.i(181874);
    if (!mHasInit)
    {
      AppMethodBeat.o(181874);
      return;
    }
    cao();
    f(true, 0L);
    cau();
    cas();
    AppMethodBeat.o(181874);
  }
  
  public final boolean car()
  {
    AppMethodBeat.i(181878);
    if ((this.oTc != null) && (this.oTc.isShowing()))
    {
      AppMethodBeat.o(181878);
      return true;
    }
    AppMethodBeat.o(181878);
    return false;
  }
  
  public final void cas()
  {
    AppMethodBeat.i(181879);
    if (this.oTc != null) {
      this.oTc.dismiss();
    }
    AppMethodBeat.o(181879);
  }
  
  public final boolean cat()
  {
    AppMethodBeat.i(181882);
    if ((this.oSZ != null) && (this.oSZ.isShowing()))
    {
      AppMethodBeat.o(181882);
      return true;
    }
    AppMethodBeat.o(181882);
    return false;
  }
  
  public final void cau()
  {
    AppMethodBeat.i(181883);
    if (!mHasInit)
    {
      AppMethodBeat.o(181883);
      return;
    }
    AY(2);
    AY(3);
    AY(4);
    AppMethodBeat.o(181883);
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
          c localc = f.dL((View)localObject);
          if (localc != null)
          {
            if (localc.oSF == null) {
              break label78;
            }
            if (paramBoolean) {
              localc.oSF.postInvalidate();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label78:
            if ((localc.oSG != null) && (localc.oSH != null))
            {
              LinearLayout localLinearLayout1 = (LinearLayout)((View)localObject).findViewById(2131303103);
              LinearLayout localLinearLayout2 = (LinearLayout)((View)localObject).findViewById(2131303110);
              localObject = (LinearLayout)((View)localObject).findViewById(2131303105);
              e.this.a(localLinearLayout1, localLinearLayout2, (View)localObject, localc.oSG.getPosInDataList());
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
    return (mHasInit) && (this.oSK);
  }
  
  public final void jY(final boolean paramBoolean)
  {
    AppMethodBeat.i(181880);
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181857);
        e.this.jZ(paramBoolean);
        AppMethodBeat.o(181857);
      }
    }, 50L);
    AppMethodBeat.o(181880);
  }
  
  public final void jZ(boolean paramBoolean)
  {
    AppMethodBeat.i(181881);
    if ((!mHasInit) || (this.oTc == null))
    {
      AppMethodBeat.o(181881);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = cak();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)) || ((this.oTf != null) && (this.oTf.getType() == 1)))
    {
      cas();
      AppMethodBeat.o(181881);
      return;
    }
    if (!caB())
    {
      cas();
      AppMethodBeat.o(181881);
      return;
    }
    int i1 = -1;
    int i2 = -1000;
    int i4 = p(localRecyclerView);
    int i5 = cay();
    int k = 0;
    int m = 0;
    i = m;
    int j = k;
    if (this.oTc != null)
    {
      i = m;
      j = k;
      if (this.oTc.getContentView() != null)
      {
        this.oTc.getContentView().measure(0, 0);
        i = this.oTc.getContentView().getMeasuredHeight();
        j = this.oSO * 2 + i;
        i = this.oTc.getContentView().getMeasuredWidth() + this.oSO * 2;
      }
    }
    int i3;
    int n;
    if (j == 0)
    {
      i3 = this.oSQ;
      if (i != 0) {
        break label414;
      }
      n = this.oSR;
      label229:
      if ((this.oSZ == null) || (!this.oSZ.isShowing()) || (!x(this.oSW))) {
        break label458;
      }
      j = this.oSW[1] - i3;
      i = this.oSW[1] + this.oSZ.getHeight() - this.oSS;
      if ((j < i4) || (j > i5)) {
        break label420;
      }
      k = this.oSW[0];
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
        j = ((LinearLayoutManager)localObject).jW();
        k = ((LinearLayoutManager)localObject).jY();
        if ((this.oTe.cUq > j) || (this.oTe.endPos < k)) {
          break label911;
        }
        k = 300;
        j = -1000;
      }
      for (;;)
      {
        if (k == -1)
        {
          cas();
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
          j = this.oSW[0];
          break label311;
          label458:
          i = i2;
          j = i1;
          if (this.oTa != null)
          {
            i = i2;
            j = i1;
            if (this.oTa.isShowing())
            {
              i = i2;
              j = i1;
              if (x(this.oSX))
              {
                j = this.oSX[1] - i3;
                k = this.oSX[1] + this.oTa.getHeight() - this.oSS;
                if ((j < i4) || (j > i5)) {
                  break label662;
                }
                i = this.oSX[0];
              }
            }
          }
          for (;;)
          {
            m = i;
            k = j;
            if (this.oTb == null) {
              break label921;
            }
            m = i;
            k = j;
            if (!this.oTb.isShowing()) {
              break label921;
            }
            m = i;
            k = j;
            if (!x(this.oSY)) {
              break label921;
            }
            k = this.oSY[1] - i3;
            i1 = this.oSY[1] + this.oTb.getHeight() - this.oSS;
            if (j != -1) {
              break label740;
            }
            if ((k < i4) || (k > i5)) {
              break label701;
            }
            j = this.oSY[0];
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
                i = this.oSX[0];
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
          j = this.oSY[0];
          i = i1;
          break label311;
          label740:
          m = i;
          k = j;
          if (j + i3 <= this.oSY[1]) {
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
          j = this.oSY[0];
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
          i(localRecyclerView, this.oSP, k);
          AppMethodBeat.o(181881);
          return;
        }
        i(localRecyclerView, this.mScreenWidth - n - this.oSP, k);
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
  
  public final void ka(boolean paramBoolean)
  {
    AppMethodBeat.i(181885);
    if (!mHasInit)
    {
      AppMethodBeat.o(181885);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = cak();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)))
    {
      cau();
      AppMethodBeat.o(181885);
      return;
    }
    View localView1 = f.e(localRecyclerView, this.oTe.cUq);
    View localView2 = f.e(localRecyclerView, this.oTe.endPos);
    if (i == 1)
    {
      AY(3);
      AY(4);
      a(2, localRecyclerView, localView1, this.oTe.startOffset);
      AppMethodBeat.o(181885);
      return;
    }
    AY(2);
    a(3, localRecyclerView, localView1, this.oTe.startOffset);
    a(4, localRecyclerView, localView2, this.oTe.oSI);
    AppMethodBeat.o(181885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.c.e
 * JD-Core Version:    0.7.0.1
 */