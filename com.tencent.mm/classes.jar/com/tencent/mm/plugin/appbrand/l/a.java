package com.tencent.mm.plugin.appbrand.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

final class a
{
  static final String[] oqz;
  
  static
  {
    AppMethodBeat.i(138799);
    LinkedList localLinkedList = new LinkedList();
    Field[] arrayOfField = androidx.e.a.a.class.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    for (;;)
    {
      Field localField;
      if (i < j) {
        localField = arrayOfField[i];
      }
      try
      {
        if ((Modifier.isFinal(localField.getModifiers())) && (Modifier.isStatic(localField.getModifiers())) && (localField.getName().startsWith("TAG_"))) {
          localLinkedList.add((String)localField.get(null));
        }
        label85:
        i += 1;
        continue;
        oqz = (String[])localLinkedList.toArray(new String[localLinkedList.size()]);
        AppMethodBeat.o(138799);
        return;
      }
      catch (Exception localException)
      {
        break label85;
      }
    }
  }
  
  static void a(androidx.e.a.a parama1, androidx.e.a.a parama2)
  {
    AppMethodBeat.i(249241);
    String[] arrayOfString = oqz;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = arrayOfString[i];
      String str2 = parama1.I(str1);
      if (str2 != null) {
        parama2.c(str1, str2);
      }
      i += 1;
    }
    parama2.ib();
    AppMethodBeat.o(249241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l.a
 * JD-Core Version:    0.7.0.1
 */