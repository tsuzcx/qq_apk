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
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c
{
  private static volatile c onj = null;
  public ArrayList<com.tencent.mm.plugin.editor.model.a.a> hIH = null;
  public com.tencent.mm.plugin.editor.model.nativenote.b.a onk = null;
  public afy onl = null;
  public int onm = 0;
  public int onn = 0;
  public int ono = 0;
  
  private boolean Ab(int paramInt)
  {
    AppMethodBeat.i(181735);
    if ((this.hIH != null) && (paramInt >= 0) && (paramInt < this.hIH.size()))
    {
      a((com.tencent.mm.plugin.editor.model.a.a)this.hIH.get(paramInt), false);
      this.hIH.remove(paramInt);
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
      int i = com.tencent.mm.plugin.editor.b.ST(((j)parama).content);
      if (paramBoolean)
      {
        this.onn = (i + this.onn);
        AppMethodBeat.o(181757);
        return;
      }
      this.onn -= i;
      AppMethodBeat.o(181757);
      return;
    }
    if (paramBoolean)
    {
      this.ono += 1;
      AppMethodBeat.o(181757);
      return;
    }
    this.ono -= 1;
    AppMethodBeat.o(181757);
  }
  
  private boolean b(int paramInt, com.tencent.mm.plugin.editor.model.a.a parama)
  {
    boolean bool = true;
    AppMethodBeat.i(181733);
    if ((parama != null) && (this.hIH != null) && (paramInt >= 0) && (paramInt <= this.hIH.size()))
    {
      this.hIH.add(paramInt, parama);
      a(parama, true);
    }
    for (;;)
    {
      AppMethodBeat.o(181733);
      return bool;
      bool = false;
    }
  }
  
  public static c bSq()
  {
    AppMethodBeat.i(181727);
    if (onj == null) {}
    try
    {
      if (onj == null) {
        onj = new c();
      }
      c localc = onj;
      AppMethodBeat.o(181727);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(181727);
    }
  }
  
  private void bSu()
  {
    AppMethodBeat.i(181741);
    if (this.hIH != null)
    {
      Iterator localIterator = this.hIH.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)localIterator.next();
        locala.omv = false;
        locala.omB = false;
      }
    }
    AppMethodBeat.o(181741);
  }
  
  private String bSx()
  {
    AppMethodBeat.i(181745);
    if ((this.onm == 0) && (this.hIH != null))
    {
      localObject = this.hIH.iterator();
      while (((Iterator)localObject).hasNext())
      {
        d locald = (d)((Iterator)localObject).next();
        if (locald.omI.startsWith("WeNote_"))
        {
          i = bt.getInt(locald.omI.substring(7), -1);
          if (i > this.onm) {}
          for (;;)
          {
            this.onm = i;
            break;
            i = this.onm;
          }
        }
      }
    }
    Object localObject = new StringBuilder("WeNote_");
    int i = this.onm + 1;
    this.onm = i;
    localObject = i;
    AppMethodBeat.o(181745);
    return localObject;
  }
  
  private static String cH(String paramString, int paramInt)
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
    if ((locald.getType() > 1) && (bt.isNullOrNil(locald.omI))) {
      locald.omI = bSx();
    }
    if (bt.isNullOrNil(parama.dkb)) {
      parama.dkb = com.tencent.mm.plugin.editor.model.b.Tb(parama.toString());
    }
    AppMethodBeat.o(181752);
  }
  
  public final com.tencent.mm.plugin.editor.model.a.a Aa(int paramInt)
  {
    AppMethodBeat.i(181729);
    if ((this.hIH != null) && (paramInt >= 0) && (paramInt < this.hIH.size()))
    {
      com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)this.hIH.get(paramInt);
      AppMethodBeat.o(181729);
      return locala;
    }
    AppMethodBeat.o(181729);
    return null;
  }
  
  public final void Ac(int paramInt)
  {
    AppMethodBeat.i(181736);
    if (this.onk != null) {
      this.onk.zV(paramInt);
    }
    AppMethodBeat.o(181736);
  }
  
  public final void H(ArrayList<WXRTEditText> paramArrayList)
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
        if (this.hIH == null) {
          return;
        }
        Iterator localIterator = this.hIH.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        locala = (com.tencent.mm.plugin.editor.model.a.a)localIterator.next();
        if (locala.omA != null)
        {
          paramArrayList.add(locala.omA);
          continue;
        }
        if (locala.omy == null) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(181754);
      }
      if (locala.omz != null)
      {
        paramArrayList.add(locala.omy);
        paramArrayList.add(locala.omz);
      }
    }
    AppMethodBeat.o(181754);
  }
  
  public final boolean I(ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList)
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
    boolean bool = eY(com.tencent.mm.plugin.editor.b.ST(localStringBuilder.toString()), i);
    AppMethodBeat.o(181755);
    return bool;
  }
  
  public final ago Te(String paramString)
  {
    AppMethodBeat.i(181748);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.EditorDataManager", "getFavProtoItem error, htmlstr is null or nil");
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
        if (i >= this.hIH.size()) {
          break label790;
        }
        localObject1 = (com.tencent.mm.plugin.editor.model.a.a)this.hIH.get(i);
        if (bt.isNullOrNil(((com.tencent.mm.plugin.editor.model.a.a)localObject1).dkb)) {
          ((com.tencent.mm.plugin.editor.model.a.a)localObject1).dkb = com.tencent.mm.plugin.editor.model.b.Tb(localObject1.toString());
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
            ((j)localObject2).dkb = ((com.tencent.mm.plugin.editor.model.a.a)localObject1).dkb;
            ((j)localObject2).omI = "-1";
            ((j)localObject2).type = 1;
            ((j)localObject2).omH = null;
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
        if (((((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType() == 6) || (((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType() == 4)) && (bt.isNullOrNil(((d)localObject1).drZ)))
        {
          localObject2 = new afy();
          ((afy)localObject2).aDy(((com.tencent.mm.plugin.editor.model.a.a)localObject1).dkb);
          ((afy)localObject2).aDv(((com.tencent.mm.plugin.editor.model.a.a)localObject1).bSi());
          localObject2 = com.tencent.mm.plugin.editor.model.b.b((afy)localObject2);
          if (i.eK((String)localObject2))
          {
            ad.e("MicroMsg.EditorDataManager", "getFavProtoItem, type = %d, localfile exist, but localpath is null or nil, set path here", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType()) });
            ((d)localObject1).drZ = ((String)localObject2);
          }
        }
        if (((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType() != 1)
        {
          localArrayList.add((d)localObject1);
        }
        else
        {
          localObject1 = (j)localObject1;
          if (bt.isNullOrNil(((j)localObject1).content))
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
              ((j)localObject2).dkb = ((j)localObject1).dkb;
              ((j)localObject2).omI = ((j)localObject1).omI;
              ((j)localObject2).type = ((j)localObject1).type;
              ((j)localObject2).omH = null;
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
            while ((i + 1 < this.hIH.size()) && (((com.tencent.mm.plugin.editor.model.a.a)this.hIH.get(i + 1)).getType() == 1) && (!bt.isNullOrNil(((j)this.hIH.get(i + 1)).content)))
            {
              localObject1 = new StringBuilder();
              localObject2 = (j)localArrayList.get(localArrayList.size() - 1);
              ((j)localObject2).content += "<br/>";
              break;
              localObject2 = new j();
              ((j)localObject2).content = ((j)localObject1).content;
              ((j)localObject2).dkb = ((j)localObject1).dkb;
              ((j)localObject2).omI = ((j)localObject1).omI;
              ((j)localObject2).type = ((j)localObject1).type;
              ((j)localObject2).omH = null;
              localArrayList.add(localObject2);
              continue;
              label790:
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
                    ((e)localObject3).createNewFile();
                    if ((i != 0) || (i.f((String)localObject2, paramString, paramString.length) != 0)) {
                      break;
                    }
                    this.onl.aDz((String)localObject2);
                    ad.i("MicroMsg.EditorDataManager", "do EditorBase.ConvertNote2FavProtoItem");
                    paramString = com.tencent.mm.plugin.editor.model.a.a((String)localObject1, localArrayList, this.onl);
                    AppMethodBeat.o(181748);
                    return paramString;
                  }
                  catch (IOException paramString)
                  {
                    ad.printErrStackTrace("MicroMsg.EditorDataManager", paramString, "", new Object[0]);
                    AppMethodBeat.o(181748);
                    return null;
                  }
                  paramString = paramString;
                  ad.printErrStackTrace("MicroMsg.EditorDataManager", paramString, "", new Object[0]);
                  ad.e("MicroMsg.EditorDataManager", "writehtmlfile, use utf-8 encoding error, use default encoding");
                  i = 1;
                  paramString = null;
                }
              }
              this.onl.VD(8);
              this.onl.aDI("WeNoteHtmlFile");
              this.onl.ux(true);
              this.onl.aDv(".htm");
              this.onl.aDy(com.tencent.mm.plugin.editor.model.b.Tb(this.onl.toString()));
              localObject2 = com.tencent.mm.plugin.editor.model.b.b(this.onl);
              ad.i("MicroMsg.EditorDataManager", "getFavProtoItem: save note html file, path is %s", new Object[] { localObject2 });
              localObject3 = new e((String)localObject2);
              if (((e)localObject3).exists()) {
                ((e)localObject3).delete();
              }
              if (!((e)localObject3).exists()) {}
              ad.i("MicroMsg.EditorDataManager", "writefile error, return");
              Toast.makeText(aj.getContext(), aj.getContext().getString(2131758993), 1).show();
              AppMethodBeat.o(181748);
              return null;
            }
          }
        }
      }
      i += 1;
    }
  }
  
  public final boolean W(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(181734);
    boolean bool1 = bool2;
    for (;;)
    {
      try
      {
        if (this.hIH != null)
        {
          bool1 = bool2;
          if (paramInt >= 0)
          {
            bool1 = bool2;
            if (paramInt < this.hIH.size())
            {
              a((com.tencent.mm.plugin.editor.model.a.a)this.hIH.get(paramInt), false);
              this.hIH.remove(paramInt);
              bool1 = true;
            }
          }
        }
        if ((bool1) && (paramBoolean) && (this.onk != null))
        {
          this.onk.zX(paramInt);
          if (paramInt > 0) {
            this.onk.eW(paramInt - 1, this.hIH.size() - (paramInt - 1));
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
      this.onk.eW(paramInt, this.hIH.size() - paramInt);
    }
  }
  
  public final void X(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(181738);
    for (;;)
    {
      try
      {
        if (this.hIH == null) {
          return;
        }
        if ((paramInt >= 0) && (paramInt < this.hIH.size()))
        {
          locala = (com.tencent.mm.plugin.editor.model.a.a)this.hIH.get(paramInt);
          if ((locala != null) && (locala.omC != paramBoolean))
          {
            locala.omC = paramBoolean;
            if (this.onk != null) {
              this.onk.zV(paramInt);
            }
          }
          return;
        }
        if (paramInt != -1) {
          continue;
        }
        paramInt = 0;
        if (paramInt >= this.hIH.size()) {
          continue;
        }
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)this.hIH.get(paramInt);
        if ((locala != null) && (locala.omC != paramBoolean))
        {
          locala.omC = paramBoolean;
          if (this.onk != null) {
            this.onk.zV(paramInt);
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
  
  public final void Y(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(181742);
    for (;;)
    {
      int i;
      try
      {
        if ((this.hIH == null) || (paramInt < 0) || (paramInt >= this.hIH.size())) {
          return;
        }
        i = 0;
        if (i < this.hIH.size()) {
          if (i == paramInt)
          {
            ((com.tencent.mm.plugin.editor.model.a.a)this.hIH.get(i)).omv = true;
            ((com.tencent.mm.plugin.editor.model.a.a)this.hIH.get(i)).omB = paramBoolean;
          }
          else
          {
            ((com.tencent.mm.plugin.editor.model.a.a)this.hIH.get(i)).omv = false;
            ((com.tencent.mm.plugin.editor.model.a.a)this.hIH.get(i)).omB = false;
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
    if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (this.hIH == null) || (paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0) || (paramInt4 < paramInt3))
    {
      ad.e("MicroMsg.EditorDataManager", "pasteItemList,error,return");
      AppMethodBeat.o(181751);
      return -1;
    }
    Object localObject1 = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.get(paramArrayList.size() - 1);
    if (localObject1 == null)
    {
      ad.e("MicroMsg.EditorDataManager", "pasteItemList, lastInsertItem is null");
      AppMethodBeat.o(181751);
      return -1;
    }
    ((com.tencent.mm.plugin.editor.model.a.a)localObject1).omx = -1;
    ((com.tencent.mm.plugin.editor.model.a.a)localObject1).omv = true;
    ((com.tencent.mm.plugin.editor.model.a.a)localObject1).omB = false;
    Object localObject3 = Aa(paramInt2);
    if (localObject3 == null)
    {
      ad.e("MicroMsg.EditorDataManager", "pasteItemList, item is null");
      AppMethodBeat.o(181751);
      return -1;
    }
    for (;;)
    {
      label468:
      label473:
      int j;
      int i;
      try
      {
        bSu();
        if ((paramInt1 != 0) || (((com.tencent.mm.plugin.editor.model.a.a)localObject3).getType() != 1)) {
          break label871;
        }
        Object localObject2 = com.tencent.mm.plugin.editor.model.nativenote.a.a.Tc(((j)localObject3).content);
        if ((localObject2 == null) || (paramInt3 > ((Spanned)localObject2).length()) || (paramInt4 > ((Spanned)localObject2).length()))
        {
          if (localObject2 == null)
          {
            paramInt1 = -1;
            ad.e("MicroMsg.EditorDataManager", "pasteItemList error, oriText:%d  startOff:%d  endOff:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
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
        if (!bt.isNullOrNil((String)localObject2))
        {
          if (!((String)localObject2).endsWith("<br/>")) {
            break label854;
          }
          localObject2 = ((String)localObject2).substring(0, ((String)localObject2).length() - 5);
          ((j)localObject3).content = ((String)localObject2);
          paramInt2 += 1;
          paramInt1 = paramInt2;
          if (bt.isNullOrNil((String)localObject1)) {
            break label857;
          }
          localObject3 = new j();
          ((j)localObject3).type = 1;
          localObject2 = localObject1;
          if (((String)localObject1).startsWith("<br/>")) {
            localObject2 = ((String)localObject1).substring(5, ((String)localObject1).length());
          }
          ((j)localObject3).content = ((String)localObject2);
          ((j)localObject3).omx = 0;
          ((j)localObject3).omv = false;
          ((j)localObject3).omB = false;
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
              break label851;
            }
            paramInt3 += 1;
            break label851;
          }
        }
        else
        {
          if (!bt.isNullOrNil((String)localObject1))
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
          Ab(paramInt2);
          paramInt1 = paramInt2;
          if (this.onk == null) {
            break label857;
          }
          this.onk.zX(paramInt2);
          paramInt1 = paramInt2;
          break label857;
          label616:
          paramArrayList = paramArrayList.iterator();
          paramInt2 = paramInt1;
          if (!paramArrayList.hasNext()) {
            break label886;
          }
          localObject1 = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.next();
          f((com.tencent.mm.plugin.editor.model.a.a)localObject1);
          if (!b(paramInt2, (com.tencent.mm.plugin.editor.model.a.a)localObject1)) {
            break label843;
          }
          paramInt2 += 1;
          break label883;
        }
        if ((j - 1 >= 0) && (j - 1 < bSq().size()))
        {
          paramInt1 = j - 1;
          if (this.onk != null)
          {
            paramInt3 = j - i;
            paramInt2 = paramInt3;
            if (paramInt4 != 0) {
              paramInt2 = paramInt3 + 1;
            }
            if ((i >= 0) && (paramInt2 > 0)) {
              this.onk.eV(i, paramInt2);
            }
            if (i <= 0) {
              break label815;
            }
            this.onk.eW(i - 1, bSq().size() - (i - 1));
            this.onk.zY(paramInt1);
          }
          bSA();
          AppMethodBeat.o(181751);
          return paramInt1;
        }
      }
      finally
      {
        AppMethodBeat.o(181751);
      }
      paramInt1 = bSq().size() - 1;
      continue;
      label815:
      if (i == 0)
      {
        this.onk.eW(i, bSq().size() - i);
        continue;
        label843:
        break label883;
        label851:
        label854:
        label857:
        label871:
        do
        {
          paramInt1 = paramInt2;
          break label616;
          break label473;
          break;
          paramInt4 = 0;
          paramInt2 = paramInt1;
          paramInt3 = paramInt1;
          paramInt1 = paramInt4;
          break label468;
        } while (paramInt1 == 1);
        paramInt1 = paramInt2 + 1;
        continue;
        label883:
        continue;
        label886:
        paramInt4 = 0;
        j = paramInt2;
        i = paramInt1;
      }
    }
  }
  
  public final int a(ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList, WXRTEditText paramWXRTEditText, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(181750);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (this.hIH == null))
    {
      ad.e("MicroMsg.EditorDataManager", "insertItemList,error,return");
      AppMethodBeat.o(181750);
      return -1;
    }
    if ((paramBoolean2) && (I(paramArrayList)) && (this.onk != null))
    {
      this.onk.bRz();
      AppMethodBeat.o(181750);
      return -1;
    }
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.get(paramArrayList.size() - 1);
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).omx = -1;
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).omv = true;
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).omB = false;
      if ((paramWXRTEditText != null) && (paramWXRTEditText.ool))
      {
        if (paramWXRTEditText.getEditTextType() != 2) {
          break label261;
        }
        ((com.tencent.mm.plugin.editor.model.a.a)localObject1).omE = 2;
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
      paramWXRTEditText.ool = false;
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).omF = paramWXRTEditText.omF;
      paramWXRTEditText.omF = 0;
      if ((paramWXRTEditText == null) || (paramWXRTEditText.getRecyclerItemPosition() != 0)) {
        if (paramWXRTEditText != null) {
          break label621;
        }
      }
      try
      {
        n = size();
        bSu();
        paramArrayList = paramArrayList.iterator();
        i = n;
        for (;;)
        {
          if (paramArrayList.hasNext())
          {
            paramWXRTEditText = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.next();
            f(paramWXRTEditText);
            if ((paramWXRTEditText == null) || (this.hIH == null)) {
              break label1247;
            }
            this.hIH.add(paramWXRTEditText);
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
            ((com.tencent.mm.plugin.editor.model.a.a)localObject1).omE = 1;
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
            ((j)localObject1).omv = false;
            ((j)localObject1).omB = false;
            paramArrayList.add(0, localObject1);
            break label169;
          }
        }
        i1 = 0;
        if ((i - 1 < 0) || (i - 1 >= bSq().size())) {
          break;
        }
        j = i - 1;
        k = j;
        m = i;
        if (paramBoolean4)
        {
          j += 1;
          i += 1;
          bSu();
          if (j >= bSq().size()) {
            break label1142;
          }
          paramArrayList = bSq().Aa(j);
          k = j;
          m = i;
          if (paramArrayList != null)
          {
            paramArrayList.omx = 0;
            paramArrayList.omv = true;
            paramArrayList.omB = false;
            m = i;
            k = j;
          }
        }
        label502:
        if (this.onk != null)
        {
          j = m - n;
          i = j;
          if (i1 != 0) {
            i = j + 1;
          }
          if ((n >= 0) && (i > 0)) {
            this.onk.eV(n, i);
          }
          if (n <= 0) {
            break label1196;
          }
          this.onk.eW(n - 1, bSq().size() - (n - 1));
          if (paramBoolean3) {
            this.onk.bRy();
          }
          this.onk.zY(k);
        }
        label583:
        bSA();
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
    localObject2 = Aa(j);
    if (localObject2 == null)
    {
      AppMethodBeat.o(181750);
      return -1;
    }
    bSu();
    if ((paramWXRTEditText.getEditTextType() == 0) && (((com.tencent.mm.plugin.editor.model.a.a)localObject2).getType() == 1))
    {
      localObject1 = paramWXRTEditText.getSelection();
      localObject3 = paramWXRTEditText.getText();
      paramWXRTEditText = ((Editable)localObject3).subSequence(0, ((g)localObject1).asw);
      localObject3 = ((Editable)localObject3).subSequence(((g)localObject1).Mc, ((Editable)localObject3).length());
      localObject1 = com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)paramWXRTEditText);
      paramWXRTEditText = com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)localObject3);
      localObject2 = (j)localObject2;
      if (!bt.isNullOrNil((String)localObject1))
      {
        if (((String)localObject1).endsWith("<br/>"))
        {
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 5);
          label776:
          ((j)localObject2).content = ((String)localObject1);
          j += 1;
          i = j;
          if (bt.isNullOrNil(paramWXRTEditText)) {
            break label1266;
          }
          localObject2 = new j();
          ((j)localObject2).type = 1;
          localObject1 = paramWXRTEditText;
          if (paramWXRTEditText.startsWith("<br/>")) {
            localObject1 = paramWXRTEditText.substring(5, paramWXRTEditText.length());
          }
          ((j)localObject2).content = ((String)localObject1);
          ((j)localObject2).omx = 0;
          ((j)localObject2).omv = false;
          ((j)localObject2).omB = false;
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
          if (bt.isNullOrNil(paramWXRTEditText)) {
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
        Ab(j);
        i = j;
        if (this.onk == null) {
          break label1266;
        }
        this.onk.zX(j);
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
        j = bSq().size() - 1;
        break label418;
        paramArrayList = new j();
        paramArrayList.type = 1;
        paramArrayList.content = "";
        paramArrayList.omx = 0;
        paramArrayList.omv = true;
        paramArrayList.omB = false;
        b(j, paramArrayList);
        k = j;
        m = i;
        break label502;
        if (n != 0) {
          break label583;
        }
        this.onk.eW(n, bSq().size() - n);
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
        if ((this.hIH == null) || (paramInt < 0) || (paramInt > this.hIH.size())) {
          break label138;
        }
        this.hIH.add(paramInt, parama);
        a(parama, true);
        if ((bool) && (this.onk != null))
        {
          this.onk.zW(paramInt);
          if (paramInt > 0) {
            this.onk.eW(paramInt - 1, this.hIH.size() - (paramInt - 1));
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
      this.onk.eW(paramInt, this.hIH.size() - paramInt);
      continue;
      label138:
      bool = false;
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
        if (this.hIH == null) {
          break label174;
        }
        k = 0;
        j = 0;
        i = paramInt;
        paramInt = j;
        if ((k >= paramArrayList.size()) || (i < 0) || (i > this.hIH.size())) {
          break label203;
        }
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.get(k);
        j = paramInt;
        m = i;
        if (locala == null) {
          break label188;
        }
        f(locala);
        this.hIH.add(i, locala);
        j = paramInt + 1;
        m = i + 1;
        a(locala, true);
      }
      finally
      {
        AppMethodBeat.o(181731);
      }
      if ((bool) && (this.onk != null)) {
        this.onk.eV(i - paramInt, paramInt);
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
  
  public final void bSA()
  {
    AppMethodBeat.i(181756);
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
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
        c.a(c.this, com.tencent.mm.plugin.editor.b.ST(localObject.toString()));
        c.b(c.this, i);
        AppMethodBeat.o(181726);
      }
    });
    AppMethodBeat.o(181756);
  }
  
  public final int bSB()
  {
    AppMethodBeat.i(181759);
    try
    {
      if (this.hIH == null) {
        return -1;
      }
      int i = 0;
      while (i < this.hIH.size())
      {
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)this.hIH.get(i);
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
  
  public final int bSC()
  {
    AppMethodBeat.i(181760);
    try
    {
      if (this.hIH == null) {
        return -1;
      }
      int i = this.hIH.size() - 1;
      while (i >= 0)
      {
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)this.hIH.get(i);
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
  
  public final void bSr()
  {
    AppMethodBeat.i(181737);
    if (this.hIH != null) {}
    for (int i = this.hIH.size();; i = 0)
    {
      ad.i("MicroMsg.EditorDataManager", "clear mDataList, size:%d", new Object[] { Integer.valueOf(i) });
      try
      {
        if (this.hIH != null) {
          this.hIH.clear();
        }
        this.ono = 0;
        this.onn = 0;
        AppMethodBeat.o(181737);
        return;
      }
      finally
      {
        AppMethodBeat.o(181737);
      }
    }
  }
  
  public final int bSs()
  {
    AppMethodBeat.i(181739);
    for (;;)
    {
      try
      {
        if (this.hIH != null)
        {
          i = 0;
          if (i < this.hIH.size())
          {
            if (((com.tencent.mm.plugin.editor.model.a.a)this.hIH.get(i)).omv) {
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
  
  public final void bSt()
  {
    AppMethodBeat.i(181740);
    try
    {
      if (this.hIH != null)
      {
        Iterator localIterator = this.hIH.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)localIterator.next();
          locala.omv = false;
          locala.omB = false;
        }
      }
    }
    finally
    {
      AppMethodBeat.o(181740);
    }
    AppMethodBeat.o(181740);
  }
  
  public final int bSv()
  {
    AppMethodBeat.i(181743);
    for (;;)
    {
      try
      {
        if (this.hIH != null)
        {
          i = 0;
          if (i < this.hIH.size())
          {
            if ((((com.tencent.mm.plugin.editor.model.a.a)this.hIH.get(i)).getType() == 4) && (((m)this.hIH.get(i)).omS.booleanValue())) {
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
  
  public final String bSw()
  {
    AppMethodBeat.i(181744);
    for (;;)
    {
      try
      {
        if ((this.onm != 0) || (this.hIH == null)) {
          break;
        }
        Iterator localIterator = this.hIH.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        d locald = (d)localIterator.next();
        if (locald.omI.startsWith("WeNote_"))
        {
          i = bt.getInt(locald.omI.substring(7), -1);
          if (i > this.onm) {
            this.onm = i;
          } else {
            i = this.onm;
          }
        }
      }
      finally
      {
        AppMethodBeat.o(181744);
      }
    }
    Object localObject2 = new StringBuilder("WeNote_");
    int i = this.onm + 1;
    this.onm = i;
    localObject2 = i;
    AppMethodBeat.o(181744);
    return localObject2;
  }
  
  public final String bSy()
  {
    AppMethodBeat.i(181746);
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i;
      Object localObject3;
      try
      {
        if ((this.hIH == null) || (this.hIH.size() <= 0)) {
          return "";
        }
        i = 0;
        if (i >= this.hIH.size()) {
          break label301;
        }
        localObject3 = (com.tencent.mm.plugin.editor.model.a.a)this.hIH.get(i);
        switch (((com.tencent.mm.plugin.editor.model.a.a)localObject3).getType())
        {
        case 1: 
          localObject3 = (j)localObject3;
          if (bt.isNullOrNil(((j)localObject3).content)) {
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
      if ((i + 1 < this.hIH.size()) && (((com.tencent.mm.plugin.editor.model.a.a)this.hIH.get(i + 1)).getType() == 1) && (!bt.isNullOrNil(((j)this.hIH.get(i + 1)).content)))
      {
        localObject1.append("<br/>");
        break label337;
        localObject1.append(cH(((h)localObject3).omI, 2));
        break label337;
        localObject1.append(cH(((l)localObject3).omI, 6));
        break label337;
        localObject1.append(cH(((m)localObject3).omI, 4));
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
  
  public final ArrayList<com.tencent.mm.plugin.editor.model.a.a> bSz()
  {
    AppMethodBeat.i(181753);
    if (this.hIH == null)
    {
      AppMethodBeat.o(181753);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = this.hIH.iterator();
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
  
  public final boolean e(com.tencent.mm.plugin.editor.model.a.a parama)
  {
    boolean bool = true;
    AppMethodBeat.i(181730);
    if (parama != null) {}
    for (;;)
    {
      try
      {
        if (this.hIH != null)
        {
          this.hIH.add(parama);
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
  
  public final boolean eY(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {}
    for (int i = 0;; i = 1)
    {
      if (paramInt2 < 0) {}
      for (int j = 0;; j = 1)
      {
        if ((i != 0) && (this.onn + paramInt1 > 16384)) {}
        while ((j != 0) && (this.ono + paramInt2 > 30)) {
          return true;
        }
        return false;
      }
    }
  }
  
  public final void eZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181758);
    ad.i("MicroMsg.EditorDataManager", "checkMergeTextDataItem startPos: %d endPos: %d needNotify: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.TRUE });
    for (;;)
    {
      Object localObject3;
      int i;
      Spanned localSpanned2;
      try
      {
        if (this.hIH == null) {
          return;
        }
        int j = paramInt1;
        if (paramInt1 <= 0) {
          j = 0;
        }
        if (paramInt2 < this.hIH.size()) {
          break label487;
        }
        paramInt2 = this.hIH.size() - 1;
        paramInt1 = -1;
        if (paramInt2 <= j) {
          break label443;
        }
        Object localObject1 = (com.tencent.mm.plugin.editor.model.a.a)this.hIH.get(paramInt2);
        localObject3 = (com.tencent.mm.plugin.editor.model.a.a)this.hIH.get(paramInt2 - 1);
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
        if (bt.isNullOrNil(((j)localObject1).content)) {
          break label414;
        }
        Spanned localSpanned1 = com.tencent.mm.plugin.editor.model.nativenote.a.a.Tc(((j)localObject1).content);
        localSpanned2 = com.tencent.mm.plugin.editor.model.nativenote.a.a.Tc(((j)localObject3).content);
        ((j)localObject3).content = (((j)localObject3).content + "<br/>" + ((j)localObject1).content);
        if (((j)localObject1).omv)
        {
          ((j)localObject3).omv = true;
          ((j)localObject3).omB = false;
          if ((((j)localObject1).omx == -1) || (((j)localObject1).omx >= localSpanned1.length()))
          {
            ((j)localObject3).omx = -1;
            ad.i("MicroMsg.EditorDataManager", "checkMergeTextDataItem remove position: %d", new Object[] { Integer.valueOf(paramInt2) });
            Ab(paramInt2);
            i = paramInt1;
            if (this.onk == null) {
              break label492;
            }
            this.onk.zX(paramInt2);
            i = paramInt1;
            break label492;
          }
          i = localSpanned2.length();
          ((j)localObject1).omx += i + 1;
          continue;
        }
        if (!((j)localObject3).omv) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(181758);
      }
      if (((j)localObject3).omx == -1)
      {
        ((j)localObject3).omx = localSpanned2.length();
        continue;
        label414:
        if (localObject2.omv)
        {
          ((j)localObject3).omv = true;
          ((j)localObject3).omB = false;
          ((j)localObject3).omx = -1;
          continue;
          label443:
          if ((paramInt1 != -1) && (this.onk != null)) {
            this.onk.eW(paramInt1, this.hIH.size() - paramInt1);
          }
          bSA();
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
    if (this.hIH != null)
    {
      int i = this.hIH.size();
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