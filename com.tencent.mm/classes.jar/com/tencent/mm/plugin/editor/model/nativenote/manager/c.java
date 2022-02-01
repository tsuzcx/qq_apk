package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.content.Context;
import android.text.Editable;
import android.text.Spanned;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.d.h;
import com.tencent.mm.plugin.editor.model.a.d;
import com.tencent.mm.plugin.editor.model.a.j;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.editor.model.a.m;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c
{
  private static volatile c xyQ = null;
  public ArrayList<com.tencent.mm.plugin.editor.model.a.a> mDataList = null;
  public com.tencent.mm.plugin.editor.model.nativenote.b.a xyR = null;
  public arf xyS = null;
  public int xyT = 0;
  public int xyU = 0;
  public int xyV = 0;
  
  private boolean JM(int paramInt)
  {
    AppMethodBeat.i(181735);
    if ((this.mDataList != null) && (paramInt >= 0) && (paramInt < this.mDataList.size()))
    {
      a((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(paramInt), false);
      this.mDataList.remove(paramInt);
    }
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(181735);
      return bool;
    }
  }
  
  private void a(com.tencent.mm.plugin.editor.model.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(181757);
    if (parama == null)
    {
      AppMethodBeat.o(181757);
      return;
    }
    if (parama.getType() == 1)
    {
      int i = com.tencent.mm.plugin.editor.b.anr(((j)parama).content);
      if (paramBoolean)
      {
        this.xyU = (i + this.xyU);
        AppMethodBeat.o(181757);
        return;
      }
      this.xyU -= i;
      AppMethodBeat.o(181757);
      return;
    }
    if (paramBoolean)
    {
      this.xyV += 1;
      AppMethodBeat.o(181757);
      return;
    }
    this.xyV -= 1;
    AppMethodBeat.o(181757);
  }
  
  private boolean b(int paramInt, com.tencent.mm.plugin.editor.model.a.a parama)
  {
    boolean bool = true;
    AppMethodBeat.i(181733);
    if ((parama != null) && (this.mDataList != null) && (paramInt >= 0) && (paramInt <= this.mDataList.size()))
    {
      this.mDataList.add(paramInt, parama);
      a(parama, true);
    }
    for (;;)
    {
      AppMethodBeat.o(181733);
      return bool;
      bool = false;
    }
  }
  
  private static String dT(String paramString, int paramInt)
  {
    AppMethodBeat.i(181747);
    paramString = String.format("<div><object data-type=\"%d\" id=\"%s\" name=\"%s\" class=\"item item-\"></object></div>", new Object[] { Integer.valueOf(paramInt), paramString, paramString });
    AppMethodBeat.o(181747);
    return paramString;
  }
  
  public static c dwm()
  {
    AppMethodBeat.i(181727);
    if (xyQ == null) {}
    try
    {
      if (xyQ == null) {
        xyQ = new c();
      }
      c localc = xyQ;
      AppMethodBeat.o(181727);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(181727);
    }
  }
  
  private void dwq()
  {
    AppMethodBeat.i(181741);
    if (this.mDataList != null)
    {
      Iterator localIterator = this.mDataList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)localIterator.next();
        locala.xyb = false;
        locala.xyh = false;
      }
    }
    AppMethodBeat.o(181741);
  }
  
  private String dwt()
  {
    AppMethodBeat.i(181745);
    if ((this.xyT == 0) && (this.mDataList != null))
    {
      localObject = this.mDataList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        d locald = (d)((Iterator)localObject).next();
        if (locald.xyo.startsWith("WeNote_"))
        {
          i = Util.getInt(locald.xyo.substring(7), -1);
          if (i > this.xyT) {}
          for (;;)
          {
            this.xyT = i;
            break;
            i = this.xyT;
          }
        }
      }
    }
    Object localObject = new StringBuilder("WeNote_");
    int i = this.xyT + 1;
    this.xyT = i;
    localObject = i;
    AppMethodBeat.o(181745);
    return localObject;
  }
  
  private void f(com.tencent.mm.plugin.editor.model.a.a parama)
  {
    AppMethodBeat.i(181752);
    if (parama == null)
    {
      AppMethodBeat.o(181752);
      return;
    }
    d locald = (d)parama;
    if ((locald.getType() > 1) && (Util.isNullOrNil(locald.xyo))) {
      locald.xyo = dwt();
    }
    if (Util.isNullOrNil(parama.hIQ)) {
      parama.hIQ = com.tencent.mm.plugin.editor.model.b.anz(parama.toString());
    }
    AppMethodBeat.o(181752);
  }
  
  public final com.tencent.mm.plugin.editor.model.a.a JL(int paramInt)
  {
    AppMethodBeat.i(181729);
    if ((this.mDataList != null) && (paramInt >= 0) && (paramInt < this.mDataList.size()))
    {
      com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(paramInt);
      AppMethodBeat.o(181729);
      return locala;
    }
    AppMethodBeat.o(181729);
    return null;
  }
  
  public final void JN(int paramInt)
  {
    AppMethodBeat.i(181736);
    if (this.xyR != null) {
      this.xyR.JG(paramInt);
    }
    AppMethodBeat.o(181736);
  }
  
  public final void X(ArrayList<WXRTEditText> paramArrayList)
  {
    AppMethodBeat.i(181754);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(181754);
      return;
    }
    paramArrayList.clear();
    for (;;)
    {
      com.tencent.mm.plugin.editor.model.a.a locala;
      try
      {
        if (this.mDataList == null) {
          return;
        }
        Iterator localIterator = this.mDataList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        locala = (com.tencent.mm.plugin.editor.model.a.a)localIterator.next();
        if (locala.xyg != null)
        {
          paramArrayList.add(locala.xyg);
          continue;
        }
        if (locala.xye == null) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(181754);
      }
      if (locala.xyf != null)
      {
        paramArrayList.add(locala.xye);
        paramArrayList.add(locala.xyf);
      }
    }
    AppMethodBeat.o(181754);
  }
  
  public final boolean Y(ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList)
  {
    AppMethodBeat.i(181755);
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    while (paramArrayList.hasNext())
    {
      com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.next();
      if (locala.getType() != 1) {
        i += 1;
      } else {
        localStringBuilder.append(((j)locala).content);
      }
    }
    boolean bool = gK(com.tencent.mm.plugin.editor.b.anr(localStringBuilder.toString()), i);
    AppMethodBeat.o(181755);
    return bool;
  }
  
  public final int a(com.tencent.mm.plugin.editor.model.a.a parama, WXRTEditText paramWXRTEditText, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(181749);
    if (parama == null)
    {
      AppMethodBeat.o(181749);
      return -1;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(parama);
    int i = a(localArrayList, paramWXRTEditText, true, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(181749);
    return i;
  }
  
  public final int a(ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(181751);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (this.mDataList == null) || (paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0) || (paramInt4 < paramInt3))
    {
      Log.e("MicroMsg.EditorDataManager", "pasteItemList,error,return");
      AppMethodBeat.o(181751);
      return -1;
    }
    Object localObject1 = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.get(paramArrayList.size() - 1);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.EditorDataManager", "pasteItemList, lastInsertItem is null");
      AppMethodBeat.o(181751);
      return -1;
    }
    ((com.tencent.mm.plugin.editor.model.a.a)localObject1).xyd = -1;
    ((com.tencent.mm.plugin.editor.model.a.a)localObject1).xyb = true;
    ((com.tencent.mm.plugin.editor.model.a.a)localObject1).xyh = false;
    Object localObject3 = JL(paramInt2);
    if (localObject3 == null)
    {
      Log.e("MicroMsg.EditorDataManager", "pasteItemList, item is null");
      AppMethodBeat.o(181751);
      return -1;
    }
    for (;;)
    {
      label462:
      label467:
      int j;
      int i;
      try
      {
        dwq();
        if ((paramInt1 != 0) || (((com.tencent.mm.plugin.editor.model.a.a)localObject3).getType() != 1)) {
          break label863;
        }
        Object localObject2 = com.tencent.mm.plugin.editor.model.nativenote.a.a.anA(((j)localObject3).content);
        if ((localObject2 == null) || (paramInt3 > ((Spanned)localObject2).length()) || (paramInt4 > ((Spanned)localObject2).length()))
        {
          if (localObject2 == null)
          {
            paramInt1 = -1;
            Log.e("MicroMsg.EditorDataManager", "pasteItemList error, oriText:%d  startOff:%d  endOff:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
            return -1;
          }
          paramInt1 = ((Spanned)localObject2).length();
          continue;
        }
        localObject1 = ((Spanned)localObject2).subSequence(0, paramInt3);
        CharSequence localCharSequence = ((Spanned)localObject2).subSequence(paramInt4, ((Spanned)localObject2).length());
        localObject2 = com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)localObject1);
        localObject1 = com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)localCharSequence);
        localObject3 = (j)localObject3;
        if (!Util.isNullOrNil((String)localObject2))
        {
          if (!((String)localObject2).endsWith("<br/>")) {
            break label846;
          }
          localObject2 = ((String)localObject2).substring(0, ((String)localObject2).length() - 5);
          ((j)localObject3).content = ((String)localObject2);
          paramInt2 += 1;
          paramInt1 = paramInt2;
          if (Util.isNullOrNil((String)localObject1)) {
            break label849;
          }
          localObject3 = new j();
          ((j)localObject3).type = 1;
          localObject2 = localObject1;
          if (((String)localObject1).startsWith("<br/>")) {
            localObject2 = ((String)localObject1).substring(5, ((String)localObject1).length());
          }
          ((j)localObject3).content = ((String)localObject2);
          ((j)localObject3).xyd = 0;
          ((j)localObject3).xyb = false;
          ((j)localObject3).xyh = false;
          b(paramInt2, (com.tencent.mm.plugin.editor.model.a.a)localObject3);
          paramInt4 = 1;
          paramInt1 = paramInt2;
          paramInt3 = paramInt2;
          paramInt2 = paramInt1;
          paramInt1 = paramInt4;
          paramArrayList = paramArrayList.iterator();
          j = paramInt3;
          paramInt4 = paramInt1;
          i = paramInt2;
          if (paramArrayList.hasNext())
          {
            localObject1 = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.next();
            f((com.tencent.mm.plugin.editor.model.a.a)localObject1);
            if (!b(paramInt3, (com.tencent.mm.plugin.editor.model.a.a)localObject1)) {
              break label843;
            }
            paramInt3 += 1;
            break label843;
          }
        }
        else
        {
          if (!Util.isNullOrNil((String)localObject1))
          {
            localObject2 = localObject1;
            if (((String)localObject1).startsWith("<br/>")) {
              localObject2 = ((String)localObject1).substring(5, ((String)localObject1).length());
            }
            ((j)localObject3).content = ((String)localObject2);
            paramInt1 = 0;
            paramInt4 = paramInt2;
            paramInt3 = paramInt2;
            paramInt2 = paramInt4;
            continue;
          }
          JM(paramInt2);
          paramInt1 = paramInt2;
          if (this.xyR == null) {
            break label849;
          }
          this.xyR.JI(paramInt2);
          paramInt1 = paramInt2;
          break label849;
          label610:
          paramArrayList = paramArrayList.iterator();
          paramInt2 = paramInt1;
          if (!paramArrayList.hasNext()) {
            break label878;
          }
          localObject1 = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.next();
          f((com.tencent.mm.plugin.editor.model.a.a)localObject1);
          if (!b(paramInt2, (com.tencent.mm.plugin.editor.model.a.a)localObject1)) {
            break label835;
          }
          paramInt2 += 1;
          break label875;
        }
        if ((j - 1 >= 0) && (j - 1 < dwm().size()))
        {
          paramInt1 = j - 1;
          if (this.xyR != null)
          {
            paramInt3 = j - i;
            paramInt2 = paramInt3;
            if (paramInt4 != 0) {
              paramInt2 = paramInt3 + 1;
            }
            if ((i >= 0) && (paramInt2 > 0)) {
              this.xyR.gH(i, paramInt2);
            }
            if (i <= 0) {
              break label807;
            }
            this.xyR.gI(i - 1, dwm().size() - (i - 1));
            this.xyR.JJ(paramInt1);
          }
          dww();
          AppMethodBeat.o(181751);
          return paramInt1;
        }
      }
      finally
      {
        AppMethodBeat.o(181751);
      }
      paramInt1 = dwm().size() - 1;
      continue;
      label807:
      if (i == 0)
      {
        this.xyR.gI(i, dwm().size() - i);
        continue;
        label835:
        break label875;
        label843:
        label846:
        label849:
        label863:
        do
        {
          paramInt1 = paramInt2;
          break label610;
          break label467;
          break;
          paramInt4 = 0;
          paramInt2 = paramInt1;
          paramInt3 = paramInt1;
          paramInt1 = paramInt4;
          break label462;
        } while (paramInt1 == 1);
        paramInt1 = paramInt2 + 1;
        continue;
        label875:
        continue;
        label878:
        paramInt4 = 0;
        j = paramInt2;
        i = paramInt1;
      }
    }
  }
  
  public final int a(ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList, WXRTEditText paramWXRTEditText, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(181750);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (this.mDataList == null))
    {
      Log.e("MicroMsg.EditorDataManager", "insertItemList,error,return");
      AppMethodBeat.o(181750);
      return -1;
    }
    if ((paramBoolean2) && (Y(paramArrayList)) && (this.xyR != null))
    {
      this.xyR.dvv();
      AppMethodBeat.o(181750);
      return -1;
    }
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.get(paramArrayList.size() - 1);
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).xyd = -1;
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).xyb = true;
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).xyh = false;
      if ((paramWXRTEditText != null) && (paramWXRTEditText.xzU))
      {
        if (paramWXRTEditText.getEditTextType() != 2) {
          break label261;
        }
        ((com.tencent.mm.plugin.editor.model.a.a)localObject1).xyk = 2;
      }
    }
    label169:
    int n;
    int i;
    label258:
    label261:
    int i1;
    label390:
    label418:
    int k;
    int m;
    for (;;)
    {
      paramWXRTEditText.xzU = false;
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).xyl = paramWXRTEditText.xyl;
      paramWXRTEditText.xyl = 0;
      if ((paramWXRTEditText == null) || (paramWXRTEditText.getRecyclerItemPosition() != 0)) {
        if (paramWXRTEditText != null) {
          break label621;
        }
      }
      try
      {
        n = size();
        dwq();
        paramArrayList = paramArrayList.iterator();
        i = n;
        for (;;)
        {
          if (paramArrayList.hasNext())
          {
            paramWXRTEditText = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.next();
            f(paramWXRTEditText);
            if ((paramWXRTEditText == null) || (this.mDataList == null)) {
              break label1249;
            }
            this.mDataList.add(paramWXRTEditText);
            a(paramWXRTEditText, true);
            j = 1;
            if (j == 0) {
              break label1255;
            }
            i += 1;
            continue;
            if (paramWXRTEditText.getEditTextType() != 1) {
              break;
            }
            ((com.tencent.mm.plugin.editor.model.a.a)localObject1).xyk = 1;
            break;
            if ((paramWXRTEditText.getEditTextType() == 2) || (paramWXRTEditText.getSelectionStart() != 0) || (paramArrayList == null) || (paramArrayList.size() <= 0)) {
              break label169;
            }
            i = ((com.tencent.mm.plugin.editor.model.a.a)paramArrayList.get(0)).getType();
            if ((i != 2) && (i != 6) && (i != 5) && (i != 3) && (i != 4)) {
              break label169;
            }
            localObject1 = new j();
            ((j)localObject1).content = "";
            ((j)localObject1).xyb = false;
            ((j)localObject1).xyh = false;
            paramArrayList.add(0, localObject1);
            break label169;
          }
        }
        i1 = 0;
        if ((i - 1 < 0) || (i - 1 >= dwm().size())) {
          break;
        }
        j = i - 1;
        k = j;
        m = i;
        if (paramBoolean4)
        {
          j += 1;
          i += 1;
          dwq();
          if (j >= dwm().size()) {
            break label1144;
          }
          paramArrayList = dwm().JL(j);
          k = j;
          m = i;
          if (paramArrayList != null)
          {
            paramArrayList.xyd = 0;
            paramArrayList.xyb = true;
            paramArrayList.xyh = false;
            m = i;
            k = j;
          }
        }
        label502:
        if (this.xyR != null)
        {
          j = m - n;
          i = j;
          if (i1 != 0) {
            i = j + 1;
          }
          if ((n >= 0) && (i > 0)) {
            this.xyR.gH(n, i);
          }
          if (n <= 0) {
            break label1198;
          }
          this.xyR.gI(n - 1, dwm().size() - (n - 1));
          if (paramBoolean3) {
            this.xyR.dvu();
          }
          this.xyR.JJ(k);
        }
        label583:
        dww();
        AppMethodBeat.o(181750);
        return k;
      }
      finally
      {
        label621:
        Object localObject2;
        Object localObject3;
        AppMethodBeat.o(181750);
      }
    }
    int j = paramWXRTEditText.getRecyclerItemPosition();
    localObject2 = JL(j);
    if (localObject2 == null)
    {
      AppMethodBeat.o(181750);
      return -1;
    }
    dwq();
    if ((paramWXRTEditText.getEditTextType() == 0) && (((com.tencent.mm.plugin.editor.model.a.a)localObject2).getType() == 1))
    {
      localObject1 = paramWXRTEditText.getSelection();
      localObject3 = paramWXRTEditText.getText();
      paramWXRTEditText = ((Editable)localObject3).subSequence(0, ((g)localObject1).uG);
      localObject3 = ((Editable)localObject3).subSequence(((g)localObject1).uH, ((Editable)localObject3).length());
      localObject1 = com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)paramWXRTEditText);
      paramWXRTEditText = com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)localObject3);
      localObject2 = (j)localObject2;
      if (!Util.isNullOrNil((String)localObject1))
      {
        if (!((String)localObject1).endsWith("<br/>")) {
          break label1265;
        }
        localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 5);
        label776:
        ((j)localObject2).content = ((String)localObject1);
        j += 1;
        i = j;
        if (Util.isNullOrNil(paramWXRTEditText)) {
          break label1268;
        }
        localObject2 = new j();
        ((j)localObject2).type = 1;
        localObject1 = paramWXRTEditText;
        if (paramWXRTEditText.startsWith("<br/>")) {
          localObject1 = paramWXRTEditText.substring(5, paramWXRTEditText.length());
        }
        ((j)localObject2).content = ((String)localObject1);
        ((j)localObject2).xyd = 0;
        ((j)localObject2).xyb = false;
        ((j)localObject2).xyh = false;
        b(j, (com.tencent.mm.plugin.editor.model.a.a)localObject2);
        i = j;
        k = 1;
        m = j;
        j = i;
        i = m;
      }
    }
    for (;;)
    {
      label892:
      paramArrayList = paramArrayList.iterator();
      for (m = i;; m = i)
      {
        i = m;
        n = j;
        i1 = k;
        if (!paramArrayList.hasNext()) {
          break label390;
        }
        paramWXRTEditText = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.next();
        f(paramWXRTEditText);
        if (b(m, paramWXRTEditText))
        {
          i = m + 1;
          continue;
          if (!Util.isNullOrNil(paramWXRTEditText))
          {
            localObject1 = paramWXRTEditText;
            if (paramWXRTEditText.startsWith("<br/>")) {
              localObject1 = paramWXRTEditText.substring(5, paramWXRTEditText.length());
            }
            ((j)localObject2).content = ((String)localObject1);
            k = j;
            m = 0;
            i = j;
            j = k;
            k = m;
            break label892;
          }
          JM(j);
          i = j;
          if (this.xyR == null) {
            break label1268;
          }
          this.xyR.JI(j);
          i = j;
          break label1268;
          if (paramWXRTEditText.getEditTextType() != 1) {
            j += 1;
          }
          for (;;)
          {
            paramArrayList = paramArrayList.iterator();
            i = j;
            label1075:
            if (paramArrayList.hasNext())
            {
              paramWXRTEditText = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.next();
              f(paramWXRTEditText);
              paramBoolean1 = b(i, paramWXRTEditText);
              if (!paramBoolean1) {
                break label1236;
              }
              i += 1;
            }
            label1198:
            label1236:
            for (;;)
            {
              break label1075;
              j = dwm().size() - 1;
              break label418;
              label1144:
              paramArrayList = new j();
              paramArrayList.type = 1;
              paramArrayList.content = "";
              paramArrayList.xyd = 0;
              paramArrayList.xyb = true;
              paramArrayList.xyh = false;
              b(j, paramArrayList);
              k = j;
              m = i;
              break label502;
              if (n != 0) {
                break label583;
              }
              this.xyR.gI(n, dwm().size() - n);
              break label583;
              i1 = 0;
              n = j;
              break;
            }
          }
        }
        i = m;
        continue;
        label1249:
        j = 0;
        break;
        label1255:
        break label258;
      }
      label1265:
      break label776;
      label1268:
      j = i;
      k = 0;
    }
  }
  
  public final boolean a(int paramInt, com.tencent.mm.plugin.editor.model.a.a parama)
  {
    boolean bool = true;
    AppMethodBeat.i(181732);
    for (;;)
    {
      try
      {
        if ((this.mDataList == null) || (paramInt < 0) || (paramInt > this.mDataList.size())) {
          break label138;
        }
        this.mDataList.add(paramInt, parama);
        a(parama, true);
        if ((bool) && (this.xyR != null))
        {
          this.xyR.JH(paramInt);
          if (paramInt > 0) {
            this.xyR.gI(paramInt - 1, this.mDataList.size() - (paramInt - 1));
          }
        }
        else
        {
          AppMethodBeat.o(181732);
          return bool;
        }
      }
      finally
      {
        AppMethodBeat.o(181732);
      }
      this.xyR.gI(paramInt, this.mDataList.size() - paramInt);
      continue;
      label138:
      bool = false;
    }
  }
  
  public final arv anD(String paramString)
  {
    AppMethodBeat.i(181748);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.EditorDataManager", "getFavProtoItem error, htmlstr is null or nil");
      AppMethodBeat.o(181748);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        if (i >= this.mDataList.size()) {
          break label794;
        }
        localObject1 = (com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i);
        if (Util.isNullOrNil(((com.tencent.mm.plugin.editor.model.a.a)localObject1).hIQ)) {
          ((com.tencent.mm.plugin.editor.model.a.a)localObject1).hIQ = com.tencent.mm.plugin.editor.model.b.anz(localObject1.toString());
        }
        if (((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType() == -1) {
          if ((localArrayList.size() > 0) && (((d)localArrayList.get(localArrayList.size() - 1)).type == 1))
          {
            localObject1 = new StringBuilder();
            localObject2 = (j)localArrayList.get(localArrayList.size() - 1);
            ((j)localObject2).content += "\n";
          }
          else
          {
            localObject2 = new j();
            ((j)localObject2).content = "\n";
            ((j)localObject2).hIQ = ((com.tencent.mm.plugin.editor.model.a.a)localObject1).hIQ;
            ((j)localObject2).xyo = "-1";
            ((j)localObject2).type = 1;
            ((j)localObject2).xyn = null;
            localArrayList.add(localObject2);
          }
        }
      }
      finally
      {
        AppMethodBeat.o(181748);
      }
      if (((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType() >= -1)
      {
        if (((((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType() == 6) || (((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType() == 4)) && (Util.isNullOrNil(((d)localObject1).hTM)))
        {
          localObject2 = new arf();
          ((arf)localObject2).bsB(((com.tencent.mm.plugin.editor.model.a.a)localObject1).hIQ);
          ((arf)localObject2).bsy(((com.tencent.mm.plugin.editor.model.a.a)localObject1).dwe());
          localObject2 = com.tencent.mm.plugin.editor.model.b.b((arf)localObject2);
          if (y.ZC((String)localObject2))
          {
            Log.e("MicroMsg.EditorDataManager", "getFavProtoItem, type = %d, localfile exist, but localpath is null or nil, set path here", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType()) });
            ((d)localObject1).hTM = ((String)localObject2);
          }
        }
        if (((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType() != 1)
        {
          localArrayList.add((d)localObject1);
        }
        else
        {
          localObject1 = (j)localObject1;
          if (Util.isNullOrNil(((j)localObject1).content))
          {
            if ((localArrayList.size() > 0) && (((d)localArrayList.get(localArrayList.size() - 1)).getType() == 1))
            {
              localObject1 = new StringBuilder();
              localObject2 = (j)localArrayList.get(localArrayList.size() - 1);
              ((j)localObject2).content += "<br/>";
            }
            else
            {
              localObject2 = new j();
              ((j)localObject2).content = "<br/>";
              ((j)localObject2).hIQ = ((j)localObject1).hIQ;
              ((j)localObject2).xyo = ((j)localObject1).xyo;
              ((j)localObject2).type = ((j)localObject1).type;
              ((j)localObject2).xyn = null;
              localArrayList.add(localObject2);
            }
          }
          else
          {
            Object localObject3;
            if ((localArrayList.size() > 0) && (((d)localArrayList.get(localArrayList.size() - 1)).getType() == 1))
            {
              localObject2 = new StringBuilder();
              localObject3 = (j)localArrayList.get(localArrayList.size() - 1);
              ((j)localObject3).content += ((j)localObject1).content;
            }
            while ((i + 1 < this.mDataList.size()) && (((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i + 1)).getType() == 1) && (!Util.isNullOrNil(((j)this.mDataList.get(i + 1)).content)))
            {
              localObject1 = new StringBuilder();
              localObject2 = (j)localArrayList.get(localArrayList.size() - 1);
              ((j)localObject2).content += "<br/>";
              break;
              localObject2 = new j();
              ((j)localObject2).content = ((j)localObject1).content;
              ((j)localObject2).hIQ = ((j)localObject1).hIQ;
              ((j)localObject2).xyo = ((j)localObject1).xyo;
              ((j)localObject2).type = ((j)localObject1).type;
              ((j)localObject2).xyn = null;
              localArrayList.add(localObject2);
              continue;
              label794:
              paramString = Pattern.compile("<wx-", 2).matcher(paramString).replaceAll("<");
              localObject1 = Pattern.compile("</wx-", 2).matcher(paramString).replaceAll("</");
              try
              {
                paramString = ((String)localObject1).getBytes("UTF-8");
                i = 0;
              }
              catch (UnsupportedEncodingException paramString)
              {
                for (;;)
                {
                  try
                  {
                    ((u)localObject3).jKZ();
                    if ((i != 0) || (y.f((String)localObject2, paramString, paramString.length) != 0)) {
                      break;
                    }
                    this.xyS.bsC((String)localObject2);
                    Log.i("MicroMsg.EditorDataManager", "do EditorBase.ConvertNote2FavProtoItem");
                    paramString = com.tencent.mm.plugin.editor.model.a.a((String)localObject1, localArrayList, this.xyS);
                    AppMethodBeat.o(181748);
                    return paramString;
                  }
                  catch (IOException paramString)
                  {
                    Log.printErrStackTrace("MicroMsg.EditorDataManager", paramString, "", new Object[0]);
                    AppMethodBeat.o(181748);
                    return null;
                  }
                  paramString = paramString;
                  Log.printErrStackTrace("MicroMsg.EditorDataManager", paramString, "", new Object[0]);
                  Log.e("MicroMsg.EditorDataManager", "writehtmlfile, use utf-8 encoding error, use default encoding");
                  i = 1;
                  paramString = null;
                }
              }
              this.xyS.axy(8);
              this.xyS.bsL("WeNoteHtmlFile");
              this.xyS.Kk(true);
              this.xyS.bsy(".htm");
              this.xyS.bsB(com.tencent.mm.plugin.editor.model.b.anz(this.xyS.toString()));
              localObject2 = com.tencent.mm.plugin.editor.model.b.b(this.xyS);
              Log.i("MicroMsg.EditorDataManager", "getFavProtoItem: save note html file, path is %s", new Object[] { localObject2 });
              localObject3 = new u((String)localObject2);
              if (((u)localObject3).jKS()) {
                ((u)localObject3).diJ();
              }
              if (!((u)localObject3).jKS()) {}
              Log.i("MicroMsg.EditorDataManager", "writefile error, return");
              Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(d.h.favorite_save_fail), 1).show();
              AppMethodBeat.o(181748);
              return null;
            }
          }
        }
      }
      i += 1;
    }
  }
  
  public final boolean av(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(181734);
    boolean bool1 = bool2;
    for (;;)
    {
      try
      {
        if (this.mDataList != null)
        {
          bool1 = bool2;
          if (paramInt >= 0)
          {
            bool1 = bool2;
            if (paramInt < this.mDataList.size())
            {
              a((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(paramInt), false);
              this.mDataList.remove(paramInt);
              bool1 = true;
            }
          }
        }
        if ((bool1) && (paramBoolean) && (this.xyR != null))
        {
          this.xyR.JI(paramInt);
          if (paramInt > 0) {
            this.xyR.gI(paramInt - 1, this.mDataList.size() - (paramInt - 1));
          }
        }
        else
        {
          AppMethodBeat.o(181734);
          return bool1;
        }
      }
      finally
      {
        AppMethodBeat.o(181734);
      }
      this.xyR.gI(paramInt, this.mDataList.size() - paramInt);
    }
  }
  
  /* Error */
  public final void aw(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 551
    //   3: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 29	com/tencent/mm/plugin/editor/model/nativenote/manager/c:mDataList	Ljava/util/ArrayList;
    //   12: ifnonnull +12 -> 24
    //   15: aload_0
    //   16: monitorexit
    //   17: ldc_w 551
    //   20: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: return
    //   24: iload_1
    //   25: iflt +69 -> 94
    //   28: iload_1
    //   29: aload_0
    //   30: getfield 29	com/tencent/mm/plugin/editor/model/nativenote/manager/c:mDataList	Ljava/util/ArrayList;
    //   33: invokevirtual 54	java/util/ArrayList:size	()I
    //   36: if_icmpge +58 -> 94
    //   39: aload_0
    //   40: getfield 29	com/tencent/mm/plugin/editor/model/nativenote/manager/c:mDataList	Ljava/util/ArrayList;
    //   43: iload_1
    //   44: invokevirtual 58	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   47: checkcast 60	com/tencent/mm/plugin/editor/model/a/a
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +33 -> 85
    //   55: aload_3
    //   56: getfield 554	com/tencent/mm/plugin/editor/model/a/a:xyi	Z
    //   59: iload_2
    //   60: if_icmpeq +25 -> 85
    //   63: aload_3
    //   64: iload_2
    //   65: putfield 554	com/tencent/mm/plugin/editor/model/a/a:xyi	Z
    //   68: aload_0
    //   69: getfield 31	com/tencent/mm/plugin/editor/model/nativenote/manager/c:xyR	Lcom/tencent/mm/plugin/editor/model/nativenote/b/a;
    //   72: ifnull +13 -> 85
    //   75: aload_0
    //   76: getfield 31	com/tencent/mm/plugin/editor/model/nativenote/manager/c:xyR	Lcom/tencent/mm/plugin/editor/model/nativenote/b/a;
    //   79: iload_1
    //   80: invokeinterface 204 2 0
    //   85: aload_0
    //   86: monitorexit
    //   87: ldc_w 551
    //   90: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: return
    //   94: iload_1
    //   95: iconst_m1
    //   96: if_icmpne -11 -> 85
    //   99: iconst_0
    //   100: istore_1
    //   101: iload_1
    //   102: aload_0
    //   103: getfield 29	com/tencent/mm/plugin/editor/model/nativenote/manager/c:mDataList	Ljava/util/ArrayList;
    //   106: invokevirtual 54	java/util/ArrayList:size	()I
    //   109: if_icmpge -24 -> 85
    //   112: aload_0
    //   113: getfield 29	com/tencent/mm/plugin/editor/model/nativenote/manager/c:mDataList	Ljava/util/ArrayList;
    //   116: iload_1
    //   117: invokevirtual 58	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   120: checkcast 60	com/tencent/mm/plugin/editor/model/a/a
    //   123: astore_3
    //   124: aload_3
    //   125: ifnull +33 -> 158
    //   128: aload_3
    //   129: getfield 554	com/tencent/mm/plugin/editor/model/a/a:xyi	Z
    //   132: iload_2
    //   133: if_icmpeq +25 -> 158
    //   136: aload_3
    //   137: iload_2
    //   138: putfield 554	com/tencent/mm/plugin/editor/model/a/a:xyi	Z
    //   141: aload_0
    //   142: getfield 31	com/tencent/mm/plugin/editor/model/nativenote/manager/c:xyR	Lcom/tencent/mm/plugin/editor/model/nativenote/b/a;
    //   145: ifnull +13 -> 158
    //   148: aload_0
    //   149: getfield 31	com/tencent/mm/plugin/editor/model/nativenote/manager/c:xyR	Lcom/tencent/mm/plugin/editor/model/nativenote/b/a;
    //   152: iload_1
    //   153: invokeinterface 204 2 0
    //   158: iload_1
    //   159: iconst_1
    //   160: iadd
    //   161: istore_1
    //   162: goto -61 -> 101
    //   165: astore_3
    //   166: aload_0
    //   167: monitorexit
    //   168: ldc_w 551
    //   171: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_3
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	c
    //   0	176	1	paramInt	int
    //   0	176	2	paramBoolean	boolean
    //   50	87	3	locala	com.tencent.mm.plugin.editor.model.a.a
    //   165	10	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	17	165	finally
    //   28	51	165	finally
    //   55	85	165	finally
    //   85	87	165	finally
    //   101	124	165	finally
    //   128	158	165	finally
  }
  
  public final void ax(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(181742);
    for (;;)
    {
      int i;
      try
      {
        if ((this.mDataList == null) || (paramInt < 0) || (paramInt >= this.mDataList.size())) {
          return;
        }
        i = 0;
        if (i < this.mDataList.size()) {
          if (i == paramInt)
          {
            ((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i)).xyb = true;
            ((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i)).xyh = paramBoolean;
          }
          else
          {
            ((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i)).xyb = false;
            ((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i)).xyh = false;
          }
        }
      }
      finally
      {
        AppMethodBeat.o(181742);
      }
      AppMethodBeat.o(181742);
      return;
      i += 1;
    }
  }
  
  public final boolean b(int paramInt, ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList)
  {
    AppMethodBeat.i(181731);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      AppMethodBeat.o(181731);
      return false;
    }
    for (;;)
    {
      int k;
      int m;
      try
      {
        if (this.mDataList == null) {
          break label174;
        }
        k = 0;
        j = 0;
        i = paramInt;
        paramInt = j;
        if ((k >= paramArrayList.size()) || (i < 0) || (i > this.mDataList.size())) {
          break label203;
        }
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.get(k);
        j = paramInt;
        m = i;
        if (locala == null) {
          break label188;
        }
        f(locala);
        this.mDataList.add(i, locala);
        j = paramInt + 1;
        m = i + 1;
        a(locala, true);
      }
      finally
      {
        AppMethodBeat.o(181731);
      }
      if ((bool) && (this.xyR != null)) {
        this.xyR.gH(i - paramInt, paramInt);
      }
      AppMethodBeat.o(181731);
      return bool;
      label174:
      boolean bool = false;
      int j = 0;
      int i = paramInt;
      paramInt = j;
      continue;
      label188:
      k += 1;
      paramInt = j;
      i = m;
      continue;
      label203:
      bool = true;
    }
  }
  
  public final void dwn()
  {
    AppMethodBeat.i(181737);
    if (this.mDataList != null) {}
    for (int i = this.mDataList.size();; i = 0)
    {
      Log.i("MicroMsg.EditorDataManager", "clear mDataList, size:%d", new Object[] { Integer.valueOf(i) });
      try
      {
        if (this.mDataList != null) {
          this.mDataList.clear();
        }
        this.xyV = 0;
        this.xyU = 0;
        AppMethodBeat.o(181737);
        return;
      }
      finally
      {
        AppMethodBeat.o(181737);
      }
    }
  }
  
  public final int dwo()
  {
    AppMethodBeat.i(181739);
    for (;;)
    {
      try
      {
        if (this.mDataList != null)
        {
          i = 0;
          if (i < this.mDataList.size())
          {
            if (((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i)).xyb) {
              return i;
            }
            i += 1;
            continue;
          }
        }
        int i = -1;
      }
      finally
      {
        AppMethodBeat.o(181739);
      }
    }
  }
  
  public final void dwp()
  {
    AppMethodBeat.i(181740);
    try
    {
      if (this.mDataList != null)
      {
        Iterator localIterator = this.mDataList.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)localIterator.next();
          locala.xyb = false;
          locala.xyh = false;
        }
      }
    }
    finally
    {
      AppMethodBeat.o(181740);
    }
    AppMethodBeat.o(181740);
  }
  
  public final int dwr()
  {
    AppMethodBeat.i(181743);
    for (;;)
    {
      try
      {
        if (this.mDataList != null)
        {
          i = 0;
          if (i < this.mDataList.size())
          {
            if ((((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i)).getType() == 4) && (((m)this.mDataList.get(i)).xyz.booleanValue())) {
              return i;
            }
            i += 1;
            continue;
          }
        }
        int i = -1;
      }
      finally
      {
        AppMethodBeat.o(181743);
      }
    }
  }
  
  public final String dws()
  {
    AppMethodBeat.i(181744);
    for (;;)
    {
      try
      {
        if ((this.xyT != 0) || (this.mDataList == null)) {
          break;
        }
        Iterator localIterator = this.mDataList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        d locald = (d)localIterator.next();
        if (locald.xyo.startsWith("WeNote_"))
        {
          i = Util.getInt(locald.xyo.substring(7), -1);
          if (i > this.xyT) {
            this.xyT = i;
          } else {
            i = this.xyT;
          }
        }
      }
      finally
      {
        AppMethodBeat.o(181744);
      }
    }
    Object localObject2 = new StringBuilder("WeNote_");
    int i = this.xyT + 1;
    this.xyT = i;
    localObject2 = i;
    AppMethodBeat.o(181744);
    return localObject2;
  }
  
  public final String dwu()
  {
    AppMethodBeat.i(181746);
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i;
      Object localObject3;
      try
      {
        if ((this.mDataList == null) || (this.mDataList.size() <= 0)) {
          return "";
        }
        i = 0;
        if (i >= this.mDataList.size()) {
          break label301;
        }
        localObject3 = (com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i);
        switch (((com.tencent.mm.plugin.editor.model.a.a)localObject3).getType())
        {
        case 1: 
          localObject3 = (j)localObject3;
          if (Util.isNullOrNil(((j)localObject3).content)) {
            localStringBuilder.append("<br/>");
          }
          break;
        }
      }
      finally
      {
        AppMethodBeat.o(181746);
      }
      localObject1.append(((j)localObject3).content);
      if ((i + 1 < this.mDataList.size()) && (((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i + 1)).getType() == 1) && (!Util.isNullOrNil(((j)this.mDataList.get(i + 1)).content)))
      {
        localObject1.append("<br/>");
        break label337;
        localObject1.append(dT(((com.tencent.mm.plugin.editor.model.a.h)localObject3).xyo, 2));
        break label337;
        localObject1.append(dT(((l)localObject3).xyo, 6));
        break label337;
        localObject1.append(dT(((m)localObject3).xyo, 4));
        break label337;
        localObject1.append("<hr/>");
        break label337;
        label301:
        Object localObject2 = new StringBuilder(localObject1.toString().replaceAll("\n", "<br/>"));
        localObject2 = ((StringBuilder)localObject2).toString();
        AppMethodBeat.o(181746);
        return localObject2;
      }
      label337:
      i += 1;
    }
  }
  
  public final ArrayList<com.tencent.mm.plugin.editor.model.a.a> dwv()
  {
    AppMethodBeat.i(181753);
    if (this.mDataList == null)
    {
      AppMethodBeat.o(181753);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = this.mDataList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(com.tencent.mm.plugin.editor.b.a((com.tencent.mm.plugin.editor.model.a.a)localIterator.next()));
      }
    }
    finally
    {
      AppMethodBeat.o(181753);
    }
    AppMethodBeat.o(181753);
    return localArrayList1;
  }
  
  public final void dww()
  {
    AppMethodBeat.i(181756);
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181726);
        int i;
        synchronized (c.this)
        {
          if (c.a(c.this) == null)
          {
            AppMethodBeat.o(181726);
            return;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          Iterator localIterator = c.a(c.this).iterator();
          i = 0;
          while (localIterator.hasNext())
          {
            com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)localIterator.next();
            if (locala.getType() != 1) {
              i += 1;
            } else {
              localStringBuilder.append(((j)locala).content);
            }
          }
        }
        c.a(c.this, com.tencent.mm.plugin.editor.b.anr(localObject.toString()));
        c.b(c.this, i);
        AppMethodBeat.o(181726);
      }
    });
    AppMethodBeat.o(181756);
  }
  
  public final int dwx()
  {
    AppMethodBeat.i(181759);
    try
    {
      if (this.mDataList == null) {
        return -1;
      }
      int i = 0;
      while (i < this.mDataList.size())
      {
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i);
        if ((locala != null) && (locala.getType() != -3) && (locala.getType() != -2)) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    finally
    {
      AppMethodBeat.o(181759);
    }
  }
  
  public final int dwy()
  {
    AppMethodBeat.i(181760);
    try
    {
      if (this.mDataList == null) {
        return -1;
      }
      int i = this.mDataList.size() - 1;
      while (i >= 0)
      {
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i);
        if ((locala != null) && (locala.getType() != -3) && (locala.getType() != -2)) {
          return i;
        }
        i -= 1;
      }
      return -1;
    }
    finally
    {
      AppMethodBeat.o(181760);
    }
  }
  
  public final boolean e(com.tencent.mm.plugin.editor.model.a.a parama)
  {
    boolean bool = true;
    AppMethodBeat.i(181730);
    if (parama != null) {}
    for (;;)
    {
      try
      {
        if (this.mDataList != null)
        {
          this.mDataList.add(parama);
          a(parama, true);
          return bool;
        }
      }
      finally
      {
        AppMethodBeat.o(181730);
      }
      bool = false;
    }
  }
  
  public final boolean gK(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {}
    for (int i = 0;; i = 1)
    {
      if (paramInt2 < 0) {}
      for (int j = 0;; j = 1)
      {
        if ((i != 0) && (this.xyU + paramInt1 > 16384)) {}
        while ((j != 0) && (this.xyV + paramInt2 > 30)) {
          return true;
        }
        return false;
      }
    }
  }
  
  public final void gL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181758);
    Log.i("MicroMsg.EditorDataManager", "checkMergeTextDataItem startPos: %d endPos: %d needNotify: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.TRUE });
    for (;;)
    {
      Object localObject3;
      int i;
      Spanned localSpanned2;
      try
      {
        if (this.mDataList == null) {
          return;
        }
        int j = paramInt1;
        if (paramInt1 <= 0) {
          j = 0;
        }
        if (paramInt2 < this.mDataList.size()) {
          break label487;
        }
        paramInt2 = this.mDataList.size() - 1;
        paramInt1 = -1;
        if (paramInt2 <= j) {
          break label443;
        }
        Object localObject1 = (com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(paramInt2);
        localObject3 = (com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(paramInt2 - 1);
        i = paramInt1;
        if (localObject1 == null) {
          break label492;
        }
        i = paramInt1;
        if (((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType() != 1) {
          break label492;
        }
        i = paramInt1;
        if (localObject3 == null) {
          break label492;
        }
        i = paramInt1;
        if (((com.tencent.mm.plugin.editor.model.a.a)localObject3).getType() != 1) {
          break label492;
        }
        paramInt1 = paramInt2 - 1;
        localObject1 = (j)localObject1;
        localObject3 = (j)localObject3;
        if (Util.isNullOrNil(((j)localObject1).content)) {
          break label414;
        }
        Spanned localSpanned1 = com.tencent.mm.plugin.editor.model.nativenote.a.a.anA(((j)localObject1).content);
        localSpanned2 = com.tencent.mm.plugin.editor.model.nativenote.a.a.anA(((j)localObject3).content);
        ((j)localObject3).content = (((j)localObject3).content + "<br/>" + ((j)localObject1).content);
        if (((j)localObject1).xyb)
        {
          ((j)localObject3).xyb = true;
          ((j)localObject3).xyh = false;
          if ((((j)localObject1).xyd == -1) || (((j)localObject1).xyd >= localSpanned1.length()))
          {
            ((j)localObject3).xyd = -1;
            Log.i("MicroMsg.EditorDataManager", "checkMergeTextDataItem remove position: %d", new Object[] { Integer.valueOf(paramInt2) });
            JM(paramInt2);
            i = paramInt1;
            if (this.xyR == null) {
              break label492;
            }
            this.xyR.JI(paramInt2);
            i = paramInt1;
            break label492;
          }
          i = localSpanned2.length();
          ((j)localObject1).xyd += i + 1;
          continue;
        }
        if (!((j)localObject3).xyb) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(181758);
      }
      if (((j)localObject3).xyd == -1)
      {
        ((j)localObject3).xyd = localSpanned2.length();
        continue;
        label414:
        if (localObject2.xyb)
        {
          ((j)localObject3).xyb = true;
          ((j)localObject3).xyh = false;
          ((j)localObject3).xyd = -1;
          continue;
          label443:
          if ((paramInt1 != -1) && (this.xyR != null)) {
            this.xyR.gI(paramInt1, this.mDataList.size() - paramInt1);
          }
          dww();
          AppMethodBeat.o(181758);
          return;
          label487:
          paramInt1 = -1;
          continue;
          label492:
          paramInt2 -= 1;
          paramInt1 = i;
        }
      }
    }
  }
  
  public final int size()
  {
    AppMethodBeat.i(181728);
    if (this.mDataList != null)
    {
      int i = this.mDataList.size();
      AppMethodBeat.o(181728);
      return i;
    }
    AppMethodBeat.o(181728);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.c
 * JD-Core Version:    0.7.0.1
 */