package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.content.Context;
import android.text.Editable;
import android.text.Spanned;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.a.d;
import com.tencent.mm.plugin.editor.model.a.h;
import com.tencent.mm.plugin.editor.model.a.j;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.editor.model.a.m;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c
{
  private static volatile c pAX = null;
  public ArrayList<com.tencent.mm.plugin.editor.model.a.a> mDataList = null;
  public com.tencent.mm.plugin.editor.model.nativenote.b.a pAY = null;
  public ajx pAZ = null;
  public int pBa = 0;
  public int pBb = 0;
  public int pBc = 0;
  
  private boolean BN(int paramInt)
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
      int i = com.tencent.mm.plugin.editor.b.abD(((j)parama).content);
      if (paramBoolean)
      {
        this.pBb = (i + this.pBb);
        AppMethodBeat.o(181757);
        return;
      }
      this.pBb -= i;
      AppMethodBeat.o(181757);
      return;
    }
    if (paramBoolean)
    {
      this.pBc += 1;
      AppMethodBeat.o(181757);
      return;
    }
    this.pBc -= 1;
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
  
  private static String cT(String paramString, int paramInt)
  {
    AppMethodBeat.i(181747);
    paramString = String.format("<div><object data-type=\"%d\" id=\"%s\" name=\"%s\" class=\"item item-\"></object></div>", new Object[] { Integer.valueOf(paramInt), paramString, paramString });
    AppMethodBeat.o(181747);
    return paramString;
  }
  
  private void cfC()
  {
    AppMethodBeat.i(181741);
    if (this.mDataList != null)
    {
      Iterator localIterator = this.mDataList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)localIterator.next();
        locala.pAj = false;
        locala.pAp = false;
      }
    }
    AppMethodBeat.o(181741);
  }
  
  private String cfF()
  {
    AppMethodBeat.i(181745);
    if ((this.pBa == 0) && (this.mDataList != null))
    {
      localObject = this.mDataList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        d locald = (d)((Iterator)localObject).next();
        if (locald.pAw.startsWith("WeNote_"))
        {
          i = bu.getInt(locald.pAw.substring(7), -1);
          if (i > this.pBa) {}
          for (;;)
          {
            this.pBa = i;
            break;
            i = this.pBa;
          }
        }
      }
    }
    Object localObject = new StringBuilder("WeNote_");
    int i = this.pBa + 1;
    this.pBa = i;
    localObject = i;
    AppMethodBeat.o(181745);
    return localObject;
  }
  
  public static c cfy()
  {
    AppMethodBeat.i(181727);
    if (pAX == null) {}
    try
    {
      if (pAX == null) {
        pAX = new c();
      }
      c localc = pAX;
      AppMethodBeat.o(181727);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(181727);
    }
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
    if ((locald.getType() > 1) && (bu.isNullOrNil(locald.pAw))) {
      locald.pAw = cfF();
    }
    if (bu.isNullOrNil(parama.dua)) {
      parama.dua = com.tencent.mm.plugin.editor.model.b.abL(parama.toString());
    }
    AppMethodBeat.o(181752);
  }
  
  public final com.tencent.mm.plugin.editor.model.a.a BM(int paramInt)
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
  
  public final void BO(int paramInt)
  {
    AppMethodBeat.i(181736);
    if (this.pAY != null) {
      this.pAY.BH(paramInt);
    }
    AppMethodBeat.o(181736);
  }
  
  public final void M(ArrayList<WXRTEditText> paramArrayList)
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
        if (locala.pAo != null)
        {
          paramArrayList.add(locala.pAo);
          continue;
        }
        if (locala.pAm == null) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(181754);
      }
      if (locala.pAn != null)
      {
        paramArrayList.add(locala.pAm);
        paramArrayList.add(locala.pAn);
      }
    }
    AppMethodBeat.o(181754);
  }
  
  public final boolean N(ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList)
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
    boolean bool = fg(com.tencent.mm.plugin.editor.b.abD(localStringBuilder.toString()), i);
    AppMethodBeat.o(181755);
    return bool;
  }
  
  public final boolean Y(int paramInt, boolean paramBoolean)
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
        if ((bool1) && (paramBoolean) && (this.pAY != null))
        {
          this.pAY.BJ(paramInt);
          if (paramInt > 0) {
            this.pAY.fe(paramInt - 1, this.mDataList.size() - (paramInt - 1));
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
      this.pAY.fe(paramInt, this.mDataList.size() - paramInt);
    }
  }
  
  public final void Z(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(181738);
    for (;;)
    {
      try
      {
        if (this.mDataList == null) {
          return;
        }
        if ((paramInt >= 0) && (paramInt < this.mDataList.size()))
        {
          locala = (com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(paramInt);
          if ((locala != null) && (locala.pAq != paramBoolean))
          {
            locala.pAq = paramBoolean;
            if (this.pAY != null) {
              this.pAY.BH(paramInt);
            }
          }
          return;
        }
        if (paramInt != -1) {
          continue;
        }
        paramInt = 0;
        if (paramInt >= this.mDataList.size()) {
          continue;
        }
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(paramInt);
        if ((locala != null) && (locala.pAq != paramBoolean))
        {
          locala.pAq = paramBoolean;
          if (this.pAY != null) {
            this.pAY.BH(paramInt);
          }
        }
      }
      finally
      {
        AppMethodBeat.o(181738);
      }
      paramInt += 1;
    }
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
      ae.e("MicroMsg.EditorDataManager", "pasteItemList,error,return");
      AppMethodBeat.o(181751);
      return -1;
    }
    Object localObject1 = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.get(paramArrayList.size() - 1);
    if (localObject1 == null)
    {
      ae.e("MicroMsg.EditorDataManager", "pasteItemList, lastInsertItem is null");
      AppMethodBeat.o(181751);
      return -1;
    }
    ((com.tencent.mm.plugin.editor.model.a.a)localObject1).pAl = -1;
    ((com.tencent.mm.plugin.editor.model.a.a)localObject1).pAj = true;
    ((com.tencent.mm.plugin.editor.model.a.a)localObject1).pAp = false;
    Object localObject3 = BM(paramInt2);
    if (localObject3 == null)
    {
      ae.e("MicroMsg.EditorDataManager", "pasteItemList, item is null");
      AppMethodBeat.o(181751);
      return -1;
    }
    for (;;)
    {
      label472:
      label477:
      int j;
      int i;
      try
      {
        cfC();
        if ((paramInt1 != 0) || (((com.tencent.mm.plugin.editor.model.a.a)localObject3).getType() != 1)) {
          break label875;
        }
        Object localObject2 = com.tencent.mm.plugin.editor.model.nativenote.a.a.abM(((j)localObject3).content);
        if ((localObject2 == null) || (paramInt3 > ((Spanned)localObject2).length()) || (paramInt4 > ((Spanned)localObject2).length()))
        {
          if (localObject2 == null)
          {
            paramInt1 = -1;
            ae.e("MicroMsg.EditorDataManager", "pasteItemList error, oriText:%d  startOff:%d  endOff:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
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
        if (!bu.isNullOrNil((String)localObject2))
        {
          if (!((String)localObject2).endsWith("<br/>")) {
            break label858;
          }
          localObject2 = ((String)localObject2).substring(0, ((String)localObject2).length() - 5);
          ((j)localObject3).content = ((String)localObject2);
          paramInt2 += 1;
          paramInt1 = paramInt2;
          if (bu.isNullOrNil((String)localObject1)) {
            break label861;
          }
          localObject3 = new j();
          ((j)localObject3).type = 1;
          localObject2 = localObject1;
          if (((String)localObject1).startsWith("<br/>")) {
            localObject2 = ((String)localObject1).substring(5, ((String)localObject1).length());
          }
          ((j)localObject3).content = ((String)localObject2);
          ((j)localObject3).pAl = 0;
          ((j)localObject3).pAj = false;
          ((j)localObject3).pAp = false;
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
              break label855;
            }
            paramInt3 += 1;
            break label855;
          }
        }
        else
        {
          if (!bu.isNullOrNil((String)localObject1))
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
          BN(paramInt2);
          paramInt1 = paramInt2;
          if (this.pAY == null) {
            break label861;
          }
          this.pAY.BJ(paramInt2);
          paramInt1 = paramInt2;
          break label861;
          label620:
          paramArrayList = paramArrayList.iterator();
          paramInt2 = paramInt1;
          if (!paramArrayList.hasNext()) {
            break label890;
          }
          localObject1 = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.next();
          f((com.tencent.mm.plugin.editor.model.a.a)localObject1);
          if (!b(paramInt2, (com.tencent.mm.plugin.editor.model.a.a)localObject1)) {
            break label847;
          }
          paramInt2 += 1;
          break label887;
        }
        if ((j - 1 >= 0) && (j - 1 < cfy().size()))
        {
          paramInt1 = j - 1;
          if (this.pAY != null)
          {
            paramInt3 = j - i;
            paramInt2 = paramInt3;
            if (paramInt4 != 0) {
              paramInt2 = paramInt3 + 1;
            }
            if ((i >= 0) && (paramInt2 > 0)) {
              this.pAY.fd(i, paramInt2);
            }
            if (i <= 0) {
              break label819;
            }
            this.pAY.fe(i - 1, cfy().size() - (i - 1));
            this.pAY.BK(paramInt1);
          }
          cfI();
          AppMethodBeat.o(181751);
          return paramInt1;
        }
      }
      finally
      {
        AppMethodBeat.o(181751);
      }
      paramInt1 = cfy().size() - 1;
      continue;
      label819:
      if (i == 0)
      {
        this.pAY.fe(i, cfy().size() - i);
        continue;
        label847:
        break label887;
        label855:
        label858:
        label861:
        label875:
        do
        {
          paramInt1 = paramInt2;
          break label620;
          break label477;
          break;
          paramInt4 = 0;
          paramInt2 = paramInt1;
          paramInt3 = paramInt1;
          paramInt1 = paramInt4;
          break label472;
        } while (paramInt1 == 1);
        paramInt1 = paramInt2 + 1;
        continue;
        label887:
        continue;
        label890:
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
      ae.e("MicroMsg.EditorDataManager", "insertItemList,error,return");
      AppMethodBeat.o(181750);
      return -1;
    }
    if ((paramBoolean2) && (N(paramArrayList)) && (this.pAY != null))
    {
      this.pAY.ceH();
      AppMethodBeat.o(181750);
      return -1;
    }
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.get(paramArrayList.size() - 1);
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).pAl = -1;
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).pAj = true;
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).pAp = false;
      if ((paramWXRTEditText != null) && (paramWXRTEditText.pBZ))
      {
        if (paramWXRTEditText.getEditTextType() != 2) {
          break label262;
        }
        ((com.tencent.mm.plugin.editor.model.a.a)localObject1).pAs = 2;
      }
    }
    label170:
    int n;
    int i;
    label259:
    label262:
    int i1;
    label391:
    label419:
    int k;
    int m;
    for (;;)
    {
      paramWXRTEditText.pBZ = false;
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).pAt = paramWXRTEditText.pAt;
      paramWXRTEditText.pAt = 0;
      if ((paramWXRTEditText == null) || (paramWXRTEditText.getRecyclerItemPosition() != 0)) {
        if (paramWXRTEditText != null) {
          break label622;
        }
      }
      try
      {
        n = size();
        cfC();
        paramArrayList = paramArrayList.iterator();
        i = n;
        for (;;)
        {
          if (paramArrayList.hasNext())
          {
            paramWXRTEditText = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.next();
            f(paramWXRTEditText);
            if ((paramWXRTEditText == null) || (this.mDataList == null)) {
              break label1248;
            }
            this.mDataList.add(paramWXRTEditText);
            a(paramWXRTEditText, true);
            j = 1;
            if (j == 0) {
              break label1254;
            }
            i += 1;
            continue;
            if (paramWXRTEditText.getEditTextType() != 1) {
              break;
            }
            ((com.tencent.mm.plugin.editor.model.a.a)localObject1).pAs = 1;
            break;
            if ((paramWXRTEditText.getEditTextType() == 2) || (paramWXRTEditText.getSelectionStart() != 0) || (paramArrayList == null) || (paramArrayList.size() <= 0)) {
              break label170;
            }
            i = ((com.tencent.mm.plugin.editor.model.a.a)paramArrayList.get(0)).getType();
            if ((i != 2) && (i != 6) && (i != 5) && (i != 3) && (i != 4)) {
              break label170;
            }
            localObject1 = new j();
            ((j)localObject1).content = "";
            ((j)localObject1).pAj = false;
            ((j)localObject1).pAp = false;
            paramArrayList.add(0, localObject1);
            break label170;
          }
        }
        i1 = 0;
        if ((i - 1 < 0) || (i - 1 >= cfy().size())) {
          break;
        }
        j = i - 1;
        k = j;
        m = i;
        if (paramBoolean4)
        {
          j += 1;
          i += 1;
          cfC();
          if (j >= cfy().size()) {
            break label1143;
          }
          paramArrayList = cfy().BM(j);
          k = j;
          m = i;
          if (paramArrayList != null)
          {
            paramArrayList.pAl = 0;
            paramArrayList.pAj = true;
            paramArrayList.pAp = false;
            m = i;
            k = j;
          }
        }
        label503:
        if (this.pAY != null)
        {
          j = m - n;
          i = j;
          if (i1 != 0) {
            i = j + 1;
          }
          if ((n >= 0) && (i > 0)) {
            this.pAY.fd(n, i);
          }
          if (n <= 0) {
            break label1197;
          }
          this.pAY.fe(n - 1, cfy().size() - (n - 1));
          if (paramBoolean3) {
            this.pAY.ceG();
          }
          this.pAY.BK(k);
        }
        label584:
        cfI();
        AppMethodBeat.o(181750);
        return k;
      }
      finally
      {
        label622:
        Object localObject2;
        Object localObject3;
        AppMethodBeat.o(181750);
      }
    }
    int j = paramWXRTEditText.getRecyclerItemPosition();
    localObject2 = BM(j);
    if (localObject2 == null)
    {
      AppMethodBeat.o(181750);
      return -1;
    }
    cfC();
    if ((paramWXRTEditText.getEditTextType() == 0) && (((com.tencent.mm.plugin.editor.model.a.a)localObject2).getType() == 1))
    {
      localObject1 = paramWXRTEditText.getSelection();
      localObject3 = paramWXRTEditText.getText();
      paramWXRTEditText = ((Editable)localObject3).subSequence(0, ((g)localObject1).avj);
      localObject3 = ((Editable)localObject3).subSequence(((g)localObject1).OQ, ((Editable)localObject3).length());
      localObject1 = com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)paramWXRTEditText);
      paramWXRTEditText = com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)localObject3);
      localObject2 = (j)localObject2;
      if (!bu.isNullOrNil((String)localObject1))
      {
        if (((String)localObject1).endsWith("<br/>"))
        {
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 5);
          label777:
          ((j)localObject2).content = ((String)localObject1);
          j += 1;
          i = j;
          if (bu.isNullOrNil(paramWXRTEditText)) {
            break label1267;
          }
          localObject2 = new j();
          ((j)localObject2).type = 1;
          localObject1 = paramWXRTEditText;
          if (paramWXRTEditText.startsWith("<br/>")) {
            localObject1 = paramWXRTEditText.substring(5, paramWXRTEditText.length());
          }
          ((j)localObject2).content = ((String)localObject1);
          ((j)localObject2).pAl = 0;
          ((j)localObject2).pAj = false;
          ((j)localObject2).pAp = false;
          b(j, (com.tencent.mm.plugin.editor.model.a.a)localObject2);
          i = j;
          k = 1;
          m = j;
          j = i;
          i = m;
        }
      }
      else
      {
        for (;;)
        {
          label893:
          paramArrayList = paramArrayList.iterator();
          m = i;
          label902:
          i = m;
          n = j;
          i1 = k;
          if (!paramArrayList.hasNext()) {
            break;
          }
          paramWXRTEditText = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.next();
          f(paramWXRTEditText);
          if (!b(m, paramWXRTEditText)) {
            break label1241;
          }
          i = m + 1;
          break label1257;
          if (bu.isNullOrNil(paramWXRTEditText)) {
            break label1017;
          }
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
        }
        label1017:
        BN(j);
        i = j;
        if (this.pAY == null) {
          break label1267;
        }
        this.pAY.BJ(j);
        i = j;
        break label1267;
      }
    }
    else if (paramWXRTEditText.getEditTextType() != 1)
    {
      j += 1;
      label1067:
      paramArrayList = paramArrayList.iterator();
      i = j;
    }
    label1143:
    label1277:
    for (;;)
    {
      if (paramArrayList.hasNext())
      {
        paramWXRTEditText = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.next();
        f(paramWXRTEditText);
        if (!b(i, paramWXRTEditText)) {
          break label1235;
        }
        i += 1;
        break label1277;
        j = cfy().size() - 1;
        break label419;
        paramArrayList = new j();
        paramArrayList.type = 1;
        paramArrayList.content = "";
        paramArrayList.pAl = 0;
        paramArrayList.pAj = true;
        paramArrayList.pAp = false;
        b(j, paramArrayList);
        k = j;
        m = i;
        break label503;
        if (n != 0) {
          break label584;
        }
        this.pAY.fe(n, cfy().size() - n);
        break label584;
      }
      i1 = 0;
      n = j;
      break label391;
      break label1277;
      break label1067;
      i = m;
      break label1257;
      j = 0;
      break;
      break label259;
      m = i;
      break label902;
      break label777;
      j = i;
      k = 0;
      break label893;
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
        if ((bool) && (this.pAY != null))
        {
          this.pAY.BI(paramInt);
          if (paramInt > 0) {
            this.pAY.fe(paramInt - 1, this.mDataList.size() - (paramInt - 1));
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
      this.pAY.fe(paramInt, this.mDataList.size() - paramInt);
      continue;
      label138:
      bool = false;
    }
  }
  
  public final void aa(int paramInt, boolean paramBoolean)
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
            ((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i)).pAj = true;
            ((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i)).pAp = paramBoolean;
          }
          else
          {
            ((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i)).pAj = false;
            ((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i)).pAp = false;
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
  
  public final akn abO(String paramString)
  {
    AppMethodBeat.i(181748);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.EditorDataManager", "getFavProtoItem error, htmlstr is null or nil");
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
          break label796;
        }
        localObject1 = (com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i);
        if (bu.isNullOrNil(((com.tencent.mm.plugin.editor.model.a.a)localObject1).dua)) {
          ((com.tencent.mm.plugin.editor.model.a.a)localObject1).dua = com.tencent.mm.plugin.editor.model.b.abL(localObject1.toString());
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
            ((j)localObject2).dua = ((com.tencent.mm.plugin.editor.model.a.a)localObject1).dua;
            ((j)localObject2).pAw = "-1";
            ((j)localObject2).type = 1;
            ((j)localObject2).pAv = null;
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
        if (((((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType() == 6) || (((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType() == 4)) && (bu.isNullOrNil(((d)localObject1).dCC)))
        {
          localObject2 = new ajx();
          ((ajx)localObject2).aPP(((com.tencent.mm.plugin.editor.model.a.a)localObject1).dua);
          ((ajx)localObject2).aPM(((com.tencent.mm.plugin.editor.model.a.a)localObject1).cfq());
          localObject2 = com.tencent.mm.plugin.editor.model.b.b((ajx)localObject2);
          if (o.fB((String)localObject2))
          {
            ae.e("MicroMsg.EditorDataManager", "getFavProtoItem, type = %d, localfile exist, but localpath is null or nil, set path here", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType()) });
            ((d)localObject1).dCC = ((String)localObject2);
          }
        }
        if (((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType() != 1)
        {
          localArrayList.add((d)localObject1);
        }
        else
        {
          localObject1 = (j)localObject1;
          if (bu.isNullOrNil(((j)localObject1).content))
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
              ((j)localObject2).dua = ((j)localObject1).dua;
              ((j)localObject2).pAw = ((j)localObject1).pAw;
              ((j)localObject2).type = ((j)localObject1).type;
              ((j)localObject2).pAv = null;
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
            while ((i + 1 < this.mDataList.size()) && (((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i + 1)).getType() == 1) && (!bu.isNullOrNil(((j)this.mDataList.get(i + 1)).content)))
            {
              localObject1 = new StringBuilder();
              localObject2 = (j)localArrayList.get(localArrayList.size() - 1);
              ((j)localObject2).content += "<br/>";
              break;
              localObject2 = new j();
              ((j)localObject2).content = ((j)localObject1).content;
              ((j)localObject2).dua = ((j)localObject1).dua;
              ((j)localObject2).pAw = ((j)localObject1).pAw;
              ((j)localObject2).type = ((j)localObject1).type;
              ((j)localObject2).pAv = null;
              localArrayList.add(localObject2);
              continue;
              label796:
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
                    ((k)localObject3).createNewFile();
                    if ((i != 0) || (o.f((String)localObject2, paramString, paramString.length) != 0)) {
                      break;
                    }
                    this.pAZ.aPQ((String)localObject2);
                    ae.i("MicroMsg.EditorDataManager", "do EditorBase.ConvertNote2FavProtoItem");
                    paramString = com.tencent.mm.plugin.editor.model.a.a((String)localObject1, localArrayList, this.pAZ);
                    AppMethodBeat.o(181748);
                    return paramString;
                  }
                  catch (IOException paramString)
                  {
                    ae.printErrStackTrace("MicroMsg.EditorDataManager", paramString, "", new Object[0]);
                    AppMethodBeat.o(181748);
                    return null;
                  }
                  paramString = paramString;
                  ae.printErrStackTrace("MicroMsg.EditorDataManager", paramString, "", new Object[0]);
                  ae.e("MicroMsg.EditorDataManager", "writehtmlfile, use utf-8 encoding error, use default encoding");
                  i = 1;
                  paramString = null;
                }
              }
              this.pAZ.aao(8);
              this.pAZ.aPZ("WeNoteHtmlFile");
              this.pAZ.wt(true);
              this.pAZ.aPM(".htm");
              this.pAZ.aPP(com.tencent.mm.plugin.editor.model.b.abL(this.pAZ.toString()));
              localObject2 = com.tencent.mm.plugin.editor.model.b.b(this.pAZ);
              ae.i("MicroMsg.EditorDataManager", "getFavProtoItem: save note html file, path is %s", new Object[] { localObject2 });
              localObject3 = new k((String)localObject2);
              if (((k)localObject3).exists()) {
                ((k)localObject3).delete();
              }
              if (!((k)localObject3).exists()) {}
              ae.i("MicroMsg.EditorDataManager", "writefile error, return");
              Toast.makeText(ak.getContext(), ak.getContext().getString(2131758993), 1).show();
              AppMethodBeat.o(181748);
              return null;
            }
          }
        }
      }
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
      if ((bool) && (this.pAY != null)) {
        this.pAY.fd(i - paramInt, paramInt);
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
  
  public final int cfA()
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
            if (((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i)).pAj) {
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
  
  public final void cfB()
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
          locala.pAj = false;
          locala.pAp = false;
        }
      }
    }
    finally
    {
      AppMethodBeat.o(181740);
    }
    AppMethodBeat.o(181740);
  }
  
  public final int cfD()
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
            if ((((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i)).getType() == 4) && (((m)this.mDataList.get(i)).pAG.booleanValue())) {
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
  
  public final String cfE()
  {
    AppMethodBeat.i(181744);
    for (;;)
    {
      try
      {
        if ((this.pBa != 0) || (this.mDataList == null)) {
          break;
        }
        Iterator localIterator = this.mDataList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        d locald = (d)localIterator.next();
        if (locald.pAw.startsWith("WeNote_"))
        {
          i = bu.getInt(locald.pAw.substring(7), -1);
          if (i > this.pBa) {
            this.pBa = i;
          } else {
            i = this.pBa;
          }
        }
      }
      finally
      {
        AppMethodBeat.o(181744);
      }
    }
    Object localObject2 = new StringBuilder("WeNote_");
    int i = this.pBa + 1;
    this.pBa = i;
    localObject2 = i;
    AppMethodBeat.o(181744);
    return localObject2;
  }
  
  public final String cfG()
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
          if (bu.isNullOrNil(((j)localObject3).content)) {
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
      if ((i + 1 < this.mDataList.size()) && (((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i + 1)).getType() == 1) && (!bu.isNullOrNil(((j)this.mDataList.get(i + 1)).content)))
      {
        localObject1.append("<br/>");
        break label337;
        localObject1.append(cT(((h)localObject3).pAw, 2));
        break label337;
        localObject1.append(cT(((l)localObject3).pAw, 6));
        break label337;
        localObject1.append(cT(((m)localObject3).pAw, 4));
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
  
  public final ArrayList<com.tencent.mm.plugin.editor.model.a.a> cfH()
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
  
  public final void cfI()
  {
    AppMethodBeat.i(181756);
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
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
        c.a(c.this, com.tencent.mm.plugin.editor.b.abD(localObject.toString()));
        c.b(c.this, i);
        AppMethodBeat.o(181726);
      }
    });
    AppMethodBeat.o(181756);
  }
  
  public final int cfJ()
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
  
  public final int cfK()
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
  
  public final void cfz()
  {
    AppMethodBeat.i(181737);
    if (this.mDataList != null) {}
    for (int i = this.mDataList.size();; i = 0)
    {
      ae.i("MicroMsg.EditorDataManager", "clear mDataList, size:%d", new Object[] { Integer.valueOf(i) });
      try
      {
        if (this.mDataList != null) {
          this.mDataList.clear();
        }
        this.pBc = 0;
        this.pBb = 0;
        AppMethodBeat.o(181737);
        return;
      }
      finally
      {
        AppMethodBeat.o(181737);
      }
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
  
  public final boolean fg(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {}
    for (int i = 0;; i = 1)
    {
      if (paramInt2 < 0) {}
      for (int j = 0;; j = 1)
      {
        if ((i != 0) && (this.pBb + paramInt1 > 16384)) {}
        while ((j != 0) && (this.pBc + paramInt2 > 30)) {
          return true;
        }
        return false;
      }
    }
  }
  
  public final void fh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181758);
    ae.i("MicroMsg.EditorDataManager", "checkMergeTextDataItem startPos: %d endPos: %d needNotify: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.TRUE });
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
          break label489;
        }
        paramInt2 = this.mDataList.size() - 1;
        paramInt1 = -1;
        if (paramInt2 <= j) {
          break label445;
        }
        Object localObject1 = (com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(paramInt2);
        localObject3 = (com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(paramInt2 - 1);
        i = paramInt1;
        if (localObject1 == null) {
          break label494;
        }
        i = paramInt1;
        if (((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType() != 1) {
          break label494;
        }
        i = paramInt1;
        if (localObject3 == null) {
          break label494;
        }
        i = paramInt1;
        if (((com.tencent.mm.plugin.editor.model.a.a)localObject3).getType() != 1) {
          break label494;
        }
        paramInt1 = paramInt2 - 1;
        localObject1 = (j)localObject1;
        localObject3 = (j)localObject3;
        if (bu.isNullOrNil(((j)localObject1).content)) {
          break label416;
        }
        Spanned localSpanned1 = com.tencent.mm.plugin.editor.model.nativenote.a.a.abM(((j)localObject1).content);
        localSpanned2 = com.tencent.mm.plugin.editor.model.nativenote.a.a.abM(((j)localObject3).content);
        ((j)localObject3).content = (((j)localObject3).content + "<br/>" + ((j)localObject1).content);
        if (((j)localObject1).pAj)
        {
          ((j)localObject3).pAj = true;
          ((j)localObject3).pAp = false;
          if ((((j)localObject1).pAl == -1) || (((j)localObject1).pAl >= localSpanned1.length()))
          {
            ((j)localObject3).pAl = -1;
            ae.i("MicroMsg.EditorDataManager", "checkMergeTextDataItem remove position: %d", new Object[] { Integer.valueOf(paramInt2) });
            BN(paramInt2);
            i = paramInt1;
            if (this.pAY == null) {
              break label494;
            }
            this.pAY.BJ(paramInt2);
            i = paramInt1;
            break label494;
          }
          i = localSpanned2.length();
          ((j)localObject1).pAl += i + 1;
          continue;
        }
        if (!((j)localObject3).pAj) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(181758);
      }
      if (((j)localObject3).pAl == -1)
      {
        ((j)localObject3).pAl = localSpanned2.length();
        continue;
        label416:
        if (localObject2.pAj)
        {
          ((j)localObject3).pAj = true;
          ((j)localObject3).pAp = false;
          ((j)localObject3).pAl = -1;
          continue;
          label445:
          if ((paramInt1 != -1) && (this.pAY != null)) {
            this.pAY.fe(paramInt1, this.mDataList.size() - paramInt1);
          }
          cfI();
          AppMethodBeat.o(181758);
          return;
          label489:
          paramInt1 = -1;
          continue;
          label494:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.c
 * JD-Core Version:    0.7.0.1
 */