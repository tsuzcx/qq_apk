package com.bumptech.glide.c.a;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class n
  extends l<InputStream>
{
  private static final UriMatcher aFA;
  
  static
  {
    AppMethodBeat.i(76902);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    aFA = localUriMatcher;
    localUriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
    aFA.addURI("com.android.contacts", "contacts/lookup/*", 1);
    aFA.addURI("com.android.contacts", "contacts/#/photo", 2);
    aFA.addURI("com.android.contacts", "contacts/#", 3);
    aFA.addURI("com.android.contacts", "contacts/#/display_photo", 4);
    aFA.addURI("com.android.contacts", "phone_lookup/*", 5);
    AppMethodBeat.o(76902);
  }
  
  public n(ContentResolver paramContentResolver, Uri paramUri)
  {
    super(paramContentResolver, paramUri);
  }
  
  public final Class<InputStream> om()
  {
    return InputStream.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.bumptech.glide.c.a.n
 * JD-Core Version:    0.7.0.1
 */