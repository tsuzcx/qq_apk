package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class IntentSenderRequest
  implements Parcelable
{
  public static final Parcelable.Creator<IntentSenderRequest> CREATOR;
  public final IntentSender fh;
  public final Intent fi;
  public final int fj;
  public final int fk;
  
  static
  {
    AppMethodBeat.i(199253);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(199253);
  }
  
  IntentSenderRequest(IntentSender paramIntentSender, Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.fh = paramIntentSender;
    this.fi = paramIntent;
    this.fj = paramInt1;
    this.fk = paramInt2;
  }
  
  IntentSenderRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(199247);
    this.fh = ((IntentSender)paramParcel.readParcelable(IntentSender.class.getClassLoader()));
    this.fi = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
    this.fj = paramParcel.readInt();
    this.fk = paramParcel.readInt();
    AppMethodBeat.o(199247);
  }
  
  public final IntentSender bp()
  {
    return this.fh;
  }
  
  public final Intent bq()
  {
    return this.fi;
  }
  
  public final int br()
  {
    return this.fj;
  }
  
  public final int bs()
  {
    return this.fk;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(199277);
    paramParcel.writeParcelable(this.fh, paramInt);
    paramParcel.writeParcelable(this.fi, paramInt);
    paramParcel.writeInt(this.fj);
    paramParcel.writeInt(this.fk);
    AppMethodBeat.o(199277);
  }
  
  public static final class a
  {
    private IntentSender fh;
    private Intent fi;
    private int fj;
    private int fk;
    
    public a(IntentSender paramIntentSender)
    {
      this.fh = paramIntentSender;
    }
    
    public final a b(Intent paramIntent)
    {
      this.fi = paramIntent;
      return this;
    }
    
    public final IntentSenderRequest bt()
    {
      AppMethodBeat.i(199236);
      IntentSenderRequest localIntentSenderRequest = new IntentSenderRequest(this.fh, this.fi, this.fj, this.fk);
      AppMethodBeat.o(199236);
      return localIntentSenderRequest;
    }
    
    public final a j(int paramInt1, int paramInt2)
    {
      this.fk = paramInt1;
      this.fj = paramInt2;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.activity.result.IntentSenderRequest
 * JD-Core Version:    0.7.0.1
 */