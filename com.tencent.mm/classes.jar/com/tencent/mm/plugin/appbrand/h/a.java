package com.tencent.mm.plugin.appbrand.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

final class a
{
  static final String[] hvA;
  
  static
  {
    AppMethodBeat.i(65351);
    LinkedList localLinkedList = new LinkedList();
    Field[] arrayOfField = android.support.d.a.class.getDeclaredFields();
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
        hvA = (String[])localLinkedList.toArray(new String[localLinkedList.size()]);
        AppMethodBeat.o(65351);
        return;
      }
      catch (Exception localException)
      {
        break label85;
      }
    }
  }
  
  static void a(android.support.d.a parama1, android.support.d.a parama2)
  {
    AppMethodBeat.i(65350);
    String[] arrayOfString = hvA;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = arrayOfString[i];
      String str2 = parama1.getAttribute(str1);
      if (str2 != null) {
        parama2.setAttribute(str1, str2);
      }
      i += 1;
    }
    parama2.saveAttributes();
    AppMethodBeat.o(65350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.a
 * JD-Core Version:    0.7.0.1
 */