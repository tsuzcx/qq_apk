package android.support.v4.media.session;

import android.media.session.MediaSession.QueueItem;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaSessionCompat
{
  public static void d(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
    }
  }
  
  public static final class QueueItem
    implements Parcelable
  {
    public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator() {};
    private final MediaDescriptionCompat Jn;
    private final long KQ;
    private Object KR;
    
    QueueItem(Parcel paramParcel)
    {
      this.Jn = ((MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel));
      this.KQ = paramParcel.readLong();
    }
    
    private QueueItem(Object paramObject, MediaDescriptionCompat paramMediaDescriptionCompat, long paramLong)
    {
      if (paramMediaDescriptionCompat == null) {
        throw new IllegalArgumentException("Description cannot be null.");
      }
      if (paramLong == -1L) {
        throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
      }
      this.Jn = paramMediaDescriptionCompat;
      this.KQ = paramLong;
      this.KR = paramObject;
    }
    
    public static List<QueueItem> l(List<?> paramList)
    {
      if ((paramList == null) || (Build.VERSION.SDK_INT < 21)) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        paramList = localIterator.next();
        if ((paramList == null) || (Build.VERSION.SDK_INT < 21)) {}
        for (paramList = null;; paramList = new QueueItem(paramList, MediaDescriptionCompat.u(((MediaSession.QueueItem)paramList).getDescription()), ((MediaSession.QueueItem)paramList).getQueueId()))
        {
          localArrayList.add(paramList);
          break;
        }
      }
      return localArrayList;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final String toString()
    {
      return "MediaSession.QueueItem {Description=" + this.Jn + ", Id=" + this.KQ + " }";
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      this.Jn.writeToParcel(paramParcel, paramInt);
      paramParcel.writeLong(this.KQ);
    }
  }
  
  public static final class ResultReceiverWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator() {};
    ResultReceiver KS;
    
    ResultReceiverWrapper(Parcel paramParcel)
    {
      this.KS = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      this.KS.writeToParcel(paramParcel, paramInt);
    }
  }
  
  public static final class Token
    implements Parcelable
  {
    public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator() {};
    final Object KT;
    b KU;
    Bundle KV;
    
    Token(Object paramObject)
    {
      this(paramObject, null, (byte)0);
    }
    
    private Token(Object paramObject, b paramb)
    {
      this(paramObject, paramb, (byte)0);
    }
    
    private Token(Object paramObject, b paramb, byte paramByte)
    {
      this.KT = paramObject;
      this.KU = paramb;
      this.KV = null;
    }
    
    public static Token a(Object paramObject, b paramb)
    {
      if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21)) {
        return new Token(d.z(paramObject), paramb);
      }
      return null;
    }
    
    public static Token y(Object paramObject)
    {
      return a(paramObject, null);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof Token)) {
          return false;
        }
        paramObject = (Token)paramObject;
        if (this.KT != null) {
          break;
        }
      } while (paramObject.KT == null);
      return false;
      if (paramObject.KT == null) {
        return false;
      }
      return this.KT.equals(paramObject.KT);
    }
    
    public final int hashCode()
    {
      if (this.KT == null) {
        return 0;
      }
      return this.KT.hashCode();
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramParcel.writeParcelable((Parcelable)this.KT, paramInt);
        return;
      }
      paramParcel.writeStrongBinder((IBinder)this.KT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat
 * JD-Core Version:    0.7.0.1
 */