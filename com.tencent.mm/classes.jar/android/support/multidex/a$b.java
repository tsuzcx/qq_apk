package android.support.multidex;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class a$b
{
  static void a(ClassLoader paramClassLoader, List<File> paramList, File paramFile)
  {
    Object localObject = a.c(paramClassLoader, "pathList").get(paramClassLoader);
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    a.a(localObject, "dexElements", (Object[])a.c(localObject, "makeDexElements", new Class[] { ArrayList.class, File.class, ArrayList.class }).invoke(localObject, new Object[] { paramList, paramFile, localArrayList }));
    if (localArrayList.size() > 0)
    {
      paramList = localArrayList.iterator();
      while (paramList.hasNext()) {
        paramList.next();
      }
      paramFile = a.c(paramClassLoader, "dexElementsSuppressedExceptions");
      localObject = (IOException[])paramFile.get(paramClassLoader);
      if (localObject != null) {
        break label167;
      }
      paramList = (IOException[])localArrayList.toArray(new IOException[localArrayList.size()]);
    }
    for (;;)
    {
      paramFile.set(paramClassLoader, paramList);
      return;
      label167:
      paramList = new IOException[localArrayList.size() + localObject.length];
      localArrayList.toArray(paramList);
      System.arraycopy(localObject, 0, paramList, localArrayList.size(), localObject.length);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.multidex.a.b
 * JD-Core Version:    0.7.0.1
 */