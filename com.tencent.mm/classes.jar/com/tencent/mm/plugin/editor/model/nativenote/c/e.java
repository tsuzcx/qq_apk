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
  public static volatile e xAS = null;
  public MMHandler mHandler = null;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public boolean xAT = true;
  public int xAU = 0;
  public int xAV = 0;
  public int xAW = 14;
  public int xAX = 0;
  public int xAY = 0;
  public int xAZ = 0;
  public int xBa = 0;
  public int xBb = 0;
  public int xBc = 0;
  public int xBd = 0;
  public int[] xBe = null;
  public int[] xBf = null;
  public int[] xBg = null;
  public int[] xBh = null;
  public PopupWindow xBi = null;
  public PopupWindow xBj = null;
  public PopupWindow xBk = null;
  public PopupWindow xBl = null;
  public com.tencent.mm.plugin.editor.model.nativenote.b.a xBm = null;
  public d xBn = null;
  public b xBo = null;
  public MTimerHandler xBp = null;
  public MTimerHandler xBq = null;
  public TextView xBr = null;
  public TextView xBs = null;
  public TextView xBt = null;
  public TextView xBu = null;
  public TextView xBv = null;
  public TextView xBw = null;
  public TextView xBx = null;
  public TextView xBy = null;
  
  private e()
  {
    mHasInit = false;
  }
  
  private static boolean C(int[] paramArrayOfInt)
  {
    return (mHasInit) && (paramArrayOfInt != null) && (paramArrayOfInt.length == 2) && (paramArrayOfInt[0] != -1) && (paramArrayOfInt[1] != -1);
  }
  
  private boolean JR(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(181884);
    if ((this.xBo != null) && (this.xBo.viewType == paramInt) && (this.xBo.getType() == 1))
    {
      AppMethodBeat.o(181884);
      return false;
    }
    if ((paramInt == 2) && (this.xBi != null))
    {
      this.xBi.dismiss();
      aq(2, -1, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(181884);
      return bool;
      if ((paramInt == 3) && (this.xBj != null))
      {
        this.xBj.dismiss();
        aq(3, -1, -1);
      }
      else if ((paramInt == 4) && (this.xBk != null))
      {
        this.xBk.dismiss();
        aq(4, -1, -1);
      }
      else
      {
        bool = false;
      }
    }
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
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.a.a.anA(paramj.content);
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
          Spanned localSpanned = com.tencent.mm.plugin.editor.model.nativenote.a.a.anA(str);
          paramInt1 = paramInt2;
          if (localSpanned != null) {
            paramInt1 = paramInt2 + localSpanned.length();
          }
        }
        paramj.content = (com.tencent.mm.plugin.editor.model.nativenote.a.b.a(paramString) + str + com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)localObject));
      }
      if (paramBoolean3) {
        paramj.xyb = true;
      }
      for (paramj.xyd = paramInt1;; paramj.xyd = -1)
      {
        AppMethodBeat.o(181902);
        return localSpannableStringBuilder;
        paramj.xyb = false;
      }
    }
  }
  
  private SpannableStringBuilder a(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(181900);
    d locald = dwT();
    dwW();
    int j = locald.getSelectType();
    if ((j != 1) && (j != 2))
    {
      Log.e("EditorSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
      AppMethodBeat.o(181900);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().JL(locald.dIY);
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
        paramString = a((j)localObject, locald.oHY, locald.xAR, false, false, "", true);
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().a(paramArrayList, 0, locald.dIY, locald.oHY, locald.xAR);
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().gL(locald.dIY, locald.dIY + paramArrayList.size() + 1);
        paramArrayList = paramString;
      }
      for (;;)
      {
        AppMethodBeat.o(181900);
        return paramArrayList;
        paramString = a((j)localObject, locald.oHY, locald.xAR, false, paramBoolean, paramString, true);
        if (this.xBm != null) {
          this.xBm.JG(locald.dIY);
        }
        paramArrayList = paramString;
        if (paramBoolean)
        {
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().dww();
          paramArrayList = paramString;
        }
      }
    }
    if ((j == 1) && (paramBoolean))
    {
      if (locald.oHY == 0) {
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
      ((j)localObject).xyb = false;
      ((j)localObject).xyd = -1;
      paramArrayList.add(localObject);
    }
    label410:
    label419:
    for (;;)
    {
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().a(paramArrayList, i, locald.dIY, locald.oHY, locald.xAR);
      paramString = com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm();
      i = locald.dIY;
      j = locald.dIY;
      paramString.gL(i - 1, paramArrayList.size() + j + 1);
      paramArrayList = localSpannableStringBuilder;
      break;
      AppMethodBeat.o(181900);
      return localSpannableStringBuilder;
    }
  }
  
  private void a(int paramInt1, RecyclerView paramRecyclerView, View paramView, int paramInt2)
  {
    AppMethodBeat.i(270819);
    if ((!mHasInit) || (paramRecyclerView == null))
    {
      AppMethodBeat.o(270819);
      return;
    }
    paramView = f.eX(paramView);
    if (paramView == null)
    {
      JR(paramInt1);
      AppMethodBeat.o(270819);
      return;
    }
    if (paramView.xAO != null) {
      paramView = paramView.xAO;
    }
    for (;;)
    {
      if (paramView == null)
      {
        JR(paramInt1);
        AppMethodBeat.o(270819);
        return;
        if ((paramView.xAP != null) && (paramView.xAQ != null))
        {
          if (paramInt2 == 0)
          {
            paramView = paramView.xAP;
            paramInt2 = 0;
            continue;
          }
          if (paramInt2 == 1)
          {
            paramView = paramView.xAQ;
            paramInt2 = 0;
          }
        }
      }
      else
      {
        Object localObject = paramView.getText();
        if ((localObject == null) || (paramInt2 < 0) || (paramInt2 > ((Editable)localObject).length()))
        {
          JR(paramInt1);
          AppMethodBeat.o(270819);
          return;
        }
        localObject = paramView.getLayout();
        if (localObject == null)
        {
          JR(paramInt1);
          AppMethodBeat.o(270819);
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
          f3 = f3 + paramView.getHeight() - this.xAU;
          if (paramInt1 == 3)
          {
            f1 = f4 + this.xBd;
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
            JR(paramInt1);
          }
          AppMethodBeat.o(270819);
          return;
          f1 = f4;
          f2 = f3;
          if (paramInt1 != 4) {
            break;
          }
          f1 = f4 - this.xBd;
          f2 = f3;
          break;
          bool = a(2, paramRecyclerView, this.xBi, (int)(f1 + localObject[0] - this.xBc), (int)(localObject[1] + f2));
          continue;
          bool = a(3, paramRecyclerView, this.xBj, (int)(f1 + localObject[0] - this.xBj.getWidth()), (int)(localObject[1] + f2));
          continue;
          bool = a(4, paramRecyclerView, this.xBk, (int)(f1 + localObject[0]), (int)(localObject[1] + f2));
        }
      }
      paramView = null;
    }
  }
  
  private boolean a(int paramInt1, RecyclerView paramRecyclerView, PopupWindow paramPopupWindow, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(270820);
    if ((!mHasInit) || (paramRecyclerView == null) || (paramPopupWindow == null))
    {
      AppMethodBeat.o(270820);
      return false;
    }
    if ((paramInt3 < l(paramRecyclerView)) || (paramInt3 > this.mScreenHeight - dwS()))
    {
      AppMethodBeat.o(270820);
      return false;
    }
    if (paramPopupWindow.isShowing())
    {
      paramPopupWindow.update(paramInt2, paramInt3, -1, -1, false);
      aq(paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      if (paramInt1 == 2)
      {
        dxb();
        this.xBq.startTimer(3000L, 0L);
      }
      AppMethodBeat.o(270820);
      return true;
      paramPopupWindow.showAtLocation(paramRecyclerView, 0, paramInt2, paramInt3);
      aq(paramInt1, paramInt2, paramInt3);
    }
  }
  
  private void aq(int paramInt1, int paramInt2, int paramInt3)
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
        } while ((this.xBf == null) || (this.xBf.length != 2));
        this.xBf[0] = paramInt2;
        this.xBf[1] = paramInt3;
        return;
      } while ((this.xBg == null) || (this.xBg.length != 2));
      this.xBg[0] = paramInt2;
      this.xBg[1] = paramInt3;
      return;
    } while ((this.xBh == null) || (this.xBh.length != 2));
    this.xBh[0] = paramInt2;
    this.xBh[1] = paramInt3;
  }
  
  private int ar(int paramInt1, int paramInt2, int paramInt3)
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
      bool = L(paramInt2, paramInt3, paramInt2, paramInt3);
    }
    while (bool)
    {
      AppMethodBeat.o(181892);
      return 3;
      if ((this.xBn == null) || (paramInt2 > this.xBn.endPos) || ((paramInt2 == this.xBn.endPos) && (paramInt3 >= this.xBn.xAR)))
      {
        AppMethodBeat.o(181892);
        return 1;
      }
      bool = L(paramInt2, paramInt3, this.xBn.endPos, this.xBn.xAR);
      continue;
      if ((this.xBn == null) || (paramInt2 < this.xBn.dIY) || ((paramInt2 == this.xBn.dIY) && (paramInt3 <= this.xBn.oHY)))
      {
        AppMethodBeat.o(181892);
        return 1;
      }
      bool = L(this.xBn.dIY, this.xBn.oHY, paramInt2, paramInt3);
    }
    AppMethodBeat.o(181892);
    return 2;
  }
  
  private ArrayList<com.tencent.mm.plugin.editor.model.a.a> b(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList, String paramString)
  {
    AppMethodBeat.i(181901);
    d locald = dwT();
    dwW();
    ArrayList localArrayList = new ArrayList();
    if (locald.getSelectType() != 3)
    {
      Log.e("EditorSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
      AppMethodBeat.o(181901);
      return null;
    }
    int i = locald.dIY;
    int j = locald.endPos;
    if (j >= locald.dIY)
    {
      Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().JL(j);
      SpannableStringBuilder localSpannableStringBuilder;
      j localj;
      if (localObject != null) {
        if ((j == locald.endPos) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
        {
          localObject = (j)localObject;
          localSpannableStringBuilder = a((j)localObject, 0, locald.xAR, false, paramBoolean, "", false);
          if (!Util.isNullOrNil(localSpannableStringBuilder))
          {
            localj = new j();
            localj.content = com.tencent.mm.plugin.editor.model.nativenote.a.b.a(localSpannableStringBuilder);
            localj.xyd = -1;
            localj.xyb = false;
            localArrayList.add(localj);
          }
          if ((paramBoolean) && (Util.isNullOrNil(((j)localObject).content))) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().av(j, true);
          }
        }
      }
      for (;;)
      {
        j -= 1;
        break;
        if ((j == locald.dIY) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
        {
          localObject = (j)localObject;
          localSpannableStringBuilder = a((j)localObject, locald.oHY, 0, true, paramBoolean, "", false);
          if (!Util.isNullOrNil(localSpannableStringBuilder))
          {
            localj = new j();
            localj.content = com.tencent.mm.plugin.editor.model.nativenote.a.b.a(localSpannableStringBuilder);
            localj.xyd = -1;
            localj.xyb = false;
            localArrayList.add(localj);
          }
          if ((paramBoolean) && (Util.isNullOrNil(((j)localObject).content))) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().av(j, true);
          } else {
            i += 1;
          }
        }
        else
        {
          localArrayList.add(com.tencent.mm.plugin.editor.b.a((com.tencent.mm.plugin.editor.model.a.a)localObject));
          if (paramBoolean) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().av(j, true);
          }
        }
      }
    }
    if (paramBoolean)
    {
      j = i + 1;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().b(i, paramArrayList);
        j = paramArrayList.size() + i;
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().gL(i - 1, j);
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
      paramArrayList.xyb = false;
      paramArrayList.xyd = -1;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().a(i, paramArrayList);
      break;
      paramString = "";
    }
  }
  
  private boolean c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(270821);
    if ((!mHasInit) || (paramRecyclerView == null) || (this.xBl == null))
    {
      AppMethodBeat.o(270821);
      return false;
    }
    if ((paramInt2 < l(paramRecyclerView)) || (paramInt2 > this.mScreenHeight - dwS()))
    {
      AppMethodBeat.o(270821);
      return false;
    }
    if (this.xBl.isShowing()) {
      this.xBl.update(paramInt1, paramInt2, -1, -1, false);
    }
    for (;;)
    {
      AppMethodBeat.o(270821);
      return true;
      this.xBl.showAtLocation(paramRecyclerView, 0, paramInt1, paramInt2);
    }
  }
  
  public static e dwQ()
  {
    AppMethodBeat.i(181865);
    if (xAS == null) {}
    try
    {
      if (xAS == null) {
        xAS = new e();
      }
      e locale = xAS;
      AppMethodBeat.o(181865);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(181865);
    }
  }
  
  private int dwS()
  {
    AppMethodBeat.i(181867);
    if (this.xBm != null)
    {
      int i = this.xBm.dvC();
      int j = this.xBm.dvD();
      AppMethodBeat.o(181867);
      return i + j;
    }
    AppMethodBeat.o(181867);
    return 0;
  }
  
  private void dwU()
  {
    AppMethodBeat.i(181871);
    L(-1, -1, -1, -1);
    AppMethodBeat.o(181871);
  }
  
  private void dwV()
  {
    AppMethodBeat.i(181873);
    if (this.xBm != null) {
      this.xBm.dvB();
    }
    AppMethodBeat.o(181873);
  }
  
  private void dxb()
  {
    AppMethodBeat.i(181888);
    if (this.xBq == null)
    {
      this.xBq = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(181858);
          if ((e.this.getSelectType() == 1) && (e.b(e.this))) {
            e.this.dwY();
          }
          AppMethodBeat.o(181858);
          return true;
        }
      }, false);
      AppMethodBeat.o(181888);
      return;
    }
    this.xBq.stopTimer();
    AppMethodBeat.o(181888);
  }
  
  private void dxc()
  {
    AppMethodBeat.i(181893);
    if (this.xBo == null)
    {
      this.xBo = new b();
      AppMethodBeat.o(181893);
      return;
    }
    this.xBo.reset();
    AppMethodBeat.o(181893);
  }
  
  private void dxd()
  {
    AppMethodBeat.i(181894);
    if (this.xBp == null)
    {
      this.xBp = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(181860);
          Log.d("EditorSelectManager", "onTimerExpired: ");
          RecyclerView localRecyclerView = e.a(e.this);
          int i;
          int j;
          if ((e.c(e.this) != null) && (e.c(e.this).xAH < e.a(e.this, localRecyclerView)))
          {
            i = 1;
            if ((e.c(e.this) == null) || (e.c(e.this).xAH <= e.d(e.this))) {
              break label205;
            }
            j = 1;
            label89:
            if ((!e.dxo()) || (localRecyclerView == null) || (e.c(e.this) == null) || (e.c(e.this).getType() != 1) || ((i == 0) && (j == 0))) {
              break label254;
            }
            if ((i == 0) || (!localRecyclerView.canScrollVertically(-1))) {
              break label210;
            }
            if (e.c(e.this).viewType == 3) {
              e.e(e.this);
            }
            e.f(e.this);
            e.this.dxa();
            e.this.dwY();
            localRecyclerView.br(0, -300);
          }
          for (;;)
          {
            AppMethodBeat.o(181860);
            return true;
            i = 0;
            break;
            label205:
            j = 0;
            break label89;
            label210:
            if ((j != 0) && (localRecyclerView.canScrollVertically(1)))
            {
              e.f(e.this);
              e.this.dxa();
              e.this.dwY();
              localRecyclerView.br(0, 300);
              continue;
              label254:
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
    this.xBp.stopTimer();
    AppMethodBeat.o(181894);
  }
  
  private int dxe()
  {
    AppMethodBeat.i(181896);
    int j = 0;
    if (this.xBm != null) {
      j = this.xBm.dvC();
    }
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.xBm != null) {
        i = this.xBm.dvD();
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
  
  private void dxf()
  {
    AppMethodBeat.i(181898);
    if (this.xBm != null) {
      this.xBm.dvA();
    }
    AppMethodBeat.o(181898);
  }
  
  private boolean dxh()
  {
    AppMethodBeat.i(181903);
    boolean bool1 = p(this.xBr, false);
    boolean bool2 = p(this.xBs, false);
    boolean bool3 = p(this.xBt, dxi());
    boolean bool4 = p(this.xBu, dxj());
    boolean bool5 = p(this.xBv, dxk());
    boolean bool6 = p(this.xBw, dxl());
    boolean bool7 = p(this.xBx, dxm());
    boolean bool8 = p(this.xBy, dxn());
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5) || (bool6) || (bool7) || (bool8))
    {
      AppMethodBeat.o(181903);
      return true;
    }
    AppMethodBeat.o(181903);
    return false;
  }
  
  private boolean dxi()
  {
    AppMethodBeat.i(181905);
    if (getSelectType() != 1)
    {
      AppMethodBeat.o(181905);
      return false;
    }
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().JL(this.xBn.dIY);
    if ((locala != null) && ((com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().size() > 1) || (locala.getType() != 1) || (!Util.isNullOrNil(((j)locala).content))))
    {
      AppMethodBeat.o(181905);
      return true;
    }
    AppMethodBeat.o(181905);
    return false;
  }
  
  private boolean dxj()
  {
    AppMethodBeat.i(181906);
    int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().dwx();
    int j = com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().dwy();
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().JL(i);
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().JL(j);
    if ((localObject == null) || (locala == null))
    {
      AppMethodBeat.o(181906);
      return false;
    }
    if ((this.xBn != null) && (this.xBn.dIY == i) && (this.xBn.oHY == 0) && (this.xBn.endPos == j)) {
      if (locala.getType() == 1)
      {
        localObject = com.tencent.mm.plugin.editor.model.nativenote.a.a.anA(((j)locala).content);
        if (localObject == null)
        {
          AppMethodBeat.o(181906);
          return false;
        }
        if (this.xBn.xAR == ((Spanned)localObject).length())
        {
          AppMethodBeat.o(181906);
          return false;
        }
      }
      else if ((locala.getType() != 1) && (this.xBn.xAR == 1))
      {
        AppMethodBeat.o(181906);
        return false;
      }
    }
    AppMethodBeat.o(181906);
    return true;
  }
  
  private boolean dxk()
  {
    boolean bool2 = true;
    AppMethodBeat.i(181907);
    if (!this.xAT)
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
    if (this.xBm != null) {
      if (this.xBm.dvE()) {
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
  
  private boolean dxl()
  {
    AppMethodBeat.i(181908);
    int i = getSelectType();
    if ((this.xAT) && ((i == 2) || (i == 3)))
    {
      AppMethodBeat.o(181908);
      return true;
    }
    AppMethodBeat.o(181908);
    return false;
  }
  
  private boolean dxm()
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
  
  private boolean dxn()
  {
    AppMethodBeat.i(181910);
    if ((!this.xAT) || (getSelectType() == 0))
    {
      AppMethodBeat.o(181910);
      return false;
    }
    MMApplicationContext.getContext();
    if (com.tencent.mm.plugin.editor.model.nativenote.manager.b.dwl() != 1)
    {
      AppMethodBeat.o(181910);
      return true;
    }
    AppMethodBeat.o(181910);
    return false;
  }
  
  private RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(270818);
    if (this.xBm != null)
    {
      RecyclerView localRecyclerView = this.xBm.dvF();
      AppMethodBeat.o(270818);
      return localRecyclerView;
    }
    AppMethodBeat.o(270818);
    return null;
  }
  
  public static boolean isEnabled()
  {
    return mHasInit;
  }
  
  public static void j(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(181897);
    if (paramTextView != null) {
      paramTextView.setTextSize(1, paramInt);
    }
    AppMethodBeat.o(181897);
  }
  
  private int l(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(270822);
    int j = 150;
    int i = j;
    if (paramRecyclerView != null)
    {
      paramRecyclerView.getLocationOnScreen(this.xBe);
      i = j;
      if (C(this.xBe)) {
        i = this.xBe[1];
      }
    }
    AppMethodBeat.o(270822);
    return i;
  }
  
  private void nW(boolean paramBoolean)
  {
    AppMethodBeat.i(181891);
    if ((!mHasInit) || (this.xBi == null) || (this.xBj == null) || (this.xBk == null) || (this.xBn == null))
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
    if ((this.xBo == null) || (this.xBo.getType() != 1))
    {
      AppMethodBeat.o(181891);
      return;
    }
    int k = this.xBo.viewType;
    if ((k != 2) && (k != 3) && (k != 4))
    {
      AppMethodBeat.o(181891);
      return;
    }
    float f2 = this.xBo.xAG - this.xBo.fif;
    float f1 = this.xBo.xAH;
    float f3 = this.xBo.fig;
    f3 = this.xAU / 2 + (f1 - f3);
    View localView;
    Object localObject2;
    Object localObject1;
    int i;
    if (k == 2)
    {
      f1 = f2 + this.xBi.getWidth() / 2;
      localRecyclerView.getLocationOnScreen(this.xBe);
      localView = localRecyclerView.Q(f1 - this.xBe[0], f3 - this.xBe[1]);
      localObject2 = f.eX(localView);
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
        f1 = f2 + this.xBj.getWidth();
        break;
        if (((c)localObject2).xAO != null)
        {
          localObject1 = ((c)localObject2).xAO;
          localObject2 = new int[2];
          ((WXRTEditText)localObject1).getLocationOnScreen((int[])localObject2);
          i = ((WXRTEditText)localObject1).getOffsetForPosition(f1 - localObject2[0], f3 - localObject2[1]);
          i = ar(k, ((WXRTEditText)localObject1).getPosInDataList(), i);
        }
        else if ((((c)localObject2).xAP != null) && (((c)localObject2).xAQ != null))
        {
          if (k == 3)
          {
            localObject2 = ((c)localObject2).xAP;
            j = ar(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.xBj, (int)(this.xBo.xAG - this.xBo.fif), (int)(this.xBo.xAH - this.xBo.fig));
              i = j;
              localObject1 = localObject2;
            }
          }
          else if (k == 4)
          {
            localObject2 = ((c)localObject2).xAQ;
            j = ar(k, ((WXRTEditText)localObject2).getPosInDataList(), 1);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.xBk, (int)(this.xBo.xAG - this.xBo.fif), (int)(this.xBo.xAH - this.xBo.fig));
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
            localObject2 = ((c)localObject2).xAP;
          }
          for (int j = ar(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);; j = ar(k, ((WXRTEditText)localObject2).getPosInDataList(), 1))
          {
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.xBi, (int)(this.xBo.xAG - this.xBo.fif), (int)(this.xBo.xAH - this.xBo.fig));
              localObject1 = localObject2;
              i = j;
            }
            break;
            localObject2 = ((c)localObject2).xAQ;
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
          if ((!paramBoolean) || ((this.xBo.xAH >= l(localRecyclerView)) && (this.xBo.xAH <= dxe())) || ((this.xBp != null) && (!this.xBp.stopped()))) {
            break label1163;
          }
          dxd();
          this.xBp.startTimer(100L);
          AppMethodBeat.o(181891);
          return;
          i = 1;
          continue;
          localObject2 = ((WXRTEditText)localObject1).getText();
          i = getSelectType();
          if ((this.xAT) && (localObject2 != null) && (i == 1))
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
                dwV();
              }
              dwY();
              h(true, 0L);
              if (k != 4) {
                break label1147;
              }
            }
          }
          label1147:
          for (i = this.xBn.xAR;; i = this.xBn.oHY)
          {
            a(k, localRecyclerView, localView, i);
            i = 1;
            break;
            if (this.xBn.oHY > ((Editable)localObject2).length()) {
              break label912;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.xBn.oHY);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label912;
            if ((!this.xAT) || (localObject2 == null) || (i != 2) || (!((WXRTEditText)localObject1).hasFocus())) {
              break label912;
            }
            if ((((WXRTEditText)localObject1).getEditTextType() == 1) || (((WXRTEditText)localObject1).getEditTextType() == 2))
            {
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
              ((WXRTEditText)localObject1).setSelection(0);
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
              break label912;
            }
            if ((this.xBn.oHY > ((Editable)localObject2).length()) || (this.xBn.xAR > ((Editable)localObject2).length())) {
              break label912;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.xBn.oHY, this.xBn.xAR);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label912;
          }
        }
        label912:
        dxd();
        label1163:
        AppMethodBeat.o(181891);
        return;
        i = 0;
      }
    }
  }
  
  private static boolean p(View paramView, boolean paramBoolean)
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
  
  public final int JQ(int paramInt)
  {
    AppMethodBeat.i(181872);
    if ((!mHasInit) || (this.xBn == null))
    {
      AppMethodBeat.o(181872);
      return 0;
    }
    if ((getSelectType() == 0) || (paramInt < this.xBn.dIY) || (paramInt > this.xBn.endPos))
    {
      AppMethodBeat.o(181872);
      return 0;
    }
    if ((paramInt == this.xBn.dIY) && (paramInt == this.xBn.endPos))
    {
      AppMethodBeat.o(181872);
      return 1;
    }
    if ((paramInt > this.xBn.dIY) && (paramInt < this.xBn.endPos))
    {
      AppMethodBeat.o(181872);
      return 2;
    }
    if ((paramInt == this.xBn.dIY) && (paramInt < this.xBn.endPos))
    {
      AppMethodBeat.o(181872);
      return 4;
    }
    if ((paramInt > this.xBn.dIY) && (paramInt == this.xBn.endPos))
    {
      AppMethodBeat.o(181872);
      return 3;
    }
    AppMethodBeat.o(181872);
    return 0;
  }
  
  public final boolean L(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(181870);
    if (!mHasInit)
    {
      AppMethodBeat.o(181870);
      return false;
    }
    boolean bool;
    if (this.xBn == null)
    {
      this.xBn = new d(paramInt1, paramInt2, paramInt3, paramInt4);
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        Log.d("EditorSelectManager", "setSelectInfo: %d:%d - %d:%d", new Object[] { Integer.valueOf(this.xBn.dIY), Integer.valueOf(this.xBn.oHY), Integer.valueOf(this.xBn.endPos), Integer.valueOf(this.xBn.xAR) });
      }
      AppMethodBeat.o(181870);
      return bool;
      if ((this.xBn.dIY != paramInt1) || (this.xBn.oHY != paramInt2) || (this.xBn.endPos != paramInt3) || (this.xBn.xAR != paramInt4))
      {
        this.xBn.K(paramInt1, paramInt2, paramInt3, paramInt4);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final void Q(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(181875);
    if (!mHasInit)
    {
      AppMethodBeat.o(181875);
      return;
    }
    dxa();
    dwY();
    h(true, 50L);
    nV(paramBoolean1);
    nT(paramBoolean2);
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
    if ((this.xBo != null) && (this.xBo.getType() == 1) && (this.xBo.viewType != paramInt))
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
      dxc();
      if (!dwX()) {
        nU(true);
      }
      this.xBo.a(paramInt, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), 0);
      AppMethodBeat.o(181890);
      return;
      if ((this.xBo != null) && (this.xBo.getType() == 1))
      {
        this.xBo.xAG = paramMotionEvent.getRawX();
        this.xBo.xAH = paramMotionEvent.getRawY();
        nW(true);
        AppMethodBeat.o(181890);
        return;
        dxc();
        this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(181859);
            e.this.nV(true);
            e.this.nU(true);
            AppMethodBeat.o(181859);
          }
        }, 200L);
      }
    }
  }
  
  public final void a(View paramView1, View paramView2, View paramView3, int paramInt)
  {
    AppMethodBeat.i(181877);
    if ((!mHasInit) || (paramView1 == null) || (paramView2 == null) || (paramView3 == null) || (this.xBn == null))
    {
      AppMethodBeat.o(181877);
      return;
    }
    switch (JQ(paramInt))
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
      if (this.xBn.oHY == this.xBn.xAR) {
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
      if (this.xBn.oHY == 0)
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
    } while (this.xBn.xAR == 0);
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
    paramView3.setVisibility(4);
    AppMethodBeat.o(181877);
  }
  
  public final boolean dwR()
  {
    return (mHasInit) && (this.xAT);
  }
  
  public final d dwT()
  {
    AppMethodBeat.i(181869);
    if (!mHasInit)
    {
      locald = new d();
      AppMethodBeat.o(181869);
      return locald;
    }
    if (this.xBn == null) {
      this.xBn = new d();
    }
    d locald = new d(this.xBn.dIY, this.xBn.oHY, this.xBn.endPos, this.xBn.xAR);
    AppMethodBeat.o(181869);
    return locald;
  }
  
  public final void dwW()
  {
    AppMethodBeat.i(181874);
    if (!mHasInit)
    {
      AppMethodBeat.o(181874);
      return;
    }
    dwU();
    h(true, 0L);
    dxa();
    dwY();
    AppMethodBeat.o(181874);
  }
  
  public final boolean dwX()
  {
    AppMethodBeat.i(181878);
    if ((this.xBl != null) && (this.xBl.isShowing()))
    {
      AppMethodBeat.o(181878);
      return true;
    }
    AppMethodBeat.o(181878);
    return false;
  }
  
  public final void dwY()
  {
    AppMethodBeat.i(181879);
    if (this.xBl != null) {
      this.xBl.dismiss();
    }
    AppMethodBeat.o(181879);
  }
  
  public final boolean dwZ()
  {
    AppMethodBeat.i(181882);
    if ((this.xBi != null) && (this.xBi.isShowing()))
    {
      AppMethodBeat.o(181882);
      return true;
    }
    AppMethodBeat.o(181882);
    return false;
  }
  
  public final void dxa()
  {
    AppMethodBeat.i(181883);
    if (!mHasInit)
    {
      AppMethodBeat.o(181883);
      return;
    }
    JR(2);
    JR(3);
    JR(4);
    AppMethodBeat.o(181883);
  }
  
  public final void dxg()
  {
    AppMethodBeat.i(181899);
    Log.i("EditorSelectManager", "deleteSelectedData");
    if (!mHasInit)
    {
      Log.e("EditorSelectManager", "deleteSelectedData: not init");
      AppMethodBeat.o(181899);
      return;
    }
    dwY();
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
    dxf();
    AppMethodBeat.o(181899);
  }
  
  public final int getSelectType()
  {
    AppMethodBeat.i(181868);
    if (!mHasInit)
    {
      AppMethodBeat.o(181868);
      return 0;
    }
    if (this.xBn == null) {
      this.xBn = new d();
    }
    int i = this.xBn.getSelectType();
    AppMethodBeat.o(181868);
    return i;
  }
  
  public final void h(final boolean paramBoolean, long paramLong)
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
          c localc = f.eX((View)localObject);
          if (localc != null)
          {
            if (localc.xAO == null) {
              break label78;
            }
            if (paramBoolean) {
              localc.xAO.postInvalidate();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label78:
            if ((localc.xAP != null) && (localc.xAQ != null))
            {
              LinearLayout localLinearLayout1 = (LinearLayout)((View)localObject).findViewById(d.e.fSM);
              LinearLayout localLinearLayout2 = (LinearLayout)((View)localObject).findViewById(d.e.fSP);
              localObject = (LinearLayout)((View)localObject).findViewById(d.e.fSN);
              e.this.a(localLinearLayout1, localLinearLayout2, (View)localObject, localc.xAP.getPosInDataList());
            }
          }
        }
        AppMethodBeat.o(181852);
      }
    }, paramLong);
    AppMethodBeat.o(181876);
  }
  
  public final void nT(final boolean paramBoolean)
  {
    AppMethodBeat.i(181880);
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181857);
        e.this.nU(paramBoolean);
        AppMethodBeat.o(181857);
      }
    }, 50L);
    AppMethodBeat.o(181880);
  }
  
  public final void nU(boolean paramBoolean)
  {
    AppMethodBeat.i(181881);
    if ((!mHasInit) || (this.xBl == null))
    {
      AppMethodBeat.o(181881);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = getSelectType();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)) || ((this.xBo != null) && (this.xBo.getType() == 1)))
    {
      dwY();
      AppMethodBeat.o(181881);
      return;
    }
    if (!dxh())
    {
      dwY();
      AppMethodBeat.o(181881);
      return;
    }
    int i1 = -1;
    int i2 = -1000;
    int i4 = l(localRecyclerView);
    int i5 = dxe();
    int k = 0;
    int m = 0;
    i = m;
    int j = k;
    if (this.xBl != null)
    {
      i = m;
      j = k;
      if (this.xBl.getContentView() != null)
      {
        this.xBl.getContentView().measure(0, 0);
        i = this.xBl.getContentView().getMeasuredHeight();
        j = this.xAX * 2 + i;
        i = this.xBl.getContentView().getMeasuredWidth() + this.xAX * 2;
      }
    }
    int i3;
    int n;
    if (j == 0)
    {
      i3 = this.xAZ;
      if (i != 0) {
        break label414;
      }
      n = this.xBa;
      label229:
      if ((this.xBi == null) || (!this.xBi.isShowing()) || (!C(this.xBf))) {
        break label458;
      }
      j = this.xBf[1] - i3;
      i = this.xBf[1] + this.xBi.getHeight() - this.xBb;
      if ((j < i4) || (j > i5)) {
        break label420;
      }
      k = this.xBf[0];
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
        j = ((LinearLayoutManager)localObject).Ju();
        k = ((LinearLayoutManager)localObject).Jw();
        if ((this.xBn.dIY > j) || (this.xBn.endPos < k)) {
          break label911;
        }
        k = 300;
        j = -1000;
      }
      for (;;)
      {
        if (k == -1)
        {
          dwY();
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
          j = this.xBf[0];
          break label311;
          label458:
          i = i2;
          j = i1;
          if (this.xBj != null)
          {
            i = i2;
            j = i1;
            if (this.xBj.isShowing())
            {
              i = i2;
              j = i1;
              if (C(this.xBg))
              {
                j = this.xBg[1] - i3;
                k = this.xBg[1] + this.xBj.getHeight() - this.xBb;
                if ((j < i4) || (j > i5)) {
                  break label662;
                }
                i = this.xBg[0];
              }
            }
          }
          for (;;)
          {
            m = i;
            k = j;
            if (this.xBk == null) {
              break label921;
            }
            m = i;
            k = j;
            if (!this.xBk.isShowing()) {
              break label921;
            }
            m = i;
            k = j;
            if (!C(this.xBh)) {
              break label921;
            }
            k = this.xBh[1] - i3;
            i1 = this.xBh[1] + this.xBk.getHeight() - this.xBb;
            if (j != -1) {
              break label740;
            }
            if ((k < i4) || (k > i5)) {
              break label701;
            }
            j = this.xBh[0];
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
                i = this.xBg[0];
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
          j = this.xBh[0];
          i = i1;
          break label311;
          label740:
          m = i;
          k = j;
          if (j + i3 <= this.xBh[1]) {
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
          j = this.xBh[0];
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
          c(localRecyclerView, this.xAY, k);
          AppMethodBeat.o(181881);
          return;
        }
        c(localRecyclerView, this.mScreenWidth - n - this.xAY, k);
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
  
  public final void nV(boolean paramBoolean)
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
      dxa();
      AppMethodBeat.o(181885);
      return;
    }
    View localView1 = f.c(localRecyclerView, this.xBn.dIY);
    View localView2 = f.c(localRecyclerView, this.xBn.endPos);
    if (i == 1)
    {
      JR(3);
      JR(4);
      a(2, localRecyclerView, localView1, this.xBn.oHY);
      AppMethodBeat.o(181885);
      return;
    }
    JR(2);
    a(3, localRecyclerView, localView1, this.xBn.oHY);
    a(4, localRecyclerView, localView2, this.xBn.xAR);
    AppMethodBeat.o(181885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.c.e
 * JD-Core Version:    0.7.0.1
 */