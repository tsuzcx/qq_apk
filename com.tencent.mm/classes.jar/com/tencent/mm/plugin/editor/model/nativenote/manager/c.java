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
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static volatile c oQJ = null;
  public ArrayList<com.tencent.mm.plugin.editor.model.a.a> ijj = null;
  public com.tencent.mm.plugin.editor.model.nativenote.b.a oQK = null;
  public agx oQL = null;
  public int oQM = 0;
  public int oQN = 0;
  public int oQO = 0;
  
  private boolean AT(int paramInt)
  {
    AppMethodBeat.i(181735);
    if ((this.ijj != null) && (paramInt >= 0) && (paramInt < this.ijj.size()))
    {
      a((com.tencent.mm.plugin.editor.model.a.a)this.ijj.get(paramInt), false);
      this.ijj.remove(paramInt);
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
      int i = com.tencent.mm.plugin.editor.b.Xf(((j)parama).content);
      if (paramBoolean)
      {
        this.oQN = (i + this.oQN);
        AppMethodBeat.o(181757);
        return;
      }
      this.oQN -= i;
      AppMethodBeat.o(181757);
      return;
    }
    if (paramBoolean)
    {
      this.oQO += 1;
      AppMethodBeat.o(181757);
      return;
    }
    this.oQO -= 1;
    AppMethodBeat.o(181757);
  }
  
  private boolean b(int paramInt, com.tencent.mm.plugin.editor.model.a.a parama)
  {
    boolean bool = true;
    AppMethodBeat.i(181733);
    if ((parama != null) && (this.ijj != null) && (paramInt >= 0) && (paramInt <= this.ijj.size()))
    {
      this.ijj.add(paramInt, parama);
      a(parama, true);
    }
    for (;;)
    {
      AppMethodBeat.o(181733);
      return bool;
      bool = false;
    }
  }
  
  public static c bZF()
  {
    AppMethodBeat.i(181727);
    if (oQJ == null) {}
    try
    {
      if (oQJ == null) {
        oQJ = new c();
      }
      c localc = oQJ;
      AppMethodBeat.o(181727);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(181727);
    }
  }
  
  private void bZJ()
  {
    AppMethodBeat.i(181741);
    if (this.ijj != null)
    {
      Iterator localIterator = this.ijj.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)localIterator.next();
        locala.oPV = false;
        locala.oQb = false;
      }
    }
    AppMethodBeat.o(181741);
  }
  
  private String bZM()
  {
    AppMethodBeat.i(181745);
    if ((this.oQM == 0) && (this.ijj != null))
    {
      localObject = this.ijj.iterator();
      while (((Iterator)localObject).hasNext())
      {
        d locald = (d)((Iterator)localObject).next();
        if (locald.oQi.startsWith("WeNote_"))
        {
          i = bs.getInt(locald.oQi.substring(7), -1);
          if (i > this.oQM) {}
          for (;;)
          {
            this.oQM = i;
            break;
            i = this.oQM;
          }
        }
      }
    }
    Object localObject = new StringBuilder("WeNote_");
    int i = this.oQM + 1;
    this.oQM = i;
    localObject = i;
    AppMethodBeat.o(181745);
    return localObject;
  }
  
  private static String cM(String paramString, int paramInt)
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
    if ((locald.getType() > 1) && (bs.isNullOrNil(locald.oQi))) {
      locald.oQi = bZM();
    }
    if (bs.isNullOrNil(parama.dhw)) {
      parama.dhw = com.tencent.mm.plugin.editor.model.b.Xn(parama.toString());
    }
    AppMethodBeat.o(181752);
  }
  
  public final com.tencent.mm.plugin.editor.model.a.a AS(int paramInt)
  {
    AppMethodBeat.i(181729);
    if ((this.ijj != null) && (paramInt >= 0) && (paramInt < this.ijj.size()))
    {
      com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)this.ijj.get(paramInt);
      AppMethodBeat.o(181729);
      return locala;
    }
    AppMethodBeat.o(181729);
    return null;
  }
  
  public final void AU(int paramInt)
  {
    AppMethodBeat.i(181736);
    if (this.oQK != null) {
      this.oQK.AN(paramInt);
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
        if (this.ijj == null) {
          return;
        }
        Iterator localIterator = this.ijj.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        locala = (com.tencent.mm.plugin.editor.model.a.a)localIterator.next();
        if (locala.oQa != null)
        {
          paramArrayList.add(locala.oQa);
          continue;
        }
        if (locala.oPY == null) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(181754);
      }
      if (locala.oPZ != null)
      {
        paramArrayList.add(locala.oPY);
        paramArrayList.add(locala.oPZ);
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
    boolean bool = fb(com.tencent.mm.plugin.editor.b.Xf(localStringBuilder.toString()), i);
    AppMethodBeat.o(181755);
    return bool;
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
        if (this.ijj != null)
        {
          bool1 = bool2;
          if (paramInt >= 0)
          {
            bool1 = bool2;
            if (paramInt < this.ijj.size())
            {
              a((com.tencent.mm.plugin.editor.model.a.a)this.ijj.get(paramInt), false);
              this.ijj.remove(paramInt);
              bool1 = true;
            }
          }
        }
        if ((bool1) && (paramBoolean) && (this.oQK != null))
        {
          this.oQK.AP(paramInt);
          if (paramInt > 0) {
            this.oQK.eZ(paramInt - 1, this.ijj.size() - (paramInt - 1));
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
      this.oQK.eZ(paramInt, this.ijj.size() - paramInt);
    }
  }
  
  public final void X(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(181738);
    for (;;)
    {
      try
      {
        if (this.ijj == null) {
          return;
        }
        if ((paramInt >= 0) && (paramInt < this.ijj.size()))
        {
          locala = (com.tencent.mm.plugin.editor.model.a.a)this.ijj.get(paramInt);
          if ((locala != null) && (locala.oQc != paramBoolean))
          {
            locala.oQc = paramBoolean;
            if (this.oQK != null) {
              this.oQK.AN(paramInt);
            }
          }
          return;
        }
        if (paramInt != -1) {
          continue;
        }
        paramInt = 0;
        if (paramInt >= this.ijj.size()) {
          continue;
        }
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)this.ijj.get(paramInt);
        if ((locala != null) && (locala.oQc != paramBoolean))
        {
          locala.oQc = paramBoolean;
          if (this.oQK != null) {
            this.oQK.AN(paramInt);
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
  
  public final ahn Xq(String paramString)
  {
    AppMethodBeat.i(181748);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.EditorDataManager", "getFavProtoItem error, htmlstr is null or nil");
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
        if (i >= this.ijj.size()) {
          break label796;
        }
        localObject1 = (com.tencent.mm.plugin.editor.model.a.a)this.ijj.get(i);
        if (bs.isNullOrNil(((com.tencent.mm.plugin.editor.model.a.a)localObject1).dhw)) {
          ((com.tencent.mm.plugin.editor.model.a.a)localObject1).dhw = com.tencent.mm.plugin.editor.model.b.Xn(localObject1.toString());
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
            ((j)localObject2).dhw = ((com.tencent.mm.plugin.editor.model.a.a)localObject1).dhw;
            ((j)localObject2).oQi = "-1";
            ((j)localObject2).type = 1;
            ((j)localObject2).oQh = null;
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
        if (((((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType() == 6) || (((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType() == 4)) && (bs.isNullOrNil(((d)localObject1).dpK)))
        {
          localObject2 = new agx();
          ((agx)localObject2).aIP(((com.tencent.mm.plugin.editor.model.a.a)localObject1).dhw);
          ((agx)localObject2).aIM(((com.tencent.mm.plugin.editor.model.a.a)localObject1).bZx());
          localObject2 = com.tencent.mm.plugin.editor.model.b.b((agx)localObject2);
          if (i.eA((String)localObject2))
          {
            ac.e("MicroMsg.EditorDataManager", "getFavProtoItem, type = %d, localfile exist, but localpath is null or nil, set path here", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType()) });
            ((d)localObject1).dpK = ((String)localObject2);
          }
        }
        if (((com.tencent.mm.plugin.editor.model.a.a)localObject1).getType() != 1)
        {
          localArrayList.add((d)localObject1);
        }
        else
        {
          localObject1 = (j)localObject1;
          if (bs.isNullOrNil(((j)localObject1).content))
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
              ((j)localObject2).dhw = ((j)localObject1).dhw;
              ((j)localObject2).oQi = ((j)localObject1).oQi;
              ((j)localObject2).type = ((j)localObject1).type;
              ((j)localObject2).oQh = null;
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
            while ((i + 1 < this.ijj.size()) && (((com.tencent.mm.plugin.editor.model.a.a)this.ijj.get(i + 1)).getType() == 1) && (!bs.isNullOrNil(((j)this.ijj.get(i + 1)).content)))
            {
              localObject1 = new StringBuilder();
              localObject2 = (j)localArrayList.get(localArrayList.size() - 1);
              ((j)localObject2).content += "<br/>";
              break;
              localObject2 = new j();
              ((j)localObject2).content = ((j)localObject1).content;
              ((j)localObject2).dhw = ((j)localObject1).dhw;
              ((j)localObject2).oQi = ((j)localObject1).oQi;
              ((j)localObject2).type = ((j)localObject1).type;
              ((j)localObject2).oQh = null;
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
                    ((e)localObject3).createNewFile();
                    if ((i != 0) || (i.f((String)localObject2, paramString, paramString.length) != 0)) {
                      break;
                    }
                    this.oQL.aIQ((String)localObject2);
                    ac.i("MicroMsg.EditorDataManager", "do EditorBase.ConvertNote2FavProtoItem");
                    paramString = com.tencent.mm.plugin.editor.model.a.a((String)localObject1, localArrayList, this.oQL);
                    AppMethodBeat.o(181748);
                    return paramString;
                  }
                  catch (IOException paramString)
                  {
                    ac.printErrStackTrace("MicroMsg.EditorDataManager", paramString, "", new Object[0]);
                    AppMethodBeat.o(181748);
                    return null;
                  }
                  paramString = paramString;
                  ac.printErrStackTrace("MicroMsg.EditorDataManager", paramString, "", new Object[0]);
                  ac.e("MicroMsg.EditorDataManager", "writehtmlfile, use utf-8 encoding error, use default encoding");
                  i = 1;
                  paramString = null;
                }
              }
              this.oQL.XM(8);
              this.oQL.aIZ("WeNoteHtmlFile");
              this.oQL.vz(true);
              this.oQL.aIM(".htm");
              this.oQL.aIP(com.tencent.mm.plugin.editor.model.b.Xn(this.oQL.toString()));
              localObject2 = com.tencent.mm.plugin.editor.model.b.b(this.oQL);
              ac.i("MicroMsg.EditorDataManager", "getFavProtoItem: save note html file, path is %s", new Object[] { localObject2 });
              localObject3 = new e((String)localObject2);
              if (((e)localObject3).exists()) {
                ((e)localObject3).delete();
              }
              if (!((e)localObject3).exists()) {}
              ac.i("MicroMsg.EditorDataManager", "writefile error, return");
              Toast.makeText(ai.getContext(), ai.getContext().getString(2131758993), 1).show();
              AppMethodBeat.o(181748);
              return null;
            }
          }
        }
      }
      i += 1;
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
        if ((this.ijj == null) || (paramInt < 0) || (paramInt >= this.ijj.size())) {
          return;
        }
        i = 0;
        if (i < this.ijj.size()) {
          if (i == paramInt)
          {
            ((com.tencent.mm.plugin.editor.model.a.a)this.ijj.get(i)).oPV = true;
            ((com.tencent.mm.plugin.editor.model.a.a)this.ijj.get(i)).oQb = paramBoolean;
          }
          else
          {
            ((com.tencent.mm.plugin.editor.model.a.a)this.ijj.get(i)).oPV = false;
            ((com.tencent.mm.plugin.editor.model.a.a)this.ijj.get(i)).oQb = false;
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
    if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (this.ijj == null) || (paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0) || (paramInt4 < paramInt3))
    {
      ac.e("MicroMsg.EditorDataManager", "pasteItemList,error,return");
      AppMethodBeat.o(181751);
      return -1;
    }
    Object localObject1 = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.get(paramArrayList.size() - 1);
    if (localObject1 == null)
    {
      ac.e("MicroMsg.EditorDataManager", "pasteItemList, lastInsertItem is null");
      AppMethodBeat.o(181751);
      return -1;
    }
    ((com.tencent.mm.plugin.editor.model.a.a)localObject1).oPX = -1;
    ((com.tencent.mm.plugin.editor.model.a.a)localObject1).oPV = true;
    ((com.tencent.mm.plugin.editor.model.a.a)localObject1).oQb = false;
    Object localObject3 = AS(paramInt2);
    if (localObject3 == null)
    {
      ac.e("MicroMsg.EditorDataManager", "pasteItemList, item is null");
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
        bZJ();
        if ((paramInt1 != 0) || (((com.tencent.mm.plugin.editor.model.a.a)localObject3).getType() != 1)) {
          break label875;
        }
        Object localObject2 = com.tencent.mm.plugin.editor.model.nativenote.a.a.Xo(((j)localObject3).content);
        if ((localObject2 == null) || (paramInt3 > ((Spanned)localObject2).length()) || (paramInt4 > ((Spanned)localObject2).length()))
        {
          if (localObject2 == null)
          {
            paramInt1 = -1;
            ac.e("MicroMsg.EditorDataManager", "pasteItemList error, oriText:%d  startOff:%d  endOff:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
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
        if (!bs.isNullOrNil((String)localObject2))
        {
          if (!((String)localObject2).endsWith("<br/>")) {
            break label858;
          }
          localObject2 = ((String)localObject2).substring(0, ((String)localObject2).length() - 5);
          ((j)localObject3).content = ((String)localObject2);
          paramInt2 += 1;
          paramInt1 = paramInt2;
          if (bs.isNullOrNil((String)localObject1)) {
            break label861;
          }
          localObject3 = new j();
          ((j)localObject3).type = 1;
          localObject2 = localObject1;
          if (((String)localObject1).startsWith("<br/>")) {
            localObject2 = ((String)localObject1).substring(5, ((String)localObject1).length());
          }
          ((j)localObject3).content = ((String)localObject2);
          ((j)localObject3).oPX = 0;
          ((j)localObject3).oPV = false;
          ((j)localObject3).oQb = false;
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
          if (!bs.isNullOrNil((String)localObject1))
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
          AT(paramInt2);
          paramInt1 = paramInt2;
          if (this.oQK == null) {
            break label861;
          }
          this.oQK.AP(paramInt2);
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
        if ((j - 1 >= 0) && (j - 1 < bZF().size()))
        {
          paramInt1 = j - 1;
          if (this.oQK != null)
          {
            paramInt3 = j - i;
            paramInt2 = paramInt3;
            if (paramInt4 != 0) {
              paramInt2 = paramInt3 + 1;
            }
            if ((i >= 0) && (paramInt2 > 0)) {
              this.oQK.eY(i, paramInt2);
            }
            if (i <= 0) {
              break label819;
            }
            this.oQK.eZ(i - 1, bZF().size() - (i - 1));
            this.oQK.AQ(paramInt1);
          }
          bZP();
          AppMethodBeat.o(181751);
          return paramInt1;
        }
      }
      finally
      {
        AppMethodBeat.o(181751);
      }
      paramInt1 = bZF().size() - 1;
      continue;
      label819:
      if (i == 0)
      {
        this.oQK.eZ(i, bZF().size() - i);
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
    if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (this.ijj == null))
    {
      ac.e("MicroMsg.EditorDataManager", "insertItemList,error,return");
      AppMethodBeat.o(181750);
      return -1;
    }
    if ((paramBoolean2) && (N(paramArrayList)) && (this.oQK != null))
    {
      this.oQK.bYO();
      AppMethodBeat.o(181750);
      return -1;
    }
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.get(paramArrayList.size() - 1);
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).oPX = -1;
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).oPV = true;
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).oQb = false;
      if ((paramWXRTEditText != null) && (paramWXRTEditText.oRL))
      {
        if (paramWXRTEditText.getEditTextType() != 2) {
          break label262;
        }
        ((com.tencent.mm.plugin.editor.model.a.a)localObject1).oQe = 2;
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
      paramWXRTEditText.oRL = false;
      ((com.tencent.mm.plugin.editor.model.a.a)localObject1).oQf = paramWXRTEditText.oQf;
      paramWXRTEditText.oQf = 0;
      if ((paramWXRTEditText == null) || (paramWXRTEditText.getRecyclerItemPosition() != 0)) {
        if (paramWXRTEditText != null) {
          break label622;
        }
      }
      try
      {
        n = size();
        bZJ();
        paramArrayList = paramArrayList.iterator();
        i = n;
        for (;;)
        {
          if (paramArrayList.hasNext())
          {
            paramWXRTEditText = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.next();
            f(paramWXRTEditText);
            if ((paramWXRTEditText == null) || (this.ijj == null)) {
              break label1248;
            }
            this.ijj.add(paramWXRTEditText);
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
            ((com.tencent.mm.plugin.editor.model.a.a)localObject1).oQe = 1;
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
            ((j)localObject1).oPV = false;
            ((j)localObject1).oQb = false;
            paramArrayList.add(0, localObject1);
            break label170;
          }
        }
        i1 = 0;
        if ((i - 1 < 0) || (i - 1 >= bZF().size())) {
          break;
        }
        j = i - 1;
        k = j;
        m = i;
        if (paramBoolean4)
        {
          j += 1;
          i += 1;
          bZJ();
          if (j >= bZF().size()) {
            break label1143;
          }
          paramArrayList = bZF().AS(j);
          k = j;
          m = i;
          if (paramArrayList != null)
          {
            paramArrayList.oPX = 0;
            paramArrayList.oPV = true;
            paramArrayList.oQb = false;
            m = i;
            k = j;
          }
        }
        label503:
        if (this.oQK != null)
        {
          j = m - n;
          i = j;
          if (i1 != 0) {
            i = j + 1;
          }
          if ((n >= 0) && (i > 0)) {
            this.oQK.eY(n, i);
          }
          if (n <= 0) {
            break label1197;
          }
          this.oQK.eZ(n - 1, bZF().size() - (n - 1));
          if (paramBoolean3) {
            this.oQK.bYN();
          }
          this.oQK.AQ(k);
        }
        label584:
        bZP();
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
    localObject2 = AS(j);
    if (localObject2 == null)
    {
      AppMethodBeat.o(181750);
      return -1;
    }
    bZJ();
    if ((paramWXRTEditText.getEditTextType() == 0) && (((com.tencent.mm.plugin.editor.model.a.a)localObject2).getType() == 1))
    {
      localObject1 = paramWXRTEditText.getSelection();
      localObject3 = paramWXRTEditText.getText();
      paramWXRTEditText = ((Editable)localObject3).subSequence(0, ((g)localObject1).atr);
      localObject3 = ((Editable)localObject3).subSequence(((g)localObject1).MZ, ((Editable)localObject3).length());
      localObject1 = com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)paramWXRTEditText);
      paramWXRTEditText = com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)localObject3);
      localObject2 = (j)localObject2;
      if (!bs.isNullOrNil((String)localObject1))
      {
        if (((String)localObject1).endsWith("<br/>"))
        {
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 5);
          label777:
          ((j)localObject2).content = ((String)localObject1);
          j += 1;
          i = j;
          if (bs.isNullOrNil(paramWXRTEditText)) {
            break label1267;
          }
          localObject2 = new j();
          ((j)localObject2).type = 1;
          localObject1 = paramWXRTEditText;
          if (paramWXRTEditText.startsWith("<br/>")) {
            localObject1 = paramWXRTEditText.substring(5, paramWXRTEditText.length());
          }
          ((j)localObject2).content = ((String)localObject1);
          ((j)localObject2).oPX = 0;
          ((j)localObject2).oPV = false;
          ((j)localObject2).oQb = false;
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
          if (bs.isNullOrNil(paramWXRTEditText)) {
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
        AT(j);
        i = j;
        if (this.oQK == null) {
          break label1267;
        }
        this.oQK.AP(j);
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
        j = bZF().size() - 1;
        break label419;
        paramArrayList = new j();
        paramArrayList.type = 1;
        paramArrayList.content = "";
        paramArrayList.oPX = 0;
        paramArrayList.oPV = true;
        paramArrayList.oQb = false;
        b(j, paramArrayList);
        k = j;
        m = i;
        break label503;
        if (n != 0) {
          break label584;
        }
        this.oQK.eZ(n, bZF().size() - n);
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
        if ((this.ijj == null) || (paramInt < 0) || (paramInt > this.ijj.size())) {
          break label138;
        }
        this.ijj.add(paramInt, parama);
        a(parama, true);
        if ((bool) && (this.oQK != null))
        {
          this.oQK.AO(paramInt);
          if (paramInt > 0) {
            this.oQK.eZ(paramInt - 1, this.ijj.size() - (paramInt - 1));
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
      this.oQK.eZ(paramInt, this.ijj.size() - paramInt);
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
        if (this.ijj == null) {
          break label174;
        }
        k = 0;
        j = 0;
        i = paramInt;
        paramInt = j;
        if ((k >= paramArrayList.size()) || (i < 0) || (i > this.ijj.size())) {
          break label203;
        }
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)paramArrayList.get(k);
        j = paramInt;
        m = i;
        if (locala == null) {
          break label188;
        }
        f(locala);
        this.ijj.add(i, locala);
        j = paramInt + 1;
        m = i + 1;
        a(locala, true);
      }
      finally
      {
        AppMethodBeat.o(181731);
      }
      if ((bool) && (this.oQK != null)) {
        this.oQK.eY(i - paramInt, paramInt);
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
  
  public final void bZG()
  {
    AppMethodBeat.i(181737);
    if (this.ijj != null) {}
    for (int i = this.ijj.size();; i = 0)
    {
      ac.i("MicroMsg.EditorDataManager", "clear mDataList, size:%d", new Object[] { Integer.valueOf(i) });
      try
      {
        if (this.ijj != null) {
          this.ijj.clear();
        }
        this.oQO = 0;
        this.oQN = 0;
        AppMethodBeat.o(181737);
        return;
      }
      finally
      {
        AppMethodBeat.o(181737);
      }
    }
  }
  
  public final int bZH()
  {
    AppMethodBeat.i(181739);
    for (;;)
    {
      try
      {
        if (this.ijj != null)
        {
          i = 0;
          if (i < this.ijj.size())
          {
            if (((com.tencent.mm.plugin.editor.model.a.a)this.ijj.get(i)).oPV) {
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
  
  public final void bZI()
  {
    AppMethodBeat.i(181740);
    try
    {
      if (this.ijj != null)
      {
        Iterator localIterator = this.ijj.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)localIterator.next();
          locala.oPV = false;
          locala.oQb = false;
        }
      }
    }
    finally
    {
      AppMethodBeat.o(181740);
    }
    AppMethodBeat.o(181740);
  }
  
  public final int bZK()
  {
    AppMethodBeat.i(181743);
    for (;;)
    {
      try
      {
        if (this.ijj != null)
        {
          i = 0;
          if (i < this.ijj.size())
          {
            if ((((com.tencent.mm.plugin.editor.model.a.a)this.ijj.get(i)).getType() == 4) && (((m)this.ijj.get(i)).oQs.booleanValue())) {
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
  
  public final String bZL()
  {
    AppMethodBeat.i(181744);
    for (;;)
    {
      try
      {
        if ((this.oQM != 0) || (this.ijj == null)) {
          break;
        }
        Iterator localIterator = this.ijj.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        d locald = (d)localIterator.next();
        if (locald.oQi.startsWith("WeNote_"))
        {
          i = bs.getInt(locald.oQi.substring(7), -1);
          if (i > this.oQM) {
            this.oQM = i;
          } else {
            i = this.oQM;
          }
        }
      }
      finally
      {
        AppMethodBeat.o(181744);
      }
    }
    Object localObject2 = new StringBuilder("WeNote_");
    int i = this.oQM + 1;
    this.oQM = i;
    localObject2 = i;
    AppMethodBeat.o(181744);
    return localObject2;
  }
  
  public final String bZN()
  {
    AppMethodBeat.i(181746);
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i;
      Object localObject3;
      try
      {
        if ((this.ijj == null) || (this.ijj.size() <= 0)) {
          return "";
        }
        i = 0;
        if (i >= this.ijj.size()) {
          break label301;
        }
        localObject3 = (com.tencent.mm.plugin.editor.model.a.a)this.ijj.get(i);
        switch (((com.tencent.mm.plugin.editor.model.a.a)localObject3).getType())
        {
        case 1: 
          localObject3 = (j)localObject3;
          if (bs.isNullOrNil(((j)localObject3).content)) {
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
      if ((i + 1 < this.ijj.size()) && (((com.tencent.mm.plugin.editor.model.a.a)this.ijj.get(i + 1)).getType() == 1) && (!bs.isNullOrNil(((j)this.ijj.get(i + 1)).content)))
      {
        localObject1.append("<br/>");
        break label337;
        localObject1.append(cM(((h)localObject3).oQi, 2));
        break label337;
        localObject1.append(cM(((l)localObject3).oQi, 6));
        break label337;
        localObject1.append(cM(((m)localObject3).oQi, 4));
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
  
  public final ArrayList<com.tencent.mm.plugin.editor.model.a.a> bZO()
  {
    AppMethodBeat.i(181753);
    if (this.ijj == null)
    {
      AppMethodBeat.o(181753);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = this.ijj.iterator();
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
  
  public final void bZP()
  {
    AppMethodBeat.i(181756);
    com.tencent.mm.kernel.g.agU().az(new Runnable()
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
        c.a(c.this, com.tencent.mm.plugin.editor.b.Xf(localObject.toString()));
        c.b(c.this, i);
        AppMethodBeat.o(181726);
      }
    });
    AppMethodBeat.o(181756);
  }
  
  public final int bZQ()
  {
    AppMethodBeat.i(181759);
    try
    {
      if (this.ijj == null) {
        return -1;
      }
      int i = 0;
      while (i < this.ijj.size())
      {
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)this.ijj.get(i);
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
  
  public final int bZR()
  {
    AppMethodBeat.i(181760);
    try
    {
      if (this.ijj == null) {
        return -1;
      }
      int i = this.ijj.size() - 1;
      while (i >= 0)
      {
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)this.ijj.get(i);
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
        if (this.ijj != null)
        {
          this.ijj.add(parama);
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
  
  public final boolean fb(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {}
    for (int i = 0;; i = 1)
    {
      if (paramInt2 < 0) {}
      for (int j = 0;; j = 1)
      {
        if ((i != 0) && (this.oQN + paramInt1 > 16384)) {}
        while ((j != 0) && (this.oQO + paramInt2 > 30)) {
          return true;
        }
        return false;
      }
    }
  }
  
  public final void fc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181758);
    ac.i("MicroMsg.EditorDataManager", "checkMergeTextDataItem startPos: %d endPos: %d needNotify: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.TRUE });
    for (;;)
    {
      Object localObject3;
      int i;
      Spanned localSpanned2;
      try
      {
        if (this.ijj == null) {
          return;
        }
        int j = paramInt1;
        if (paramInt1 <= 0) {
          j = 0;
        }
        if (paramInt2 < this.ijj.size()) {
          break label489;
        }
        paramInt2 = this.ijj.size() - 1;
        paramInt1 = -1;
        if (paramInt2 <= j) {
          break label445;
        }
        Object localObject1 = (com.tencent.mm.plugin.editor.model.a.a)this.ijj.get(paramInt2);
        localObject3 = (com.tencent.mm.plugin.editor.model.a.a)this.ijj.get(paramInt2 - 1);
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
        if (bs.isNullOrNil(((j)localObject1).content)) {
          break label416;
        }
        Spanned localSpanned1 = com.tencent.mm.plugin.editor.model.nativenote.a.a.Xo(((j)localObject1).content);
        localSpanned2 = com.tencent.mm.plugin.editor.model.nativenote.a.a.Xo(((j)localObject3).content);
        ((j)localObject3).content = (((j)localObject3).content + "<br/>" + ((j)localObject1).content);
        if (((j)localObject1).oPV)
        {
          ((j)localObject3).oPV = true;
          ((j)localObject3).oQb = false;
          if ((((j)localObject1).oPX == -1) || (((j)localObject1).oPX >= localSpanned1.length()))
          {
            ((j)localObject3).oPX = -1;
            ac.i("MicroMsg.EditorDataManager", "checkMergeTextDataItem remove position: %d", new Object[] { Integer.valueOf(paramInt2) });
            AT(paramInt2);
            i = paramInt1;
            if (this.oQK == null) {
              break label494;
            }
            this.oQK.AP(paramInt2);
            i = paramInt1;
            break label494;
          }
          i = localSpanned2.length();
          ((j)localObject1).oPX += i + 1;
          continue;
        }
        if (!((j)localObject3).oPV) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(181758);
      }
      if (((j)localObject3).oPX == -1)
      {
        ((j)localObject3).oPX = localSpanned2.length();
        continue;
        label416:
        if (localObject2.oPV)
        {
          ((j)localObject3).oPV = true;
          ((j)localObject3).oQb = false;
          ((j)localObject3).oPX = -1;
          continue;
          label445:
          if ((paramInt1 != -1) && (this.oQK != null)) {
            this.oQK.eZ(paramInt1, this.ijj.size() - paramInt1);
          }
          bZP();
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
    if (this.ijj != null)
    {
      int i = this.ijj.size();
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