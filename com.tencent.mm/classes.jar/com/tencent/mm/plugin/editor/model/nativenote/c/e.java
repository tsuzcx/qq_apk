package com.tencent.mm.plugin.editor.model.nativenote.c;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.d.e;
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
  public static volatile e uuv = null;
  public MMHandler mHandler = null;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public int uuA = 0;
  public int uuB = 0;
  public int uuC = 0;
  public int uuD = 0;
  public int uuE = 0;
  public int uuF = 0;
  public int uuG = 0;
  public int[] uuH = null;
  public int[] uuI = null;
  public int[] uuJ = null;
  public int[] uuK = null;
  public PopupWindow uuL = null;
  public PopupWindow uuM = null;
  public PopupWindow uuN = null;
  public PopupWindow uuO = null;
  public com.tencent.mm.plugin.editor.model.nativenote.b.a uuP = null;
  public d uuQ = null;
  public b uuR = null;
  public MTimerHandler uuS = null;
  public MTimerHandler uuT = null;
  public TextView uuU = null;
  public TextView uuV = null;
  public TextView uuW = null;
  public TextView uuX = null;
  public TextView uuY = null;
  public TextView uuZ = null;
  public boolean uuw = true;
  public int uux = 0;
  public int uuy = 0;
  public int uuz = 14;
  public TextView uva = null;
  public TextView uvb = null;
  
  private e()
  {
    mHasInit = false;
  }
  
  private static boolean A(int[] paramArrayOfInt)
  {
    return (mHasInit) && (paramArrayOfInt != null) && (paramArrayOfInt.length == 2) && (paramArrayOfInt[0] != -1) && (paramArrayOfInt[1] != -1);
  }
  
  private boolean Jk(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(181884);
    if ((this.uuR != null) && (this.uuR.viewType == paramInt) && (this.uuR.getType() == 1))
    {
      AppMethodBeat.o(181884);
      return false;
    }
    if ((paramInt == 2) && (this.uuL != null))
    {
      this.uuL.dismiss();
      Z(2, -1, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(181884);
      return bool;
      if ((paramInt == 3) && (this.uuM != null))
      {
        this.uuM.dismiss();
        Z(3, -1, -1);
      }
      else if ((paramInt == 4) && (this.uuN != null))
      {
        this.uuN.dismiss();
        Z(4, -1, -1);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private void Z(int paramInt1, int paramInt2, int paramInt3)
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
        } while ((this.uuI == null) || (this.uuI.length != 2));
        this.uuI[0] = paramInt2;
        this.uuI[1] = paramInt3;
        return;
      } while ((this.uuJ == null) || (this.uuJ.length != 2));
      this.uuJ[0] = paramInt2;
      this.uuJ[1] = paramInt3;
      return;
    } while ((this.uuK == null) || (this.uuK.length != 2));
    this.uuK[0] = paramInt2;
    this.uuK[1] = paramInt3;
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
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.a.a.atL(paramj.content);
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
          Spanned localSpanned = com.tencent.mm.plugin.editor.model.nativenote.a.a.atL(str);
          paramInt1 = paramInt2;
          if (localSpanned != null) {
            paramInt1 = paramInt2 + localSpanned.length();
          }
        }
        paramj.content = (com.tencent.mm.plugin.editor.model.nativenote.a.b.a(paramString) + str + com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)localObject));
      }
      if (paramBoolean3) {
        paramj.urG = true;
      }
      for (paramj.urI = paramInt1;; paramj.urI = -1)
      {
        AppMethodBeat.o(181902);
        return localSpannableStringBuilder;
        paramj.urG = false;
      }
    }
  }
  
  private SpannableStringBuilder a(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(181900);
    d locald = cSB();
    cSE();
    int j = locald.getSelectType();
    if ((j != 1) && (j != 2))
    {
      Log.e("EditorSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
      AppMethodBeat.o(181900);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().Jd(locald.bPt);
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
        paramString = a((j)localObject, locald.lPo, locald.uuu, false, false, "", true);
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().a(paramArrayList, 0, locald.bPt, locald.lPo, locald.uuu);
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().fU(locald.bPt, locald.bPt + paramArrayList.size() + 1);
        paramArrayList = paramString;
      }
      for (;;)
      {
        AppMethodBeat.o(181900);
        return paramArrayList;
        paramString = a((j)localObject, locald.lPo, locald.uuu, false, paramBoolean, paramString, true);
        if (this.uuP != null) {
          this.uuP.IY(locald.bPt);
        }
        paramArrayList = paramString;
        if (paramBoolean)
        {
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().cSd();
          paramArrayList = paramString;
        }
      }
    }
    if ((j == 1) && (paramBoolean))
    {
      if (locald.lPo == 0) {
        i = 1;
      }
      if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
        break label419;
      }
      if (Util.isNullOrNil(paramString)) {
        break label410;
      }
      paramArrayList = new ArrayList();
      localObject = new j();
      ((j)localObject).content = paramString;
      ((j)localObject).urG = false;
      ((j)localObject).urI = -1;
      paramArrayList.add(localObject);
    }
    label410:
    label419:
    for (;;)
    {
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().a(paramArrayList, i, locald.bPt, locald.lPo, locald.uuu);
      paramString = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT();
      i = locald.bPt;
      j = locald.bPt;
      paramString.fU(i - 1, paramArrayList.size() + j + 1);
      paramArrayList = localSpannableStringBuilder;
      break;
      AppMethodBeat.o(181900);
      return localSpannableStringBuilder;
    }
  }
  
  private void a(int paramInt1, RecyclerView paramRecyclerView, View paramView, int paramInt2)
  {
    AppMethodBeat.i(187639);
    if ((!mHasInit) || (paramRecyclerView == null))
    {
      AppMethodBeat.o(187639);
      return;
    }
    paramView = f.ee(paramView);
    if (paramView == null)
    {
      Jk(paramInt1);
      AppMethodBeat.o(187639);
      return;
    }
    if (paramView.uur != null) {
      paramView = paramView.uur;
    }
    for (;;)
    {
      if (paramView == null)
      {
        Jk(paramInt1);
        AppMethodBeat.o(187639);
        return;
        if ((paramView.uus != null) && (paramView.uut != null))
        {
          if (paramInt2 == 0)
          {
            paramView = paramView.uus;
            paramInt2 = 0;
            continue;
          }
          if (paramInt2 == 1)
          {
            paramView = paramView.uut;
            paramInt2 = 0;
          }
        }
      }
      else
      {
        Object localObject = paramView.getText();
        if ((localObject == null) || (paramInt2 < 0) || (paramInt2 > ((Editable)localObject).length()))
        {
          Jk(paramInt1);
          AppMethodBeat.o(187639);
          return;
        }
        localObject = paramView.getLayout();
        if (localObject == null)
        {
          Jk(paramInt1);
          AppMethodBeat.o(187639);
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
          f3 = f3 + paramView.getHeight() - this.uux;
          if (paramInt1 == 3)
          {
            f1 = f4 + this.uuG;
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
            Jk(paramInt1);
          }
          AppMethodBeat.o(187639);
          return;
          f1 = f4;
          f2 = f3;
          if (paramInt1 != 4) {
            break;
          }
          f1 = f4 - this.uuG;
          f2 = f3;
          break;
          bool = a(2, paramRecyclerView, this.uuL, (int)(f1 + localObject[0] - this.uuF), (int)(localObject[1] + f2));
          continue;
          bool = a(3, paramRecyclerView, this.uuM, (int)(f1 + localObject[0] - this.uuM.getWidth()), (int)(localObject[1] + f2));
          continue;
          bool = a(4, paramRecyclerView, this.uuN, (int)(f1 + localObject[0]), (int)(localObject[1] + f2));
        }
      }
      paramView = null;
    }
  }
  
  private boolean a(int paramInt1, RecyclerView paramRecyclerView, PopupWindow paramPopupWindow, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(187640);
    if ((!mHasInit) || (paramRecyclerView == null) || (paramPopupWindow == null))
    {
      AppMethodBeat.o(187640);
      return false;
    }
    if ((paramInt3 < h(paramRecyclerView)) || (paramInt3 > this.mScreenHeight - cSA()))
    {
      AppMethodBeat.o(187640);
      return false;
    }
    if (paramPopupWindow.isShowing())
    {
      paramPopupWindow.update(paramInt2, paramInt3, -1, -1, false);
      Z(paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      if (paramInt1 == 2)
      {
        cSJ();
        this.uuT.startTimer(3000L, 0L);
      }
      AppMethodBeat.o(187640);
      return true;
      paramPopupWindow.showAtLocation(paramRecyclerView, 0, paramInt2, paramInt3);
      Z(paramInt1, paramInt2, paramInt3);
    }
  }
  
  private int aa(int paramInt1, int paramInt2, int paramInt3)
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
      bool = F(paramInt2, paramInt3, paramInt2, paramInt3);
    }
    while (bool)
    {
      AppMethodBeat.o(181892);
      return 3;
      if ((this.uuQ == null) || (paramInt2 > this.uuQ.endPos) || ((paramInt2 == this.uuQ.endPos) && (paramInt3 >= this.uuQ.uuu)))
      {
        AppMethodBeat.o(181892);
        return 1;
      }
      bool = F(paramInt2, paramInt3, this.uuQ.endPos, this.uuQ.uuu);
      continue;
      if ((this.uuQ == null) || (paramInt2 < this.uuQ.bPt) || ((paramInt2 == this.uuQ.bPt) && (paramInt3 <= this.uuQ.lPo)))
      {
        AppMethodBeat.o(181892);
        return 1;
      }
      bool = F(this.uuQ.bPt, this.uuQ.lPo, paramInt2, paramInt3);
    }
    AppMethodBeat.o(181892);
    return 2;
  }
  
  private ArrayList<com.tencent.mm.plugin.editor.model.a.a> b(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList, String paramString)
  {
    AppMethodBeat.i(181901);
    d locald = cSB();
    cSE();
    ArrayList localArrayList = new ArrayList();
    if (locald.getSelectType() != 3)
    {
      Log.e("EditorSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
      AppMethodBeat.o(181901);
      return null;
    }
    int i = locald.bPt;
    int j = locald.endPos;
    if (j >= locald.bPt)
    {
      Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().Jd(j);
      SpannableStringBuilder localSpannableStringBuilder;
      j localj;
      if (localObject != null) {
        if ((j == locald.endPos) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
        {
          localObject = (j)localObject;
          localSpannableStringBuilder = a((j)localObject, 0, locald.uuu, false, paramBoolean, "", false);
          if (!Util.isNullOrNil(localSpannableStringBuilder))
          {
            localj = new j();
            localj.content = com.tencent.mm.plugin.editor.model.nativenote.a.b.a(localSpannableStringBuilder);
            localj.urI = -1;
            localj.urG = false;
            localArrayList.add(localj);
          }
          if ((paramBoolean) && (Util.isNullOrNil(((j)localObject).content))) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().ae(j, true);
          }
        }
      }
      for (;;)
      {
        j -= 1;
        break;
        if ((j == locald.bPt) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
        {
          localObject = (j)localObject;
          localSpannableStringBuilder = a((j)localObject, locald.lPo, 0, true, paramBoolean, "", false);
          if (!Util.isNullOrNil(localSpannableStringBuilder))
          {
            localj = new j();
            localj.content = com.tencent.mm.plugin.editor.model.nativenote.a.b.a(localSpannableStringBuilder);
            localj.urI = -1;
            localj.urG = false;
            localArrayList.add(localj);
          }
          if ((paramBoolean) && (Util.isNullOrNil(((j)localObject).content))) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().ae(j, true);
          } else {
            i += 1;
          }
        }
        else
        {
          localArrayList.add(com.tencent.mm.plugin.editor.b.a((com.tencent.mm.plugin.editor.model.a.a)localObject));
          if (paramBoolean) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().ae(j, true);
          }
        }
      }
    }
    if (paramBoolean)
    {
      j = i + 1;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().b(i, paramArrayList);
        j = paramArrayList.size() + i;
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().fU(i - 1, j);
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
      paramArrayList.urG = false;
      paramArrayList.urI = -1;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().a(i, paramArrayList);
      break;
      paramString = "";
    }
  }
  
  private boolean c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187643);
    if ((!mHasInit) || (paramRecyclerView == null) || (this.uuO == null))
    {
      AppMethodBeat.o(187643);
      return false;
    }
    if ((paramInt2 < h(paramRecyclerView)) || (paramInt2 > this.mScreenHeight - cSA()))
    {
      AppMethodBeat.o(187643);
      return false;
    }
    if (this.uuO.isShowing()) {
      this.uuO.update(paramInt1, paramInt2, -1, -1, false);
    }
    for (;;)
    {
      AppMethodBeat.o(187643);
      return true;
      this.uuO.showAtLocation(paramRecyclerView, 0, paramInt1, paramInt2);
    }
  }
  
  private int cSA()
  {
    AppMethodBeat.i(181867);
    if (this.uuP != null)
    {
      int i = this.uuP.cRj();
      int j = this.uuP.cRk();
      AppMethodBeat.o(181867);
      return i + j;
    }
    AppMethodBeat.o(181867);
    return 0;
  }
  
  private void cSC()
  {
    AppMethodBeat.i(181871);
    F(-1, -1, -1, -1);
    AppMethodBeat.o(181871);
  }
  
  private void cSD()
  {
    AppMethodBeat.i(181873);
    if (this.uuP != null) {
      this.uuP.cRi();
    }
    AppMethodBeat.o(181873);
  }
  
  private void cSJ()
  {
    AppMethodBeat.i(181888);
    if (this.uuT == null)
    {
      this.uuT = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(181858);
          if ((e.this.getSelectType() == 1) && (e.b(e.this))) {
            e.this.cSG();
          }
          AppMethodBeat.o(181858);
          return true;
        }
      }, false);
      AppMethodBeat.o(181888);
      return;
    }
    this.uuT.stopTimer();
    AppMethodBeat.o(181888);
  }
  
  private void cSK()
  {
    AppMethodBeat.i(181893);
    if (this.uuR == null)
    {
      this.uuR = new b();
      AppMethodBeat.o(181893);
      return;
    }
    this.uuR.reset();
    AppMethodBeat.o(181893);
  }
  
  private void cSL()
  {
    AppMethodBeat.i(181894);
    if (this.uuS == null)
    {
      this.uuS = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(181860);
          Log.d("EditorSelectManager", "onTimerExpired: ");
          RecyclerView localRecyclerView = e.a(e.this);
          int i;
          int j;
          if ((e.c(e.this) != null) && (e.c(e.this).uuk < e.a(e.this, localRecyclerView)))
          {
            i = 1;
            if ((e.c(e.this) == null) || (e.c(e.this).uuk <= e.d(e.this))) {
              break label206;
            }
            j = 1;
            label89:
            if ((!e.abi()) || (localRecyclerView == null) || (e.c(e.this) == null) || (e.c(e.this).getType() != 1) || ((i == 0) && (j == 0))) {
              break label256;
            }
            if ((i == 0) || (!localRecyclerView.canScrollVertically(-1))) {
              break label211;
            }
            if (e.c(e.this).viewType == 3) {
              e.e(e.this);
            }
            e.f(e.this);
            e.this.cSI();
            e.this.cSG();
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
              e.this.cSI();
              e.this.cSG();
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
    this.uuS.stopTimer();
    AppMethodBeat.o(181894);
  }
  
  private int cSM()
  {
    AppMethodBeat.i(181896);
    int j = 0;
    if (this.uuP != null) {
      j = this.uuP.cRj();
    }
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.uuP != null) {
        i = this.uuP.cRk();
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
  
  private void cSN()
  {
    AppMethodBeat.i(181898);
    if (this.uuP != null) {
      this.uuP.cRh();
    }
    AppMethodBeat.o(181898);
  }
  
  private boolean cSP()
  {
    AppMethodBeat.i(181903);
    boolean bool1 = o(this.uuU, false);
    boolean bool2 = o(this.uuV, false);
    boolean bool3 = o(this.uuW, cSQ());
    boolean bool4 = o(this.uuX, cSR());
    boolean bool5 = o(this.uuY, cSS());
    boolean bool6 = o(this.uuZ, cST());
    boolean bool7 = o(this.uva, cSU());
    boolean bool8 = o(this.uvb, cSV());
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5) || (bool6) || (bool7) || (bool8))
    {
      AppMethodBeat.o(181903);
      return true;
    }
    AppMethodBeat.o(181903);
    return false;
  }
  
  private boolean cSQ()
  {
    AppMethodBeat.i(181905);
    if (getSelectType() != 1)
    {
      AppMethodBeat.o(181905);
      return false;
    }
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().Jd(this.uuQ.bPt);
    if ((locala != null) && ((com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().size() > 1) || (locala.getType() != 1) || (!Util.isNullOrNil(((j)locala).content))))
    {
      AppMethodBeat.o(181905);
      return true;
    }
    AppMethodBeat.o(181905);
    return false;
  }
  
  private boolean cSR()
  {
    AppMethodBeat.i(181906);
    int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().cSe();
    int j = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().cSf();
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().Jd(i);
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().Jd(j);
    if ((localObject == null) || (locala == null))
    {
      AppMethodBeat.o(181906);
      return false;
    }
    if ((this.uuQ != null) && (this.uuQ.bPt == i) && (this.uuQ.lPo == 0) && (this.uuQ.endPos == j)) {
      if (locala.getType() == 1)
      {
        localObject = com.tencent.mm.plugin.editor.model.nativenote.a.a.atL(((j)locala).content);
        if (localObject == null)
        {
          AppMethodBeat.o(181906);
          return false;
        }
        if (this.uuQ.uuu == ((Spanned)localObject).length())
        {
          AppMethodBeat.o(181906);
          return false;
        }
      }
      else if ((locala.getType() != 1) && (this.uuQ.uuu == 1))
      {
        AppMethodBeat.o(181906);
        return false;
      }
    }
    AppMethodBeat.o(181906);
    return true;
  }
  
  private boolean cSS()
  {
    boolean bool2 = true;
    AppMethodBeat.i(181907);
    if (!this.uuw)
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
    if (this.uuP != null) {
      if (this.uuP.cRl()) {
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
  
  private boolean cST()
  {
    AppMethodBeat.i(181908);
    int i = getSelectType();
    if ((this.uuw) && ((i == 2) || (i == 3)))
    {
      AppMethodBeat.o(181908);
      return true;
    }
    AppMethodBeat.o(181908);
    return false;
  }
  
  private boolean cSU()
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
  
  private boolean cSV()
  {
    AppMethodBeat.i(181910);
    if ((!this.uuw) || (getSelectType() == 0))
    {
      AppMethodBeat.o(181910);
      return false;
    }
    MMApplicationContext.getContext();
    if (com.tencent.mm.plugin.editor.model.nativenote.manager.b.cRS() != 1)
    {
      AppMethodBeat.o(181910);
      return true;
    }
    AppMethodBeat.o(181910);
    return false;
  }
  
  public static e cSy()
  {
    AppMethodBeat.i(181865);
    if (uuv == null) {}
    try
    {
      if (uuv == null) {
        uuv = new e();
      }
      e locale = uuv;
      AppMethodBeat.o(181865);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(181865);
    }
  }
  
  private RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(187621);
    if (this.uuP != null)
    {
      RecyclerView localRecyclerView = this.uuP.cRm();
      AppMethodBeat.o(187621);
      return localRecyclerView;
    }
    AppMethodBeat.o(187621);
    return null;
  }
  
  private int h(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(187646);
    int j = 150;
    int i = j;
    if (paramRecyclerView != null)
    {
      paramRecyclerView.getLocationOnScreen(this.uuH);
      i = j;
      if (A(this.uuH)) {
        i = this.uuH[1];
      }
    }
    AppMethodBeat.o(187646);
    return i;
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
  
  private void mA(boolean paramBoolean)
  {
    AppMethodBeat.i(181891);
    if ((!mHasInit) || (this.uuL == null) || (this.uuM == null) || (this.uuN == null) || (this.uuQ == null))
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
    if ((this.uuR == null) || (this.uuR.getType() != 1))
    {
      AppMethodBeat.o(181891);
      return;
    }
    int k = this.uuR.viewType;
    if ((k != 2) && (k != 3) && (k != 4))
    {
      AppMethodBeat.o(181891);
      return;
    }
    float f2 = this.uuR.uuj - this.uuR.dit;
    float f1 = this.uuR.uuk;
    float f3 = this.uuR.diu;
    f3 = this.uux / 2 + (f1 - f3);
    View localView;
    Object localObject2;
    Object localObject1;
    int i;
    if (k == 2)
    {
      f1 = f2 + this.uuL.getWidth() / 2;
      localRecyclerView.getLocationOnScreen(this.uuH);
      localView = localRecyclerView.h(f1 - this.uuH[0], f3 - this.uuH[1]);
      localObject2 = f.ee(localView);
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
        f1 = f2 + this.uuM.getWidth();
        break;
        if (((c)localObject2).uur != null)
        {
          localObject1 = ((c)localObject2).uur;
          localObject2 = new int[2];
          ((WXRTEditText)localObject1).getLocationOnScreen((int[])localObject2);
          i = ((WXRTEditText)localObject1).getOffsetForPosition(f1 - localObject2[0], f3 - localObject2[1]);
          i = aa(k, ((WXRTEditText)localObject1).getPosInDataList(), i);
        }
        else if ((((c)localObject2).uus != null) && (((c)localObject2).uut != null))
        {
          if (k == 3)
          {
            localObject2 = ((c)localObject2).uus;
            j = aa(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.uuM, (int)(this.uuR.uuj - this.uuR.dit), (int)(this.uuR.uuk - this.uuR.diu));
              i = j;
              localObject1 = localObject2;
            }
          }
          else if (k == 4)
          {
            localObject2 = ((c)localObject2).uut;
            j = aa(k, ((WXRTEditText)localObject2).getPosInDataList(), 1);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.uuN, (int)(this.uuR.uuj - this.uuR.dit), (int)(this.uuR.uuk - this.uuR.diu));
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
            localObject2 = ((c)localObject2).uus;
          }
          for (int j = aa(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);; j = aa(k, ((WXRTEditText)localObject2).getPosInDataList(), 1))
          {
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.uuL, (int)(this.uuR.uuj - this.uuR.dit), (int)(this.uuR.uuk - this.uuR.diu));
              localObject1 = localObject2;
              i = j;
            }
            break;
            localObject2 = ((c)localObject2).uut;
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
          if ((!paramBoolean) || ((this.uuR.uuk >= h(localRecyclerView)) && (this.uuR.uuk <= cSM())) || ((this.uuS != null) && (!this.uuS.stopped()))) {
            break label1163;
          }
          cSL();
          this.uuS.startTimer(100L);
          AppMethodBeat.o(181891);
          return;
          i = 1;
          continue;
          localObject2 = ((WXRTEditText)localObject1).getText();
          i = getSelectType();
          if ((this.uuw) && (localObject2 != null) && (i == 1))
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
                cSD();
              }
              cSG();
              f(true, 0L);
              if (k != 4) {
                break label1147;
              }
            }
          }
          label1147:
          for (i = this.uuQ.uuu;; i = this.uuQ.lPo)
          {
            a(k, localRecyclerView, localView, i);
            i = 1;
            break;
            if (this.uuQ.lPo > ((Editable)localObject2).length()) {
              break label912;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.uuQ.lPo);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label912;
            if ((!this.uuw) || (localObject2 == null) || (i != 2) || (!((WXRTEditText)localObject1).hasFocus())) {
              break label912;
            }
            if ((((WXRTEditText)localObject1).getEditTextType() == 1) || (((WXRTEditText)localObject1).getEditTextType() == 2))
            {
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
              ((WXRTEditText)localObject1).setSelection(0);
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
              break label912;
            }
            if ((this.uuQ.lPo > ((Editable)localObject2).length()) || (this.uuQ.uuu > ((Editable)localObject2).length())) {
              break label912;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.uuQ.lPo, this.uuQ.uuu);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label912;
          }
        }
        label912:
        cSL();
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
  
  public final boolean F(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(181870);
    if (!mHasInit)
    {
      AppMethodBeat.o(181870);
      return false;
    }
    boolean bool;
    if (this.uuQ == null)
    {
      this.uuQ = new d(paramInt1, paramInt2, paramInt3, paramInt4);
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        Log.d("EditorSelectManager", "setSelectInfo: %d:%d - %d:%d", new Object[] { Integer.valueOf(this.uuQ.bPt), Integer.valueOf(this.uuQ.lPo), Integer.valueOf(this.uuQ.endPos), Integer.valueOf(this.uuQ.uuu) });
      }
      AppMethodBeat.o(181870);
      return bool;
      if ((this.uuQ.bPt != paramInt1) || (this.uuQ.lPo != paramInt2) || (this.uuQ.endPos != paramInt3) || (this.uuQ.uuu != paramInt4))
      {
        this.uuQ.E(paramInt1, paramInt2, paramInt3, paramInt4);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final int Jj(int paramInt)
  {
    AppMethodBeat.i(181872);
    if ((!mHasInit) || (this.uuQ == null))
    {
      AppMethodBeat.o(181872);
      return 0;
    }
    if ((getSelectType() == 0) || (paramInt < this.uuQ.bPt) || (paramInt > this.uuQ.endPos))
    {
      AppMethodBeat.o(181872);
      return 0;
    }
    if ((paramInt == this.uuQ.bPt) && (paramInt == this.uuQ.endPos))
    {
      AppMethodBeat.o(181872);
      return 1;
    }
    if ((paramInt > this.uuQ.bPt) && (paramInt < this.uuQ.endPos))
    {
      AppMethodBeat.o(181872);
      return 2;
    }
    if ((paramInt == this.uuQ.bPt) && (paramInt < this.uuQ.endPos))
    {
      AppMethodBeat.o(181872);
      return 4;
    }
    if ((paramInt > this.uuQ.bPt) && (paramInt == this.uuQ.endPos))
    {
      AppMethodBeat.o(181872);
      return 3;
    }
    AppMethodBeat.o(181872);
    return 0;
  }
  
  public final void M(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(181875);
    if (!mHasInit)
    {
      AppMethodBeat.o(181875);
      return;
    }
    cSI();
    cSG();
    f(true, 50L);
    mz(paramBoolean1);
    mx(paramBoolean2);
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
    if ((this.uuR != null) && (this.uuR.getType() == 1) && (this.uuR.viewType != paramInt))
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
      cSK();
      if (!cSF()) {
        my(true);
      }
      this.uuR.a(paramInt, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), 0);
      AppMethodBeat.o(181890);
      return;
      if ((this.uuR != null) && (this.uuR.getType() == 1))
      {
        this.uuR.uuj = paramMotionEvent.getRawX();
        this.uuR.uuk = paramMotionEvent.getRawY();
        mA(true);
        AppMethodBeat.o(181890);
        return;
        cSK();
        this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(181859);
            e.this.mz(true);
            e.this.my(true);
            AppMethodBeat.o(181859);
          }
        }, 200L);
      }
    }
  }
  
  public final void a(View paramView1, View paramView2, View paramView3, int paramInt)
  {
    AppMethodBeat.i(181877);
    if ((!mHasInit) || (paramView1 == null) || (paramView2 == null) || (paramView3 == null) || (this.uuQ == null))
    {
      AppMethodBeat.o(181877);
      return;
    }
    switch (Jj(paramInt))
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
      if (this.uuQ.lPo == this.uuQ.uuu) {
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
      if (this.uuQ.lPo == 0)
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
    } while (this.uuQ.uuu == 0);
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
    paramView3.setVisibility(4);
    AppMethodBeat.o(181877);
  }
  
  public final d cSB()
  {
    AppMethodBeat.i(181869);
    if (!mHasInit)
    {
      locald = new d();
      AppMethodBeat.o(181869);
      return locald;
    }
    if (this.uuQ == null) {
      this.uuQ = new d();
    }
    d locald = new d(this.uuQ.bPt, this.uuQ.lPo, this.uuQ.endPos, this.uuQ.uuu);
    AppMethodBeat.o(181869);
    return locald;
  }
  
  public final void cSE()
  {
    AppMethodBeat.i(181874);
    if (!mHasInit)
    {
      AppMethodBeat.o(181874);
      return;
    }
    cSC();
    f(true, 0L);
    cSI();
    cSG();
    AppMethodBeat.o(181874);
  }
  
  public final boolean cSF()
  {
    AppMethodBeat.i(181878);
    if ((this.uuO != null) && (this.uuO.isShowing()))
    {
      AppMethodBeat.o(181878);
      return true;
    }
    AppMethodBeat.o(181878);
    return false;
  }
  
  public final void cSG()
  {
    AppMethodBeat.i(181879);
    if (this.uuO != null) {
      this.uuO.dismiss();
    }
    AppMethodBeat.o(181879);
  }
  
  public final boolean cSH()
  {
    AppMethodBeat.i(181882);
    if ((this.uuL != null) && (this.uuL.isShowing()))
    {
      AppMethodBeat.o(181882);
      return true;
    }
    AppMethodBeat.o(181882);
    return false;
  }
  
  public final void cSI()
  {
    AppMethodBeat.i(181883);
    if (!mHasInit)
    {
      AppMethodBeat.o(181883);
      return;
    }
    Jk(2);
    Jk(3);
    Jk(4);
    AppMethodBeat.o(181883);
  }
  
  public final void cSO()
  {
    AppMethodBeat.i(181899);
    Log.i("EditorSelectManager", "deleteSelectedData");
    if (!mHasInit)
    {
      Log.e("EditorSelectManager", "deleteSelectedData: not init");
      AppMethodBeat.o(181899);
      return;
    }
    cSG();
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
    cSN();
    AppMethodBeat.o(181899);
  }
  
  public final boolean cSz()
  {
    return (mHasInit) && (this.uuw);
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
          c localc = f.ee((View)localObject);
          if (localc != null)
          {
            if (localc.uur == null) {
              break label78;
            }
            if (paramBoolean) {
              localc.uur.postInvalidate();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label78:
            if ((localc.uus != null) && (localc.uut != null))
            {
              LinearLayout localLinearLayout1 = (LinearLayout)((View)localObject).findViewById(d.e.dQG);
              LinearLayout localLinearLayout2 = (LinearLayout)((View)localObject).findViewById(d.e.dQJ);
              localObject = (LinearLayout)((View)localObject).findViewById(d.e.dQH);
              e.this.a(localLinearLayout1, localLinearLayout2, (View)localObject, localc.uus.getPosInDataList());
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
    if (this.uuQ == null) {
      this.uuQ = new d();
    }
    int i = this.uuQ.getSelectType();
    AppMethodBeat.o(181868);
    return i;
  }
  
  public final void mx(final boolean paramBoolean)
  {
    AppMethodBeat.i(181880);
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181857);
        e.this.my(paramBoolean);
        AppMethodBeat.o(181857);
      }
    }, 50L);
    AppMethodBeat.o(181880);
  }
  
  public final void my(boolean paramBoolean)
  {
    AppMethodBeat.i(181881);
    if ((!mHasInit) || (this.uuO == null))
    {
      AppMethodBeat.o(181881);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = getSelectType();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)) || ((this.uuR != null) && (this.uuR.getType() == 1)))
    {
      cSG();
      AppMethodBeat.o(181881);
      return;
    }
    if (!cSP())
    {
      cSG();
      AppMethodBeat.o(181881);
      return;
    }
    int i1 = -1;
    int i2 = -1000;
    int i4 = h(localRecyclerView);
    int i5 = cSM();
    int k = 0;
    int m = 0;
    i = m;
    int j = k;
    if (this.uuO != null)
    {
      i = m;
      j = k;
      if (this.uuO.getContentView() != null)
      {
        this.uuO.getContentView().measure(0, 0);
        i = this.uuO.getContentView().getMeasuredHeight();
        j = this.uuA * 2 + i;
        i = this.uuO.getContentView().getMeasuredWidth() + this.uuA * 2;
      }
    }
    int i3;
    int n;
    if (j == 0)
    {
      i3 = this.uuC;
      if (i != 0) {
        break label414;
      }
      n = this.uuD;
      label229:
      if ((this.uuL == null) || (!this.uuL.isShowing()) || (!A(this.uuI))) {
        break label458;
      }
      j = this.uuI[1] - i3;
      i = this.uuI[1] + this.uuL.getHeight() - this.uuE;
      if ((j < i4) || (j > i5)) {
        break label420;
      }
      k = this.uuI[0];
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
        j = ((LinearLayoutManager)localObject).kJ();
        k = ((LinearLayoutManager)localObject).kL();
        if ((this.uuQ.bPt > j) || (this.uuQ.endPos < k)) {
          break label911;
        }
        k = 300;
        j = -1000;
      }
      for (;;)
      {
        if (k == -1)
        {
          cSG();
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
          j = this.uuI[0];
          break label311;
          label458:
          i = i2;
          j = i1;
          if (this.uuM != null)
          {
            i = i2;
            j = i1;
            if (this.uuM.isShowing())
            {
              i = i2;
              j = i1;
              if (A(this.uuJ))
              {
                j = this.uuJ[1] - i3;
                k = this.uuJ[1] + this.uuM.getHeight() - this.uuE;
                if ((j < i4) || (j > i5)) {
                  break label662;
                }
                i = this.uuJ[0];
              }
            }
          }
          for (;;)
          {
            m = i;
            k = j;
            if (this.uuN == null) {
              break label921;
            }
            m = i;
            k = j;
            if (!this.uuN.isShowing()) {
              break label921;
            }
            m = i;
            k = j;
            if (!A(this.uuK)) {
              break label921;
            }
            k = this.uuK[1] - i3;
            i1 = this.uuK[1] + this.uuN.getHeight() - this.uuE;
            if (j != -1) {
              break label740;
            }
            if ((k < i4) || (k > i5)) {
              break label701;
            }
            j = this.uuK[0];
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
                i = this.uuJ[0];
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
          j = this.uuK[0];
          i = i1;
          break label311;
          label740:
          m = i;
          k = j;
          if (j + i3 <= this.uuK[1]) {
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
          j = this.uuK[0];
          i = i1;
          break label311;
        }
        i = this.mScreenWidth / 3;
        m = this.mScreenWidth * 2 / 3;
        if ((j == -1000) || ((j >= i) && (j <= m)))
        {
          c(localRecyclerView, (this.mScreenWidth - n) / 2, k);
          AppMethodBeat.o(181881);
          return;
        }
        if (j < i)
        {
          c(localRecyclerView, this.uuB, k);
          AppMethodBeat.o(181881);
          return;
        }
        c(localRecyclerView, this.mScreenWidth - n - this.uuB, k);
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
  
  public final void mz(boolean paramBoolean)
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
      cSI();
      AppMethodBeat.o(181885);
      return;
    }
    View localView1 = f.c(localRecyclerView, this.uuQ.bPt);
    View localView2 = f.c(localRecyclerView, this.uuQ.endPos);
    if (i == 1)
    {
      Jk(3);
      Jk(4);
      a(2, localRecyclerView, localView1, this.uuQ.lPo);
      AppMethodBeat.o(181885);
      return;
    }
    Jk(2);
    a(3, localRecyclerView, localView1, this.uuQ.lPo);
    a(4, localRecyclerView, localView2, this.uuQ.uuu);
    AppMethodBeat.o(181885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.c.e
 * JD-Core Version:    0.7.0.1
 */