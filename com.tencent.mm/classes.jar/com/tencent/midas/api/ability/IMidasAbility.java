package com.tencent.midas.api.ability;

import android.os.Bundle;

public abstract interface IMidasAbility
{
  public abstract void fromBundle(Bundle paramBundle);
  
  public abstract Bundle toBundle();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.api.ability.IMidasAbility
 * JD-Core Version:    0.7.0.1
 */