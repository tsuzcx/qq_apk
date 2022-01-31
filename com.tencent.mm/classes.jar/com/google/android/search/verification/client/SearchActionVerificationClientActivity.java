package com.google.android.search.verification.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public abstract class SearchActionVerificationClientActivity
  extends Activity
{
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new Intent(this, oz());
    paramBundle.putExtra("SearchActionVerificationClientExtraIntent", getIntent());
    startService(paramBundle);
    finish();
  }
  
  public abstract Class<? extends SearchActionVerificationClientService> oz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.search.verification.client.SearchActionVerificationClientActivity
 * JD-Core Version:    0.7.0.1
 */