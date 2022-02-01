package androidx.core.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.core.graphics.drawable.IconCompat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class h
{
  private static final Object bpr;
  private static Field bps;
  private static boolean bpt;
  private static final Object bpu;
  
  static
  {
    AppMethodBeat.i(196411);
    bpr = new Object();
    bpu = new Object();
    AppMethodBeat.o(196411);
  }
  
  public static SparseArray<Bundle> W(List<Bundle> paramList)
  {
    AppMethodBeat.i(196349);
    Object localObject1 = null;
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Bundle localBundle = (Bundle)paramList.get(i);
      Object localObject2 = localObject1;
      if (localBundle != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new SparseArray();
        }
        ((SparseArray)localObject2).put(i, localBundle);
      }
      i += 1;
      localObject1 = localObject2;
    }
    AppMethodBeat.o(196349);
    return localObject1;
  }
  
  public static Bundle a(Notification.Builder paramBuilder, f.a parama)
  {
    AppMethodBeat.i(196377);
    IconCompat localIconCompat = parama.Dw();
    if (localIconCompat != null) {}
    for (int i = localIconCompat.getResId();; i = 0)
    {
      paramBuilder.addAction(i, parama.title, parama.boi);
      paramBuilder = new Bundle(parama.mExtras);
      if (parama.boc != null) {
        paramBuilder.putParcelableArray("android.support.remoteInputs", a(parama.boc));
      }
      if (parama.bod != null) {
        paramBuilder.putParcelableArray("android.support.dataRemoteInputs", a(parama.bod));
      }
      paramBuilder.putBoolean("android.support.allowGeneratedReplies", parama.boe);
      AppMethodBeat.o(196377);
      return paramBuilder;
    }
  }
  
  public static Bundle a(Notification paramNotification)
  {
    AppMethodBeat.i(196362);
    synchronized (bpr)
    {
      if (bpt)
      {
        AppMethodBeat.o(196362);
        return null;
      }
    }
    try
    {
      if (bps == null)
      {
        localObject1 = Notification.class.getDeclaredField("extras");
        if (!Bundle.class.isAssignableFrom(((Field)localObject1).getType()))
        {
          bpt = true;
          AppMethodBeat.o(196362);
          return null;
        }
        ((Field)localObject1).setAccessible(true);
        bps = (Field)localObject1;
      }
      Bundle localBundle = (Bundle)bps.get(paramNotification);
      Object localObject1 = localBundle;
      if (localBundle == null)
      {
        localObject1 = new Bundle();
        bps.set(paramNotification, localObject1);
      }
      AppMethodBeat.o(196362);
      return localObject1;
    }
    catch (NoSuchFieldException paramNotification)
    {
      bpt = true;
      AppMethodBeat.o(196362);
      return null;
      paramNotification = finally;
      AppMethodBeat.o(196362);
      throw paramNotification;
    }
    catch (IllegalAccessException paramNotification)
    {
      label117:
      break label117;
    }
  }
  
  private static Bundle[] a(j[] paramArrayOfj)
  {
    AppMethodBeat.i(196403);
    if (paramArrayOfj == null)
    {
      AppMethodBeat.o(196403);
      return null;
    }
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfj.length];
    int i = 0;
    while (i < paramArrayOfj.length)
    {
      Object localObject1 = paramArrayOfj[i];
      Bundle localBundle = new Bundle();
      localBundle.putString("resultKey", ((j)localObject1).bpK);
      localBundle.putCharSequence("label", ((j)localObject1).bpL);
      localBundle.putCharSequenceArray("choices", ((j)localObject1).bpM);
      localBundle.putBoolean("allowFreeFormInput", ((j)localObject1).bpN);
      localBundle.putBundle("extras", ((j)localObject1).mExtras);
      Object localObject2 = ((j)localObject1).bpP;
      if ((localObject2 != null) && (!((Set)localObject2).isEmpty()))
      {
        localObject1 = new ArrayList(((Set)localObject2).size());
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
        }
        localBundle.putStringArrayList("allowedDataTypes", (ArrayList)localObject1);
      }
      arrayOfBundle[i] = localBundle;
      i += 1;
    }
    AppMethodBeat.o(196403);
    return arrayOfBundle;
  }
  
  static Bundle c(f.a parama)
  {
    AppMethodBeat.i(196390);
    Bundle localBundle = new Bundle();
    Object localObject = parama.Dw();
    int i;
    if (localObject != null)
    {
      i = ((IconCompat)localObject).getResId();
      localBundle.putInt("icon", i);
      localBundle.putCharSequence("title", parama.title);
      localBundle.putParcelable("actionIntent", parama.boi);
      if (parama.mExtras == null) {
        break label138;
      }
    }
    label138:
    for (localObject = new Bundle(parama.mExtras);; localObject = new Bundle())
    {
      ((Bundle)localObject).putBoolean("android.support.allowGeneratedReplies", parama.boe);
      localBundle.putBundle("extras", (Bundle)localObject);
      localBundle.putParcelableArray("remoteInputs", a(parama.boc));
      localBundle.putBoolean("showsUserInterface", parama.bof);
      localBundle.putInt("semanticAction", parama.bog);
      AppMethodBeat.o(196390);
      return localBundle;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.core.app.h
 * JD-Core Version:    0.7.0.1
 */