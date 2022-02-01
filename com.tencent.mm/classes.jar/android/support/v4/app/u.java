package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.os.Bundle;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class u
{
  private static final Object If = new Object();
  private static Field Ig;
  private static boolean Ih;
  private static final Object Ii = new Object();
  
  public static Bundle a(Notification.Builder paramBuilder, s.a parama)
  {
    paramBuilder.addAction(parama.icon, parama.title, parama.actionIntent);
    paramBuilder = new Bundle(parama.mExtras);
    if (parama.GX != null) {
      paramBuilder.putParcelableArray("android.support.remoteInputs", a(parama.GX));
    }
    if (parama.GY != null) {
      paramBuilder.putParcelableArray("android.support.dataRemoteInputs", a(parama.GY));
    }
    paramBuilder.putBoolean("android.support.allowGeneratedReplies", parama.GZ);
    return paramBuilder;
  }
  
  public static Bundle a(Notification paramNotification)
  {
    Object localObject1;
    Bundle localBundle;
    synchronized (If)
    {
      if (Ih) {
        return null;
      }
    }
  }
  
  private static Bundle[] a(x[] paramArrayOfx)
  {
    if (paramArrayOfx == null) {
      return null;
    }
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfx.length];
    int i = 0;
    while (i < paramArrayOfx.length)
    {
      Object localObject1 = paramArrayOfx[i];
      Bundle localBundle = new Bundle();
      localBundle.putString("resultKey", ((x)localObject1).Ix);
      localBundle.putCharSequence("label", ((x)localObject1).Iy);
      localBundle.putCharSequenceArray("choices", ((x)localObject1).Iz);
      localBundle.putBoolean("allowFreeFormInput", ((x)localObject1).IA);
      localBundle.putBundle("extras", ((x)localObject1).mExtras);
      Object localObject2 = ((x)localObject1).IB;
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
    return arrayOfBundle;
  }
  
  static Bundle c(s.a parama)
  {
    Bundle localBundle2 = new Bundle();
    localBundle2.putInt("icon", parama.icon);
    localBundle2.putCharSequence("title", parama.title);
    localBundle2.putParcelable("actionIntent", parama.actionIntent);
    if (parama.mExtras != null) {}
    for (Bundle localBundle1 = new Bundle(parama.mExtras);; localBundle1 = new Bundle())
    {
      localBundle1.putBoolean("android.support.allowGeneratedReplies", parama.GZ);
      localBundle2.putBundle("extras", localBundle1);
      localBundle2.putParcelableArray("remoteInputs", a(parama.GX));
      localBundle2.putBoolean("showsUserInterface", parama.Ha);
      localBundle2.putInt("semanticAction", parama.Hb);
      return localBundle2;
    }
  }
  
  public static SparseArray<Bundle> h(List<Bundle> paramList)
  {
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
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.u
 * JD-Core Version:    0.7.0.1
 */