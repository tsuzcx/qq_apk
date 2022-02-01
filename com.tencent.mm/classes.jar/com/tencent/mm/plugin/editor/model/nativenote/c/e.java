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
  public static volatile e pwt = null;
  public ap mHandler = null;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public int pwA = 0;
  public int pwB = 0;
  public int pwC = 0;
  public int pwD = 0;
  public int pwE = 0;
  public int[] pwF = null;
  public int[] pwG = null;
  public int[] pwH = null;
  public int[] pwI = null;
  public PopupWindow pwJ = null;
  public PopupWindow pwK = null;
  public PopupWindow pwL = null;
  public PopupWindow pwM = null;
  public com.tencent.mm.plugin.editor.model.nativenote.b.a pwN = null;
  public d pwO = null;
  public b pwP = null;
  public av pwQ = null;
  public av pwR = null;
  public TextView pwS = null;
  public TextView pwT = null;
  public TextView pwU = null;
  public TextView pwV = null;
  public TextView pwW = null;
  public TextView pwX = null;
  public TextView pwY = null;
  public TextView pwZ = null;
  public boolean pwu = true;
  public int pwv = 0;
  public int pww = 0;
  public int pwx = 14;
  public int pwy = 0;
  public int pwz = 0;
  
  private e()
  {
    mHasInit = false;
  }
  
  private boolean BG(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(181884);
    if ((this.pwP != null) && (this.pwP.oIb == paramInt) && (this.pwP.getType() == 1))
    {
      AppMethodBeat.o(181884);
      return false;
    }
    if ((paramInt == 2) && (this.pwJ != null))
    {
      this.pwJ.dismiss();
      X(2, -1, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(181884);
      return bool;
      if ((paramInt == 3) && (this.pwK != null))
      {
        this.pwK.dismiss();
        X(3, -1, -1);
      }
      else if ((paramInt == 4) && (this.pwL != null))
      {
        this.pwL.dismiss();
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
        } while ((this.pwG == null) || (this.pwG.length != 2));
        this.pwG[0] = paramInt2;
        this.pwG[1] = paramInt3;
        return;
      } while ((this.pwH == null) || (this.pwH.length != 2));
      this.pwH[0] = paramInt2;
      this.pwH[1] = paramInt3;
      return;
    } while ((this.pwI == null) || (this.pwI.length != 2));
    this.pwI[0] = paramInt2;
    this.pwI[1] = paramInt3;
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
      if ((this.pwO == null) || (paramInt2 > this.pwO.endPos) || ((paramInt2 == this.pwO.endPos) && (paramInt3 >= this.pwO.pws)))
      {
        AppMethodBeat.o(181892);
        return 1;
      }
      bool = B(paramInt2, paramInt3, this.pwO.endPos, this.pwO.pws);
      continue;
      if ((this.pwO == null) || (paramInt2 < this.pwO.dfG) || ((paramInt2 == this.pwO.dfG) && (paramInt3 <= this.pwO.startOffset)))
      {
        AppMethodBeat.o(181892);
        return 1;
      }
      bool = B(this.pwO.dfG, this.pwO.startOffset, paramInt2, paramInt3);
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
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.a.a.aaV(paramj.content);
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
          Spanned localSpanned = com.tencent.mm.plugin.editor.model.nativenote.a.a.aaV(str);
          paramInt1 = paramInt2;
          if (localSpanned != null) {
            paramInt1 = paramInt2 + localSpanned.length();
          }
        }
        paramj.content = (com.tencent.mm.plugin.editor.model.nativenote.a.b.a(paramString) + str + com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)localObject));
      }
      if (paramBoolean3) {
        paramj.ptF = true;
      }
      for (paramj.ptH = paramInt1;; paramj.ptH = -1)
      {
        AppMethodBeat.o(181902);
        return localSpannableStringBuilder;
        paramj.ptF = false;
      }
    }
  }
  
  private SpannableStringBuilder a(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(181900);
    d locald = ceR();
    ceU();
    int j = locald.ceO();
    if ((j != 1) && (j != 2))
    {
      ad.e("EditorSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
      AppMethodBeat.o(181900);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().BA(locald.dfG);
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
        paramString = a((j)localObject, locald.startOffset, locald.pws, false, false, "", true);
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().a(paramArrayList, 0, locald.dfG, locald.startOffset, locald.pws);
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().fg(locald.dfG, locald.dfG + paramArrayList.size() + 1);
        paramArrayList = paramString;
      }
      for (;;)
      {
        AppMethodBeat.o(181900);
        return paramArrayList;
        paramString = a((j)localObject, locald.startOffset, locald.pws, false, paramBoolean, paramString, true);
        if (this.pwN != null) {
          this.pwN.Bv(locald.dfG);
        }
        paramArrayList = paramString;
        if (paramBoolean)
        {
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().cet();
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
      ((j)localObject).ptF = false;
      ((j)localObject).ptH = -1;
      paramArrayList.add(localObject);
    }
    label411:
    label420:
    for (;;)
    {
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().a(paramArrayList, i, locald.dfG, locald.startOffset, locald.pws);
      paramString = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej();
      i = locald.dfG;
      j = locald.dfG;
      paramString.fg(i - 1, paramArrayList.size() + j + 1);
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
      BG(paramInt1);
      AppMethodBeat.o(181886);
      return;
    }
    if (paramView.pwp != null) {
      paramView = paramView.pwp;
    }
    for (;;)
    {
      if (paramView == null)
      {
        BG(paramInt1);
        AppMethodBeat.o(181886);
        return;
        if ((paramView.pwq != null) && (paramView.pwr != null))
        {
          if (paramInt2 == 0)
          {
            paramView = paramView.pwq;
            paramInt2 = 0;
            continue;
          }
          if (paramInt2 == 1)
          {
            paramView = paramView.pwr;
            paramInt2 = 0;
          }
        }
      }
      else
      {
        Object localObject = paramView.getText();
        if ((localObject == null) || (paramInt2 < 0) || (paramInt2 > ((Editable)localObject).length()))
        {
          BG(paramInt1);
          AppMethodBeat.o(181886);
          return;
        }
        localObject = paramView.getLayout();
        if (localObject == null)
        {
          BG(paramInt1);
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
          f3 = f3 + paramView.getHeight() - this.pwv;
          if (paramInt1 == 3)
          {
            f1 = f4 + this.pwE;
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
            BG(paramInt1);
          }
          AppMethodBeat.o(181886);
          return;
          f1 = f4;
          f2 = f3;
          if (paramInt1 != 4) {
            break;
          }
          f1 = f4 - this.pwE;
          f2 = f3;
          break;
          bool = a(2, paramRecyclerView, this.pwJ, (int)(f1 + localObject[0] - this.pwD), (int)(localObject[1] + f2));
          continue;
          bool = a(3, paramRecyclerView, this.pwK, (int)(f1 + localObject[0] - this.pwK.getWidth()), (int)(localObject[1] + f2));
          continue;
          bool = a(4, paramRecyclerView, this.pwL, (int)(f1 + localObject[0]), (int)(localObject[1] + f2));
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
    if ((paramInt3 < p(paramRecyclerView)) || (paramInt3 > this.mScreenHeight - ceQ()))
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
        ceZ();
        this.pwR.az(3000L, 0L);
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
    d locald = ceR();
    ceU();
    ArrayList localArrayList = new ArrayList();
    if (locald.ceO() != 3)
    {
      ad.e("EditorSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
      AppMethodBeat.o(181901);
      return null;
    }
    int i = locald.dfG;
    int j = locald.endPos;
    if (j >= locald.dfG)
    {
      Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().BA(j);
      SpannableStringBuilder localSpannableStringBuilder;
      j localj;
      if (localObject != null) {
        if ((j == locald.endPos) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
        {
          localObject = (j)localObject;
          localSpannableStringBuilder = a((j)localObject, 0, locald.pws, false, paramBoolean, "", false);
          if (!bt.ai(localSpannableStringBuilder))
          {
            localj = new j();
            localj.content = com.tencent.mm.plugin.editor.model.nativenote.a.b.a(localSpannableStringBuilder);
            localj.ptH = -1;
            localj.ptF = false;
            localArrayList.add(localj);
          }
          if ((paramBoolean) && (bt.isNullOrNil(((j)localObject).content))) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().W(j, true);
          }
        }
      }
      for (;;)
      {
        j -= 1;
        break;
        if ((j == locald.dfG) && (((com.tencent.mm.plugin.editor.model.a.a)localObject).getType() == 1))
        {
          localObject = (j)localObject;
          localSpannableStringBuilder = a((j)localObject, locald.startOffset, 0, true, paramBoolean, "", false);
          if (!bt.ai(localSpannableStringBuilder))
          {
            localj = new j();
            localj.content = com.tencent.mm.plugin.editor.model.nativenote.a.b.a(localSpannableStringBuilder);
            localj.ptH = -1;
            localj.ptF = false;
            localArrayList.add(localj);
          }
          if ((paramBoolean) && (bt.isNullOrNil(((j)localObject).content))) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().W(j, true);
          } else {
            i += 1;
          }
        }
        else
        {
          localArrayList.add(com.tencent.mm.plugin.editor.b.a((com.tencent.mm.plugin.editor.model.a.a)localObject));
          if (paramBoolean) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().W(j, true);
          }
        }
      }
    }
    if (paramBoolean)
    {
      j = i + 1;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().b(i, paramArrayList);
        j = paramArrayList.size() + i;
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().fg(i - 1, j);
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
      paramArrayList.ptF = false;
      paramArrayList.ptH = -1;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().a(i, paramArrayList);
      break;
      paramString = "";
    }
  }
  
  public static e ceP()
  {
    AppMethodBeat.i(181865);
    if (pwt == null) {}
    try
    {
      if (pwt == null) {
        pwt = new e();
      }
      e locale = pwt;
      AppMethodBeat.o(181865);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(181865);
    }
  }
  
  private int ceQ()
  {
    AppMethodBeat.i(181867);
    if (this.pwN != null)
    {
      int i = this.pwN.cdz();
      int j = this.pwN.cdA();
      AppMethodBeat.o(181867);
      return i + j;
    }
    AppMethodBeat.o(181867);
    return 0;
  }
  
  private void ceS()
  {
    AppMethodBeat.i(181871);
    B(-1, -1, -1, -1);
    AppMethodBeat.o(181871);
  }
  
  private void ceT()
  {
    AppMethodBeat.i(181873);
    if (this.pwN != null) {
      this.pwN.cdy();
    }
    AppMethodBeat.o(181873);
  }
  
  private void ceZ()
  {
    AppMethodBeat.i(181888);
    if (this.pwR == null)
    {
      this.pwR = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(181858);
          if ((e.this.ceO() == 1) && (e.b(e.this))) {
            e.this.ceW();
          }
          AppMethodBeat.o(181858);
          return true;
        }
      }, false);
      AppMethodBeat.o(181888);
      return;
    }
    this.pwR.stopTimer();
    AppMethodBeat.o(181888);
  }
  
  private void cfa()
  {
    AppMethodBeat.i(181893);
    if (this.pwP == null)
    {
      this.pwP = new b();
      AppMethodBeat.o(181893);
      return;
    }
    this.pwP.reset();
    AppMethodBeat.o(181893);
  }
  
  private void cfb()
  {
    AppMethodBeat.i(181894);
    if (this.pwQ == null)
    {
      this.pwQ = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(181860);
          ad.d("EditorSelectManager", "onTimerExpired: ");
          RecyclerView localRecyclerView = e.a(e.this);
          int i;
          int j;
          if ((e.c(e.this) != null) && (e.c(e.this).pwi < e.a(e.this, localRecyclerView)))
          {
            i = 1;
            if ((e.c(e.this) == null) || (e.c(e.this).pwi <= e.d(e.this))) {
              break label206;
            }
            j = 1;
            label89:
            if ((!e.Mv()) || (localRecyclerView == null) || (e.c(e.this) == null) || (e.c(e.this).getType() != 1) || ((i == 0) && (j == 0))) {
              break label256;
            }
            if ((i == 0) || (!localRecyclerView.canScrollVertically(-1))) {
              break label211;
            }
            if (e.c(e.this).oIb == 3) {
              e.e(e.this);
            }
            e.f(e.this);
            e.this.ceY();
            e.this.ceW();
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
              e.this.ceY();
              e.this.ceW();
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
    this.pwQ.stopTimer();
    AppMethodBeat.o(181894);
  }
  
  private int cfc()
  {
    AppMethodBeat.i(181896);
    int j = 0;
    if (this.pwN != null) {
      j = this.pwN.cdz();
    }
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.pwN != null) {
        i = this.pwN.cdA();
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
  
  private void cfd()
  {
    AppMethodBeat.i(181898);
    if (this.pwN != null) {
      this.pwN.cdx();
    }
    AppMethodBeat.o(181898);
  }
  
  private boolean cff()
  {
    AppMethodBeat.i(181903);
    boolean bool1 = o(this.pwS, false);
    boolean bool2 = o(this.pwT, false);
    boolean bool3 = o(this.pwU, cfg());
    boolean bool4 = o(this.pwV, cfh());
    boolean bool5 = o(this.pwW, cfi());
    boolean bool6 = o(this.pwX, cfj());
    boolean bool7 = o(this.pwY, cfk());
    boolean bool8 = o(this.pwZ, cfl());
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5) || (bool6) || (bool7) || (bool8))
    {
      AppMethodBeat.o(181903);
      return true;
    }
    AppMethodBeat.o(181903);
    return false;
  }
  
  private boolean cfg()
  {
    AppMethodBeat.i(181905);
    if (ceO() != 1)
    {
      AppMethodBeat.o(181905);
      return false;
    }
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().BA(this.pwO.dfG);
    if ((locala != null) && ((com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().size() > 1) || (locala.getType() != 1) || (!bt.isNullOrNil(((j)locala).content))))
    {
      AppMethodBeat.o(181905);
      return true;
    }
    AppMethodBeat.o(181905);
    return false;
  }
  
  private boolean cfh()
  {
    AppMethodBeat.i(181906);
    int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().ceu();
    int j = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().cev();
    Object localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().BA(i);
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().BA(j);
    if ((localObject == null) || (locala == null))
    {
      AppMethodBeat.o(181906);
      return false;
    }
    if ((this.pwO != null) && (this.pwO.dfG == i) && (this.pwO.startOffset == 0) && (this.pwO.endPos == j)) {
      if (locala.getType() == 1)
      {
        localObject = com.tencent.mm.plugin.editor.model.nativenote.a.a.aaV(((j)locala).content);
        if (localObject == null)
        {
          AppMethodBeat.o(181906);
          return false;
        }
        if (this.pwO.pws == ((Spanned)localObject).length())
        {
          AppMethodBeat.o(181906);
          return false;
        }
      }
      else if ((locala.getType() != 1) && (this.pwO.pws == 1))
      {
        AppMethodBeat.o(181906);
        return false;
      }
    }
    AppMethodBeat.o(181906);
    return true;
  }
  
  private boolean cfi()
  {
    boolean bool2 = true;
    AppMethodBeat.i(181907);
    if (!this.pwu)
    {
      AppMethodBeat.o(181907);
      return false;
    }
    int i = ceO();
    if ((i == 0) || (i == 1))
    {
      AppMethodBeat.o(181907);
      return false;
    }
    boolean bool1 = bool2;
    if (this.pwN != null) {
      if (this.pwN.cdB()) {
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
  
  private boolean cfj()
  {
    AppMethodBeat.i(181908);
    int i = ceO();
    if ((this.pwu) && ((i == 2) || (i == 3)))
    {
      AppMethodBeat.o(181908);
      return true;
    }
    AppMethodBeat.o(181908);
    return false;
  }
  
  private boolean cfk()
  {
    AppMethodBeat.i(181909);
    int i = ceO();
    if ((i == 2) || (i == 3))
    {
      AppMethodBeat.o(181909);
      return true;
    }
    AppMethodBeat.o(181909);
    return false;
  }
  
  private boolean cfl()
  {
    AppMethodBeat.i(181910);
    if ((!this.pwu) || (ceO() == 0))
    {
      AppMethodBeat.o(181910);
      return false;
    }
    aj.getContext();
    if (com.tencent.mm.plugin.editor.model.nativenote.manager.b.cei() != 1)
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
    if (this.pwN != null)
    {
      RecyclerView localRecyclerView = this.pwN.cdC();
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
    if ((!mHasInit) || (paramRecyclerView == null) || (this.pwM == null))
    {
      AppMethodBeat.o(181889);
      return false;
    }
    if ((paramInt2 < p(paramRecyclerView)) || (paramInt2 > this.mScreenHeight - ceQ()))
    {
      AppMethodBeat.o(181889);
      return false;
    }
    if (this.pwM.isShowing()) {
      this.pwM.update(paramInt1, paramInt2, -1, -1, false);
    }
    for (;;)
    {
      AppMethodBeat.o(181889);
      return true;
      this.pwM.showAtLocation(paramRecyclerView, 0, paramInt1, paramInt2);
    }
  }
  
  public static boolean isEnabled()
  {
    return mHasInit;
  }
  
  private void km(boolean paramBoolean)
  {
    AppMethodBeat.i(181891);
    if ((!mHasInit) || (this.pwJ == null) || (this.pwK == null) || (this.pwL == null) || (this.pwO == null))
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
    if ((this.pwP == null) || (this.pwP.getType() != 1))
    {
      AppMethodBeat.o(181891);
      return;
    }
    int k = this.pwP.oIb;
    if ((k != 2) && (k != 3) && (k != 4))
    {
      AppMethodBeat.o(181891);
      return;
    }
    float f2 = this.pwP.pwh - this.pwP.cNg;
    float f1 = this.pwP.pwi;
    float f3 = this.pwP.cNh;
    f3 = this.pwv / 2 + (f1 - f3);
    View localView;
    Object localObject2;
    Object localObject1;
    int i;
    if (k == 2)
    {
      f1 = f2 + this.pwJ.getWidth() / 2;
      localRecyclerView.getLocationOnScreen(this.pwF);
      localView = localRecyclerView.o(f1 - this.pwF[0], f3 - this.pwF[1]);
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
        f1 = f2 + this.pwK.getWidth();
        break;
        if (((c)localObject2).pwp != null)
        {
          localObject1 = ((c)localObject2).pwp;
          localObject2 = new int[2];
          ((WXRTEditText)localObject1).getLocationOnScreen((int[])localObject2);
          i = ((WXRTEditText)localObject1).getOffsetForPosition(f1 - localObject2[0], f3 - localObject2[1]);
          i = Y(k, ((WXRTEditText)localObject1).getPosInDataList(), i);
        }
        else if ((((c)localObject2).pwq != null) && (((c)localObject2).pwr != null))
        {
          if (k == 3)
          {
            localObject2 = ((c)localObject2).pwq;
            j = Y(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.pwK, (int)(this.pwP.pwh - this.pwP.cNg), (int)(this.pwP.pwi - this.pwP.cNh));
              i = j;
              localObject1 = localObject2;
            }
          }
          else if (k == 4)
          {
            localObject2 = ((c)localObject2).pwr;
            j = Y(k, ((WXRTEditText)localObject2).getPosInDataList(), 1);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.pwL, (int)(this.pwP.pwh - this.pwP.cNg), (int)(this.pwP.pwi - this.pwP.cNh));
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
            localObject2 = ((c)localObject2).pwq;
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
              a(k, localRecyclerView, this.pwJ, (int)(this.pwP.pwh - this.pwP.cNg), (int)(this.pwP.pwi - this.pwP.cNh));
              localObject1 = localObject2;
              i = j;
            }
            break;
            localObject2 = ((c)localObject2).pwr;
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
          if ((!paramBoolean) || ((this.pwP.pwi >= p(localRecyclerView)) && (this.pwP.pwi <= cfc())) || ((this.pwQ != null) && (!this.pwQ.fkZ()))) {
            break label1166;
          }
          cfb();
          this.pwQ.az(100L, 100L);
          AppMethodBeat.o(181891);
          return;
          i = 1;
          continue;
          localObject2 = ((WXRTEditText)localObject1).getText();
          i = ceO();
          if ((this.pwu) && (localObject2 != null) && (i == 1))
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
                ceT();
              }
              ceW();
              f(true, 0L);
              if (k != 4) {
                break label1150;
              }
            }
          }
          label1150:
          for (i = this.pwO.pws;; i = this.pwO.startOffset)
          {
            a(k, localRecyclerView, localView, i);
            i = 1;
            break;
            if (this.pwO.startOffset > ((Editable)localObject2).length()) {
              break label915;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.pwO.startOffset);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label915;
            if ((!this.pwu) || (localObject2 == null) || (i != 2) || (!((WXRTEditText)localObject1).hasFocus())) {
              break label915;
            }
            if ((((WXRTEditText)localObject1).getEditTextType() == 1) || (((WXRTEditText)localObject1).getEditTextType() == 2))
            {
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
              ((WXRTEditText)localObject1).setSelection(0);
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
              break label915;
            }
            if ((this.pwO.startOffset > ((Editable)localObject2).length()) || (this.pwO.pws > ((Editable)localObject2).length())) {
              break label915;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.pwO.startOffset, this.pwO.pws);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label915;
          }
        }
        label915:
        cfb();
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
      paramRecyclerView.getLocationOnScreen(this.pwF);
      i = j;
      if (x(this.pwF)) {
        i = this.pwF[1];
      }
    }
    AppMethodBeat.o(181895);
    return i;
  }
  
  private static boolean x(int[] paramArrayOfInt)
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
    if (this.pwO == null)
    {
      this.pwO = new d(paramInt1, paramInt2, paramInt3, paramInt4);
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        ad.d("EditorSelectManager", "setSelectInfo: %d:%d - %d:%d", new Object[] { Integer.valueOf(this.pwO.dfG), Integer.valueOf(this.pwO.startOffset), Integer.valueOf(this.pwO.endPos), Integer.valueOf(this.pwO.pws) });
      }
      AppMethodBeat.o(181870);
      return bool;
      if ((this.pwO.dfG != paramInt1) || (this.pwO.startOffset != paramInt2) || (this.pwO.endPos != paramInt3) || (this.pwO.pws != paramInt4))
      {
        this.pwO.set(paramInt1, paramInt2, paramInt3, paramInt4);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final int BF(int paramInt)
  {
    AppMethodBeat.i(181872);
    if ((!mHasInit) || (this.pwO == null))
    {
      AppMethodBeat.o(181872);
      return 0;
    }
    if ((ceO() == 0) || (paramInt < this.pwO.dfG) || (paramInt > this.pwO.endPos))
    {
      AppMethodBeat.o(181872);
      return 0;
    }
    if ((paramInt == this.pwO.dfG) && (paramInt == this.pwO.endPos))
    {
      AppMethodBeat.o(181872);
      return 1;
    }
    if ((paramInt > this.pwO.dfG) && (paramInt < this.pwO.endPos))
    {
      AppMethodBeat.o(181872);
      return 2;
    }
    if ((paramInt == this.pwO.dfG) && (paramInt < this.pwO.endPos))
    {
      AppMethodBeat.o(181872);
      return 4;
    }
    if ((paramInt > this.pwO.dfG) && (paramInt == this.pwO.endPos))
    {
      AppMethodBeat.o(181872);
      return 3;
    }
    AppMethodBeat.o(181872);
    return 0;
  }
  
  public final void K(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(181875);
    if (!mHasInit)
    {
      AppMethodBeat.o(181875);
      return;
    }
    ceY();
    ceW();
    f(true, 50L);
    kl(paramBoolean1);
    kj(paramBoolean2);
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
    if ((this.pwP != null) && (this.pwP.getType() == 1) && (this.pwP.oIb != paramInt))
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
      cfa();
      if (!ceV()) {
        kk(true);
      }
      this.pwP.a(paramInt, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), 0);
      AppMethodBeat.o(181890);
      return;
      if ((this.pwP != null) && (this.pwP.getType() == 1))
      {
        this.pwP.pwh = paramMotionEvent.getRawX();
        this.pwP.pwi = paramMotionEvent.getRawY();
        km(true);
        AppMethodBeat.o(181890);
        return;
        cfa();
        this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(181859);
            e.this.kl(true);
            e.this.kk(true);
            AppMethodBeat.o(181859);
          }
        }, 200L);
      }
    }
  }
  
  public final void a(View paramView1, View paramView2, View paramView3, int paramInt)
  {
    AppMethodBeat.i(181877);
    if ((!mHasInit) || (paramView1 == null) || (paramView2 == null) || (paramView3 == null) || (this.pwO == null))
    {
      AppMethodBeat.o(181877);
      return;
    }
    switch (BF(paramInt))
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
      if (this.pwO.startOffset == this.pwO.pws) {
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
      if (this.pwO.startOffset == 0)
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
    } while (this.pwO.pws == 0);
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
    paramView3.setVisibility(4);
    AppMethodBeat.o(181877);
  }
  
  public final int ceO()
  {
    AppMethodBeat.i(181868);
    if (!mHasInit)
    {
      AppMethodBeat.o(181868);
      return 0;
    }
    if (this.pwO == null) {
      this.pwO = new d();
    }
    int i = this.pwO.ceO();
    AppMethodBeat.o(181868);
    return i;
  }
  
  public final d ceR()
  {
    AppMethodBeat.i(181869);
    if (!mHasInit)
    {
      locald = new d();
      AppMethodBeat.o(181869);
      return locald;
    }
    if (this.pwO == null) {
      this.pwO = new d();
    }
    d locald = new d(this.pwO.dfG, this.pwO.startOffset, this.pwO.endPos, this.pwO.pws);
    AppMethodBeat.o(181869);
    return locald;
  }
  
  public final void ceU()
  {
    AppMethodBeat.i(181874);
    if (!mHasInit)
    {
      AppMethodBeat.o(181874);
      return;
    }
    ceS();
    f(true, 0L);
    ceY();
    ceW();
    AppMethodBeat.o(181874);
  }
  
  public final boolean ceV()
  {
    AppMethodBeat.i(181878);
    if ((this.pwM != null) && (this.pwM.isShowing()))
    {
      AppMethodBeat.o(181878);
      return true;
    }
    AppMethodBeat.o(181878);
    return false;
  }
  
  public final void ceW()
  {
    AppMethodBeat.i(181879);
    if (this.pwM != null) {
      this.pwM.dismiss();
    }
    AppMethodBeat.o(181879);
  }
  
  public final boolean ceX()
  {
    AppMethodBeat.i(181882);
    if ((this.pwJ != null) && (this.pwJ.isShowing()))
    {
      AppMethodBeat.o(181882);
      return true;
    }
    AppMethodBeat.o(181882);
    return false;
  }
  
  public final void ceY()
  {
    AppMethodBeat.i(181883);
    if (!mHasInit)
    {
      AppMethodBeat.o(181883);
      return;
    }
    BG(2);
    BG(3);
    BG(4);
    AppMethodBeat.o(181883);
  }
  
  public final void cfe()
  {
    AppMethodBeat.i(181899);
    ad.i("EditorSelectManager", "deleteSelectedData");
    if (!mHasInit)
    {
      ad.e("EditorSelectManager", "deleteSelectedData: not init");
      AppMethodBeat.o(181899);
      return;
    }
    ceW();
    int i = ceO();
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
    cfd();
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
            if (localc.pwp == null) {
              break label78;
            }
            if (paramBoolean) {
              localc.pwp.postInvalidate();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label78:
            if ((localc.pwq != null) && (localc.pwr != null))
            {
              LinearLayout localLinearLayout1 = (LinearLayout)((View)localObject).findViewById(2131303103);
              LinearLayout localLinearLayout2 = (LinearLayout)((View)localObject).findViewById(2131303110);
              localObject = (LinearLayout)((View)localObject).findViewById(2131303105);
              e.this.a(localLinearLayout1, localLinearLayout2, (View)localObject, localc.pwq.getPosInDataList());
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
    return (mHasInit) && (this.pwu);
  }
  
  public final void kj(final boolean paramBoolean)
  {
    AppMethodBeat.i(181880);
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181857);
        e.this.kk(paramBoolean);
        AppMethodBeat.o(181857);
      }
    }, 50L);
    AppMethodBeat.o(181880);
  }
  
  public final void kk(boolean paramBoolean)
  {
    AppMethodBeat.i(181881);
    if ((!mHasInit) || (this.pwM == null))
    {
      AppMethodBeat.o(181881);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = ceO();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)) || ((this.pwP != null) && (this.pwP.getType() == 1)))
    {
      ceW();
      AppMethodBeat.o(181881);
      return;
    }
    if (!cff())
    {
      ceW();
      AppMethodBeat.o(181881);
      return;
    }
    int i1 = -1;
    int i2 = -1000;
    int i4 = p(localRecyclerView);
    int i5 = cfc();
    int k = 0;
    int m = 0;
    i = m;
    int j = k;
    if (this.pwM != null)
    {
      i = m;
      j = k;
      if (this.pwM.getContentView() != null)
      {
        this.pwM.getContentView().measure(0, 0);
        i = this.pwM.getContentView().getMeasuredHeight();
        j = this.pwy * 2 + i;
        i = this.pwM.getContentView().getMeasuredWidth() + this.pwy * 2;
      }
    }
    int i3;
    int n;
    if (j == 0)
    {
      i3 = this.pwA;
      if (i != 0) {
        break label414;
      }
      n = this.pwB;
      label229:
      if ((this.pwJ == null) || (!this.pwJ.isShowing()) || (!x(this.pwG))) {
        break label458;
      }
      j = this.pwG[1] - i3;
      i = this.pwG[1] + this.pwJ.getHeight() - this.pwC;
      if ((j < i4) || (j > i5)) {
        break label420;
      }
      k = this.pwG[0];
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
        if ((this.pwO.dfG > j) || (this.pwO.endPos < k)) {
          break label911;
        }
        k = 300;
        j = -1000;
      }
      for (;;)
      {
        if (k == -1)
        {
          ceW();
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
          j = this.pwG[0];
          break label311;
          label458:
          i = i2;
          j = i1;
          if (this.pwK != null)
          {
            i = i2;
            j = i1;
            if (this.pwK.isShowing())
            {
              i = i2;
              j = i1;
              if (x(this.pwH))
              {
                j = this.pwH[1] - i3;
                k = this.pwH[1] + this.pwK.getHeight() - this.pwC;
                if ((j < i4) || (j > i5)) {
                  break label662;
                }
                i = this.pwH[0];
              }
            }
          }
          for (;;)
          {
            m = i;
            k = j;
            if (this.pwL == null) {
              break label921;
            }
            m = i;
            k = j;
            if (!this.pwL.isShowing()) {
              break label921;
            }
            m = i;
            k = j;
            if (!x(this.pwI)) {
              break label921;
            }
            k = this.pwI[1] - i3;
            i1 = this.pwI[1] + this.pwL.getHeight() - this.pwC;
            if (j != -1) {
              break label740;
            }
            if ((k < i4) || (k > i5)) {
              break label701;
            }
            j = this.pwI[0];
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
                i = this.pwH[0];
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
          j = this.pwI[0];
          i = i1;
          break label311;
          label740:
          m = i;
          k = j;
          if (j + i3 <= this.pwI[1]) {
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
          j = this.pwI[0];
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
          i(localRecyclerView, this.pwz, k);
          AppMethodBeat.o(181881);
          return;
        }
        i(localRecyclerView, this.mScreenWidth - n - this.pwz, k);
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
  
  public final void kl(boolean paramBoolean)
  {
    AppMethodBeat.i(181885);
    if (!mHasInit)
    {
      AppMethodBeat.o(181885);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = ceO();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)))
    {
      ceY();
      AppMethodBeat.o(181885);
      return;
    }
    View localView1 = f.e(localRecyclerView, this.pwO.dfG);
    View localView2 = f.e(localRecyclerView, this.pwO.endPos);
    if (i == 1)
    {
      BG(3);
      BG(4);
      a(2, localRecyclerView, localView1, this.pwO.startOffset);
      AppMethodBeat.o(181885);
      return;
    }
    BG(2);
    a(3, localRecyclerView, localView1, this.pwO.startOffset);
    a(4, localRecyclerView, localView2, this.pwO.pws);
    AppMethodBeat.o(181885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.c.e
 * JD-Core Version:    0.7.0.1
 */