package android.support.v4.content;

import android.content.Context;
import android.support.v4.f.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class c<D>
{
  boolean mAbandoned = false;
  boolean mContentChanged = false;
  Context mContext;
  int mId;
  b<D> mListener;
  a<D> mOnLoadCanceledListener;
  boolean mProcessingChange = false;
  boolean mReset = true;
  boolean mStarted = false;
  
  public c(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  public void abandon()
  {
    this.mAbandoned = true;
    onAbandon();
  }
  
  public boolean cancelLoad()
  {
    return onCancelLoad();
  }
  
  public void commitContentChanged()
  {
    this.mProcessingChange = false;
  }
  
  public String dataToString(D paramD)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    d.a(paramD, localStringBuilder);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void deliverCancellation() {}
  
  public void deliverResult(D paramD)
  {
    if (this.mListener != null) {
      this.mListener.k(paramD);
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.mId);
    paramPrintWriter.print(" mListener=");
    paramPrintWriter.println(this.mListener);
    if ((this.mStarted) || (this.mContentChanged) || (this.mProcessingChange))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(this.mStarted);
      paramPrintWriter.print(" mContentChanged=");
      paramPrintWriter.print(this.mContentChanged);
      paramPrintWriter.print(" mProcessingChange=");
      paramPrintWriter.println(this.mProcessingChange);
    }
    if ((this.mAbandoned) || (this.mReset))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAbandoned=");
      paramPrintWriter.print(this.mAbandoned);
      paramPrintWriter.print(" mReset=");
      paramPrintWriter.println(this.mReset);
    }
  }
  
  public void forceLoad()
  {
    onForceLoad();
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public boolean isAbandoned()
  {
    return this.mAbandoned;
  }
  
  public boolean isReset()
  {
    return this.mReset;
  }
  
  public boolean isStarted()
  {
    return this.mStarted;
  }
  
  protected void onAbandon() {}
  
  protected boolean onCancelLoad()
  {
    return false;
  }
  
  public void onContentChanged()
  {
    if (this.mStarted)
    {
      forceLoad();
      return;
    }
    this.mContentChanged = true;
  }
  
  protected void onForceLoad() {}
  
  protected void onReset() {}
  
  public void onStartLoading() {}
  
  protected void onStopLoading() {}
  
  public void registerListener(int paramInt, b<D> paramb)
  {
    if (this.mListener != null) {
      throw new IllegalStateException("There is already a listener registered");
    }
    this.mListener = paramb;
    this.mId = paramInt;
  }
  
  public void registerOnLoadCanceledListener(a<D> parama)
  {
    if (this.mOnLoadCanceledListener != null) {
      throw new IllegalStateException("There is already a listener registered");
    }
    this.mOnLoadCanceledListener = parama;
  }
  
  public void reset()
  {
    onReset();
    this.mReset = true;
    this.mStarted = false;
    this.mAbandoned = false;
    this.mContentChanged = false;
    this.mProcessingChange = false;
  }
  
  public void rollbackContentChanged()
  {
    if (this.mProcessingChange) {
      onContentChanged();
    }
  }
  
  public final void startLoading()
  {
    this.mStarted = true;
    this.mReset = false;
    this.mAbandoned = false;
    onStartLoading();
  }
  
  public void stopLoading()
  {
    this.mStarted = false;
    onStopLoading();
  }
  
  public boolean takeContentChanged()
  {
    boolean bool = this.mContentChanged;
    this.mContentChanged = false;
    this.mProcessingChange |= bool;
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    d.a(this, localStringBuilder);
    localStringBuilder.append(" id=");
    localStringBuilder.append(this.mId);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void unregisterListener(b<D> paramb)
  {
    if (this.mListener == null) {
      throw new IllegalStateException("No listener register");
    }
    if (this.mListener != paramb) {
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    this.mListener = null;
  }
  
  public void unregisterOnLoadCanceledListener(a<D> parama)
  {
    if (this.mOnLoadCanceledListener == null) {
      throw new IllegalStateException("No listener register");
    }
    if (this.mOnLoadCanceledListener != parama) {
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    this.mOnLoadCanceledListener = null;
  }
  
  public static abstract interface a<D> {}
  
  public static abstract interface b<D>
  {
    public abstract void k(D paramD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.content.c
 * JD-Core Version:    0.7.0.1
 */