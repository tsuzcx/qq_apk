package com.tencent.mm.plugin.appbrand.m;

import androidx.f.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

final class b
{
  static final String[] rur;
  
  static
  {
    AppMethodBeat.i(138799);
    LinkedList localLinkedList = new LinkedList();
    Field[] arrayOfField = a.class.getDeclaredFields();
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
        rur = (String[])localLinkedList.toArray(new String[localLinkedList.size()]);
        AppMethodBeat.o(138799);
        return;
      }
      catch (Exception localException)
      {
        break label85;
      }
    }
  }
  
  static void a(a parama1, a parama2)
  {
    AppMethodBeat.i(317198);
    String[] arrayOfString = rur;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = arrayOfString[i];
      String str2 = parama1.aC(str1);
      if (str2 != null) {
        parama2.m(str1, str2);
      }
      i += 1;
    }
    parama2.FM();
    AppMethodBeat.o(317198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.b
 * JD-Core Version:    0.7.0.1
 */