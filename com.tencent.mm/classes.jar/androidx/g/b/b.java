package androidx.g.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class b<D>
{
  boolean mAbandoned;
  boolean mContentChanged;
  Context mContext;
  int mId;
  b<D> mListener;
  a<D> mOnLoadCanceledListener;
  boolean mProcessingChange;
  boolean mReset;
  boolean mStarted;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(188344);
    this.mStarted = false;
    this.mAbandoned = false;
    this.mReset = true;
    this.mContentChanged = false;
    this.mProcessingChange = false;
    this.mContext = paramContext.getApplicationContext();
    AppMethodBeat.o(188344);
  }
  
  public void abandon()
  {
    AppMethodBeat.i(188366);
    this.mAbandoned = true;
    onAbandon();
    AppMethodBeat.o(188366);
  }
  
  public boolean cancelLoad()
  {
    AppMethodBeat.i(188356);
    boolean bool = onCancelLoad();
    AppMethodBeat.o(188356);
    return bool;
  }
  
  public void commitContentChanged()
  {
    this.mProcessingChange = false;
  }
  
  public String dataToString(D paramD)
  {
    AppMethodBeat.i(188375);
    StringBuilder localStringBuilder = new StringBuilder(64);
    androidx.core.f.b.a(paramD, localStringBuilder);
    localStringBuilder.append("}");
    paramD = localStringBuilder.toString();
    AppMethodBeat.o(188375);
    return paramD;
  }
  
  public void deliverCancellation() {}
  
  public void deliverResult(D paramD)
  {
    AppMethodBeat.i(188345);
    if (this.mListener != null) {
      this.mListener.M(paramD);
    }
    AppMethodBeat.o(188345);
  }
  
  @Deprecated
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    AppMethodBeat.i(188380);
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
    AppMethodBeat.o(188380);
  }
  
  public void forceLoad()
  {
    AppMethodBeat.i(188359);
    onForceLoad();
    AppMethodBeat.o(188359);
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
    AppMethodBeat.i(188373);
    if (this.mStarted)
    {
      forceLoad();
      AppMethodBeat.o(188373);
      return;
    }
    this.mContentChanged = true;
    AppMethodBeat.o(188373);
  }
  
  protected void onForceLoad() {}
  
  protected void onReset() {}
  
  protected void onStartLoading() {}
  
  protected void onStopLoading() {}
  
  public void registerListener(int paramInt, b<D> paramb)
  {
    AppMethodBeat.i(188349);
    if (this.mListener != null)
    {
      paramb = new IllegalStateException("There is already a listener registered");
      AppMethodBeat.o(188349);
      throw paramb;
    }
    this.mListener = paramb;
    this.mId = paramInt;
    AppMethodBeat.o(188349);
  }
  
  public void registerOnLoadCanceledListener(a<D> parama)
  {
    AppMethodBeat.i(188352);
    if (this.mOnLoadCanceledListener != null)
    {
      parama = new IllegalStateException("There is already a listener registered");
      AppMethodBeat.o(188352);
      throw parama;
    }
    this.mOnLoadCanceledListener = parama;
    AppMethodBeat.o(188352);
  }
  
  public void reset()
  {
    AppMethodBeat.i(188367);
    onReset();
    this.mReset = true;
    this.mStarted = false;
    this.mAbandoned = false;
    this.mContentChanged = false;
    this.mProcessingChange = false;
    AppMethodBeat.o(188367);
  }
  
  public void rollbackContentChanged()
  {
    AppMethodBeat.i(188372);
    if (this.mProcessingChange) {
      onContentChanged();
    }
    AppMethodBeat.o(188372);
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(188354);
    this.mStarted = true;
    this.mReset = false;
    this.mAbandoned = false;
    onStartLoading();
    AppMethodBeat.o(188354);
  }
  
  public void stopLoading()
  {
    AppMethodBeat.i(188362);
    this.mStarted = false;
    onStopLoading();
    AppMethodBeat.o(188362);
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
    AppMethodBeat.i(188376);
    Object localObject = new StringBuilder(64);
    androidx.core.f.b.a(this, (StringBuilder)localObject);
    ((StringBuilder)localObject).append(" id=");
    ((StringBuilder)localObject).append(this.mId);
    ((StringBuilder)localObject).append("}");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(188376);
    return localObject;
  }
  
  public void unregisterListener(b<D> paramb)
  {
    AppMethodBeat.i(188350);
    if (this.mListener == null)
    {
      paramb = new IllegalStateException("No listener register");
      AppMethodBeat.o(188350);
      throw paramb;
    }
    if (this.mListener != paramb)
    {
      paramb = new IllegalArgumentException("Attempting to unregister the wrong listener");
      AppMethodBeat.o(188350);
      throw paramb;
    }
    this.mListener = null;
    AppMethodBeat.o(188350);
  }
  
  public void unregisterOnLoadCanceledListener(a<D> parama)
  {
    AppMethodBeat.i(188353);
    if (this.mOnLoadCanceledListener == null)
    {
      parama = new IllegalStateException("No listener register");
      AppMethodBeat.o(188353);
      throw parama;
    }
    if (this.mOnLoadCanceledListener != parama)
    {
      parama = new IllegalArgumentException("Attempting to unregister the wrong listener");
      AppMethodBeat.o(188353);
      throw parama;
    }
    this.mOnLoadCanceledListener = null;
    AppMethodBeat.o(188353);
  }
  
  public static abstract interface a<D> {}
  
  public static abstract interface b<D>
  {
    public abstract void M(D paramD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.g.b.b
 * JD-Core Version:    0.7.0.1
 */