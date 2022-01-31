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

final class z
{
  private static final Object ys = new Object();
  private static Field yt;
  private static boolean yu;
  private static final Object yv = new Object();
  
  public static Bundle a(Notification.Builder paramBuilder, x.a parama)
  {
    paramBuilder.addAction(parama.icon, parama.title, parama.actionIntent);
    paramBuilder = new Bundle(parama.mExtras);
    if (parama.xs != null) {
      paramBuilder.putParcelableArray("android.support.remoteInputs", a(parama.xs));
    }
    if (parama.xt != null) {
      paramBuilder.putParcelableArray("android.support.dataRemoteInputs", a(parama.xt));
    }
    paramBuilder.putBoolean("android.support.allowGeneratedReplies", parama.xu);
    return paramBuilder;
  }
  
  public static Bundle a(Notification paramNotification)
  {
    Object localObject1;
    Bundle localBundle;
    synchronized (ys)
    {
      if (yu) {
        return null;
      }
    }
  }
  
  private static Bundle[] a(ac[] paramArrayOfac)
  {
    if (paramArrayOfac == null) {
      return null;
    }
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfac.length];
    int i = 0;
    while (i < paramArrayOfac.length)
    {
      Object localObject1 = paramArrayOfac[i];
      Bundle localBundle = new Bundle();
      localBundle.putString("resultKey", ((ac)localObject1).yL);
      localBundle.putCharSequence("label", ((ac)localObject1).yM);
      localBundle.putCharSequenceArray("choices", ((ac)localObject1).yN);
      localBundle.putBoolean("allowFreeFormInput", ((ac)localObject1).yO);
      localBundle.putBundle("extras", ((ac)localObject1).mExtras);
      Object localObject2 = ((ac)localObject1).yP;
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
  
  public static SparseArray<Bundle> i(List<Bundle> paramList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.app.z
 * JD-Core Version:    0.7.0.1
 */