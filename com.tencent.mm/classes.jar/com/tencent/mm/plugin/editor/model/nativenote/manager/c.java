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
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c
{
  private static volatile c qQo = null;
  public ArrayList<com.tencent.mm.plugin.editor.model.a.a> mDataList = null;
  public com.tencent.mm.plugin.editor.model.nativenote.b.a qQp = null;
  public aml qQq = null;
  public int qQr = 0;
  public int qQs = 0;
  public int qQt = 0;
  
  private boolean Fx(int paramInt)
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
      int i = com.tencent.mm.plugin.editor.b.alJ(((j)parama).content);
      if (paramBoolean)
      {
        this.qQs = (i + this.qQs);
        AppMethodBeat.o(181757);
        return;
      }
      this.qQs -= i;
      AppMethodBeat.o(181757);
      return;
    }
    if (paramBoolean)
    {
      this.qQt += 1;
      AppMethodBeat.o(181757);
      return;
    }
    this.qQt -= 1;
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
  
  public static c cDo()
  {
    AppMethodBeat.i(181727);
    if (qQo == null) {}
    try
    {
      if (qQo == null) {
        qQo = new c();
      }
      c localc = qQo;
      AppMethodBeat.o(181727);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(181727);
    }
  }
  
  private void cDs()
  {
    AppMethodBeat.i(181741);
    if (this.mDataList != null)
    {
      Iterator localIterator = this.mDataList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)localIterator.next();
        locala.qPA = false;
        locala.qPG = false;
      }
    }
    AppMethodBeat.o(181741);
  }
  
  private String cDv()
  {
    AppMethodBeat.i(181745);
    if ((this.qQr == 0) && (this.mDataList != null))
    {
      localObject = this.mDataList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        d locald = (d)((Iterator)localObject).next();
        if (locald.qPN.startsWith("WeNote_"))
        {
          i = Util.getInt(locald.qPN.substring(7), -1);
          if (i > this.qQr) {}
          for (;;)
          {
            this.qQr = i;
            break;
            i = this.qQr;
          }
        }
      }
    }
    Object localObject = new StringBuilder("WeNote_");
    int i = this.qQr + 1;
    this.qQr = i;
    localObject = i;
    AppMethodBeat.o(181745);
    return localObject;
  }
  
  private static String cY(String paramString, int paramInt)
  {
    AppMethodBeat.i(181747);
    paramString = String.format("<div><object data-type=\"%d\" id=\"%s\" name=\"%s\" class=\"item item-\"></object></div>", new Object[] { Integer.valueOf(paramInt), paramString, paramString });
    AppMethodBeat.o(181747);
    return paramString;
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
    if ((locald.getType() > 1) && (Util.isNullOrNil(locald.qPN))) {
      locald.qPN = cDv();
    }
    if (Util.isNullOrNil(parama.dLl)) {
      parama.dLl = com.tencent.mm.plugin.editor.model.b.alR(parama.toString());
    }
    AppMethodBeat.o(181752);
  }
  
  public final com.tencent.mm.plugin.editor.model.a.a Fw(int paramInt)
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
  
  public final void Fy(int paramInt)
  {
    AppMethodBeat.i(181736);
    if (this.qQp != null) {
      this.qQp.Fr(paramInt);
    }
    AppMethodBeat.o(181736);
  }
  
  public final void T(ArrayList<WXRTEditText> paramArrayList)
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
        if (locala.qPF != null)
        {
          paramArrayList.add(locala.qPF);
          continue;
        }
        if (locala.qPD == null) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(181754);
      }
      if (locala.qPE != null)
      {
        paramArrayList.add(locala.qPD);
        paramArrayList.add(locala.qPE);
      }
    }
    AppMethodBeat.o(181754);
  }
  
  public final boolean U(ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList)
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
    boolean bool = fw(com.tencent.mm.plugin.editor.b.alJ(localStringBuilder.toString()), i);
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
    ((com.tencent.mm.plugin.editor.model.a.a)localObject1).qPC = -1;
    ((com.tencent.mm.plugin.editor.model.a.a)localObject1).qPA = true;
    ((com.tencent.mm.plugin.editor.model.a.a)localObject1).qPG = false;
    Object localObject3 = Fw(paramInt2);
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
        cDs();
        if ((paramInt1 != 0) || (((com.tencent.mm.plugin.editor.model.a.a)localObject3).getType() != 1)) {
          break label863;
        }
        Object localObject2 = com.tencent.mm.plugin.editor.model.nativenote.a.a.alS(((j)localObject3).content);
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
          ((j)localObject3).qPC = 0;
          ((j)localObject3).qPA = false;
          ((j)localObject3).qPG = false;
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
          Fx(paramInt2);
          paramInt1 = paramInt2;
          if (this.qQp == null) {
            break label849;
          }
          this.qQp.Ft(paramInt2);
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
        if ((j - 1 >= 0) && (j - 1 < cDo().size()))
        {
          paramInt1 = j - 1;
          if (this.qQp != null)
          {
            paramInt3 = j - i;
            paramInt2 = paramInt3;
            if (paramInt4 != 0) {
              paramInt2 = paramInt3 + 1;
            }
            if ((i >= 0) && (paramInt2 > 0)) {
              this.qQp.ft(i, paramInt2);
            }
            if (i <= 0) {
              break label807;
            }
            this.qQp.fu(i - 1, cDo().size() - (i - 1));
            this.qQp.Fu(paramInt1);
          }
          cDy();
          AppMethodBeat.o(181751);
          return paramInt1;
        }
      }
      finally
      {
        AppMethodBeat.o(181751);
      }
      paramInt1 = cDo().size() - 1;
      continue;
      label807:
      if (i == 0)
      {
        this.qQp.fu(i, cDo().size() - i);
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
    if ((paramBoolean2) && (U(paramArrayList)) && (this.qQp != null))
    {
      this.qQp.cCx();
      AppMethodBeat.o(181750);
      return -1;
    }
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.get(paramArrayList.size() - 1);
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).qPC = -1;
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).qPA = true;
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).qPG = false;
      if ((paramWXRTEditText != null) && (paramWXRTEditText.qRr))
      {
        if (paramWXRTEditText.getEditTextType() != 2) {
          break label261;
        }
        ((com.tencent.mm.plugin.editor.model.a.a)localObject1).qPJ = 2;
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
      paramWXRTEditText.qRr = false;
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).qPK = paramWXRTEditText.qPK;
      paramWXRTEditText.qPK = 0;
      if ((paramWXRTEditText == null) || (paramWXRTEditText.getRecyclerItemPosition() != 0)) {
        if (paramWXRTEditText != null) {
          break label621;
        }
      }
      try
      {
        n = size();
        cDs();
        paramArrayList = paramArrayList.iterator();
        i = n;
        for (;;)
        {
          if (paramArrayList.hasNext())
          {
            paramWXRTEditText = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.next();
            f(paramWXRTEditText);
            if ((paramWXRTEditText == null) || (this.mDataList == null)) {
              break label1247;
            }
            this.mDataList.add(paramWXRTEditText);
            a(paramWXRTEditText, true);
            j = 1;
            if (j == 0) {
              break label1253;
            }
            i += 1;
            continue;
            if (paramWXRTEditText.getEditTextType() != 1) {
              break;
            }
            ((com.tencent.mm.plugin.editor.model.a.a)localObject1).qPJ = 1;
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
            ((j)localObject1).qPA = false;
            ((j)localObject1).qPG = false;
            paramArrayList.add(0, localObject1);
            break label169;
          }
        }
        i1 = 0;
        if ((i - 1 < 0) || (i - 1 >= cDo().size())) {
          break;
        }
        j = i - 1;
        k = j;
        m = i;
        if (paramBoolean4)
        {
          j += 1;
          i += 1;
          cDs();
          if (j >= cDo().size()) {
            break label1142;
          }
          paramArrayList = cDo().Fw(j);
          k = j;
          m = i;
          if (paramArrayList != null)
          {
            paramArrayList.qPC = 0;
            paramArrayList.qPA = true;
            paramArrayList.qPG = false;
            m = i;
            k = j;
          }
        }
        label502:
        if (this.qQp != null)
        {
          j = m - n;
          i = j;
          if (i1 != 0) {
            i = j + 1;
          }
          if ((n >= 0) && (i > 0)) {
            this.qQp.ft(n, i);
          }
          if (n <= 0) {
            break label1196;
          }
          this.qQp.fu(n - 1, cDo().size() - (n - 1));
          if (paramBoolean3) {
            this.qQp.cCw();
          }
          this.qQp.Fu(k);
        }
        label583:
        cDy();
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
    localObject2 = Fw(j);
    if (localObject2 == null)
    {
      AppMethodBeat.o(181750);
      return -1;
    }
    cDs();
    if ((paramWXRTEditText.getEditTextType() == 0) && (((com.tencent.mm.plugin.editor.model.a.a)localObject2).getType() == 1))
    {
      localObject1 = paramWXRTEditText.getSelection();
      localObject3 = paramWXRTEditText.getText();
      paramWXRTEditText = ((Editable)localObject3).subSequence(0, ((g)localObject1).avh);
      localObject3 = ((Editable)localObject3).subSequence(((g)localObject1).Pc, ((Editable)localObject3).length());
      localObject1 = com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)paramWXRTEditText);
      paramWXRTEditText = com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)localObject3);
      localObject2 = (j)localObject2;
      if (!Util.isNullOrNil((String)localObject1))
      {
        if (((String)localObject1).endsWith("<br/>"))
        {
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 5);
          label776:
          ((j)localObject2).content = ((String)localObject1);
          j += 1;
          i = j;
          if (Util.isNullOrNil(paramWXRTEditText)) {
            break label1266;
          }
          localObject2 = new j();
          ((j)localObject2).type = 1;
          localObject1 = paramWXRTEditText;
          if (paramWXRTEditText.startsWith("<br/>")) {
            localObject1 = paramWXRTEditText.substring(5, paramWXRTEditText.length());
          }
          ((j)localObject2).content = ((String)localObject1);
          ((j)localObject2).qPC = 0;
          ((j)localObject2).qPA = false;
          ((j)localObject2).qPG = false;
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
          label892:
          paramArrayList = paramArrayList.iterator();
          m = i;
          label901:
          i = m;
          n = j;
          i1 = k;
          if (!paramArrayList.hasNext()) {
            break;
          }
          paramWXRTEditText = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.next();
          f(paramWXRTEditText);
          if (!b(m, paramWXRTEditText)) {
            break label1240;
          }
          i = m + 1;
          break label1256;
          if (Util.isNullOrNil(paramWXRTEditText)) {
            break label1016;
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
        label1016:
        Fx(j);
        i = j;
        if (this.qQp == null) {
          break label1266;
        }
        this.qQp.Ft(j);
        i = j;
        break label1266;
      }
    }
    else if (paramWXRTEditText.getEditTextType() != 1)
    {
      j += 1;
      label1066:
      paramArrayList = paramArrayList.iterator();
      i = j;
    }
    label1142:
    label1276:
    for (;;)
    {
      if (paramArrayList.hasNext())
      {
        paramWXRTEditText = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.next();
        f(paramWXRTEditText);
        if (!b(i, paramWXRTEditText)) {
          break label1234;
        }
        i += 1;
        break label1276;
        j = cDo().size() - 1;
        break label418;
        paramArrayList = new j();
        paramArrayList.type = 1;
        paramArrayList.content = "";
        paramArrayList.qPC = 0;
        paramArrayList.qPA = true;
        paramArrayList.qPG = false;
        b(j, paramArrayList);
        k = j;
        m = i;
        break label502;
        if (n != 0) {
          break label583;
        }
        this.qQp.fu(n, cDo().size() - n);
        break label583;
      }
      i1 = 0;
      n = j;
      break label390;
      break label1276;
      break label1066;
      i = m;
      break label1256;
      j = 0;
      break;
      break label258;
      m = i;
      break label901;
      break label776;
      j = i;
      k = 0;
      break label892;
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
        if ((bool) && (this.qQp != null))
        {
          this.qQp.Fs(paramInt);
          if (paramInt > 0) {
            this.qQp.fu(paramInt - 1, this.mDataList.size() - (paramInt - 1));
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
      this.qQp.fu(paramInt, this.mDataList.size() - paramInt);
      continue;
      label138:
      bool = false;
    }
  }
  
  public final boolean ae(int paramInt, boolean paramBoolean)
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
        if ((bool1) && (paramBoolean) && (this.qQp != null))
        {
          this.qQp.Ft(paramInt);
          if (paramInt > 0) {
            this.qQp.fu(paramInt - 1, this.mDataList.size() - (paramInt - 1));
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
      this.qQp.fu(paramInt, this.mDataList.size() - paramInt);
    }
  }
  
  public final void af(int paramInt, boolean paramBoolean)
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
          if ((locala != null) && (locala.qPH != paramBoolean))
          {
            locala.qPH = paramBoolean;
            if (this.qQp != null) {
              this.qQp.Fr(paramInt);
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
        if ((locala != null) && (locala.qPH != paramBoolean))
        {
          locala.qPH = paramBoolean;
          if (this.qQp != null) {
            this.qQp.Fr(paramInt);
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
  
  public final void ag(int paramInt, boolean paramBoolean)
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
            ((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i)).qPA = true;
            ((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i)).qPG = paramBoolean;
          }
          else
          {
            ((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i)).qPA = false;
            ((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i)).qPG = false;
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
  
  public final anb alU(String paramString)
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
        if (Util.isNullOrNil(((com.tencent.mm.plugin.editor.model.a.a)localObject1).dLl)) {
          ((com.tencent.mm.plugin.editor.model.a.a)localObject1).dLl = com.tencent.mm.plugin.editor.model.b.alR(localObject1.toString());
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
            ((j)localObject2).dLl = ((com.tencent.mm.plugin.editor.model.a.a)localObject1).dLl;
            ((j)localObject2).qPN = "-1";
            ((j)localObject2).type = 1;
            ((j)localObject2).qPM = null;
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
        if (((((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType() == 6) || (((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType() == 4)) && (Util.isNullOrNil(((d)localObject1).dUs)))
        {
          localObject2 = new aml();
          ((aml)localObject2).bgs(((com.tencent.mm.plugin.editor.model.a.a)localObject1).dLl);
          ((aml)localObject2).bgp(((com.tencent.mm.plugin.editor.model.a.a)localObject1).cDg());
          localObject2 = com.tencent.mm.plugin.editor.model.b.b((aml)localObject2);
          if (s.YS((String)localObject2))
          {
            Log.e("MicroMsg.EditorDataManager", "getFavProtoItem, type = %d, localfile exist, but localpath is null or nil, set path here", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType()) });
            ((d)localObject1).dUs = ((String)localObject2);
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
              ((j)localObject2).dLl = ((j)localObject1).dLl;
              ((j)localObject2).qPN = ((j)localObject1).qPN;
              ((j)localObject2).type = ((j)localObject1).type;
              ((j)localObject2).qPM = null;
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
              ((j)localObject2).dLl = ((j)localObject1).dLl;
              ((j)localObject2).qPN = ((j)localObject1).qPN;
              ((j)localObject2).type = ((j)localObject1).type;
              ((j)localObject2).qPM = null;
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
                    ((o)localObject3).createNewFile();
                    if ((i != 0) || (s.f((String)localObject2, paramString, paramString.length) != 0)) {
                      break;
                    }
                    this.qQq.bgt((String)localObject2);
                    Log.i("MicroMsg.EditorDataManager", "do EditorBase.ConvertNote2FavProtoItem");
                    paramString = com.tencent.mm.plugin.editor.model.a.a((String)localObject1, localArrayList, this.qQq);
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
              this.qQq.ajd(8);
              this.qQq.bgC("WeNoteHtmlFile");
              this.qQq.At(true);
              this.qQq.bgp(".htm");
              this.qQq.bgs(com.tencent.mm.plugin.editor.model.b.alR(this.qQq.toString()));
              localObject2 = com.tencent.mm.plugin.editor.model.b.b(this.qQq);
              Log.i("MicroMsg.EditorDataManager", "getFavProtoItem: save note html file, path is %s", new Object[] { localObject2 });
              localObject3 = new o((String)localObject2);
              if (((o)localObject3).exists()) {
                ((o)localObject3).delete();
              }
              if (!((o)localObject3).exists()) {}
              Log.i("MicroMsg.EditorDataManager", "writefile error, return");
              Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131759318), 1).show();
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
      if ((bool) && (this.qQp != null)) {
        this.qQp.ft(i - paramInt, paramInt);
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
  
  public final int cDA()
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
  
  public final void cDp()
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
        this.qQt = 0;
        this.qQs = 0;
        AppMethodBeat.o(181737);
        return;
      }
      finally
      {
        AppMethodBeat.o(181737);
      }
    }
  }
  
  public final int cDq()
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
            if (((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i)).qPA) {
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
  
  public final void cDr()
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
          locala.qPA = false;
          locala.qPG = false;
        }
      }
    }
    finally
    {
      AppMethodBeat.o(181740);
    }
    AppMethodBeat.o(181740);
  }
  
  public final int cDt()
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
            if ((((com.tencent.mm.plugin.editor.model.a.a)this.mDataList.get(i)).getType() == 4) && (((m)this.mDataList.get(i)).qPX.booleanValue())) {
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
  
  public final String cDu()
  {
    AppMethodBeat.i(181744);
    for (;;)
    {
      try
      {
        if ((this.qQr != 0) || (this.mDataList == null)) {
          break;
        }
        Iterator localIterator = this.mDataList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        d locald = (d)localIterator.next();
        if (locald.qPN.startsWith("WeNote_"))
        {
          i = Util.getInt(locald.qPN.substring(7), -1);
          if (i > this.qQr) {
            this.qQr = i;
          } else {
            i = this.qQr;
          }
        }
      }
      finally
      {
        AppMethodBeat.o(181744);
      }
    }
    Object localObject2 = new StringBuilder("WeNote_");
    int i = this.qQr + 1;
    this.qQr = i;
    localObject2 = i;
    AppMethodBeat.o(181744);
    return localObject2;
  }
  
  public final String cDw()
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
        localObject1.append(cY(((h)localObject3).qPN, 2));
        break label337;
        localObject1.append(cY(((l)localObject3).qPN, 6));
        break label337;
        localObject1.append(cY(((m)localObject3).qPN, 4));
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
  
  public final ArrayList<com.tencent.mm.plugin.editor.model.a.a> cDx()
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
  
  public final void cDy()
  {
    AppMethodBeat.i(181756);
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
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
        c.a(c.this, com.tencent.mm.plugin.editor.b.alJ(localObject.toString()));
        c.b(c.this, i);
        AppMethodBeat.o(181726);
      }
    });
    AppMethodBeat.o(181756);
  }
  
  public final int cDz()
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
  
  public final boolean fw(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {}
    for (int i = 0;; i = 1)
    {
      if (paramInt2 < 0) {}
      for (int j = 0;; j = 1)
      {
        if ((i != 0) && (this.qQs + paramInt1 > 16384)) {}
        while ((j != 0) && (this.qQt + paramInt2 > 30)) {
          return true;
        }
        return false;
      }
    }
  }
  
  public final void fx(int paramInt1, int paramInt2)
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
        Spanned localSpanned1 = com.tencent.mm.plugin.editor.model.nativenote.a.a.alS(((j)localObject1).content);
        localSpanned2 = com.tencent.mm.plugin.editor.model.nativenote.a.a.alS(((j)localObject3).content);
        ((j)localObject3).content = (((j)localObject3).content + "<br/>" + ((j)localObject1).content);
        if (((j)localObject1).qPA)
        {
          ((j)localObject3).qPA = true;
          ((j)localObject3).qPG = false;
          if ((((j)localObject1).qPC == -1) || (((j)localObject1).qPC >= localSpanned1.length()))
          {
            ((j)localObject3).qPC = -1;
            Log.i("MicroMsg.EditorDataManager", "checkMergeTextDataItem remove position: %d", new Object[] { Integer.valueOf(paramInt2) });
            Fx(paramInt2);
            i = paramInt1;
            if (this.qQp == null) {
              break label492;
            }
            this.qQp.Ft(paramInt2);
            i = paramInt1;
            break label492;
          }
          i = localSpanned2.length();
          ((j)localObject1).qPC += i + 1;
          continue;
        }
        if (!((j)localObject3).qPA) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(181758);
      }
      if (((j)localObject3).qPC == -1)
      {
        ((j)localObject3).qPC = localSpanned2.length();
        continue;
        label414:
        if (localObject2.qPA)
        {
          ((j)localObject3).qPA = true;
          ((j)localObject3).qPG = false;
          ((j)localObject3).qPC = -1;
          continue;
          label443:
          if ((paramInt1 != -1) && (this.qQp != null)) {
            this.qQp.fu(paramInt1, this.mDataList.size() - paramInt1);
          }
          cDy();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.c
 * JD-Core Version:    0.7.0.1
 */