package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b
{
  public static ArrayList<com.tencent.mm.plugin.editor.model.a.a> dataList;
  private static String oni;
  
  public static ArrayList<com.tencent.mm.plugin.editor.model.a.a> bSm()
  {
    AppMethodBeat.i(181720);
    ArrayList localArrayList = new ArrayList();
    if (dataList == null)
    {
      AppMethodBeat.o(181720);
      return localArrayList;
    }
    Iterator localIterator = dataList.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.b.a((com.tencent.mm.plugin.editor.model.a.a)localIterator.next());
      if (d(locala)) {
        localArrayList.add(locala);
      }
    }
    AppMethodBeat.o(181720);
    return localArrayList;
  }
  
  private static Set<String> bSn()
  {
    AppMethodBeat.i(181722);
    HashSet localHashSet = new HashSet();
    if (dataList == null)
    {
      AppMethodBeat.o(181722);
      return localHashSet;
    }
    Iterator localIterator = dataList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (com.tencent.mm.plugin.editor.model.a.a)localIterator.next();
      String str = com.tencent.mm.plugin.editor.b.b((com.tencent.mm.plugin.editor.model.a.a)localObject);
      if (!bt.isNullOrNil(str)) {
        localHashSet.add(str);
      }
      localObject = com.tencent.mm.plugin.editor.b.c((com.tencent.mm.plugin.editor.model.a.a)localObject);
      if (!bt.isNullOrNil((String)localObject)) {
        localHashSet.add(localObject);
      }
    }
    AppMethodBeat.o(181722);
    return localHashSet;
  }
  
  public static boolean bSo()
  {
    AppMethodBeat.i(181724);
    ClipboardManager localClipboardManager = (ClipboardManager)aj.getContext().getSystemService("clipboard");
    if (localClipboardManager.getText().length() >= 16384)
    {
      AppMethodBeat.o(181724);
      return true;
    }
    if (com.tencent.mm.plugin.editor.b.SU(localClipboardManager.getText().toString()) >= 16384)
    {
      AppMethodBeat.o(181724);
      return true;
    }
    AppMethodBeat.o(181724);
    return false;
  }
  
  public static int bSp()
  {
    AppMethodBeat.i(181725);
    Object localObject = (ClipboardManager)aj.getContext().getSystemService("clipboard");
    if ((localObject == null) || (((ClipboardManager)localObject).getText() == null) || (((ClipboardManager)localObject).getText().length() <= 0)) {}
    for (int i = 1;; i = 0)
    {
      if ((dataList == null) || (dataList.size() <= 0)) {}
      for (int j = 1;; j = 0)
      {
        if ((i != 0) && (j != 0))
        {
          AppMethodBeat.o(181725);
          return 1;
        }
        if ((i == 0) && (j != 0))
        {
          AppMethodBeat.o(181725);
          return 2;
        }
        if (i != 0)
        {
          AppMethodBeat.o(181725);
          return 3;
        }
        try
        {
          localObject = ((ClipboardManager)localObject).getText();
          if ((localObject instanceof Spanned)) {}
          for (localObject = com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned)localObject); ((String)localObject).equals(oni); localObject = ((CharSequence)localObject).toString())
          {
            AppMethodBeat.o(181725);
            return 3;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("EditorClipboardManager", "get clipboard data error : ", new Object[] { localException });
            String str = "";
          }
          AppMethodBeat.o(181725);
          return 2;
        }
      }
    }
  }
  
  public static void c(Context paramContext, ArrayList<com.tencent.mm.plugin.editor.model.a.a> paramArrayList)
  {
    AppMethodBeat.i(181719);
    if (dataList != null) {
      dataList.clear();
    }
    dataList = paramArrayList;
    com.tencent.mm.plugin.fav.a.ao.qbk = bSn();
    paramArrayList = new StringBuilder("");
    if (dataList != null)
    {
      int i = 0;
      if (i < dataList.size())
      {
        if (i != dataList.size() - 1) {
          paramArrayList.append(com.tencent.mm.plugin.editor.b.a(paramContext, (com.tencent.mm.plugin.editor.model.a.a)dataList.get(i))).append("<br/>");
        }
        for (;;)
        {
          i += 1;
          break;
          paramArrayList.append(com.tencent.mm.plugin.editor.b.a(paramContext, (com.tencent.mm.plugin.editor.model.a.a)dataList.get(i)));
        }
      }
    }
    oni = com.tencent.mm.plugin.editor.b.SW(paramArrayList.toString());
    paramContext = (ClipboardManager)aj.getContext().getSystemService("clipboard");
    if (paramContext != null) {
      paramContext.setText(com.tencent.mm.plugin.editor.model.nativenote.a.a.Tc(oni));
    }
    AppMethodBeat.o(181719);
  }
  
  public static void clearData()
  {
    AppMethodBeat.i(181721);
    if (dataList != null) {
      dataList.clear();
    }
    oni = "";
    com.tencent.mm.plugin.fav.a.ao.qbk = null;
    AppMethodBeat.o(181721);
  }
  
  private static boolean d(com.tencent.mm.plugin.editor.model.a.a parama)
  {
    AppMethodBeat.i(181723);
    if (parama == null)
    {
      AppMethodBeat.o(181723);
      return false;
    }
    boolean bool2 = true;
    int i = parama.getType();
    boolean bool1;
    if ((i != 2) && (i != 6) && (i != 4))
    {
      bool1 = bool2;
      if (i != 5) {}
    }
    else
    {
      String str = com.tencent.mm.plugin.editor.b.b(parama);
      if (!bt.isNullOrNil(str))
      {
        bool1 = bool2;
        if (i.eK(str)) {}
      }
      else
      {
        bool1 = false;
      }
    }
    if (i != 2)
    {
      bool2 = bool1;
      if (i != 6) {}
    }
    else
    {
      parama = com.tencent.mm.plugin.editor.b.c(parama);
      if (!bt.isNullOrNil(parama))
      {
        bool2 = bool1;
        if (i.eK(parama)) {}
      }
      else
      {
        bool2 = false;
      }
    }
    AppMethodBeat.o(181723);
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.b
 * JD-Core Version:    0.7.0.1
 */