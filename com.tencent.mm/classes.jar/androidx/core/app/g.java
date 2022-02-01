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

final class g
{
  private static final Object Jo;
  private static Field Jp;
  private static boolean Jq;
  private static final Object Jr;
  
  static
  {
    AppMethodBeat.i(250387);
    Jo = new Object();
    Jr = new Object();
    AppMethodBeat.o(250387);
  }
  
  public static Bundle a(Notification.Builder paramBuilder, e.a parama)
  {
    AppMethodBeat.i(250381);
    IconCompat localIconCompat = parama.gn();
    if (localIconCompat != null) {}
    for (int i = localIconCompat.getResId();; i = 0)
    {
      paramBuilder.addAction(i, parama.Ig, parama.Ih);
      paramBuilder = new Bundle(parama.mExtras);
      if (parama.HZ != null) {
        paramBuilder.putParcelableArray("android.support.remoteInputs", a(parama.HZ));
      }
      if (parama.Ia != null) {
        paramBuilder.putParcelableArray("android.support.dataRemoteInputs", a(parama.Ia));
      }
      paramBuilder.putBoolean("android.support.allowGeneratedReplies", parama.Ib);
      AppMethodBeat.o(250381);
      return paramBuilder;
    }
  }
  
  public static Bundle a(Notification paramNotification)
  {
    AppMethodBeat.i(250379);
    synchronized (Jo)
    {
      if (Jq)
      {
        AppMethodBeat.o(250379);
        return null;
      }
    }
    try
    {
      if (Jp == null)
      {
        localObject1 = Notification.class.getDeclaredField("extras");
        if (!Bundle.class.isAssignableFrom(((Field)localObject1).getType()))
        {
          Jq = true;
          AppMethodBeat.o(250379);
          return null;
        }
        ((Field)localObject1).setAccessible(true);
        Jp = (Field)localObject1;
      }
      Bundle localBundle = (Bundle)Jp.get(paramNotification);
      Object localObject1 = localBundle;
      if (localBundle == null)
      {
        localObject1 = new Bundle();
        Jp.set(paramNotification, localObject1);
      }
      AppMethodBeat.o(250379);
      return localObject1;
    }
    catch (NoSuchFieldException paramNotification)
    {
      Jq = true;
      AppMethodBeat.o(250379);
      return null;
      paramNotification = finally;
      AppMethodBeat.o(250379);
      throw paramNotification;
    }
    catch (IllegalAccessException paramNotification)
    {
      label117:
      break label117;
    }
  }
  
  private static Bundle[] a(i[] paramArrayOfi)
  {
    AppMethodBeat.i(250385);
    if (paramArrayOfi == null)
    {
      AppMethodBeat.o(250385);
      return null;
    }
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfi.length];
    int i = 0;
    while (i < paramArrayOfi.length)
    {
      Object localObject1 = paramArrayOfi[i];
      Bundle localBundle = new Bundle();
      localBundle.putString("resultKey", ((i)localObject1).JH);
      localBundle.putCharSequence("label", ((i)localObject1).JI);
      localBundle.putCharSequenceArray("choices", ((i)localObject1).JJ);
      localBundle.putBoolean("allowFreeFormInput", ((i)localObject1).JK);
      localBundle.putBundle("extras", ((i)localObject1).mExtras);
      Object localObject2 = ((i)localObject1).JM;
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
    AppMethodBeat.o(250385);
    return arrayOfBundle;
  }
  
  static Bundle c(e.a parama)
  {
    AppMethodBeat.i(250383);
    Bundle localBundle = new Bundle();
    Object localObject = parama.gn();
    int i;
    if (localObject != null)
    {
      i = ((IconCompat)localObject).getResId();
      localBundle.putInt("icon", i);
      localBundle.putCharSequence("title", parama.Ig);
      localBundle.putParcelable("actionIntent", parama.Ih);
      if (parama.mExtras == null) {
        break label135;
      }
    }
    label135:
    for (localObject = new Bundle(parama.mExtras);; localObject = new Bundle())
    {
      ((Bundle)localObject).putBoolean("android.support.allowGeneratedReplies", parama.Ib);
      localBundle.putBundle("extras", (Bundle)localObject);
      localBundle.putParcelableArray("remoteInputs", a(parama.HZ));
      localBundle.putBoolean("showsUserInterface", parama.Ic);
      localBundle.putInt("semanticAction", parama.Ie);
      AppMethodBeat.o(250383);
      return localBundle;
      i = 0;
      break;
    }
  }
  
  public static SparseArray<Bundle> g(List<Bundle> paramList)
  {
    AppMethodBeat.i(250377);
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
    AppMethodBeat.o(250377);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.app.g
 * JD-Core Version:    0.7.0.1
 */