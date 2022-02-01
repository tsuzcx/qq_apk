package androidx.h.b;

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
    AppMethodBeat.i(193157);
    this.mStarted = false;
    this.mAbandoned = false;
    this.mReset = true;
    this.mContentChanged = false;
    this.mProcessingChange = false;
    this.mContext = paramContext.getApplicationContext();
    AppMethodBeat.o(193157);
  }
  
  public void abandon()
  {
    AppMethodBeat.i(193341);
    this.mAbandoned = true;
    onAbandon();
    AppMethodBeat.o(193341);
  }
  
  public boolean cancelLoad()
  {
    AppMethodBeat.i(193284);
    boolean bool = onCancelLoad();
    AppMethodBeat.o(193284);
    return bool;
  }
  
  public void commitContentChanged()
  {
    this.mProcessingChange = false;
  }
  
  public String dataToString(D paramD)
  {
    AppMethodBeat.i(193425);
    StringBuilder localStringBuilder = new StringBuilder(64);
    androidx.core.f.b.a(paramD, localStringBuilder);
    localStringBuilder.append("}");
    paramD = localStringBuilder.toString();
    AppMethodBeat.o(193425);
    return paramD;
  }
  
  public void deliverCancellation() {}
  
  public void deliverResult(D paramD)
  {
    AppMethodBeat.i(193165);
    if (this.mListener != null) {
      this.mListener.aL(paramD);
    }
    AppMethodBeat.o(193165);
  }
  
  @Deprecated
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    AppMethodBeat.i(193452);
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
    AppMethodBeat.o(193452);
  }
  
  public void forceLoad()
  {
    AppMethodBeat.i(193304);
    onForceLoad();
    AppMethodBeat.o(193304);
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
    AppMethodBeat.i(193413);
    if (this.mStarted)
    {
      forceLoad();
      AppMethodBeat.o(193413);
      return;
    }
    this.mContentChanged = true;
    AppMethodBeat.o(193413);
  }
  
  protected void onForceLoad() {}
  
  protected void onReset() {}
  
  protected void onStartLoading() {}
  
  protected void onStopLoading() {}
  
  public void registerListener(int paramInt, b<D> paramb)
  {
    AppMethodBeat.i(193197);
    if (this.mListener != null)
    {
      paramb = new IllegalStateException("There is already a listener registered");
      AppMethodBeat.o(193197);
      throw paramb;
    }
    this.mListener = paramb;
    this.mId = paramInt;
    AppMethodBeat.o(193197);
  }
  
  public void registerOnLoadCanceledListener(a<D> parama)
  {
    AppMethodBeat.i(193220);
    if (this.mOnLoadCanceledListener != null)
    {
      parama = new IllegalStateException("There is already a listener registered");
      AppMethodBeat.o(193220);
      throw parama;
    }
    this.mOnLoadCanceledListener = parama;
    AppMethodBeat.o(193220);
  }
  
  public void reset()
  {
    AppMethodBeat.i(193361);
    onReset();
    this.mReset = true;
    this.mStarted = false;
    this.mAbandoned = false;
    this.mContentChanged = false;
    this.mProcessingChange = false;
    AppMethodBeat.o(193361);
  }
  
  public void rollbackContentChanged()
  {
    AppMethodBeat.i(193400);
    if (this.mProcessingChange) {
      onContentChanged();
    }
    AppMethodBeat.o(193400);
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(193269);
    this.mStarted = true;
    this.mReset = false;
    this.mAbandoned = false;
    onStartLoading();
    AppMethodBeat.o(193269);
  }
  
  public void stopLoading()
  {
    AppMethodBeat.i(193322);
    this.mStarted = false;
    onStopLoading();
    AppMethodBeat.o(193322);
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
    AppMethodBeat.i(193437);
    Object localObject = new StringBuilder(64);
    androidx.core.f.b.a(this, (StringBuilder)localObject);
    ((StringBuilder)localObject).append(" id=");
    ((StringBuilder)localObject).append(this.mId);
    ((StringBuilder)localObject).append("}");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(193437);
    return localObject;
  }
  
  public void unregisterListener(b<D> paramb)
  {
    AppMethodBeat.i(193207);
    if (this.mListener == null)
    {
      paramb = new IllegalStateException("No listener register");
      AppMethodBeat.o(193207);
      throw paramb;
    }
    if (this.mListener != paramb)
    {
      paramb = new IllegalArgumentException("Attempting to unregister the wrong listener");
      AppMethodBeat.o(193207);
      throw paramb;
    }
    this.mListener = null;
    AppMethodBeat.o(193207);
  }
  
  public void unregisterOnLoadCanceledListener(a<D> parama)
  {
    AppMethodBeat.i(193230);
    if (this.mOnLoadCanceledListener == null)
    {
      parama = new IllegalStateException("No listener register");
      AppMethodBeat.o(193230);
      throw parama;
    }
    if (this.mOnLoadCanceledListener != parama)
    {
      parama = new IllegalArgumentException("Attempting to unregister the wrong listener");
      AppMethodBeat.o(193230);
      throw parama;
    }
    this.mOnLoadCanceledListener = null;
    AppMethodBeat.o(193230);
  }
  
  public static abstract interface a<D> {}
  
  public static abstract interface b<D>
  {
    public abstract void aL(D paramD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.h.b.b
 * JD-Core Version:    0.7.0.1
 */